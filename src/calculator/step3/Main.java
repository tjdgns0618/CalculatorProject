package calculator.step3;

import calculator.step2.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        int firstNum = 0;
        int secondNum = 0;
        int result = 0;
        char operation = ' ';
        String again = "";
        Operator operator = Operator.PLUS;

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

            if(operation == '/' && secondNum == 0){
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            operator = Operator.getOperation(operation);    // Enum을 이용하여 연산 기호 설정

            result = calculator.calculate(firstNum,secondNum, operator);
//            calculator.setResults(result);      // 세터를 이용한 결과값 저장

            System.out.println("계산결과 : " + result);

            System.out.print("더 계산하시겠습니까? (remove 입력시 삭제모드 진입, exit 입력 시 종료) : ");
            sc.nextLine();          // 버퍼 비우기
            again = sc.nextLine();

//            if(again.equals("remove")) {            // 삭제 모드
//                while (!again.equals("no")) {
//                    System.out.println("삭제하시겠습니까? (yes 입력시 첫 결과값 삭제, no 입력 시 삭제 모드 종료)");
//                    System.out.println("저장된 결과값 : " + calculator.getResults());
//                    again = sc.nextLine();
//                    if (again.equals("yes"))
//                        calculator.removeResult();  // 가장 먼저 저장된 데이터 삭제 비었을경우 빈값 출력
//                }   // 아 어떻게 exit 입력으로 돌아가지
//            }
        }
        sc.close();
    }
}
