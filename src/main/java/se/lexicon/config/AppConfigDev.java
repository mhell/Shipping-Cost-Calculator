package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import se.lexicon.calculator.ExpressDomesticShipping;
import se.lexicon.calculator.ExpressInternationalShipping;
import se.lexicon.calculator.StandardDomesticShipping;
import se.lexicon.calculator.StandardInternationalShipping;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;

import java.util.List;

@Configuration
@Profile("dev")
@PropertySource("classpath:application-dev.properties")
public class AppConfigDev {
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

    @Bean
    public ShippingCostCalculator standardInternationalShipping() {
        return new StandardInternationalShipping();
    }

    @Bean
    public ShippingCostCalculator expressDomesticShipping() {
        return new ExpressDomesticShipping();
    }

}
