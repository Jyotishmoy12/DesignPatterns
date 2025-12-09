// Kiss principle stands for Keep It Simple, Stupid

class Calculator {
    public double calculate(String operator, double a, double b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0)
                    throw new IllegalArgumentException("Division by zero");
                yield a / b;
            }
            default -> throw new UnsupportedOperationException("Unknown operator: " + operator);
        };
    }
}
