package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Graphics_card;
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

public class GraphicsCardController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Graphics_card, Integer> GraphicsCardCores;

    @FXML

    private TableColumn<Graphics_card, Double> GraphicsCardFquerency;

    @FXML
    private TableColumn<Graphics_card, String> GraphicsCardMaker;

    @FXML
    private TableColumn<Graphics_card, String> GraphicsCardName;

    @FXML
    private TableColumn<Graphics_card, Double> GraphicsCardPrice;

    @FXML
    private TableView<Graphics_card> GraphicsCardTable;

    @FXML
    private TableColumn<Graphics_card, Integer> GraphicsCardTdp;

    private ObservableList<Graphics_card> OGraphicsCardTable = FXCollections.observableArrayList();

    @FXML
    private Button AddButton;

    @FXML
    private Button BackButton;

    @FXML
    void initialize() {
        OGraphicsCardTable= FXCollections.observableArrayList(connect.getGraphicsCard());
        GraphicsCardName.setCellValueFactory(new PropertyValueFactory<Graphics_card, String>("name"));
        GraphicsCardPrice.setCellValueFactory(new PropertyValueFactory<Graphics_card, Double>("price"));
        GraphicsCardMaker.setCellValueFactory(new PropertyValueFactory<Graphics_card, String>("maker"));
        GraphicsCardFquerency.setCellValueFactory(new PropertyValueFactory<Graphics_card, Double>("frequency"));
        GraphicsCardCores.setCellValueFactory(new PropertyValueFactory<Graphics_card, Integer>("number_of_cores"));
        GraphicsCardTdp.setCellValueFactory(new PropertyValueFactory<Graphics_card, Integer>("tdp"));
        GraphicsCardTable.setItems(OGraphicsCardTable);
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


            if(GraphicsCardTable.getSelectionModel().getSelectedItem()!=null) {
                bucketList.add(GraphicsCardTable.getSelectionModel().getSelectedItem());
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
