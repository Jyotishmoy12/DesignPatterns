package observer;

public class AverageTemperatureDisplay implements Observer {
    private int sumOfTemperature;
    private int totalTemperatures;

    public AverageTemperatureDisplay(Observable observable) {
        sumOfTemperature = 0;
        totalTemperatures = 0;
        observable.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        sumOfTemperature += temperature;
        totalTemperatures += 1;
        display();
    }

    public void display() {
        System.out.println("Average temperature: " + sumOfTemperature / totalTemperatures + "°C");
    }
}
