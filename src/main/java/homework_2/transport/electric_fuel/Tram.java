package homework_2.transport.electric_fuel;

/**
 * @author u.frolova
 *
 * ТС - Трамвай, наследуемое от типового экологичного ТС.
 *
 **/

public class Tram  extends ElectricTransportExample{

    public Tram(String name, double costOfMachine, double fuelOfMachine, int maxPassengerCapacity, boolean ecoFriendly) {
        super(name, costOfMachine, fuelOfMachine, maxPassengerCapacity, ecoFriendly);
    }
}
