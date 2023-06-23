package Ex5.Util;

import Ex5.Class.Periodical;
import Ex5.Enume.Frequency;
import Ex5.Enume.PeriodicalType;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class XMLParser {
    public static List<Periodical> parse(File file) throws ParserConfigurationException, IOException, SAXException {
        List<Periodical> periodicalList = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        validateXml(document);

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        NodeList nodeList = document.getElementsByTagName("periodical");

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Periodical periodical = new Periodical();
            Node node = nodeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;

                periodical.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                periodical.setPeriodicalType(PeriodicalType.valueOf(eElement
                        .getElementsByTagName("type").item(0).getTextContent().toUpperCase()));
                periodical.setFrequency(Frequency.valueOf(eElement
                        .getElementsByTagName("frequency").item(0).getTextContent().toUpperCase()));
                periodical.setColor(Boolean.parseBoolean(eElement.
                        getElementsByTagName("isColor").item(0).getTextContent()));
                periodical.setGloss(Boolean.parseBoolean(eElement.
                        getElementsByTagName("isGloss").item(0).getTextContent()));
                periodical.setPages(Integer.parseInt(eElement.
                        getElementsByTagName("pages").item(0).getTextContent()));
                periodical.setIndex(eElement.getElementsByTagName("index").item(0).getTextContent());
                periodicalList.add(periodical);
            }
        }
        return periodicalList;
    }

    private static void validateXml(Document document) {
        Schema schema = null;
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFactory.newSchema(new File("src/Ex5/Files/ex1.xsd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Objects.nonNull(schema)) {
            Validator validator = schema.newValidator();
            try {
                validator.validate(new DOMSource(document));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
