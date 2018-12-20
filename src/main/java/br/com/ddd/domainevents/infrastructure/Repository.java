package br.com.ddd.domainevents.infrastructure;

public interface Repository <T, ID> {

    public void save(final T entity);

    public void delete(final ID id);
}
