package by.training.epam.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ingredients", propOrder = {
        "water",
        "sugar",
        "fructose",
        "chocolateType",
        "vanillin"
})
public class Ingredients {

    protected int water;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected int sugar;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected int fructose;
    protected String chocolateType;
    @XmlElement(required = true)
    protected int vanillin;

    public int getWater() {
        return water;
    }

    public void setWater(int value) {
        this.water = value;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int value) {
        this.sugar = value;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int value) {
        this.fructose = value;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(String value) {
        this.chocolateType = value;
    }

    public int getVanillin() {
        return vanillin;
    }

    public void setVanillin(int value) {
        this.vanillin = value;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "water=" + water +
                ", sugar=" + sugar +
                ", fructose=" + fructose +
                ", chocolateType='" + chocolateType + '\'' +
                ", vanillin=" + vanillin +
                '}';
    }
}
