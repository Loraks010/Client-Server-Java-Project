package Client;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import ProductTree.CPU;
import ProductTree.Mother_board;
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

import static Client.Client.bucketList;
import static Client.Client.connect;

public class MotherBoardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Mother_board, String> MotherBoardMaker;

    @FXML
    private TableColumn<Mother_board, String> MotherBoardName;

    @FXML
    private TableColumn<Mother_board, Double> MotherBoardPrice;

    @FXML
    private TableColumn<Mother_board, Integer> MotherBoardRGB;

    @FXML
    private TableColumn<Mother_board, String> MotherBoardSocket;

    private ObservableList<Mother_board> OMotherBoardTable = FXCollections.observableArrayList();

    @FXML
    private TableView<Mother_board> MotherBoardTable;

    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        OMotherBoardTable= FXCollections.observableArrayList(connect.getMother_board());
        MotherBoardName.setCellValueFactory(new PropertyValueFactory<Mother_board, String>("name"));
        MotherBoardPrice.setCellValueFactory(new PropertyValueFactory<Mother_board, Double>("price"));
        MotherBoardMaker.setCellValueFactory(new PropertyValueFactory<Mother_board, String>("maker"));
        MotherBoardSocket.setCellValueFactory(new PropertyValueFactory<Mother_board, String>("socket_type"));
        MotherBoardRGB.setCellValueFactory(new PropertyValueFactory<Mother_board, Integer>("rgb"));

        MotherBoardTable.setItems(OMotherBoardTable);
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


            if(MotherBoardTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(MotherBoardTable.getSelectionModel().getSelectedItem());
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
