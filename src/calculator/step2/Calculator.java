package calculator.step2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {

    private ArrayList<Integer> results = new ArrayList<>();

    public int calculate(int firstNum, int secondNum, char operation){
        switch (operation){
            case '+':
                return (firstNum + secondNum);
            case '-':
                return (firstNum - secondNum);
            case '*':
                return (firstNum * secondNum);
            case '/':
                return (firstNum / secondNum);
            default:
                System.out.println("사칙연산이 아닌 값이 들어가 있습니다.");
                break;
        }
        return 0;
    }

    public ArrayList<Integer> getResults() {
        return results;
    }

    public void setResults(int result) {
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
}
