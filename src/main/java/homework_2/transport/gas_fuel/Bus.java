package homework_2.transport.gas_fuel;

/**
 * @author u.frolova
 *
 * ТС - Автобус, наследуемое от типового неэкологичного ТС.
 *
 **/

public class Bus extends GasTransportExample{

    public Bus(String name, double costOfMachine, double fuelOfMachine, int maxPassengerCapacity, boolean ecoFriendly) {
        super(name, costOfMachine, fuelOfMachine, maxPassengerCapacity, ecoFriendly);
    }
}

