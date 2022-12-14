package Client;

import ProductTree.Product;
import User.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class Client extends Application {

    static public Socket sock=null;
    static public InputStream is=null;
    static public OutputStream os=null;
    static public Connection connect;
    static public ArrayList<Product> bucketList=new ArrayList<>();
    static public User us=null;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXML/Autorization.fxml")));
        stage.setTitle("ElectronicBuy");
        stage.setScene(new Scene(root,800,500));
        stage.show();


    }
    public static void main(String[] args){

        connect=new Connection();
        launch(args);
    }
}

