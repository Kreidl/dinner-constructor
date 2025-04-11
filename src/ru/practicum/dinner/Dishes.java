package ru.practicum.dinner;


import java.util.ArrayList;
import java.util.HashMap;

public class Dishes {
    HashMap<String, ArrayList<String>> dishesPerTypes = new HashMap<>();

    void addNewDish(String dishType, String dishName) {
        if (!(dishesPerTypes.containsKey(dishType))) {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dishesPerTypes.put(dishType, dishes);
        } else {
            ArrayList<String> thisDishes = dishesPerTypes.get(dishType);
            thisDishes.add(dishName);
        }
    }

    Boolean SearchDishType(String typeOfDish) {
        boolean isTypeOfDishOnDishList = false;
        for (String dish : dishesPerTypes.keySet()) {
            if (dish.equals(typeOfDish)) {
                isTypeOfDishOnDishList = true;
                break;
            }
        }
        return isTypeOfDishOnDishList;
    }

    ArrayList<String> getDishes(String typeOfDishes) {
        return dishesPerTypes.get(typeOfDishes);
    }
}



