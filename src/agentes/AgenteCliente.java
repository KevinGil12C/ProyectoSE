package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import view.VistaCliente;

/**
 *
 * @author Kevscl
 */
public class AgenteCliente extends Agent {

    private VistaCliente clienteView;

    public void setup() {
        clienteView = new VistaCliente();
        clienteView.setVisible(true);
    }

    

}
