import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import data.ActionsData;
import data.AnimalsDataEnum;
import tools.IsNumericCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Animal> animalList = new ArrayList<>();

        while (true) {
            ActionsData inputData = null;
            while (inputData == null) {
                System.out.println("Введите команду " + Arrays.toString(ActionsData.values()));
                String userData = scanner.nextLine();
                try {
                    inputData = ActionsData.toEnumActionsFunc(userData);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Введена неверная команда, попробуйте снова");
                }
            }
            switch (inputData) {
                case ADD:

                    Animal animal = getAnimal();

                    animalList.add(animal);
                    break;

                case LIST:
                    System.out.println(animalList);
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }

    private static Animal getAnimal() {
        AnimalsDataEnum animalType = null;
        while (animalType == null) {
            System.out.println("Введите тип животного, которое хотите добавить " + Arrays.toString(AnimalsDataEnum.values()));
            String scannerUserData = scanner.nextLine();
            try {
                animalType = AnimalsDataEnum.toEnumAnimalsData(scannerUserData);
            } catch (IllegalArgumentException ex) {
                System.out.println("Невозможно создать животное такого типа, повторите попытку!");
            }

        }

        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.println("Введите возраст: ");
            String ageStr = scanner.nextLine();
            if (IsNumericCheck.isNumeric(ageStr)) {
                age = Integer.parseInt(ageStr);
                break;
            }
            System.out.println("Неподдерживаемый тип данных");
        }
        int weight;
        while (true) {
            System.out.println("Введите вес: ");
            String weightStr = scanner.nextLine();
            if (IsNumericCheck.isNumeric(weightStr)) {
                weight = Integer.parseInt(weightStr);
                break;
            }
            System.out.println("Неподдерживаемый тип данных");
        }

        System.out.println("Введите цвет: ");
        String color = scanner.nextLine();


        return AnimalsFactory.animalsFactory(animalType, name, age, weight, color);
    }
}