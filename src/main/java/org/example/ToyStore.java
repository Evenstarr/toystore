package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToyStore {
    private final List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void addNewToy() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные игрушки:");
        String name;
        do {
            System.out.print("Имя: ");
            name = scanner.nextLine();
        } while (name.trim().isEmpty());

        int quantity;
        do {
            System.out.print("Количество: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Количество должно быть целым числом");
                scanner.next();
            }
            quantity = scanner.nextInt();
        } while (quantity <= 0);

        double weightPercentage;
        do {
            System.out.print("%% вес: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Вес должен быть действительным числом числом");
                scanner.next();
            }
            weightPercentage = scanner.nextDouble();
        } while (weightPercentage < 0 || weightPercentage > 100);


        Toy newToy = new Toy(name, quantity, weightPercentage);
        addToy(newToy);
        System.out.println("Новая игрушка успешно добавлена!");
    }

    public void play() {
        Toy prize = selectPrize();
        if (prize != null) {
            System.out.println("Поздравляем! Вы выиграли " + prize.getName());
            saveToTextFile(prize);
            prize.decreaseQuantity();
        } else {
            System.out.println("В розыгрыше не осталось игрушек.");
        }
        displayRemainingToys(); // Выводим оставшиеся игрушки после каждого розыгрыша
    }

    private Toy selectPrize() {
        double randomValue = Math.random() * 100;
        double cumulativeWeight = 0;

        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeightPercentage();
            if (randomValue <= cumulativeWeight) {
                return toy;
            }
        }

        return null; // No toy selected
    }

    private void saveToTextFile(Toy prize) {
        try (FileWriter writer = new FileWriter("winners.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bufferedWriter)) {

            out.println(prize.getId() + "," + prize.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayRemainingToys() {
        System.out.println("В магазине осталось:");
        for (Toy toy : toys) {
            System.out.println("ID: " + toy.getId() + ", Название: " + toy.getName() +
                    ", Количество: " + toy.getQuantity() + ", %% вес: " + toy.getWeightPercentage());
        }
    }
}
