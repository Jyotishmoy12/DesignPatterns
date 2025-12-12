package observer;

public class CurrentWeatherConditionDisplay implements Observer {
    private int temperature;
    private int humidity;

    public CurrentWeatherConditionDisplay(Observable observable) {
        observable.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current weather condition: " + temperature + "°C, " + humidity + "% humidity");
    }
}
