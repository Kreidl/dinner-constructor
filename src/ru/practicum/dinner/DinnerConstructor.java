package ru.practicum.dinner;


import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    Dishes dishes = new Dishes();
    Random random = new Random();

    void addNewDish(String dishType, String dishName) {
        dishes.addNewDish(dishType, dishName);
    }

    Boolean searchDishType(String typeOfDish) {
        return dishes.SearchDishType(typeOfDish);
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> personalDishTypes) {
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String personalDishType : personalDishTypes) {
                ArrayList<String> allDishesThisType = dishes.getDishes(personalDishType);
                int indexDish = random.nextInt(allDishesThisType.size());
                String dishName = allDishesThisType.get(indexDish);
                combo.add(dishName);
            }
            System.out.println("Комбо " + (i + 1));
            System.out.println(combo);
        }
    }

    boolean isDishListEmpty () {
        return dishes.isDishListEmpty();
    }
}



