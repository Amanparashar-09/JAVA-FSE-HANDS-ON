public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) return presentValue;
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Present Value: %.2f%n", presentValue);
        System.out.printf("Growth Rate: %.0f%%%n", growthRate * 100);
        System.out.printf("Years: %d%n", years);
        System.out.printf("Future Value: %.2f%n", futureValue);
    }
}
