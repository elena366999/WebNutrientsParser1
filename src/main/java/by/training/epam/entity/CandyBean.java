package by.training.epam.entity;

import java.io.Serializable;

public class CandyBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int energy;
    private int water;
    private int sugar;
    private int fructose;
    private String chocolateType;
    private int vanillin;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private String production;
    private String id;
    private String type;
    private String filling;

    public CandyBean() {

    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getWater() {
        return water;
    }

    public int getSugar() {
        return sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public int getVanillin() {
        return vanillin;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public String getProduction() {
        return production;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getFilling() {
        return filling;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    public void setVanillin(int vanillin) {
        this.vanillin = vanillin;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    @Override
    public String toString() {
        return "CandyBean{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", water=" + water +
                ", sugar=" + sugar +
                ", fructose=" + fructose +
                ", chocolateType='" + chocolateType + '\'' +
                ", vanillin=" + vanillin +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", production='" + production + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", filling='" + filling + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + carbohydrates;
        result = prime * result + ((chocolateType == null) ? 0 : chocolateType.hashCode());
        result = prime * result + energy;
        result = prime * result + fats;
        result = prime * result + fructose;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((production == null) ? 0 : production.hashCode());
        result = prime * result + proteins;
        result = prime * result + sugar;
        result = prime * result + ((filling == null) ? 0 : filling.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + vanillin;
        result = prime * result + water;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CandyBean other = (CandyBean) obj;
        if (carbohydrates != other.carbohydrates)
            return false;
        if (chocolateType == null) {
            if (other.chocolateType != null)
                return false;
        } else if (!chocolateType.equals(other.chocolateType))
            return false;
        if (energy != other.energy)
            return false;
        if (fats != other.fats)
            return false;
        if (fructose != other.fructose)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (production == null) {
            if (other.production != null)
                return false;
        } else if (!production.equals(other.production))
            return false;
        if (proteins != other.proteins)
            return false;
        if (sugar != other.sugar)
            return false;
        if (filling == null) {
            if (other.filling != null)
                return false;
        } else if (!filling.equals(other.filling))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return vanillin == other.vanillin && water == other.water;
    }
}