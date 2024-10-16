package sparta.challenge;


import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
//        ArithmeticCalculator<Integer> calc = new ArithmeticCalculator<>();

        ArithmeticCalculator<Double> calc = new ArithmeticCalculator<>();

        OperatorType operatorType = null;
        Scanner sc = new Scanner(System.in);
        /* 반복문 시작 */
        while (true) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
//            int num1 = sc.nextInt();
            double num1 = sc.nextDouble();
            System.out.print("두 번째 숫자를 입력하세요: ");
//            int num2 = sc.nextInt();
            double num2 = sc.nextDouble();

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
            }

            //연산 수행
            calc.calculate(operatorType, num1, num2);

            System.out.print("더 계산하시겠습니까? yes 입력 시 계속 (exit 입력 시 종료) | (remove 입력시 삭제) (show 입력시 입력보다 더 큰 값들 출력)");
            String input = sc.next();

            if (input.equals("yes")) continue;

            if (input.equals("exit")) break;
            else if (input.equals("remove")) {

//                LinkedList<Integer> list = (LinkedList<Integer>) calc.getList();
//                Integer peek = list.peek();

                LinkedList<Double> list = (LinkedList<Double>) calc.getList();
                Double peek = list.peek();
                if (peek == null) {
                    System.out.println("삭제할 값이 없습니다.");
                } else {
                    list.poll();
                    System.out.println(peek + " 값이 삭제 되었습니다!");
                }
            } else if (input.equals("show")) {
                System.out.print("기준값을 입력해주세요: ");
                double value = sc.nextDouble();
                calc.showGreaterThanScanner(value);
            } else {
                System.out.println("계산을 종료합니다.");
                break;
            }
            /* 반복문 종료 */
        }
    }
}
