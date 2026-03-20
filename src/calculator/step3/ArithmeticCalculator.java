package calculator.step3;

import calculator.step1.Calculator;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class ArithmeticCalculator {
    private int result;

    public int calculate(int firstNum, int secondNum, Operator operator) {

        switch (operator){
            case PLUS:
                this.result = firstNum + secondNum;
                break;
            case MINUS:
                this.result = firstNum - secondNum;
                break;
            case MULTIPLY:
                this.result = firstNum * secondNum;
                break;
            case DIVIDE:
                this.result = firstNum / secondNum;
                break;
            default:
                System.out.println("사칙연산이 아닌 값이 들어가 있습니다.");
                break;

        }
        return this.result;
    }


}
