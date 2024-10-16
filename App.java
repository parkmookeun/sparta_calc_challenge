package sparta.challenge;

import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;

public class App {
    private static final String TYPE = "1";

    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
//        ArithmeticCalculator<Integer> calc = new ArithmeticCalculator<>(Integer.valueOf(TYPE));
        ArithmeticCalculator<Double> calc = new ArithmeticCalculator<>(Double.valueOf(TYPE));

        OperatorType operatorType;
        double num1;
        double num2;

        Scanner sc = new Scanner(System.in);
        /* 반복문 시작 */
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = sc.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력헤주세요!");
                sc.nextLine();
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0);

            //연산자 지정
            switch (op) {
                case '+':
                    operatorType = OperatorType.ADD;
                    break;
                case '-':
                    operatorType = OperatorType.SUBTRACT;
                    break;
                case '*':
                    operatorType = OperatorType.MULTIPLY;
                    break;
                case '/':
                    operatorType = OperatorType.DIVIDE;
                    break;
                default:
                    operatorType = null;
            }

            //연산 수행
            calc.calculate(operatorType, num1, num2);

            System.out.print("더 계산하시겠습니까? yes 입력 시 계속 (exit 입력 시 종료) | (remove 입력시 삭제) (show 입력시 입력보다 더 큰 값들 출력)");
            String input = sc.next();

            //더 할거면
            if (input.equals("yes")){
                continue;
            }

            //그만할거면
            if (input.equals("exit")){
                break;
            } else if(input.equals("remove")) {

                Queue<Double> list = calc.getList();
                Double peek = list.peek();
                if (peek == null) {
                    System.out.println("삭제할 값이 없습니다.");
                } else {
                    Double removed = list.poll();
                    System.out.println(removed + " 값이 삭제 되었습니다!");
                }
            } else if (input.equals("show")) {
                System.out.print("기준값을 입력해주세요: ");
                double value = sc.nextDouble();
                calc.showGreaterThanScanner(value);
            } else {
                System.out.println("입력값이 잘못되었습니다!");
                System.out.println("계산을 종료합니다.");
                break;
            }
            /* 반복문 종료 */
        }
    }
}
