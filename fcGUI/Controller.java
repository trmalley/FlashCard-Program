package fcGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.fxml.FXMLLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder = null;
    Document doc = null;
    String[] titles = new String[10];
    String[] paths = new String[10];
    String newPath = "";
    String title = "";
    FXMLLoader loader = new FXMLLoader(getClass().getResource("fcGUI_Open.fxml"));
    OpenController openController = loader.getController();

    @FXML
    private Button openButton;
    @FXML
    private Button createButton;
    private Object Exception;


    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {
    }

    @FXML
    protected void handleOpenButtonAction(ActionEvent event) {
        Window owner = openButton.getScene().getWindow();
        System.out.println("OPEN");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("fcGUI_Open.fxml"));
                /*
                 * if "fx:controller" is not set in fxml
                 * fxmlLoader.setController(NewWindowController);
                 */
                Scene scene = new Scene(fxmlLoader.load(), 450, 200);
                Stage stage = new Stage();
                stage.setTitle("Open Flashcard");
                stage.setScene(scene);
                OpenController openController = fxmlLoader.getController();
                getTitles();
                openController.setData(titles, paths);
                stage.show();

            } catch (Exception e) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }
    }

    protected void getTitles(){

        try{
            InputStream istream = xFile.main.class.getResourceAsStream("FlashCardCollection.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(istream);
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("flashCardSet");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
              Node nNode = nList.item(temp);
              //System.out.println("\nCurrent Element :" + nNode.getNodeName());

              if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                //System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                //System.out.println("Path : " + eElement.getElementsByTagName("path").item(0).getTextContent());
                //System.out.println("Answer : " + eElement.getElementsByTagName("anwser").item(0).getTextContent());
                newPath = eElement.getElementsByTagName("path").item(0).getTextContent();
                title = eElement.getElementsByTagName("title").item(0).getTextContent();
                //System.out.println("Title: " + title);
                titles[temp] = title;
                paths[temp] = newPath;

                }
            }
            System.out.println(titles[0]);
            System.out.println(titles[1]);
            //openController.setData(titles);

            }catch (Exception e) {
                e.printStackTrace();
             }
        System.out.println("-------------------------------------");
    }

}

