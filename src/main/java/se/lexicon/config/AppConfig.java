package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.calculator.ExpressInternationalShipping;
import se.lexicon.calculator.StandardDomesticShipping;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;

import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public ShippingCalculatorFactory shippingCalculatorFactory(List<ShippingCostCalculator> calculators) {
        return new ShippingCalculatorFactory(calculators);
    }

    @Bean
    public ShippingService shippingService(ShippingCalculatorFactory factory) {
        return new ShippingService(factory);
    }

    // @Bean
    // public ShippingRequest shippingRequest(Destination destination, Speed speed, double weightKg) {
    //     return new ShippingRequest(destination, speed, weightKg);
    // }

    @Bean
    public ShippingCostCalculator standardDomesticShipping() {
        return new StandardDomesticShipping();
    }

    @Bean
    public ShippingCostCalculator expressInternationalShipping() {
        return new ExpressInternationalShipping();
    }

}
