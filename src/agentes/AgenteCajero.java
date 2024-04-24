package agentes;

import jade.content.lang.*;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import ontologia.comprasOntology;
import view.VistaCajero;

/**
 *
 * @author Kevscl
 */
public class AgenteCajero extends Agent {
    VistaCajero cajeroView;
    private Codec codec = new SLCodec();
    private Ontology ontologia = comprasOntology.getInstance();

    @Override
    protected void setup() {
        /*Descripción del Agente*/
        cajeroView = new VistaCajero();
        cajeroView.setVisible(true);
    }
}

