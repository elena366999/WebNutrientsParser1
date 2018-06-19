package by.training.epam.parser;

import java.util.ArrayList;
import java.util.List;


import by.training.epam.entity.Candy;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleCandyHandler extends DefaultHandler {

    private List<Candy> candies;
    private Candy currentCandy;
    private String tmpValue;

    public SimpleCandyHandler() {
        candies = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {

        if(localName.equals(TagConstants.CANDY)){
            currentCandy = new Candy();
            currentCandy.setId(attrs.getValue(TagConstants.ID));
            currentCandy.setType(attrs.getValue(TagConstants.TYPE));
            if (attrs.getValue(TagConstants.FILLING) != null){
                currentCandy.setFilling(attrs.getValue(TagConstants.FILLING));
            } else {
                currentCandy.setFilling("-");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        switch (localName){

            case TagConstants.CANDY:
                candies.add(currentCandy);
                break;
            case TagConstants.NAME:
                currentCandy.setName(tmpValue);
                break;
            case TagConstants.ENERGY:
                currentCandy.setEnergy(Integer.valueOf(tmpValue));
                break;
            case TagConstants.WATER:
                currentCandy.getIngredients().setWater(Integer.valueOf(tmpValue));
                break;
            case TagConstants.SUGAR:
                currentCandy.getIngredients().setSugar(Integer.valueOf(tmpValue));
                break;
            case TagConstants.FRUCTOSE:
                currentCandy.getIngredients().setFructose(Integer.valueOf(tmpValue));
                break;
            case TagConstants.VANILLIN:
                currentCandy.getIngredients().setVanillin(Integer.valueOf(tmpValue));
                break;
            case TagConstants.CHOCOLATE_TYPE:
                currentCandy.getIngredients().setChocolateType(tmpValue);
                break;
            case TagConstants.PROTEINS:
                currentCandy.getValue().setProteins(Integer.valueOf(tmpValue));
                break;
            case TagConstants.FATS:
                currentCandy.getValue().setFats(Integer.valueOf(tmpValue));
                break;
            case TagConstants.CARBOHYDRATES:
                currentCandy.getValue().setCarbohydrates(Integer.valueOf(tmpValue));
                break;
            case TagConstants.PRODUCTION:
                currentCandy.setProduction(tmpValue);
                break;
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tmpValue = new String(ch, start, length);
    }

    @Override
    public void endDocument() throws SAXException {
    }

    public List<Candy> getCandiesList(){
        return this.candies;
    }

}
