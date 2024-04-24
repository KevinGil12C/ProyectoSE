package ontologia;
import jade.content.onto.*;
import jade.content.schema.*;

public class comprasOntology extends Ontology {
    // Nombre de la ontología
    public static final String ONTOLOGY_NAME = "ontología de ropa";

    // Vocabulario de la ontología que van a manejar los agentes
    public static final String PRODUCTO = "Producto";
    public static final String PRODUCTO_NOMBRE = "nombre";
    public static final String PRODUCTO_PRECIO = "precio";

    public static final String SELECCION = "Seleccion";
    public static final String SELECCION_PRODUCTO = "producto";

    public static final String RESPUESTA = "Respuesta";
    public static final String RESPUESTA_EXISTE = "existe";

    public static final String VENTA = "Venta";
    public static final String VENTA_PRODUCTO = "producto";
    public static final String VENTA_CANTIDAD = "cantidad";

    // Instancia de la ontología (que será única)
    private static Ontology instancia = new comprasOntology();

    // Método para acceder a la instancia de la ontología
    public static Ontology getInstance() {
        return instancia;
    }

    // Constructor privado
    private comprasOntology() {
        // FrutasOntology extiende la ontología básica
        super(ONTOLOGY_NAME, BasicOntology.getInstance());

        try {
            // Añade los elementos
            add(new ConceptSchema(PRODUCTO), Producto.class);
            add(new PredicateSchema(SELECCION), Seleccion.class);
            add(new PredicateSchema(RESPUESTA), Respuesta.class);
            add(new AgentActionSchema(VENTA), Venta.class);

            // Estructura del esquema para el concepto PRODUCTO
            ConceptSchema cs = (ConceptSchema) getSchema(PRODUCTO);
            cs.add(PRODUCTO_NOMBRE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            cs.add(PRODUCTO_PRECIO, (PrimitiveSchema) getSchema(BasicOntology.FLOAT));

            // Estructura del esquema para el predicado SELECCION
            PredicateSchema ps = (PredicateSchema) getSchema(SELECCION);
            ps.add(SELECCION_PRODUCTO, (ConceptSchema) getSchema(PRODUCTO));

            // Estructura del esquema para el predicado RESPUESTA
            PredicateSchema rs = (PredicateSchema) getSchema(RESPUESTA);
            rs.add(RESPUESTA_EXISTE, (PrimitiveSchema) getSchema(BasicOntology.BOOLEAN));

            // Estructura del esquema para la acción VENTA
            AgentActionSchema as = (AgentActionSchema) getSchema(VENTA);
            as.add(VENTA_PRODUCTO, (ConceptSchema) getSchema(PRODUCTO));
            as.add(VENTA_CANTIDAD, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
        } catch (OntologyException oe) {
            oe.printStackTrace();
        }
    }
}

