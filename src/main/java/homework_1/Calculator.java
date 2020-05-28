package homework_1;

import java.util.Scanner;

/**
 * @author u.frolova
 *
 * Класс - калькулятор, выполняющий различные математические функции.
 * Калькулятор умеет выполнять следующие функции:
 * Сумма/Разность/Умножение/Возведение в степень/Вычисление факториала/Вычисление значение Фиабоначчи
 *
 */

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    private static char getOperation() {
        System.out.println("Введите операцию с консоли:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("При вводе операции допущена ошибка. Повторите попытку.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    private static double getDouble() {
        System.out.println("Введите число с консоли:");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("При вводе числа допущена ошибка. Повторите попытку.");
            scanner.next();
            number = getDouble();
        }
        return number;
    }

    public static void main(String[] args) {

        double number1 = getDouble();
        char operation = getOperation();

        if (operation == 'F') {
            Fiabonacci fiabonacci = new Fiabonacci();
            int result = fiabonacci.calculateFiabonacci((int) number1);
            System.out.println("Результат вычисления: " + result);
        } else if (operation == '!') {
            Factorial factorial = new Factorial();
            int result = factorial.calculateFactorial((int) number1);
            System.out.println("Результат вычисления: " + result);
        }
        else {
            double number2 = getDouble();
            double result;
            switch (operation) {
                case '+':
                    Sum sum = new Sum();
                    result = sum.calculateSum(number1, number2);
                    System.out.println("Результат вычисления: " + result);
                    break;
                case '-':
                    Difference difference = new Difference();
                    result = difference.calculateDiff((int) number1, (int) number2);
                    System.out.println("Результат вычисления: " + result);
                    break;
                case '*':
                    Multiplication multiplication = new Multiplication();
                    result = multiplication.calculateMult(number1, number2);
                    System.out.println("Результат вычисления: " + result);
                    break;
                case '^':
                    Exponentiation exponentiation = new Exponentiation();
                    result = exponentiation.calculateExp(number1, (int) number2);
                    System.out.println("Результат вычисления: " + result);
                    break;
                default:
                    System.out.println("Операция не распознана. Повторите ввод.");
            }
        }
    }
}






