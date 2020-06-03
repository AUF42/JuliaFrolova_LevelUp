package homework_2.transport.gas_fuel;

/**
 * @author u.frolova
 *
 * ТС - Маршрутное такси, наследуемое от типового неэкологичного ТС.
 *
 **/

public class CommercialTaxi extends GasTransportExample{

    public CommercialTaxi(String name, double costOfMachine, double fuelOfMachine, int maxPassengerCapacity, boolean ecoFriendly) {
        super(name, costOfMachine, fuelOfMachine, maxPassengerCapacity, ecoFriendly);
    }
}