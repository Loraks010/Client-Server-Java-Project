package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {
    public static void main(String[] args)  {

        try(ServerSocket server =new ServerSocket(1024))
        {
            System.out.println("Server started");
            while(true)
            {
                Socket socket=server.accept();
                new Thread(()->{
                    ConnectionClient connect=new ConnectionClient(socket);
                    System.out.println("Client connected");
                    while(true) {
                        connect.codeRead();
                    }
                }).start();
            }

        }
        catch(IOException e)
        {
            throw new RuntimeException(e);
        }

    }

}
