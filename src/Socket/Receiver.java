package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

    public static void main(String[] args) {
        int port = 5050; // Puerto en el que el receptor escucha las conexiones
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Esperando conexión...");

            // Esperar a que se establezca la conexión con el emisor
            Socket socket = serverSocket.accept();
            System.out.println("Conexión establecida.");

            // Crear un flujo de entrada para recibir los datos del archivo
            InputStream inputStream = socket.getInputStream();

            // Crear un archivo para guardar el PDF recibido
            String filePath = "ruta_de_guardado/nombre_archivo.pdf";
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            // Leer los datos del archivo desde el flujo de entrada y escribirlos en el archivo
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("Archivo PDF recibido y guardado correctamente.");

            // Cerrar los flujos y el socket
            fileOutputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
