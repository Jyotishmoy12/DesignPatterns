package decorator;


// Difference between an abstract class and a normal class:
// - An abstract class cannot be instantiated, but a normal class can.
//   (Instantiated means we can create an object from the class.)
public abstract class Burger {
    private String description;
    private double cost;

    public abstract String getDescription();

    public abstract double getCost();
}