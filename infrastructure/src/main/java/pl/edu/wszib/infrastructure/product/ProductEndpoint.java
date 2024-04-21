package pl.edu.wszib.infrastructure.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.api.product.ProductApi;
import pl.edu.wszib.application.product.ProductFacade;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {
    // TODO:
    //  - implementacja pobierania produktu na podstawie id GET /products/{productId}
    //  - tworzenie produktu POST /products
    private final ProductFacade productFacade;

    public ProductEndpoint(final ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @GetMapping
    public Collection<ProductApi> getAll() {
        return productFacade.getAll();
    }

}
