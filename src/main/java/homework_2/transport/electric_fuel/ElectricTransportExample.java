package homework_2.transport.electric_fuel;

import homework_2.transport.PublicTransport;

/**
 * @author u.frolova
 *
 * Типовое ТС с экологичным топливом - электричеством.
 *
 **/

public class ElectricTransportExample extends PublicTransport {

    public ElectricTransportExample(String name, double costOfMachine, double fuelOfMachine, int maxPassengerCapacity, boolean ecoFriendly) {
        super(name, costOfMachine, fuelOfMachine, maxPassengerCapacity, ecoFriendly);
    }
}
