package br.com.ddd.domainevents.application;

import br.com.ddd.domainevents.domain.stock.Product;
import br.com.ddd.domainevents.domain.stock.Stock;
import br.com.ddd.domainevents.domain.stock.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StockApplicationService {

    private final StockRepository repository;

    public void save(final Stock stock) {
        repository.save(stock);
    }

    public void addProduct(final String id, final Product product) {
        final Stock stock = repository.findById(id);
        stock.addProduct(product);
        save(stock);
    }

    public void bookProduct(final String productCode, final Integer quantity) {
        final Stock stock = repository.findByProdutCode(productCode);
        stock.bookProduct(productCode, quantity);
    }
}
