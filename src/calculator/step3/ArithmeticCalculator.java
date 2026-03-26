package calculator.step3;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArithmeticCalculator<T extends Number> {
    private double result;
    final private LambdaTest addNum =  (a, b) -> a + b;
    final private LambdaTest minusNum =  (a, b) -> a - b;
    final private LambdaTest multiplyNum =  (a, b) -> a * b;
    final private LambdaTest divideNum =  (a, b) -> a / b;

    private final ArrayList<Double> results = new ArrayList<>();
//    ArrayList<Double> searchs = new ArrayList<>();

    public double calculate(T firstNum, T secondNum, Operator operator) {
        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();

        switch (operator){
            case PLUS:
                this.result = addNum.apply(num1, num2);
                break;
            case MINUS:
                this.result = minusNum.apply(num1, num2);
                break;
            case MULTIPLY:
                this.result = multiplyNum.apply(num1, num2);
                break;
            case DIVIDE:
                this.result = Math.round(divideNum.apply(num1,num2) * 100) / 100.0; // 소숫점 2자리까지만 반올림
                break;
            default:
                System.out.println("사칙연산이 아닌 값이 들어가 있습니다.");
                break;
        }
        return this.result;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(double result) {
        this.results.add(result);
    }

    public void removeResult(){
        try {
            this.results.removeFirst();
        }catch (NoSuchElementException e){
            System.out.println("더 이상 지울 값이 없습니다.");
            return;
        }
    }

//    public ArrayList<T> getSearch(T number){
//        searchs.clear();
//        searchs = results.stream().filter(num -> num >= number).collect(Collectors.toList());
//
//        return searchs;
//    }
}
