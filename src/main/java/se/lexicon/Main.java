package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingService;

public class Main {
    public static void main(String[] args) {
        // Manual object creation (composition root)
        // List<ShippingCostCalculator> calculators = List.of(
        //         new StandardDomesticShipping(),
        //         new ExpressInternationalShipping()
        // );
        //
        // ShippingCalculatorFactory factory = new ShippingCalculatorFactory(calculators);
        //
        // ShippingService shippingService = new ShippingService(factory);

        // Object creation is handled by the Spring IoC Container
        String profile = "dev";
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles(profile);
        context.getEnvironment().getSystemProperties().put("spring.profiles.active", profile);
        context.register(AppConfig.class);
        context.refresh();

        ShippingService shippingService = context.getBean(ShippingService.class);

        // Create ShippingRequests
        ShippingRequest domesticStandardRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10.0);
        System.out.println("Shipping cost: " + shippingService.quote(domesticStandardRequest));

        ShippingRequest internationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        System.out.println("Shipping cost: " + shippingService.quote(internationalExpressRequest));

        ShippingRequest lightDomesticRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 5.0);
        System.out.println("Shipping cost: " + shippingService.quote(lightDomesticRequest));

        ShippingRequest heavyInternationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        System.out.println("Shipping cost: " + shippingService.quote(heavyInternationalExpressRequest));

        ShippingRequest heavyInternationalStandardRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.STANDARD, 20.0);
        System.out.println("Shipping cost: " + shippingService.quote(heavyInternationalStandardRequest));

        ShippingRequest heavyDomesticExpressRequest = new ShippingRequest(Destination.DOMESTIC, Speed.EXPRESS, 20.0);
        System.out.println("Shipping cost: " + shippingService.quote(heavyDomesticExpressRequest));

    }
}
