package homework_1;

/**
 * @author u.frolova
 *
 * Класс, выполняюший расчет заданного числа Фиабонначи
 *
 */

public class Fiabonacci {

    public static int calculateFiabonacci(int number1){
        if (number1 <= 1)
            return number1;
        else
            return (number1 - 1) + (number1 - 2);
    }
}
