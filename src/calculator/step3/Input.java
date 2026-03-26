package calculator.step3;

import java.util.InputMismatchException;
import java.util.Scanner;

// 사용자의 입력을 받는 함수 선언할 클래스
public class Input {
    private double firstNum;
    private double secondNum;
    final private Scanner sc = new Scanner(System.in);
    final private ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();

    /*
    이 코드에서는 재귀호출 방식으로 이루어져있어 StackOverflow가 발생할 수 있다.
    이 방식을 최대한 피하도록 해야겠다.
     */

    // 숫자를 입력 받는 함수
    public void inputNumbers(){
        while(true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                firstNum = sc.nextDouble();
                if (firstNum < 0) {
                    throw new Exception();
                }
                System.out.print("두 번째 숫자를 입력하세요: ");
                secondNum = sc.nextDouble();
                if (secondNum < 0) {
                    throw new Exception();
                }
                break;
            } catch (InputMismatchException exception) {
                System.out.println("양의 정수를 입력해주세요. 타입 미스 매치");
                sc.nextLine();

                /*
                14. throw new Exception()은 안티패턴입니다. 음수 입력 시 new Exception()을 throw하고 있는데, 이는 너무 포괄적입니다.
                    구체적인 예외를 사용해야 합니다. 예외 또한 상속 구조를 가지고 있기때문에 내가 처리해야하는 예외가 아니라 실제 발생해야 하는 예외도
                    catch하게 됩니다.
                 */

            } catch (Exception e) {
                System.out.println("양의 정수를 입력해주세요.");
                sc.nextLine();
            }
        }
        inputOperator();
    }

    // 사직연산 기호를 입력 받는 함수
    public void inputOperator(){
        char operation;
        Operator operator;

        while (true) {
            try {
                System.out.print("사칙연산 기호를 입력하세요: ");
                operation = sc.next().charAt(0);
                if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                    throw new Exception();
                }
                else if (operation == '/' && secondNum == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    inputNumbers();
                } else {
                    operator = Operator.getOperator(operation);
                    arithmeticCalculator.setResults(arithmeticCalculator.calculate(firstNum, secondNum, operator));
                    System.out.println("계산결과 : " + arithmeticCalculator.getResults());
                    break;
                    // 정상적으로 종료되었다면 결과 출력
                }
            } catch (Exception e) {
                System.out.println("사칙연산 기호만 입력해주세요!!!");
                sc.nextLine();
            }
        }
        inputAgain();
    }

    // remove입력시 삭제모드 , exit 입력시 프로그램 종료
    public void inputAgain(){
        String again;

        System.out.print("더 계산하시겠습니까? (remove 입력시 삭제모드 진입, exit 입력 시 종료) : ");
        again = sc.next();

        if(again.equals("exit")){
            System.out.println("프로그램을 종료합니다.");
            sc.close();
        }else if(again.equals("remove")) {            // 삭제 모드
            while (!again.equals("no")) {
                System.out.println("삭제하시겠습니까? (yes 입력시 첫 결과값 삭제, no 입력 시 삭제 모드 종료)");
                System.out.println("저장된 결과값 : " + arithmeticCalculator.getResults());
                again = sc.next();
                if (again.equals("yes"))
                    arithmeticCalculator.removeResult();  // 가장 먼저 저장된 데이터 삭제 비었을경우 빈값 출력
            }
            inputNumbers();     // 아 어떻게 exit 입력으로 돌아가지
        }else{
            inputNumbers();
        }
    }
}
