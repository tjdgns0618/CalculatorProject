package calculator.step3Refactorng;

import java.util.InputMismatchException;
import java.util.Scanner;

// 사용자의 입력을 받는 함수 선언할 클래스
public class Input {
    final private Scanner sc = new Scanner(System.in);
    final private ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();

    // 숫자를 입력 받는 함수
    public double inputNumber(String desc){
        while(true) {
            try {
                System.out.print(desc);
                double num = sc.nextDouble();
                if (num < 0) {
                    throw new InputMismatchException();
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("양의 실수를 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 사직연산 기호를 입력 받는 함수
    public Operator inputOperator(){
        while (true) {
            try {
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operation = sc.next().charAt(0);
                if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                    throw new Exception();
                }else {
                    return Operator.getOperator(operation);
                }
            } catch (Exception e) {
                System.out.println("사칙연산 기호만 입력해주세요!!!");
                sc.nextLine();
            }
        }
    }

    // remove입력시 삭제모드 , exit 입력시 프로그램 종료
    public String inputAgain(){
        return sc.next();
    }
}
