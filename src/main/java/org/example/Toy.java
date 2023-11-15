package org.example;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weightPercentage;

    public Toy(int id, String name, int quantity, double weightPercentage) {
        this.id = id;
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