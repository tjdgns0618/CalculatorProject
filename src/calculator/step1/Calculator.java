package calculator.step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = 0;
        int secondNum = 0;
        char operation = ' ';
        int result = 0;
        String again = "";

        while(!again.equals("exit")){
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
                sc.nextLine();      // 버퍼 비우기
                continue;           // 반복문 재시작
            }catch (Exception e){
                System.out.println("양의 정수를 입력해주세요.");
                continue;           // 반복문 재시작
            }

            while(true) {
                try {
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    operation = sc.next().charAt(0);
                    if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                        throw new Exception();
                    }
                    break;  // 정상적으로 종료되었다면 while문 탈출
                } catch (Exception e) {
                    System.out.println("사칙연산 기호를 입력해주세요!!!");
                }
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
                        continue;       // secondNum의 문제이기때문에 숫자입력부터 다시 받기
                    }
                    result = firstNum / secondNum;
                    break;
                default:
                    System.out.println("사칙연산이 아닌 값이 들어가 있습니다.");
                    break;
            }

            System.out.println("result = " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            sc.nextLine();          // 버퍼 비우기
            again = sc.nextLine();
        }
        sc.close();
    }
}
