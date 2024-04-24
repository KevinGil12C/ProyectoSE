package agentes;

import jade.core.AID;
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
    public void enviarMensajeACL(String contenido, AID receiver) {
        ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);
        mensaje.setContent(contenido);
        mensaje.addReceiver(receiver);
        send(mensaje);
    }
    
    public ACLMessage recibirMensajeACL() {
        ACLMessage msg = blockingReceive();
        if (msg != null) {
            // Procesar el mensaje recibido
        }
        return msg;
    }
}
