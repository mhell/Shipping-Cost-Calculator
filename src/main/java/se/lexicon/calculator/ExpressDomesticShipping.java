package se.lexicon.calculator;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

public class ExpressDomesticShipping implements ShippingCostCalculator {
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.EXPRESS;
    }

    public double calculate(ShippingRequest r) {
        return 5 + 4.5 * r.weightKg();
    }
}
