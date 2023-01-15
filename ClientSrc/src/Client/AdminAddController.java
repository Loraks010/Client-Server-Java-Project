package Client;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ProductTree.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static Client.Client.connect;

public class AdminAddController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AddCPUButton;

    @FXML
    private Button AddGraphicsCardButton;

    @FXML
    private Button AddKeyboardButton;

    @FXML
    private Button AddMotherBoardButton;

    @FXML
    private Button AddMouseButton;

    @FXML
    private Button AddPowerBlockButton;

    @FXML
    private Button AddRAMButton;

    @FXML
    private Button AddScreenButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField CPUMakerField;

    @FXML
    private TextField CPUNameField;

    @FXML
    private TextField CPUPriceField;

    @FXML
    private TextField CPUTDPField;

    @FXML
    private TextField CPUfrequencyField;

    @FXML
    private TextField CPUnumber_of_coresField;

    @FXML
    private TextField CPUtechnical_processField;

    @FXML
    private TextField CPUturbo_boost_frequencyField;

    @FXML
    private TextField GraphicsCardMakerField;

    @FXML
    private TextField GraphicsCardNameField;

    @FXML
    private TextField GraphicsCardPriceField;

    @FXML
    private TextField GraphicsCardTDPField;

    @FXML
    private TextField GraphicsCardfrequencyField;

    @FXML
    private TextField GraphicsCardnumber_of_coresField;

    @FXML
    private TextField KeyboardMakerField;

    @FXML
    private TextField KeyboardNameField;

    @FXML
    private TextField KeyboardPriceField;

    @FXML
    private TextField KeyboardRGBField;

    @FXML
    private TextField KeyboardSwitchesField;

    @FXML
    private TextField KeyboardTypeField;

    @FXML
    private TextField MotherBoardMakerField;

    @FXML
    private TextField MotherBoardNameField;

    @FXML
    private TextField MotherBoardPriceField;

    @FXML
    private TextField MotherBoardRGBField;

    @FXML
    private TextField MotherBoardSocket_typeField;

    @FXML
    private TextField MouseDPIField;

    @FXML
    private TextField MouseMakerField;

    @FXML
    private TextField MouseNameField;

    @FXML
    private TextField MousePriceField;

    @FXML
    private TextField MouseRGBField;

    @FXML
    private TextField MouseWirelessField;

    @FXML
    private TextField PowerBlockMakerField;

    @FXML
    private TextField PowerBlockNameField;

    @FXML
    private TextField PowerBlockPowerField;

    @FXML
    private TextField PowerBlockPriceField;

    @FXML
    private TextField PowerBlockcertificateField;

    @FXML
    private TextField RAMMakerField;

    @FXML
    private TextField RAMNameField;

    @FXML
    private TextField RAMPriceField;

    @FXML
    private TextField RAMVolumeField;

    @FXML
    private TextField RAMfrequencyField;

    @FXML
    private TextField RAMquantity_in_the_setField;

    @FXML
    private TextField RAMtimingsField;

    @FXML
    private TextField ScreenDiametrField;

    @FXML
    private TextField ScreenMakerField;

    @FXML
    private TextField ScreenNameField;

    @FXML
    private TextField ScreenPriceField;

    @FXML
    private TextField Screenfrequency_of_updateField;

    @FXML
    private TextField Screenscreen_resolutionField;

    @FXML
    void initialize() {

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
        AddCPUButton.setOnAction(actionEvent->{

            if(!CPUNameField.getText().trim().equals("") &&!CPUPriceField.getText().trim().equals("")&&
                    !CPUMakerField.getText().trim().equals("") &&
                    !CPUfrequencyField.getText().trim().equals("") &&
                    !CPUturbo_boost_frequencyField.getText().trim().equals("")&&
                    !CPUnumber_of_coresField.getText().trim().equals("") &&
                    !CPUtechnical_processField.getText().trim().equals("")&&
                    !CPUTDPField.getText().trim().equals(""))
            {
                try
                {
                    Double.parseDouble(CPUPriceField.getText().trim());
                    Double.parseDouble(CPUfrequencyField.getText().trim());
                    Integer.parseInt(CPUnumber_of_coresField.getText().trim());
                    Integer.parseInt(CPUtechnical_processField.getText().trim());
                    Integer.parseInt(CPUTDPField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                CPU ob = new CPU(0, CPUNameField.getText().trim(), Double.parseDouble(CPUPriceField.getText().trim()),
                        CPUMakerField.getText().trim(), Double.parseDouble(CPUfrequencyField.getText().trim()),
                        Double.parseDouble(CPUturbo_boost_frequencyField.getText().trim()),
                        Integer.parseInt(CPUnumber_of_coresField.getText().trim()),
                        Integer.parseInt(CPUtechnical_processField.getText().trim()), Integer.parseInt(CPUTDPField.getText().trim()));
                connect.addCPU(ob);
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
        AddGraphicsCardButton.setOnAction(actionEvent->{
            if(!GraphicsCardPriceField.getText().trim().equals("")
                    && !GraphicsCardNameField.getText().trim().equals("")
                    && !GraphicsCardMakerField.getText().trim().equals("")
                    && !GraphicsCardfrequencyField.getText().trim().equals("")
                    && !GraphicsCardnumber_of_coresField.getText().trim().equals("")
                    && !GraphicsCardTDPField.getText().trim().equals("")
            ) {
                try
                {
                    Double.parseDouble(GraphicsCardPriceField.getText().trim());
                    Double.parseDouble(GraphicsCardfrequencyField.getText().trim());
                    Integer.parseInt(GraphicsCardnumber_of_coresField.getText().trim());
                    Integer.parseInt(GraphicsCardTDPField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                Graphics_card ob = new Graphics_card(0, Double.parseDouble(GraphicsCardPriceField.getText().trim()), GraphicsCardNameField.getText().trim(),
                        GraphicsCardMakerField.getText().trim(), Double.parseDouble(GraphicsCardfrequencyField.getText().trim()),
                        Integer.parseInt(GraphicsCardnumber_of_coresField.getText().trim()), Integer.parseInt(GraphicsCardTDPField.getText().trim()));
                connect.addGraphics_card(ob);
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
        AddScreenButton.setOnAction(actionEvent->{
            if(!ScreenPriceField.getText().trim().equals("")
                    && !ScreenNameField.getText().trim().equals("")
                    && !ScreenMakerField.getText().trim().equals("")
                    && !Screenfrequency_of_updateField.getText().trim().equals("")
                    && !ScreenDiametrField.getText().trim().equals("")
                    && !Screenscreen_resolutionField.getText().trim().equals("")
            ) {
                try
                {
                    Double.parseDouble(ScreenPriceField.getText().trim());
                    Double.parseDouble(Screenfrequency_of_updateField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                Screen ob = new Screen(0, Double.parseDouble(ScreenPriceField.getText().trim()), ScreenNameField.getText().trim(),
                        ScreenMakerField.getText().trim(), Double.parseDouble(Screenfrequency_of_updateField.getText().trim()),
                        ScreenDiametrField.getText().trim(),Screenscreen_resolutionField.getText().trim() );
                connect.addScreen(ob);
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
        AddKeyboardButton.setOnAction(actionEvent->{
            if(!KeyboardPriceField.getText().trim().equals("")
                    && !KeyboardNameField.getText().trim().equals("")
                    && !KeyboardMakerField.getText().trim().equals("")
                    && !KeyboardRGBField.getText().trim().equals("")
                    && !KeyboardSwitchesField.getText().trim().equals("")
                    && !KeyboardTypeField.getText().trim().equals("")
            ) {
                try
                {
                    Double.parseDouble(KeyboardPriceField.getText().trim());
                    Integer.parseInt(KeyboardRGBField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                Keyboard ob = new Keyboard(0, Double.parseDouble(KeyboardPriceField.getText().trim()), KeyboardNameField.getText().trim(),
                        KeyboardMakerField.getText().trim(), KeyboardTypeField.getText().trim(),
                        KeyboardSwitchesField.getText().trim(),Integer.parseInt(KeyboardRGBField.getText().trim()));
                connect.addKeyboard(ob);
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
        AddRAMButton.setOnAction(actionEvent->{
            if(!RAMPriceField.getText().trim().equals("")
                    && !RAMNameField.getText().trim().equals("")
                    && !RAMMakerField.getText().trim().equals("")
                    && !RAMfrequencyField.getText().trim().equals("")
                    && !RAMtimingsField.getText().trim().equals("")
                    && !RAMquantity_in_the_setField.getText().trim().equals("")
                    && !RAMVolumeField.getText().trim().equals("")
            ) {
                try
                {
                    Double.parseDouble(RAMPriceField.getText().trim());
                    Integer.parseInt(RAMVolumeField.getText().trim());
                    Integer.parseInt(RAMquantity_in_the_setField.getText().trim());
                    Double.parseDouble(RAMfrequencyField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                Ram ob = new Ram(0, Double.parseDouble(RAMPriceField.getText().trim()), RAMNameField.getText().trim(),
                       RAMMakerField.getText().trim(), Integer.parseInt(RAMVolumeField.getText().trim()),
                        Integer.parseInt(RAMquantity_in_the_setField.getText().trim()),Double.parseDouble(RAMfrequencyField.getText().trim()),
                        RAMtimingsField.getText().trim());
                connect.addRam(ob);
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
        AddMouseButton.setOnAction(actionEvent->{
            if(!MousePriceField.getText().trim().equals("")
                    && !MouseNameField.getText().trim().equals("")
                    && !MouseMakerField.getText().trim().equals("")
                    && !MouseDPIField.getText().trim().equals("")
                    && !MouseRGBField.getText().trim().equals("")
                    && !MouseWirelessField.getText().trim().equals("")
            ) {
                try
                {
                    Double.parseDouble(MousePriceField.getText().trim());
                    Integer.parseInt(MouseRGBField.getText().trim());
                    Integer.parseInt(MouseDPIField.getText().trim());
                    Integer.parseInt(MouseWirelessField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                Mouse ob = new Mouse(0, Double.parseDouble(MousePriceField.getText().trim()), MouseNameField.getText().trim(),
                        MouseMakerField.getText().trim(), Integer.parseInt(MouseRGBField.getText().trim()),
                        Integer.parseInt(MouseDPIField.getText().trim()),Integer.parseInt(MouseWirelessField.getText().trim()));
                connect.addMouse(ob);
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
        AddPowerBlockButton.setOnAction(actionEvent->{
            if(!PowerBlockPriceField.getText().trim().equals("")
                    && !PowerBlockNameField.getText().trim().equals("")
                    && !PowerBlockMakerField.getText().trim().equals("")
                    && !PowerBlockPowerField.getText().trim().equals("")
                    && !PowerBlockcertificateField.getText().trim().equals("")
            ) {
                try
                {
                    Double.parseDouble(PowerBlockPriceField.getText().trim());
                    Integer.parseInt(PowerBlockPowerField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                Power_block ob = new Power_block(0, Double.parseDouble(PowerBlockPriceField.getText().trim()), PowerBlockNameField.getText().trim(),
                        PowerBlockMakerField.getText().trim(), Integer.parseInt(PowerBlockPowerField.getText().trim()),
                        PowerBlockcertificateField.getText().trim());
                connect.addPower_block(ob);
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
        AddMotherBoardButton.setOnAction(actionEvent->{
            if(!MotherBoardPriceField.getText().trim().equals("")
                    && !MotherBoardNameField.getText().trim().equals("")
                    && !MotherBoardMakerField.getText().trim().equals("")
                    && !MotherBoardRGBField.getText().trim().equals("")
                    && !MotherBoardSocket_typeField.getText().trim().equals("")
            ) {
                try
                {
                    Double.parseDouble(MotherBoardPriceField.getText().trim());
                    Integer.parseInt(MotherBoardRGBField.getText().trim());
                }
                catch (NumberFormatException e)
                {
                    return;
                }
                Mother_board ob = new Mother_board(0, Double.parseDouble(MotherBoardPriceField.getText().trim()), MotherBoardNameField.getText().trim(),
                        MotherBoardMakerField.getText().trim(),
                        MotherBoardSocket_typeField.getText().trim(), Integer.parseInt(MotherBoardRGBField.getText().trim()));
                connect.addMother_board(ob);
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
