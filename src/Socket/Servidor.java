package Socket;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author Kevscl
 */
public class Servidor extends Observable implements Runnable{
    private int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
        //System.out.println(puerto);
    }
    @Override
    public void run(){
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        try {
            servidor = new ServerSocket(puerto);
            //System.out.println("Servidor iniciado");
            //System.out.println(puerto);
            while(true){
                sc = servidor.accept();
                
                //System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                
                String mensaje = in.readUTF();
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                sc.close();
                
                
            }
        } catch (Exception e) {
            //System.out.println("Error servidor");
        }
    }
}

