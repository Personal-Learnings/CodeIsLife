package com.learnings.practise.designpatterns;

public class Decorator {
    public static void main(String[] args) {
        Pizza pizza = new Margaretta();
        System.out.println( pizza.getDescription() + ", Cost : " + pizza.getCost());

        Pizza pizza2 = new FarmHouse();
        System.out.println( pizza2.getDescription() + ", Cost : " + pizza2.getCost());
        pizza2 = new FreshTomato(pizza2);
        System.out.println( pizza2.getDescription() + ", Cost : " + pizza2.getCost());
        pizza2 = new Paneer(pizza2);
        System.out.println( pizza2.getDescription() + ", Cost : " + pizza2.getCost());
    }
}

abstract class Pizza {
    String description = "Unknown Pizza";
    public String getDescription() { return description; }
    public abstract int getCost();
}

abstract class ToppingsDecorator extends Pizza {
    public abstract String getDescription();
}

class FarmHouse extends Pizza {
    public FarmHouse() {  description = "FarmHouse"; }
    public int getCost() { return 200; }
}

class Margaretta extends Pizza {
    public Margaretta()  { description = "Margaretta"; }
    public int getCost() { return 100;  }
}

class FreshTomato extends ToppingsDecorator {
    Pizza pizza;
    public FreshTomato(Pizza pizza) { this.pizza = pizza; }
    public String getDescription() { return pizza.getDescription() + ", Fresh Tomato"; }
    public int getCost() { return 40 + pizza.getCost(); }
}

class Paneer extends ToppingsDecorator {
    Pizza pizza;
    public Paneer(Pizza pizza)  {  this.pizza = pizza; }
    public String getDescription() { return pizza.getDescription() + ", Paneer"; }
    public int getCost()  {  return 70 + pizza.getCost(); }
}