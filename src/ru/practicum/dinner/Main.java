package ru.practicum.dinner;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Программа завершена. Хорошего дня!");
                    return;
                default:
                    System.out.println("Неверная команда.");

            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (dc.isDishListEmpty()) {
            System.out.println("Список блюд пуст.");
        } else {
            System.out.println("Начинаем конструировать обед...");
            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
            int numberOfCombos = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
            String nextItem = scanner.nextLine();
            ArrayList<String> personalDishTypes = new ArrayList<>();

            while (!nextItem.isEmpty()) {
                if (dc.searchDishType(nextItem)) {
                    personalDishTypes.add(nextItem);
                    nextItem = scanner.nextLine();
                } else {
                    System.out.println("Такого типа блюда нет в наличии.");
                    nextItem = scanner.nextLine();
                }
            }
            dc.generateDishCombo(numberOfCombos, personalDishTypes);
        }
    }
}
