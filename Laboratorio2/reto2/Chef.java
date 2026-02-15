package reto2;

public class Chef {

    public static Hamburger prepararHamburguesaPersonalizada() {
        return ((Object) new HamburgerBuilder()
                .addBread())
                .addMeat()
                .addCheese()
                .addVegetables()
                .addSauce("BBQ")
                .build();
    }
}
