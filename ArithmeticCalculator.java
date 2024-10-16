package sparta.challenge;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class ArithmeticCalculator<T extends Number> {
    private Queue<T> list;

    public ArithmeticCalculator() {
        list = new LinkedList<>();
    }

    public Queue<T> getList() {
        return list;
    }

    public void setList(Queue<T> list) {
        this.list = list;
    }

    //사칙연산 함수
    public void calculate(OperatorType op, T num1, T num2) {
        //연산
        T result = null;
        if (op == null) {
            System.out.println("제대로 된 연산자를 입력하세요");
            return;
        }
        switch (op) {
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
                result = (T) (Double.valueOf(divide(num1, num2)));
                break;
        }
        showResult(result);
        list.add(result);
    }

    //입력 값보다 더 큰 값을 보여주는 함수
    public void showGreaterThanScanner(double num1) {
        List<Double> doubleList = list.stream().map(
                element -> element.doubleValue()).toList();

        List<Double> bigList = doubleList.stream().filter(
                element -> element > num1).toList();

        System.out.println("입력보다 큰 값을 출력합니다.");

        if (bigList.size() == 0) {
            System.out.println("큰 결과가 없습니다!");
        } else {
            for (Double v : bigList) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    //더하기
    private T add(T num1, T num2) {
        if (num1 instanceof Double && num2 instanceof Double) {
            return (T) (Double.valueOf(num1.doubleValue() + num2.doubleValue()));
        } else if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) (Integer.valueOf(num1.intValue() + num2.intValue()));
        }
        return null;
    }

    //빼기
    private T subtract(T num1, T num2) {
        if (num1 instanceof Double && num2 instanceof Double) {
            return (T) (Double.valueOf(num1.doubleValue() - num2.doubleValue()));
        } else if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) (Integer.valueOf(num1.intValue() - num2.intValue()));
        }
        return null;
    }

    //곱하기
    private T multiply(T num1, T num2) {
        if (num1 instanceof Double && num2 instanceof Double) {
            return (T) (Double.valueOf(num1.doubleValue() * num2.doubleValue()));
        } else if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) (Integer.valueOf(num1.intValue() * num2.intValue()));
        }
        return null;
    }

    //나누기
    private double divide(T num1, T num2) {
        return num1.doubleValue() / num2.doubleValue();
    }

    //연산 결과를 보여주는 함수
    private void showResult(T result) {
        if (result instanceof Double) {
            System.out.println("연산 결과는 " + result.doubleValue());
        } else if (result instanceof Integer) {
            System.out.println("연산 결과는 " + result.intValue());
        }
    }
}
