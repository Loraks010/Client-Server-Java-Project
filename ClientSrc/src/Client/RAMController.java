package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Mother_board;
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

public class RAMController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Ram, Integer> RamCountInSet;

    @FXML
    private TableColumn<Ram, Double> RamFquerency;

    @FXML
    private TableColumn<Ram, String> RamMaker;

    @FXML
    private TableColumn<Ram, String> RamName;

    @FXML
    private TableColumn<Ram, Double> RamPrice;

    @FXML
    private TableView<Ram> RamTable;

    @FXML
    private TableColumn<Ram, String> RamTimings;

    @FXML
    private TableColumn<Ram, Integer> RamVolume;

    private ObservableList<Ram> ORamTable = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        ORamTable= FXCollections.observableArrayList(connect.getRAM());
        RamName.setCellValueFactory(new PropertyValueFactory<Ram, String>("name"));
        RamPrice.setCellValueFactory(new PropertyValueFactory<Ram, Double>("price"));
        RamMaker.setCellValueFactory(new PropertyValueFactory<Ram, String>("maker"));
        RamVolume.setCellValueFactory(new PropertyValueFactory<Ram, Integer>("volume"));
        RamCountInSet.setCellValueFactory(new PropertyValueFactory<Ram, Integer>("quantity_in_the_set"));
        RamFquerency.setCellValueFactory(new PropertyValueFactory<Ram, Double>("frequency"));
        RamTimings.setCellValueFactory(new PropertyValueFactory<Ram, String>("timings"));

        RamTable.setItems(ORamTable);
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


            if(RamTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(RamTable.getSelectionModel().getSelectedItem());
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
