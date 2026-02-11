package reto2;

import java.util.ArrayList;
import java.util.List;

public class HamburgerBuilder {
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(String name, double price) {
        ingredients.add(new Ingredient(name, price));
    }

    public Hamburger build() {
        return new Hamburger(ingredients);
    }

    public Object addBread() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBread'");
    }
}
