package se.lexicon.calculator;

import org.springframework.beans.factory.annotation.Value;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import jakarta.annotation.PostConstruct;

public class ExpressDomesticShipping implements ShippingCostCalculator {
    @Value("${domestic.base}")
    private double domesticBase;
    @Value("${express}")
    private double express;

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.EXPRESS;
    }

    public double calculate(ShippingRequest r) {
        return domesticBase + express * r.weightKg();
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println("ExpressDomesticShipping created");
    }
}
