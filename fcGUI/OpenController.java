package fcGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpenController {


    public OpenController() {
    }

    @FXML
    private Button testButton;

    @FXML // fx:id="fruitCombo"
    private ComboBox<String> fcFiles; // Value injected by FXMLLoader

    @FXML // fx:id="group1"
    private ToggleGroup group1;

    FXMLLoader loader = new FXMLLoader(getClass().getResource("fcGUI_Cards.fxml"));
    DisplayCardController disCardController = loader.getController();

    public void setData(String[] titles, String[] paths){
        System.out.println("Set Data");
        fcFiles.getItems().clear();
        //add all needs to be xml titles
        //System.out.println(titles[0]);
        for(int i = 0; i<titles.length; i++) {
            if(titles[i] != null) {
                fcFiles.getItems().add(titles[i]);
            }
        }
    }

    @FXML
    protected void handleOpenFCButtonAction(ActionEvent event) {
        Window owner = testButton.getScene().getWindow();
        System.out.println("TEST");

        RadioButton selectedRadioButton = (RadioButton) group1.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

        System.out.println(toogleGroupValue);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fcGUI_Cards.fxml"));
            DisplayCardController disCardController = fxmlLoader.getController();
            ///////disCardController.setPath(eElement.getElementsByTagName("path").item(0).getTextContent());
            /*
             * if "fx:controller" is not set in fxml
             * fxmlLoader.setController(NewWindowController);
             */
            Scene scene = new Scene(fxmlLoader.load(), 450, 200);
            Stage stage = new Stage();
            stage.setTitle("Flashcard");
            stage.setScene(scene);

            stage.show();

        } catch (Exception e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

}
