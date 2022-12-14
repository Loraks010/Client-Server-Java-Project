package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Power_block;
import ProductTree.Screen;
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

public class ScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Screen, String> ScreenDiameter;

    @FXML
    private TableColumn<Screen, Double> ScreenFqerency;

    @FXML
    private TableColumn<Screen, String> ScreenMaker;

    @FXML
    private TableColumn<Screen, String> ScreenName;

    @FXML
    private TableColumn<Screen, Double> ScreenPrice;

    @FXML
    private TableColumn<Screen, String> ScreenResolution;

    @FXML
    private TableView<Screen> ScreenTable;

    private ObservableList<Screen> OScreenTable = FXCollections.observableArrayList();
    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        OScreenTable= FXCollections.observableArrayList(connect.getScreen());
        ScreenName.setCellValueFactory(new PropertyValueFactory<Screen, String>("name"));
        ScreenPrice.setCellValueFactory(new PropertyValueFactory<Screen, Double>("price"));
        ScreenMaker.setCellValueFactory(new PropertyValueFactory<Screen, String>("maker"));
        ScreenFqerency.setCellValueFactory(new PropertyValueFactory<Screen, Double>("frequency_of_update"));
        ScreenDiameter.setCellValueFactory(new PropertyValueFactory<Screen, String>("diameter"));
        ScreenResolution.setCellValueFactory(new PropertyValueFactory<Screen, String>("screen_resolution"));

        ScreenTable.setItems(OScreenTable);
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


            if(ScreenTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(ScreenTable.getSelectionModel().getSelectedItem());
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
