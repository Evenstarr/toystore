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
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Количество: ");
        int quantity = scanner.nextInt();
        System.out.print("Вес %%: ");
        double weightPercentage = scanner.nextDouble();

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
