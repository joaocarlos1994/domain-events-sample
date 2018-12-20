package br.com.ddd.domainevents.infrastructure;

import br.com.ddd.domainevents.domain.stock.Stock;
import br.com.ddd.domainevents.domain.stock.StockRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Repository
public class StockRepositoryImpl implements StockRepository {

    private final List<Stock> stocks = new LinkedList<>();

    @Override
    public void save(final Stock entity) {
        if (!Objects.isNull(entity) && !stocks.contains(entity)) {
            stocks.add(entity);
        }
    }

    @Override
    public void delete(final String id) {
        final Stock stockDB = stocks.stream().filter(stock -> stock.match(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        stocks.remove(stockDB);
    }

    @Override
    public List<Stock> listAll() {
        return stocks;
    }

    @Override
    public Stock findById(String id) {
        return stocks.stream().filter(stock -> stock.match(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Stock findByProdutCode(final String productCode) {
        return stocks.stream().filter(stock -> stock.matchProductCode(productCode))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
