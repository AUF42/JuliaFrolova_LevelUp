package homework_2.transport.gas_fuel;

import homework_2.transport.PublicTransport;

/**
 * @author u.frolova
 *
 * Типовое ТС с неэкологичным топливом - бензином.
 *
 **/

public class GasTransportExample extends PublicTransport {

    public GasTransportExample(String name, double costOfMachine, double fuelOfMachine, int maxPassengerCapacity, boolean ecoFriendly) {
        super(name, costOfMachine, fuelOfMachine, maxPassengerCapacity, ecoFriendly);
    }
}

