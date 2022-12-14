package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import User.User;
import User.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static Client.Client.connect;
import static Client.Client.us;


public class UserProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button ChangePasswordButton;

    @FXML
    private TextField ChangePasswordField;
    @FXML
    private TableColumn<Order, Integer> OrderID;

    @FXML
    private TableView<Order> OrderTable;

    @FXML
    private TableColumn<Order, Integer> ProductID;

    @FXML
    private TableColumn<Order, String> ProductName;

    @FXML
    private TableColumn<Order, Double> ProductPrice;
    @FXML
    private TableColumn<Order, String> OrderMaker;

    private ObservableList<Order> OOrderTable = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        User ob1=new User(us.getId(),us.getLogin(),us.getPassword(),us.getIsLocked(),us.getIsAdmin());
        OOrderTable= FXCollections.observableArrayList(connect.getUserOrderList(ob1));
        OrderID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("order_id"));
        ProductName.setCellValueFactory(new PropertyValueFactory<Order,String>("name"));
        ProductID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("product_id"));
        ProductPrice.setCellValueFactory(new PropertyValueFactory<Order, Double>("price"));
        OrderMaker.setCellValueFactory(new PropertyValueFactory<Order, String>("maker"));

        OrderTable.setItems(OOrderTable);

        BackButton.setOnAction(actionEvent->{
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/Client_menu.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        ChangePasswordButton.setOnAction(actionEvent->{
            us.setPassword(ChangePasswordField.getText());
            User ob2=new User(us.getId(),us.getLogin(),us.getPassword(),us.getIsLocked(),us.getIsAdmin());
            connect.changePassword(ob2);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/Done.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        });
    }

}
