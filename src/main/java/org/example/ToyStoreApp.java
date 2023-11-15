package org.example;

public class ToyStoreApp {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        Toy toy1 = new Toy(1, "Кукла", 10, 30);
        Toy toy2 = new Toy(2, "Машинка", 15, 40);
        Toy toy3 = new Toy(3, "Робот", 5, 20);
        Toy toy4 = new Toy(4, "Мишка", 4, 10);

        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);
        toyStore.addToy(toy4);

        toyStore.play();
    }
}
