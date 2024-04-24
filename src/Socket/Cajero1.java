/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.ObjectOutputStream;

/**
 *
 * @author lems
 */
public class Cajero1 implements Runnable {

    private String host;
    private int puerto = 5050;
    private String mensaje;

    public Cajero1(String host, String mensaje) {
        this.host = host;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        DataInputStream in;
        DataOutputStream out;
        System.out.println("Cajero en: " + host);
        try {
            Socket sc = new Socket(host, puerto);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF(mensaje);
            sc.close();
        } catch (Exception e) {
        }
    }

}