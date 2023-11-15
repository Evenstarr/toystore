package org.example;

public class Toy {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int quantity;
    private double weightPercentage;

    public Toy(String name, int quantity, double weightPercentage) {
        this.id = idCounter++;
        this.name = name;
        this.quantity = quantity;
        this.weightPercentage = weightPercentage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeightPercentage() {
        return weightPercentage;
    }

    public void setWeightPercentage(double weightPercentage) {
        this.weightPercentage = weightPercentage;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}