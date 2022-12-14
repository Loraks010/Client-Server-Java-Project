package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import ProductTree.CPU;
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

import static Client.Client.*;

public class BucketController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Product, Integer> BucketId;

    @FXML
    private TableColumn<Product, String> BucketMaker;

    @FXML
    private TableColumn<Product, String> BucketName;

    @FXML
    private TableColumn<Product, Double> BucketPrice;

    @FXML
    private TableView<Product> BucketTable;

    private ObservableList<Product> OProductTable = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;
    @FXML
    private Button DeleteButton;

    @FXML
    void initialize() {
        OProductTable= FXCollections.observableArrayList(bucketList);
        BucketName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        BucketMaker.setCellValueFactory(new PropertyValueFactory<Product, String>("maker"));
        BucketId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        BucketPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));

        BucketTable.setItems(OProductTable);

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
        AddButton.setOnAction(actionEvent->{
            if(!OProductTable.isEmpty()) {
                connect.setBuyList((ArrayList<Product>) bucketList.clone(), us);
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXML/Thanks.fxml"));

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
        DeleteButton.setOnAction(actionEvent->{
            if(BucketTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.remove(BucketTable.getSelectionModel().getSelectedItem());
                FXMLLoader loader = new FXMLLoader();
                DeleteButton.getScene().getWindow().hide();
                loader.setLocation(getClass().getResource("FXML/Bucket_menu.fxml"));
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
