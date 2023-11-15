package org.example;

import java.util.Scanner;

public class ToyStoreApp {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        Toy toy1 = new Toy("Кукла", 10, 30);
        Toy toy2 = new Toy("Машинка", 15, 40);
        Toy toy3 = new Toy("Робот", 5, 20);
        Toy toy4 = new Toy("Мишка", 4, 10);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);
        toyStore.addToy(toy4);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Играть");
            System.out.println("2. Добавить новую игрушку");
            System.out.println("3. Выход");
            System.out.print("Введите свой выбор: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    toyStore.play();
                    break;
                case 2:
                    toyStore.addNewToy();
                    break;
                case 3:
                    System.out.println("Выход, до свидания!");
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        } while (choice != 3);
    }
}
