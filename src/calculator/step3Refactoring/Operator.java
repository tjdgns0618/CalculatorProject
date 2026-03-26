package calculator.step3Refactoring;

import java.util.function.BiFunction;

public enum Operator {
    // 계속해서 "람다를 메서드 참조로 바꿀 수 있음" 라는 오류가 떠서 찾아보니
    // 이미 존재하는 식이 있으니 사용하라는 추천이였다. (a, b) -> a + b == Double::sum
    ADD('+', Double::sum),
    SUBTRACT('-', (a, b) -> a - b),
    MULTIPLY('*',(a,b) -> a * b ),
    DIVIDE('/', (a,b) -> Math.round(a / b * 100) / 100.0);

    private final char operation;

    private final BiFunction<Double, Double, Double> expression;

    Operator(char operation, BiFunction<Double, Double, Double> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public double calculate(double num1, double num2) {
        return expression.apply(num1, num2);
    }

    public static Operator getOperator(char operation) {   // static 함수로 만들어서 사용
        for (Operator operator : Operator.values()) {
            if (operator.operation == operation) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산이 아닌 값이 들어가 있습니다.");
    }
}
