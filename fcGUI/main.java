package fcGUI;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fcGUI_Main.fxml"));
        primaryStage.setTitle("Window Title");

        primaryStage.setScene(new Scene(root, 300, 275));



        FXMLLoader loader = new FXMLLoader(getClass().getResource("fcGUI_Main.fxml"));
        root = loader.load();



        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
