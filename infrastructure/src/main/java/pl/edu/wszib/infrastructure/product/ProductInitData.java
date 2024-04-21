package pl.edu.wszib.infrastructure.product;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.edu.wszib.api.product.ProductApi;
import pl.edu.wszib.application.product.ProductFacade;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class ProductInitData implements InitializingBean {
    private final ProductFacade productFacade;

    public ProductInitData(final ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @Override
    public void afterPropertiesSet() {
        productFacade.create(new ProductApi(UUID.randomUUID().toString(),
                "Testowy produkt 1",
                BigDecimal.TEN,
                Instant.now(),
                Instant.now()));
        productFacade.create(new ProductApi(UUID.randomUUID().toString(),
                "Testowy produkt 2",
                BigDecimal.TEN,
                Instant.now(),
                Instant.now()));
    }
}
