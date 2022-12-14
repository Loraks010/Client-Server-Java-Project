package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.CPU;
import ProductTree.Product;
import User.User;
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

import static Client.Client.bucketList;
import static Client.Client.connect;

public class CPUMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<CPU, Double> CPUFqurency;

    @FXML
    private TableColumn<CPU, Double> CPUPrice;

    @FXML
    private TableView<CPU> CPUTable;

    @FXML
    private TableColumn<CPU, String> CPUTableMaker;

    @FXML
    private TableColumn<CPU, String> CPUTableName;

    @FXML
    private TableColumn<CPU, Integer> CPUTableNumberOfCores;

    @FXML
    private TableColumn<CPU, Integer> CPUTdp;

    @FXML
    private TableColumn<CPU, Double> CPUTurboFqrency;

    private ObservableList<CPU> OCPUTable = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        OCPUTable= FXCollections.observableArrayList(connect.getCPU());
        CPUTableName.setCellValueFactory(new PropertyValueFactory<CPU, String>("name"));
        CPUTableMaker.setCellValueFactory(new PropertyValueFactory<CPU, String>("maker"));
        CPUTableNumberOfCores.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("number_of_cores"));
        CPUFqurency.setCellValueFactory(new PropertyValueFactory<CPU, Double>("frequency"));
        CPUTurboFqrency.setCellValueFactory(new PropertyValueFactory<CPU, Double>("turbo_boost_frequency"));
        CPUTdp.setCellValueFactory(new PropertyValueFactory<CPU, Integer>("tdp"));
        CPUPrice.setCellValueFactory(new PropertyValueFactory<CPU, Double>("price"));

        CPUTable.setItems(OCPUTable);
        AddButton.setOnAction(actionEvent->{


            if(CPUTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(CPUTable.getSelectionModel().getSelectedItem());
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
            }
        });
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
    }

}

