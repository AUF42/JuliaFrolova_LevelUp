package homework_2.transport;

/**
 * @author u.frolova
 *
 * Абстрактный класс описания общественного ТС.
 *
 * В качестве параметров для описания каждого ТС были выбраны:
 * 1. наименование ТС
 * 2. стоимость ТС
 * 3. потребление топлива
 * 4. пассажировместимость ТС
 * 5. экологичность (да/нет)
 *
 **/

abstract public class PublicTransport implements IPublicTransport {
    private String name;
    private double costOfMachine;
    private double fuelOfMachine;
    private int maxPassengerCapacity;
    private boolean ecoFriendly;

    public PublicTransport(String name, double costOfMachine, double fuelOfMachine, int maxPassengerCapacity, boolean ecoFriendly) {
        this.name = name;
        this.costOfMachine = costOfMachine;
        this.fuelOfMachine = (float) fuelOfMachine;
        this.maxPassengerCapacity = maxPassengerCapacity;
        this.ecoFriendly = ecoFriendly;
    }

    public boolean isEco() {
        return ecoFriendly;
    }

    public double getCostOfMachine() {
        return costOfMachine;
    }

    public double getFuelOfMachine() {
        return fuelOfMachine;
    }

    public int getMaxPassengerCapacity() {
        return maxPassengerCapacity;
    }

    /**
     * Возвращает строку с описанием ТС.
     *
     * @return строка с описанием ТС.
     */

    @Override
    public String toString() {
        return "PublicTransport{" +
                "name='" + name + '\'' +
                ",costOfMachine =" + costOfMachine +
                ", fuelOfMachine=" + fuelOfMachine+
                ", maxPassengerCapacity=" + maxPassengerCapacity +
                ", ecoFriendly" + ecoFriendly +
                '}' +"\n";
    }
}