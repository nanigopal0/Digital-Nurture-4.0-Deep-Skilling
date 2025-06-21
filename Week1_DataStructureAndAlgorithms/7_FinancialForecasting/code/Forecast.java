

public class Forecast {

    // Recursive method to predict future values
    public double calculateFutureValue(double currentValue, double growthRate, int remainingPeriods) {
        if (remainingPeriods == 0) { // Base case
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, remainingPeriods - 1);
    }


    public static void main(String[] args) {
        double startingValue = 2000.0;
        double growthRate = 0.08;      // 5% growth rate
        int forecastPeriods = 7;

        Forecast forecast = new Forecast();

        double futureValue = forecast.calculateFutureValue(startingValue, growthRate, forecastPeriods);

        System.out.println("The forecasted value after " + forecastPeriods + " periods is: " + futureValue);
    }
}
