package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.Product;
import User.User;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import static Client.Client.connect;
import static Client.Client.us;

public class AdminProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button BlockButton;

    @FXML
    private Button ChangePasswordButton;

    @FXML
    private TextField ChangePasswordField;
    @FXML
    private Button ChangeStatusButton;

    private ObservableList<User> OUsersTable = FXCollections.observableArrayList();
    @FXML
    private TableView<User> UserTable;
    @FXML
    private TableColumn<User, Integer> UserAdmin;

    @FXML
    private TableColumn<User, Integer> UserBlocked;

    @FXML
    private TableColumn<User, Integer> UserId;

    @FXML
    private TableColumn<User, String> UserLogin;

    @FXML
    void initialize() {
        OUsersTable= FXCollections.observableArrayList(connect.getUsers());
        UserId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        UserLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        UserAdmin.setCellValueFactory(new PropertyValueFactory<User, Integer>("isAdmin"));
        UserBlocked.setCellValueFactory(new PropertyValueFactory<User, Integer>("isLocked"));

        UserTable.setItems(OUsersTable);

        BackButton.setOnAction(actionEvent->{
            BackButton.getScene().getWindow().hide();
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
        });
        BlockButton.setOnAction(actionEvent->{

            User ob=UserTable.getSelectionModel().getSelectedItem();
            if(ob!=null) {
                connect.changeLocked(ob);
                BlockButton.getScene().getWindow().hide();
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
            }
        });
        ChangeStatusButton.setOnAction(actionEvent->{

            User ob=UserTable.getSelectionModel().getSelectedItem();
            if(ob!=null) {
                connect.changeStatus(ob);
                ChangeStatusButton.getScene().getWindow().hide();
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
            }
        });
        ChangePasswordButton.setOnAction(actionEvent->{

                us.setPassword(ChangePasswordField.getText());
                User ob1=new User(us);
                connect.changePassword(ob1);
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

        });

    }

}
