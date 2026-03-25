package calculator.step3Refactorng;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        ArithmeticCalculator<Double> doubleCalculator = new ArithmeticCalculator<>();
        ArithmeticCalculator<Integer> intCalculator = new ArithmeticCalculator<>();

        while (true) {
            double firstNumber = input.inputNumber("첫번째 숫자를 입력해주세요: ");
            double secondNumber = input.inputNumber("두번째 숫자를 입력해주세요: ");
            double result;
            Operator operator = input.inputOperator();
            if(secondNumber == 0 && operator == Operator.DIVIDE)
                continue;

            // 두 값이 모두 정수라면
            if(firstNumber == (int)firstNumber && secondNumber == (int)secondNumber){
                result = intCalculator.calculate((int)firstNumber,(int)secondNumber,operator);
            }else
                result = doubleCalculator.calculate(firstNumber,secondNumber,operator);
            // 두 값 중에 하나라도 실수라면

            doubleCalculator.setResults(result);
            System.out.println("계산 결과: " + result);
            System.out.println("저장된 결과: " + doubleCalculator.getResults() + "\n");

            System.out.println("계산을 계속 하시겠습니까? (exit : 종료, remove : 삭제 모드, 아무거나 입력시 다시 계산, search : 조회)");
            String remove = input.inputAgain();

            switch (remove){
                case "exit" : case "Exit":
                    System.out.println("프로그램을 종료합니다.");
                    input.closeScanner();
                    return;
                case "remove": case "Remove":
                    boolean removeMode = true;
                    while(removeMode){
                        System.out.println("삭제하시겠습니까? (yes 입력시 가장 오래된 결과값 삭제, no 입력 시 삭제 모드 종료)");
                        System.out.println("저장된 결과: " + doubleCalculator.getResults());
                        String select = input.inputAgain();
                        switch (select){
                            case "yes": case "Yes": case "y": case "Y":
                                doubleCalculator.removeResult();
                                break;
                            case "no": case "No": case "n": case "N":       // No 입력 후 while 돌아감
                                removeMode = false;
                                break;
                            default:
                                System.out.println("yes나 no를 입력해 주세요.");
                        }
                    }
                case "search": case "Search":
                    System.out.println("몇보다 높은 숫자를 찾을건가요?");
                    double number = input.inputNumber("숫자를 입력해주세요: ");
                    System.out.println("결과: " + doubleCalculator.getSearch(number));
                    break;
            }
        }
    }
}