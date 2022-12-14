package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Mouse;
import ProductTree.Power_block;
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

public class MouseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Mouse, Integer> MouseDPI;

    @FXML
    private TableColumn<Mouse, String> MouseMaker;

    @FXML
    private TableColumn<Mouse, String> MouseName;

    @FXML
    private TableColumn<Mouse, Double> MousePrice;

    @FXML
    private TableColumn<Mouse, Integer> MouseRGB;

    @FXML
    private TableView<Mouse> MouseTable;

    @FXML
    private TableColumn<Mouse, Integer> MouseWireless;

    private ObservableList<Mouse> OMouseTable = FXCollections.observableArrayList();

    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        OMouseTable= FXCollections.observableArrayList(connect.getMouse());
        MouseName.setCellValueFactory(new PropertyValueFactory<Mouse, String>("name"));
        MousePrice.setCellValueFactory(new PropertyValueFactory<Mouse, Double>("price"));
        MouseMaker.setCellValueFactory(new PropertyValueFactory<Mouse, String>("maker"));
        MouseRGB.setCellValueFactory(new PropertyValueFactory<Mouse, Integer>("rgb"));
        MouseDPI.setCellValueFactory(new PropertyValueFactory<Mouse, Integer>("DPI"));
        MouseWireless.setCellValueFactory(new PropertyValueFactory<Mouse,Integer>("wireless"));

        MouseTable.setItems(OMouseTable);
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


            if(MouseTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(MouseTable.getSelectionModel().getSelectedItem());
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
