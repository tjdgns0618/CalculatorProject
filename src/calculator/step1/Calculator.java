package calculator.step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum;
        int secondNum;
        char operation;
        int result = 0;

        System.out.print("첫 번째 숫자를 입력하세요: ");
        try{
            firstNum = sc.nextInt();
            if(firstNum < 0) {
                throw new Exception();
            }
        }catch(InputMismatchException exception){
            System.out.println("양의 정수를 입력해주세요. 타입 미스 매치");
            return;
        }catch (Exception e){
            System.out.println("양의 정수를 입력해주세요.");
            return;
        }

        System.out.print("두 번째 숫자를 입력하세요: ");
        try{
            secondNum = sc.nextInt();
            if(secondNum < 0) {
                throw new Exception();
            }
        }catch(InputMismatchException exception){
            System.out.println("정수를 입력해주세요. 타입 미스 매치");
            return;
        }catch (Exception e){
            System.out.println("양의 정수를 입력해주세요.");
            return;
        }

        System.out.print("사칙연산 기호를 입력하세요: ");
        try{
            operation = sc.next().charAt(0);
            if(operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                throw new Exception();
            }
        }catch (Exception e){
            System.out.println("사칙연산 기호를 입력해주세요.");
            return;
        }

        switch (operation){
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if(secondNum == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return;
                }
                result = firstNum / secondNum;
                break;
            default:
                System.out.println("사칙연산이 아닌 값이 들어가 있습니다.");
                break;
        }

        System.out.println("result = " + result);

    }
}
