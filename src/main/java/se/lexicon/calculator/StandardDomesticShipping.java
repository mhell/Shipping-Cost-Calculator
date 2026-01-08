package se.lexicon.calculator;

import org.springframework.beans.factory.annotation.Value;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import jakarta.annotation.PostConstruct;

public class StandardDomesticShipping implements ShippingCostCalculator {
    @Value("${domestic.base}")
    private double domesticBase;
    @Value("${standard}")
    private double standard;

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.STANDARD;
    }

    public double calculate(ShippingRequest r) {
        return domesticBase + standard * r.weightKg();
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("StandardDomesticShipping created");
    }
}