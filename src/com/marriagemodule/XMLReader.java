package com.marriagemodule;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLReader {
    ReaderFromFile reader = new ReaderFromFile();

    protected List<String> xmlReader (String xml) {
        List<String> listDateOfPerson = new ArrayList<>();
        TestDateOfPerson testDate = new TestDateOfPerson();

        try {
            File xmlFile = new File(xml);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("staff");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    String[] a = new String[4];
                    Element eElement = (Element) nNode;
                    a[0] = (eElement.getElementsByTagName("name").item(0).getTextContent());
                    a[1] = (eElement.getElementsByTagName("Sex").item(0).getTextContent());
                    a[2] = (eElement.getElementsByTagName("age").item(0).getTextContent());
                    a[3] = (eElement.getElementsByTagName("marriage").item(0).getTextContent());
                    boolean result =  testDate.testDateOfPerson(a);
                    if (result == false){continue;}
                for (int j = 0; j < a.length; j++) {
                    listDateOfPerson.add(a[j]);
                }}

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return listDateOfPerson;
    }

}
