package calculator.step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        try{
            int firstNum = sc.nextInt();
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
            int secondNum = sc.nextInt();
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


    }
}
