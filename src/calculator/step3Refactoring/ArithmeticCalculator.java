package calculator.step3Refactoring;

import java.util.*;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    private final List<Double> results = new ArrayList<>();

    public double calculate(T firstNum, T secondNum, Operator operator) {
        double num1 = firstNum.doubleValue();
        double num2 = secondNum.doubleValue();

        // Enum의 biFunction을 이용하여서 (람다)연산 후 결과 출력
        return operator.calculate(num1, num2);
    }

    public List<Double> getResults() {
        return Collections.unmodifiableList(results);
    }

    public void addResult(double result) {
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

    public List<Double> getSearch(double number){
         return results.stream()
                 .filter(num -> num >= number)
                 .collect(Collectors.toList());
    }
}
