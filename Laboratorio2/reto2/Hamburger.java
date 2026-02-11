package reto2;

import java.util.List;

public class Hamburger {
    private final List<Ingredient> ingredients;

    public Hamburger(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getTotalPrice() {
        return ingredients.stream()
                .mapToDouble(i -> i.getPrice()) // LAMBDA
                .sum();
    }

    public void show() {
        System.out.println("\n🍔 HAMBURGUESA FINAL");
        ingredients.forEach(i ->
                System.out.println("- " + i.getName() + " ($" + i.getPrice() + ")")
        );
        System.out.println("💰 Total a pagar: $" + getTotalPrice());
    }
}
