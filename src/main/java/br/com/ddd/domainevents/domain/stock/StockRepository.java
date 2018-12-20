package br.com.ddd.domainevents.domain.stock;

import br.com.ddd.domainevents.infrastructure.Repository;

import java.util.List;

public interface StockRepository extends Repository<Stock, String> {

    public List<Stock> listAll();

    public Stock findById(final String id);

    Stock findByProdutCode(final String productCode);
}
