package calculator.step3;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArithmeticCalculator<T extends Number> {
    private double result;

    ArrayList<T> results = new ArrayList<>();
//    ArrayList<T> searchs = new ArrayList<>();

    public double calculate(T firstNum, T secondNum, Operator operator) {
        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();

        switch (operator){
            case PLUS:
                this.result = num1 + num2;
                break;
            case MINUS:
                this.result = num1 - num2;
                break;
            case MULTIPLY:
                this.result = num1 * num2;
                break;
            case DIVIDE:
                this.result = Math.round(num1 / num2 * 100) / 100.0;    // 소숫점 2자리까지만 반올림
                break;
            default:
                System.out.println("사칙연산이 아닌 값이 들어가 있습니다.");
                break;
        }
        return this.result;
    }

    public ArrayList<T> getResults() {
        return results;
    }

    public void setResults(T result) {
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

//    public ArrayList<T> getSearch(){
//        searchs.clear();
//        for(T t : results){
//            if(t > this.result){
//                searchs.add(t);
//            }
//        }
//        return searchs;
//    }
}
