package fcGUI;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xFile.main;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class DisplayCardController {

    String path = "";
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder = null;
    Document doc = null;


    public DisplayCardController(){

        try {
            InputStream istream = main.class.getResourceAsStream(path);
            doc = dBuilder.parse(istream);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("card");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Type : " + eElement.getElementsByTagName("type").item(0).getTextContent());
                    System.out.println("Question : " + eElement.getElementsByTagName("question").item(0).getTextContent());
                    System.out.println("Answer : " + eElement.getElementsByTagName("anwser").item(0).getTextContent());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public void setPath(String path){
        this.path = path;
    }
}
