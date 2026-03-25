package calculator.step3Refactorng;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    // Enum에서 biFucntion을 이용해서 람다식을 만들었기 때문에 사용 안하게 됨
//    final private LambdaTest addNum =  Double::sum;
//    final private LambdaTest minusNum =  (a, b) -> a - b;
//    final private LambdaTest multiplyNum =  (a, b) -> a * b;
//    final private LambdaTest divideNum =  (a, b) -> a / b;

    ArrayList<Double> results = new ArrayList<>();

    public double calculate(T firstNum, T secondNum, Operator operator) {
        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();

        // Enum의 biFunction을 이용하여서 (람다)연산 후 결과 출력
        double result = operator.calculate(num1, num2);

        return result;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(double result) {
        this.results.add(result);
    }

    public void removeResult(){
        try {
            // removeFirst는 jdk 21 버전 부터 호환되는 최신 문법이고 이전버전에서는 remove(0)을 사용
            this.results.removeFirst();
        }catch (NoSuchElementException e){
            System.out.println("더 이상 지울 값이 없습니다.");
        }
    }

    public ArrayList<Double> getSearch(double number){
         return results.stream()
                 .filter(num -> num >= number)
                 .collect(Collectors.toCollection(ArrayList::new));
    }
}
