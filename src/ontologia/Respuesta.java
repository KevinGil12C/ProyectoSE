package ontologia;
import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

public class Respuesta implements Predicate {
    private boolean existe;

    public Respuesta() {
    }

    public Respuesta(boolean existe) {
        this.existe = existe;
    }

    @Slot(mandatory = true)
    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
}
