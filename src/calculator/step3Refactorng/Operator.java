package calculator.step3Refactorng;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operation;

    Operator(char operation) {
        this.operation = operation;
    }

    public static Operator getOperator(char operation) {   // static 함수로 만들어서 사용
        try {
            for (Operator operator : Operator.values()) {
                if (operator.operation == operation) {
                    return operator;
                }
            }
        }catch (Exception e) {
            System.out.println("사칙연산이 아닌 값이 들어가 있습니다.");
        }
        throw new IllegalArgumentException("사칙연산이 아닌 값이 들어가 있습니다.");
    }
}
