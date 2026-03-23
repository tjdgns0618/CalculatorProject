package calculator.step3Refactorng;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();

        while (true) {
            double firstNumber = input.inputNumber("첫번째 숫자를 입력해주세요: ");
            double secondNumber = input.inputNumber("두번째 숫자를 입력해주세요: ");

            Operator operator = input.inputOperator();
            if(secondNumber == 0 && operator == Operator.DIVIDE)
                continue;

            double result = arithmeticCalculator.calculate(firstNumber,secondNumber,operator);
            arithmeticCalculator.setResults(result);
            System.out.println("계산 결과: " + result);
            System.out.println("저장된 결과: " + arithmeticCalculator.getResults() + "\n");

            System.out.println("계산을 계속 하시겠습니까? (N : 종료, remove : 삭제 모드, 아무거나 입력시 다시 계산, search : 조회)");
            String remove = input.inputAgain();

            switch (remove){
                case "n" :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case "remove":
                    while(true){
                        System.out.println("삭제하시겠습니까? (yes 입력시 첫 결과값 삭제, no 입력 시 삭제 모드 종료)");
                        System.out.println("저장된 결과: " + arithmeticCalculator.getResults());
                        String select = input.inputAgain();
                        if(select.equals("yes")) {
                            arithmeticCalculator.removeResult();
                        }
                        else if(select.equals("no")){
                            break;
                        }else{
                            System.out.println("yes나 no를 입력해 주세요.");
                        }
                    }
                    break;
                case "search":
                    System.out.println("몇보다 높은 숫자를 찾을건가요?");
                    double number = input.inputNumber("숫자를 입력해주세요: ");
                    System.out.println("결과: " + arithmeticCalculator.getSearch(number));
                    break;
            }
        }
    }
}