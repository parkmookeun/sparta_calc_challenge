package sparta.challenge;

import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;

public class App {
    private static final String TYPE = "1";

    public static void main(String[] args) {
        /* Calculator 인스턴스 생성 */
        ArithmeticCalculator<Integer> calc = new ArithmeticCalculator<>(Integer.valueOf(TYPE));
//        ArithmeticCalculator<Double> calc = new ArithmeticCalculator<>(Double.valueOf(TYPE));

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

            //연산 수행
            calc.calculate(String.valueOf(op), num1, num2);

            System.out.print("더 계산하시겠습니까? yes 입력 시 계속 (exit 입력 시 종료) | (remove 입력시 삭제) (show 입력시 입력보다 더 큰 값들 출력)");
            try{
                String input = sc.next();
                switch (CommandType.fromValue(input)) {
                    case YES: break;
                    case EXIT: return;
                    case REMOVE:
                        remove(calc);
                        break;
                    case SHOW:
                        show(sc, calc);
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            /* 반복문 종료 */
        }
    }

    private static void show(Scanner sc, ArithmeticCalculator<Integer> calc/*calcArithmeticCalculator<Double> calc*/) {
        System.out.print("기준값을 입력해주세요: ");
        double value = sc.nextDouble();
        calc.showGreaterThanScanner(value);
    }

    private static void remove(ArithmeticCalculator<Integer> calc/*,ArithmeticCalculator<Double> calc*/) {
        Queue<Double> list = calc.getList();
        Double peek = list.peek();
        if (peek == null) {
            System.out.println("삭제할 값이 없습니다.");
        } else {
            Double removed = list.poll();
            System.out.println(removed + " 값이 삭제 되었습니다!");
        }
    }
}
