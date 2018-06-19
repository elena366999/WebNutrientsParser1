package by.training.epam.builder;
import by.training.epam.parser.DOMParser;
import by.training.epam.parser.MySAXParser;
import by.training.epam.parser.StAXParser;
import by.training.epam.parser.XMLParser;

public class CandiesBuilderFactory {

    private enum TypeParser {
        SAX, STAX, DOM
    }

    public XMLParser createCandiesListBuilder(String typeParser){

        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());

        switch (type){
            case SAX:
                return new MySAXParser();
            case DOM:
                return new DOMParser();
            case STAX:
                return StAXParser.getInstance();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }

    }
}