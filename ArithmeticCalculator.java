package sparta.challenge;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArithmeticCalculator<T extends Number> {
    private Queue<Double> list;
    private T type;

    public ArithmeticCalculator(T type) {
        list = new LinkedList<>();
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public Queue<Double> getList() {
        return list;
    }

    public void setList(Queue<Double> list) {
        this.list = list;
    }

    //사칙연산 함수
    public void calculate(String operator, double num1, double num2) {
        //연산
        double result = 0.0;
        switch (OperatorType.fromValue(operator)) {
            case ADD:
                result = add(num1, num2);
                break;
            case SUBTRACT:
                result = subtract(num1, num2);
                break;
            case MULTIPLY:
                result = multiply(num1, num2);
                break;
            case DIVIDE:
                try{
                    result = divide(num1, num2);
                }catch(ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
        }
        showResult(result);
        list.add(result);
    }

    //입력 값보다 더 큰 값을 보여주는 함수
    public void showGreaterThanScanner(double num1) {
        List<Double> bigList = list.stream().filter(num -> num > num1).toList();

        System.out.println("입력보다 큰 값을 출력합니다.");

        if (bigList.isEmpty()) {
            System.out.println("큰 결과가 없습니다!");
        } else {
            for (Double v : bigList) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    //더하기
    private double add(double num1, double num2) {
        return num1 + num2;
    }

    //빼기
    private double subtract(double num1, double num2) {
        return num1 - num2;
    }

    //곱하기
    private double multiply(double num1, double num2) {
        return num1 * num2;
    }

    //나누기
    private double divide(double num1, double num2) {
        if(num2 == 0) throw new ArithmeticException("왜 0으로 나눠!");
        return num1 / num2;
    }

    //연산 결과를 보여주는 함수
    private void showResult(double result) {
        if (getType() instanceof Double) {
            System.out.println("연산 결과는 " + result);
        } else if (getType() instanceof Integer) {
            System.out.println("연산 결과는 " + (int)result);
        }
    }
}
