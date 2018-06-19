package by.training.epam.parser;

import by.training.epam.entity.Candy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class StAXParser implements XMLParser {

    private static final StAXParser instance = new StAXParser();

    private StAXParser() {
    }

    public static StAXParser getInstance() {
        return instance;
    }

    @Override
    public List<Candy> createCandiesList() {
        String fileName = "src\\main\\java\\by\\training\\epam\\res\\Candies.xml";
        List<Candy> resultList = new ArrayList<>();

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            InputStream is = new FileInputStream(new File(fileName));
            XMLEventReader eventReader = inputFactory.createXMLEventReader(is);
            Candy item = null;

            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    if (startElement.getName().getLocalPart().equals(TagConstants.CANDY)) {
                        item = new Candy();

                        @SuppressWarnings("unchecked")
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        Attribute attribute;

                        while (attributes.hasNext()) {
                            attribute = attributes.next();

                            if (attribute.getName().toString().equals(TagConstants.ID)) {
                                item.setId(attribute.getValue());
                            }
                            if (attribute.getName().toString().equals(TagConstants.TYPE)) {
                                item.setType(attribute.getValue());
                            }
                            if (attribute.getName().toString().equals(TagConstants.FILLING)) {
                                item.setFilling(attribute.getValue());
                            }
                        }

                    }

                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.NAME)) {
                        event = eventReader.nextEvent();
                        item.setName(event.asCharacters().getData());
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.ENERGY)) {
                        event = eventReader.nextEvent();
                        item.setEnergy(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.WATER)) {
                        event = eventReader.nextEvent();
                        item.getIngredients().setWater(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.SUGAR)) {
                        event = eventReader.nextEvent();
                        item.getIngredients().setSugar(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.FRUCTOSE)) {
                        event = eventReader.nextEvent();
                        item.getIngredients().setFructose(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.VANILLIN)) {
                        event = eventReader.nextEvent();
                        item.getIngredients().setVanillin(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.CHOCOLATE_TYPE)) {
                        event = eventReader.nextEvent();
                        item.getIngredients().setChocolateType(event.asCharacters().getData());
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.PROTEINS)) {
                        event = eventReader.nextEvent();
                        item.getValue().setProteins(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.FATS)) {
                        event = eventReader.nextEvent();
                        item.getValue().setFats(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.CARBOHYDRATES)) {
                        event = eventReader.nextEvent();
                        item.getValue().setCarbohydrates(Integer.valueOf(event.asCharacters().getData()));
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals(TagConstants.PRODUCTION)) {
                        event = eventReader.nextEvent();
                        item.setProduction(event.asCharacters().getData());
                        continue;
                    }

                }

                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(TagConstants.CANDY)) {
                        resultList.add(item);

                    }

                }

            }

        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(e.getMessage());
        }

        return resultList;
    }

}
