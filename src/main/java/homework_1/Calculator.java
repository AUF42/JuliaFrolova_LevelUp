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

    public static void main(String[] args) {
        double number1 = getDouble();
        char operation = getOperation();
        if (operation =='F') {
            double result = calculateFiabonacci(number1);
            System.out.println("Результат вычисления: " + result);
        }
        if (operation == '!') {
            double result = calculateFactorial(number1);
            System.out.println("Результат вычисления: " + result);
        }
        else {
            double number2 = getDouble();
            double result = calculate(number1, number2, operation);
            System.out.println("Результат вычисления: " + result);
        }
    }

    private static double calculateFactorial(double number1) {
        double result = Factorial.calculateFactorial((int)number1);
        return result;
    }

    private static double calculateFiabonacci(double number1) {
        double result = Fiabonacci.calculateFiabonacci((int)number1);
        return result;
    }

    private static char getOperation() {
        System.out.println("Введите операцию с консоли:" );
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        }
        else {
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
        }
        else {
            System.out.println("При вводе числа допущена ошибка. Повторите попытку.");
            scanner.next();
            number = getDouble();
        }
        return number;
    }

    private static double calculate(double number1, double number2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = Sum.calculateSum(number1, number2);
                break;
            case '-':
                result = Difference.calculateDiff((int) number1, (int) number2);
                break;
            case '*':
                result = Multiplication.calculateMult(number1, number2);
                break;
            case '^':
                result = Exponentiation.calculateExp(number1, (int) number2);
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calculate(number1, number2, getOperation());
        }
        return result;
    }

}






