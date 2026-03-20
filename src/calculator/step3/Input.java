package calculator.step3;

import java.util.InputMismatchException;
import java.util.Scanner;

// 사용자의 입력을 받는 함수 선언할 클래스
public class Input {
    private double firstNum;
    private double secondNum;
    private char operation;
    private String again;

    private Operator operator;
    private Scanner sc = new Scanner(System.in);
    private ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();

    public Input(){

    }

    // 숫자를 입력 받는 함수
    public void inputNumbers(){
        try{
            System.out.print("첫 번째 숫자를 입력하세요: ");
            firstNum = sc.nextDouble();
            if(firstNum < 0) {
                throw new Exception();
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            secondNum = sc.nextDouble();
            if(secondNum < 0) {
                throw new Exception();
            }

            inputOperator();

        }catch(InputMismatchException exception){
            System.out.println("양의 정수를 입력해주세요. 타입 미스 매치");
            sc.nextLine();      // 버퍼 비우기
            inputNumbers();           // 반복문 재시작
        }catch (Exception e){
            System.out.println("양의 정수를 입력해주세요.");
            inputNumbers();
        }
    }

    // 사직연산 기호를 입력 받는 함수
    public void inputOperator(){
        try {
            System.out.print("사칙연산 기호를 입력하세요: ");
            operation = sc.next().charAt(0);
            if (operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                throw new Exception();
            }
            operator = Operator.getOperation(operation);
            arithmeticCalculator.setResults(arithmeticCalculator.calculate(firstNum,secondNum,operator));
            System.out.println("계산결과 : " + arithmeticCalculator.getResults());
            inputAgain();
            // 정상적으로 종료되었다면 결과 출력
        } catch (Exception e) {
            System.out.println("사칙연산 기호만 입력해주세요!!!");
            inputOperator();
        }

        if(operation == '/' && secondNum == 0){
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            inputNumbers();
        }
    }

    // remove입력시 삭제모드 , exit 입력시 프로그램 종료
    public void inputAgain(){
        System.out.print("더 계산하시겠습니까? (remove 입력시 삭제모드 진입, exit 입력 시 종료) : ");
        sc.nextLine();          // 버퍼 비우기
        again = sc.nextLine();

        if(again.equals("exit")){
            System.out.println("프로그램을 종료합니다.");
            return;
        }else if(again.equals("remove")) {            // 삭제 모드
            while (!again.equals("no")) {
                System.out.println("삭제하시겠습니까? (yes 입력시 첫 결과값 삭제, no 입력 시 삭제 모드 종료)");
                System.out.println("저장된 결과값 : " + arithmeticCalculator.getResults());
                again = sc.nextLine();
                if (again.equals("yes"))
                    arithmeticCalculator.removeResult();  // 가장 먼저 저장된 데이터 삭제 비었을경우 빈값 출력
            }
            inputNumbers();// 아 어떻게 exit 입력으로 돌아가지
        }else{
            inputNumbers();
        }
    }

}
