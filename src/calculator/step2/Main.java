package calculator.step2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = 0;
        int secondNum = 0;
        int result = 0;
        char operation = ' ';

        Calculator calculator = new Calculator();

        try{
            System.out.print("첫 번째 숫자를 입력하세요: ");
            firstNum = sc.nextInt();
            if(firstNum < 0) {
                throw new Exception();
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNum = sc.nextInt();
            if(secondNum < 0) {
                throw new Exception();
            }
        }catch(InputMismatchException exception){
            System.out.println("양의 정수를 입력해주세요. 타입 미스 매치");
            return;
        }catch (Exception e){
            System.out.println("양의 정수를 입력해주세요.");
            return;
        }

        try {
            System.out.print("사칙연산 기호를 입력하세요: ");
            operation = sc.next().charAt(0);
            if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("사칙연산 기호를 입력해주세요!!!");
            return;
        }

        result = calculator.calculate(firstNum,secondNum,operation);
        calculator.setResults(result);
        System.out.println("result = " + result);
        System.out.println("Results = " + calculator.getResults());


    }
}
