package se.lexicon.calculator;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import jakarta.annotation.PostConstruct;

public class StandardInternationalShipping implements ShippingCostCalculator {
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.STANDARD;
    }

    public double calculate(ShippingRequest r) {
        return 25 + 1.2 * r.weightKg();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("StandardInternationalShipping created");
    }
}
