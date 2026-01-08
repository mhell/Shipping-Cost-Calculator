package se.lexicon.calculator;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import jakarta.annotation.PostConstruct;

public class StandardDomesticShipping implements ShippingCostCalculator {
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.STANDARD;
    }

    public double calculate(ShippingRequest r) {
        return 5 + 1.2 * r.weightKg();
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("StandardDomesticShipping created");
    }
}