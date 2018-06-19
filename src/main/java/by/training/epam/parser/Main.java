package by.training.epam.parser;

import by.training.epam.builder.BeanBuilder;
import by.training.epam.builder.CandiesBuilderFactory;
import by.training.epam.entity.Candy;
import by.training.epam.entity.CandyBean;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CandiesBuilderFactory builderFactory = new CandiesBuilderFactory();
        XMLParser parser = builderFactory.createCandiesListBuilder("SAX");
        List<Candy> list = parser.createCandiesList();
        List<CandyBean> beanList = BeanBuilder.buildCandyBeanList(list);
        for (CandyBean c:beanList) {
            System.out.println(c);
        }
    }
}
