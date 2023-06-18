package agentes;

import jade.core.Agent;
import view.VistaCajero;

/**
 *
 * @author Kevscl
 */
public class AgenteCajero extends Agent{
    private VistaCajero cajeroView;

    public void setup() {
        cajeroView = new VistaCajero();
        cajeroView.setVisible(true);
        //Implementamos los action
        
    }
    
}
