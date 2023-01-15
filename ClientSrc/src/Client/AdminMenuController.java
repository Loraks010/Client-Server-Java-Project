package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Product;
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

public class AdminMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button ProfileButton;

    @FXML
    private TableView<Product> AdminTable;

    @FXML
    private TableColumn<Product, Integer> AdminTableId;

    @FXML
    private TableColumn<Product, String> AdminTableMaker;

    @FXML
    private TableColumn<Product, String> AdminTableName;

    @FXML
    private TableColumn<Product, Double> AdminTablePrice;
    @FXML
    private Button OrderButton;

    @FXML
    void initialize() {

        ObservableList<Product> productTable = FXCollections.observableArrayList(connect.getProducts());
        AdminTableId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        AdminTableName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        AdminTablePrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        AdminTableMaker.setCellValueFactory(new PropertyValueFactory<Product, String>("maker"));

        AdminTable.setItems(productTable);

        ProfileButton.setOnAction(actionEvent->{
            ProfileButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/Admin_profile.fxml"));

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
        AddButton.setOnAction(actionEvent->{
            AddButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/Admin_add.fxml"));

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

            Product ob=AdminTable.getSelectionModel().getSelectedItem();
            if(ob!=null) {
                connect.deleteProduct(ob);
                DeleteButton.getScene().getWindow().hide();
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
            }
        });
        OrderButton.setOnAction(actionEvent->{
                OrderButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXML/OrderMenu.fxml"));
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
