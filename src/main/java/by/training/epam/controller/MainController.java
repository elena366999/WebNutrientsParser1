package by.training.epam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.epam.builder.BeanBuilder;
import by.training.epam.builder.CandiesBuilderFactory;
import by.training.epam.entity.Candy;
import by.training.epam.entity.CandyBean;
import by.training.epam.parser.XMLParser;
//@WebServlet("/mainController")

public class MainController extends HttpServlet {

    private static final String CANDIES_VIEW_JSP = "/views/candiesList.jsp";
//    private static final String VALIDATION_FALSE_JSP = "/views/validationFalse.jsp";
    private static final String CANDIES_LIST_ATTRIBUTE = "candiesList";
//    private static final String SCHEMA_NAME = "by/training/epam/res/CandiesXSD.xsd";
    private static final String FILE_NAME = "by/training/epam/res/Candies.xml";
    private static String parserType;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

    //    if (req.getSession().getAttribute(CANDIES_LIST_ATTRIBUTE) == null) {
//            XMLValidator validator = new XMLValidator();
//            boolean isValid = validator.validate(fileName, schemaName);
////            if (isValid) {

        CandiesBuilderFactory builderFactory = new CandiesBuilderFactory();
        String button = req.getParameter("button");

        if ("dom".equals(button)) {
            parserType = "DOM";
        } else if ("sax".equals(button)) {
            parserType = "SAX";
        } else if ("stax".equals(button)) {
            parserType = "STAX";
        }

        XMLParser parser = builderFactory.createCandiesListBuilder(parserType);
        List<Candy> list = parser.createCandiesList();
        List<CandyBean> beanList = BeanBuilder.buildCandyBeanList(list);
        req.getSession().setAttribute(CANDIES_LIST_ATTRIBUTE, beanList);
        getServletContext().getRequestDispatcher(CANDIES_VIEW_JSP).forward(req, resp);
//            } else {
//                getServletContext().getRequestDispatcher(VALIDATION_FALSE_JSP).forward(req, resp);
//            }

        }

}

