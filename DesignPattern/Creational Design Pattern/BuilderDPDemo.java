

import java.util.ArrayList;
import java.util.List;

interface Packing {

    public String pack();
}

class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }

}

class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}

interface Item {

    public String name();

    public Float price();

    public Packing packing();
}

abstract class ColdDrinks implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

}

abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

}

class VegBurger extends Burger {

    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public Float price() {
        return 16.9f;
    }

}

class NonVegBurger extends Burger {

    @Override
    public String name() {
        return "NonVeg Burger";
    }

    @Override
    public Float price() {
        return 25.9f;
    }

}

class Pepsi extends ColdDrinks {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public Float price() {
        return 10.0f;
    }

}

class Sprite extends ColdDrinks {

    @Override
    public String name() {
        return "Sprite";
    }

    @Override
    public Float price() {
        return 11.0f;
    }

}

class Meal {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {

        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }

}

class MealBuilder {

    public Meal vegMeal() {
        Meal meal = new Meal();
        meal.addItem(new Pepsi());
        meal.addItem(new VegBurger());
        return meal;
    }
    public Meal nonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new Pepsi());
        meal.addItem(new NonVegBurger());
        return meal;
    }
}

class BuilderDPDemo {

    public static void main(String args[]) {
        MealBuilder mb=new MealBuilder();
        Meal nonvegMeal=mb.nonVegMeal();
        nonvegMeal.showItems();
        Meal vegMeal=mb.vegMeal();
        vegMeal.showItems();
    }
}

