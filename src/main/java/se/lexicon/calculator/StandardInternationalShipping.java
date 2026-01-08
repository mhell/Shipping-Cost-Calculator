package se.lexicon.calculator;

import org.springframework.beans.factory.annotation.Value;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import jakarta.annotation.PostConstruct;

public class StandardInternationalShipping implements ShippingCostCalculator {
    @Value("${international.base}")
    private double internationalBase;
    @Value("${standard}")
    private double standard;

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.STANDARD;
    }

    public double calculate(ShippingRequest r) {
        return internationalBase + standard * r.weightKg();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("StandardInternationalShipping created");
    }
}
