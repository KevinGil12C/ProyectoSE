package agentes;

import view.VistaVendedor;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Agente Vendedor
 */
public class AgenteVendedor extends Agent {

    private VistaVendedor vendedorView;

    public void setup() {
        vendedorView = new VistaVendedor(); // Pasar una referencia del agente a la vista
        vendedorView.setVisible(true);
    }

    public void enviarMensaje() {

    }

    public void recibirMensaje() {
       
    }

    
}
