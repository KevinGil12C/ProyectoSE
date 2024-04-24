package Socket;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Kevscl
 */
public class Cliente implements Runnable{
    private String host;
    private int puerto=5050;
    private String mensaje;
    private Object ob[];
    public Cliente(String host, String mensaje) {
        this.host=host;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run(){
        DataInputStream in;
        DataOutputStream out;
        System.out.println("Cliente en: " + host);
        try {
            Socket sc = new Socket(host,puerto);
            
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(mensaje);
            sc.close();
        } catch (Exception e) {
        }
    }
    
}

