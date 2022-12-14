package Client;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Product;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static Client.Client.connect;

public class OrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Order, Integer> OrderID;

    @FXML
    private TableColumn<Order, Integer> OrderProductID;

    @FXML
    private TableView<Order> OrderTable;

    @FXML
    private TableColumn<Order, Integer> OrderUserID;
    private ObservableList<Order> OOrderTable = FXCollections.observableArrayList();

    @FXML
    private Button BackButton;

    @FXML
    private Button DeleteButton;

    @FXML
    void initialize() {
        OOrderTable= FXCollections.observableArrayList(connect.getOrderList());
        OrderID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("order_id"));
        OrderUserID.setCellValueFactory(new PropertyValueFactory<Order,Integer>("user_id"));
        OrderProductID.setCellValueFactory(new PropertyValueFactory<Order, Integer>("product_id"));

        OrderTable.setItems(OOrderTable);
        BackButton.setOnAction(actionEvent->{
            BackButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/Admin_menu.fxml"));

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
        DeleteButton.setOnAction(actionEvent->{
            FXMLLoader loader = new FXMLLoader();
            Order ob=OrderTable.getSelectionModel().getSelectedItem();
            if(ob!=null) {
                DeleteButton.getScene().getWindow().hide();
                loader.setLocation(getClass().getResource("FXML/OrderMenu.fxml"));
                connect.deleteOrder(ob);
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }

        });


    }

}
