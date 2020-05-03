package xFile;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;

public class main {

    public static void main(String[] args) {

        //flashCard card = new flashCard("Test","What is 5+5?","10");

        //System.out.println(card.toString());

        String newPath = "";
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder = null;
        Document doc = null;

        try{
            InputStream istream = main.class.getResourceAsStream("FlashCardCollection.xml");
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
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Path : " + eElement.getElementsByTagName("path").item(0).getTextContent());
                    //System.out.println("Answer : " + eElement.getElementsByTagName("anwser").item(0).getTextContent());
                    newPath = eElement.getElementsByTagName("path").item(0).getTextContent();
                }
            }
            }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------");

        System.out.println(newPath);


        try {
            InputStream istream = main.class.getResourceAsStream(newPath);
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

}
