package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Result {
    private SimpleStringProperty nutrition;
    private SimpleStringProperty restaurant;
    private SimpleIntegerProperty value;

    public Result(String s1, String s2, int i){
        nutrition = new SimpleStringProperty(s1);
        restaurant = new SimpleStringProperty(s2);
        value = new SimpleIntegerProperty(i);
    }

    public String getNutrition() {
        return nutrition.get();
    }

    public void setNutrition(String s) {
        nutrition.set(s);
    }

    public String getRestaurant() {
        return restaurant.get();
    }

    public void setRestaurant(String s) {
        restaurant.set(s);
    }

    public Integer getValue() {
        return value.get();
    }

    public void setValue(int i) {
        value.set(i);
    }

    @Override
    public String toString() {
        return (restaurant.get() + ", " + nutrition.get() + " " + value.get() );
    }
}
