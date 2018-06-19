package by.training.epam.builder;

import by.training.epam.entity.Candy;
import by.training.epam.entity.CandyBean;

import java.util.ArrayList;
import java.util.List;


public class BeanBuilder {

    public static List<CandyBean> buildCandyBeanList(List<Candy> listOfCandy){

        List<CandyBean> resultList = new ArrayList<>();

        for (Candy candy : listOfCandy) {

            CandyBean bean = new CandyBean();

            bean.setId(candy.getId());
            bean.setType(candy.getType());
            bean.setEnergy(candy.getEnergy());
            bean.setName(candy.getName());
            bean.setWater(candy.getIngredients().getWater());
            bean.setSugar(candy.getIngredients().getSugar());
            bean.setVanillin(candy.getIngredients().getVanillin());
            bean.setFructose(candy.getIngredients().getFructose());
            if (candy.getIngredients().getChocolateType() != null){
                bean.setChocolateType(candy.getIngredients().getChocolateType());
            } else {
                bean.setChocolateType("");
            }
            bean.setProteins(candy.getValue().getProteins());
            bean.setFats(candy.getValue().getFats());
            bean.setCarbohydrates(candy.getValue().getCarbohydrates());
            bean.setProduction(candy.getProduction());
            if(candy.getFilling() != null){
                bean.setFilling(candy.getFilling());
            } else {
                bean.setFilling("");
            }

            resultList.add(bean);

        }

        return resultList;
    }

}
