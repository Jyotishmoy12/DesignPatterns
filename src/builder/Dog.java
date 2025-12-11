package builder;

public class Dog {
    private String name;
    private String gender;
    private String breed;
    private double price;
    public Dog(DogBuilder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.breed = builder.breed;
        this.price = builder.price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBreed() {
        return breed;
    }

    public double getPrice() {
        return price;
    }

    // toString method added so you can print the object clearly
    @Override
    public String toString() {
        return "Dog [name=" + name + ", gender=" + gender + ", breed=" + breed + ", price=" + price + "]";
    }
    public static class DogBuilder {
        private String name;
        private String gender;
        private String breed;
        private double price;

        public DogBuilder setName(String name) {
            this.name = name;
            return this; // Returns 'this' to allow method chaining
        }

        public DogBuilder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public DogBuilder setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Dog build() {
            return new Dog(this);
        }
    }
}