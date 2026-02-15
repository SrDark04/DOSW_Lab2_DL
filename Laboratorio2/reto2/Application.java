package reto2;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        ejecutar();
    }

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        HamburgerBuilder builder = new HamburgerBuilder();
        int option;

        do {
            System.out.println("\n MENÚ DE INGREDIENTES");
            System.out.println("1. Pan ($2000)");
            System.out.println("2. Carne ($5000)");
            System.out.println("3. Queso ($1500)");
            System.out.println("4. Vegetales ($1000)");
            System.out.println("5. Salsa ($800)");
            System.out.println("0. Terminar pedido");
            System.out.print("Seleccione una opción: ");

            option = sc.nextInt();

            switch (option) {
                case 1 -> builder.addIngredient("Pan", 2000);
                case 2 -> builder.addIngredient("Carne", 5000);
                case 3 -> builder.addIngredient("Queso", 1500);
                case 4 -> builder.addIngredient("Vegetales", 1000);
                case 5 -> builder.addIngredient("Salsa", 800);
                case 0 -> System.out.println("");
                default -> System.out.println("Opción inválida");
            }

        } while (option != 0);

        Hamburger hamburger = builder.build();
        hamburger.show();
    }
}
