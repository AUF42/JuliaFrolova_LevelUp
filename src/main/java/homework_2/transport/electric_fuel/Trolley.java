package homework_2.transport.electric_fuel;

/**
 * @author u.frolova
 *
 * ТС - Троллейбус, наследуемое от типового экологичного ТС.
 *
 **/

public class Trolley extends ElectricTransportExample {

    public Trolley(String name, double costOfMachine, double fuelOfMachine, int maxPassengerCapacity, boolean ecoFriendly) {
        super(name, costOfMachine, fuelOfMachine, maxPassengerCapacity, ecoFriendly);
    }
}
