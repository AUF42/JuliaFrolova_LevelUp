package homework_1;

/**
 * @author u.frolova
 *
 * Класс, выполняющий расчет факториала полученного числа
 *
 */

public class Factorial {

    public int calculateFactorial(int number1){
        int result = 1;
        for (int i = 1; i<=number1; i++){
            result *= i;
        }
        return result;
    }
}