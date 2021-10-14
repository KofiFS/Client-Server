import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Server {

    public static void main(String[] args) {
        System.out.println("Server running...");
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server: Waiting for connection...");
            Socket clientSocket = server.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println("Server: " + inputLine + "will turn into" + inputLine.toUpperCase());
                inputLine = inputLine.toUpperCase();
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.err.println("IO Exception Occurred");
            e.printStackTrace();
        }
    }
}