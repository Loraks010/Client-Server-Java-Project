package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Power_block;
import ProductTree.Ram;
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

public class PowerBlockController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Power_block, String> PowerBlockCerteficate;

    @FXML
    private TableColumn<Power_block, String> PowerBlockMaker;

    @FXML
    private TableColumn<Power_block, String> PowerBlockName;

    @FXML
    private TableColumn<Power_block, Integer> PowerBlockPower;

    @FXML
    private TableColumn<Power_block, Double> PowerBlockPrice;

    @FXML
    private TableView<Power_block> PowerBlockTable;

    private ObservableList<Power_block> OPowerBlockTable = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        OPowerBlockTable= FXCollections.observableArrayList(connect.getPowerBlock());
        PowerBlockName.setCellValueFactory(new PropertyValueFactory<Power_block, String>("name"));
        PowerBlockPrice.setCellValueFactory(new PropertyValueFactory<Power_block, Double>("price"));
        PowerBlockMaker.setCellValueFactory(new PropertyValueFactory<Power_block, String>("maker"));
        PowerBlockPower.setCellValueFactory(new PropertyValueFactory<Power_block, Integer>("power"));
        PowerBlockCerteficate.setCellValueFactory(new PropertyValueFactory<Power_block, String>("certificate"));

        PowerBlockTable.setItems(OPowerBlockTable);
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


            if(PowerBlockTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(PowerBlockTable.getSelectionModel().getSelectedItem());
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
    }

}
