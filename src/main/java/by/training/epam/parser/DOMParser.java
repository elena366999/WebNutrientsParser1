package by.training.epam.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import by.training.epam.entity.Candy;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser implements XMLParser {

    @Override
    public List<Candy> createCandiesList() {
        String fileName = "src\\main\\java\\by\\training\\epam\\res\\Candies.xml";

        List<Candy> list = new ArrayList<>();
        File xmlFile = new File(fileName);

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList candyNodeList = doc.getElementsByTagName("candy");

            for (int i = 0; i < candyNodeList.getLength(); i++) {
                Node node = candyNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    list.add(createCandyFromElement((Element) node));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    private Candy createCandyFromElement(Element candyElement) {

        Candy candy = new Candy();
        candy.setId(candyElement.getAttribute(TagConstants.ID));
        candy.setType(candyElement.getAttribute(TagConstants.TYPE));
        if (candyElement.hasAttribute(TagConstants.FILLING)) {
            candy.setFilling(candyElement.getAttribute(TagConstants.FILLING));
        } else {
            candy.setFilling("-");
        }

        candy.setName(candyElement.getElementsByTagName(TagConstants.NAME).item(0).getTextContent());
        candy.setEnergy(Integer.valueOf(candyElement.getElementsByTagName(TagConstants.ENERGY).item(0).getTextContent()));
        String water = candyElement.getElementsByTagName(TagConstants.WATER).item(0).getTextContent();
        candy.getIngredients().setWater(Integer.valueOf(water));
        String sugar = candyElement.getElementsByTagName(TagConstants.SUGAR).item(0).getTextContent();
        candy.getIngredients().setSugar(Integer.valueOf(sugar));
        String fructose = candyElement.getElementsByTagName(TagConstants.FRUCTOSE).item(0).getTextContent();
        candy.getIngredients().setFructose(Integer.valueOf(fructose));
        String vanilla = candyElement.getElementsByTagName(TagConstants.VANILLIN).item(0).getTextContent();
        candy.getIngredients().setVanillin(Integer.valueOf(vanilla));
        if (candyElement.getElementsByTagName(TagConstants.CHOCOLATE_TYPE).item(0) != null) {
            candy.getIngredients()
                    .setChocolateType(candyElement.getElementsByTagName(TagConstants.CHOCOLATE_TYPE).item(0).getTextContent());
        } else {
            candy.getIngredients().setChocolateType("");
        }
        String proteins = candyElement.getElementsByTagName(TagConstants.PROTEINS).item(0).getTextContent();
        candy.getValue().setProteins(Integer.valueOf(proteins));
        candy.getValue().setFats(Integer.valueOf(candyElement.getElementsByTagName(TagConstants.FATS).item(0).getTextContent()));
        candy.getValue().setCarbohydrates(Integer.valueOf(candyElement.getElementsByTagName(TagConstants.CARBOHYDRATES).item(0).getTextContent()));
        candy.setProduction(candyElement.getElementsByTagName(TagConstants.PRODUCTION).item(0).getTextContent());

        return candy;
    }

}