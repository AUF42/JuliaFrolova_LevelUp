package homework_2;

import homework_2.transport.PublicTransport;
import homework_2.transport.electric_fuel.Tram;
import homework_2.transport.electric_fuel.Trolley;
import homework_2.transport.gas_fuel.Bus;
import homework_2.transport.gas_fuel.CommercialTaxi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author u.frolova
 *
 * Основной класс программы. Сочетает в себе функции класса контейнера и управляющего класса.
 * Создает данные коллекции Транспортных средств.
 * Имеет методы работы с данными:
 * 1. Подсчет стоимости парка ТС;
 * 2. Сортировка ТС по расходу топлива;
 * 3. Подбор оптимального ТС по экологичности, стоимости ТС и пассажировместимости.
 *
 * В качестве удобства работы с программой  имеется меню.
 *
 **/

public class TransportStation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";

        //создаем единицы ТС

        Tram tram_1 = new Tram("tram_1", 1000, 10.5, 49, true);
        Tram tram_2 = new Tram("tram_2", 10000, 18.9, 50, true);
        Trolley trolley_1 = new Trolley("trolley_1", 80000.3, 12.9, 60, true);
        Trolley trolley_2 = new Trolley("trolley_2", 46999.3, 14.6, 61, true);
        Bus bus_1 = new Bus("bus_1", 47000, 67.8, 72, false);
        Bus bus_2 = new Bus("bus_2", 48000, 68.8, 712, false);
        CommercialTaxi commercialTaxi_1 = new CommercialTaxi("com_taxi_1", 49000, 70.8, 26, false);
        CommercialTaxi commercialTaxi_2 = new CommercialTaxi("com_taxi_2", 50000, 73.4, 30, false);

        List<PublicTransport> publicTransports = Arrays
                .asList(tram_1, tram_2, trolley_1, trolley_2, bus_1, bus_2, commercialTaxi_1, commercialTaxi_2);

        /**
         *
         * Вывод меню в консоль
         *
         */

        while (!"4".equals(s)) {
            System.out.println("1. Для подсчета стоимости парка ТС введите 1");
            System.out.println("2. Для сортировки ТС по расходу топлива введите 2");
            System.out.println("3. Для выбора оптимального ТС введите 3");
            System.out.println("4. Для выхода из программы введите 4");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }

            switch (x) {
                case 1:
                    calculateCostPublicTransports(publicTransports);
                    break;
                case 2:
                    sortByFuelOfCostPublicTransports(publicTransports);
                    break;
                case 3:
                    findTheBestPublicTransport(publicTransports);
                    break;
                case 4:
            }
        }
        System.out.println("До свидания!");
    }

    //  Посчитать стоимость парка ТС.
    public static void calculateCostPublicTransports(List<PublicTransport> publicTransports) {

        double poolPrice = 0.0;
        for (PublicTransport publicTransport : publicTransports) {
            poolPrice += publicTransport.getCostOfMachine();
        }
        System.out.println("Стоимость автопарка ОТ: " + Math.round(poolPrice * 100) / 100.0 + "\n");
    }

    // Провести сортировку по расходу топлива (в данном примере не учтен тип топлива).
    public static void sortByFuelOfCostPublicTransports(List<PublicTransport> publicTransports) {

        System.out.println("Сортировка по расходу топлива: " +  "\n");
        for (PublicTransport publicTransport : publicTransports) {
            Comparator<PublicTransport> sortByRange = Comparator.comparingInt(o -> (int) o.getFuelOfMachine());
            publicTransports.sort(sortByRange);
            System.out.printf("ТС: %s Потребление: %s " + "\n", publicTransport, publicTransport.getFuelOfMachine() + "\n");
        }
    }

    //Выбор оптимального транспортного средства.
    public static void findTheBestPublicTransport(List<PublicTransport> publicTransports) {

        System.out.println("Каким должно быть оптимальное транспортное средство?" + "\n");
        System.out.println(
                "Оно должно быть: " + "\n" + "1.Экологичным" + "\n" + "2.Иметь пассажировместимость более 60 человек"
                        + "\n" + "3.Стоимость не должна превышать 50000 у.е." + "\n");
        int passCapacity = 60;
        int maxCost = 50000;
        System.out.println("По всем параметрам нам подойдет: ");
        for (PublicTransport publicTransport : publicTransports) {
            if (publicTransport.isEco() == true && publicTransport.getMaxPassengerCapacity() >= passCapacity
                    && publicTransport.getCostOfMachine() <= maxCost) {
                System.out.println(publicTransport + "\n");
            }
        }
    }
}
