package observer;

public class MainDriverClass {
    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentWeatherConditionDisplay currentWeatherConditionDisplay = new CurrentWeatherConditionDisplay(
                weatherStation);
        AverageTemperatureDisplay averageTemperatureDisplay = new AverageTemperatureDisplay(weatherStation);

        weatherStation.parameterChanged(20, 50);
        delay();
        weatherStation.parameterChanged(25, 55);
        delay();
        weatherStation.parameterChanged(30, 60);
    }
}
