package builder;

public class Driver {

    public static void main(String[] args) {
        
        // Creating Dog 1 using the Builder Pattern
        Dog dog1 = new Dog.DogBuilder()
                .setName("Bruno")
                .setGender("Male")
                .setBreed("Pug")
                .setPrice(203.434)
                .build();

        // Creating Dog 2 (Notice the order doesn't matter)
        Dog dog2 = new Dog.DogBuilder()
                .setGender("Female")
                .setName("Alissa")
                .build();

        // Printing the results
        System.out.println(dog1);
        System.out.println(dog2);
    }
}