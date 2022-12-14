
package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Keyboard;
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

public class KeyboardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddButton;
    @FXML
    private TableColumn<Keyboard, String> KeyboardMaker;

    @FXML
    private TableColumn<Keyboard, String> KeyboardName;

    @FXML
    private TableColumn<Keyboard, Double> KeyboardPrice;

    @FXML
    private TableColumn<Keyboard, Integer> KeyboardRGB;

    @FXML
    private TableColumn<Keyboard, String> KeyboardSwitches;

    @FXML
    private TableView<Keyboard> KeyboardTable;

    @FXML
    private TableColumn<Keyboard, String> KeyboardType;

    private ObservableList<Keyboard> OKeyboardTable = FXCollections.observableArrayList();
    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        OKeyboardTable= FXCollections.observableArrayList(connect.getKeyboard());
        KeyboardName.setCellValueFactory(new PropertyValueFactory<Keyboard, String>("name"));
        KeyboardPrice.setCellValueFactory(new PropertyValueFactory<Keyboard, Double>("price"));
        KeyboardMaker.setCellValueFactory(new PropertyValueFactory<Keyboard, String>("maker"));
        KeyboardType.setCellValueFactory(new PropertyValueFactory<Keyboard, String>("type"));
        KeyboardSwitches.setCellValueFactory(new PropertyValueFactory<Keyboard, String>("switches"));
        KeyboardRGB.setCellValueFactory(new PropertyValueFactory<Keyboard, Integer>("rgb"));

        KeyboardTable.setItems(OKeyboardTable);
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


            if(KeyboardTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(KeyboardTable.getSelectionModel().getSelectedItem());
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
