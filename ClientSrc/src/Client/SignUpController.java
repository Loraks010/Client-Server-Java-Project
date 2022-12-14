package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import User.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static Client.Client.connect;
import static Client.Client.us;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button LogInButton;

    @FXML
    private TextField LoginSingUpTextField;

    @FXML
    private PasswordField PasswordSingUpTextField;

    @FXML
    private Button RegButton;

    @FXML
    void initialize() {
        LogInButton.setOnAction(actionEvent->{

            String loginTxt=LoginSingUpTextField.getText().trim();
            String passwordTxt=PasswordSingUpTextField.getText().trim();
            int code=0;
            if(!loginTxt.equals("")&&!passwordTxt.equals(""))
            {
                us =connect.signUp(loginTxt,passwordTxt);
                if(us.getId()==0 || us.getIsLocked()==1)
                {
                    LogInButton.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("FXML/Error.fxml"));

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
                else {
                    switch (us.getIsAdmin()) {
                        case 0: {
                            LogInButton.getScene().getWindow().hide();
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
                        }
                        break;
                        case 1: {
                            LogInButton.getScene().getWindow().hide();
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

                        }
                        break;
                    }
                }

            }

        });

        RegButton.setOnAction(actionEvent->{
            RegButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/Registration.fxml"));

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