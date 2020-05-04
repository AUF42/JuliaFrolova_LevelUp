package homework_1;

/**
 * @author u.frolova
 *
 * Класс, выполняющий возведение в степень полученного числа
 *
 */

public class Exponentiation {

    public static double calculateExp(double number1, int number2) {
        double result = 1;
        for(int i = 1; i<=number2; i++){
            result *= number1;
        }
        return  (result);
    }
}
