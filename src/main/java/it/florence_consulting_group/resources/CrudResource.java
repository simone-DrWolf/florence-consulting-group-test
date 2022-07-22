package it.florence_consulting_group.resources;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.ws.rs.WebApplicationException;
import java.util.List;

public abstract class CrudResource<T> {

	public static final String DEFAULT_PAGE_SIZE = "20";

	public T add(T entity) {
		this.getRepository().persist(entity);
		return entity;
	}

	public boolean delete(Long id) {
		return this.getRepository().deleteById(id);
	}

	public T get(Long id) {
		return this.getRepository().findByIdOptional(id).orElseThrow(this::notFound);
	}

	protected abstract PanacheRepository<T> getRepository();

	public List<T> list(int page, Integer size, String sort) {
		return this.getRepository().findAll(Sort.by(sort)).page(Page.of(page, size)).list();
	}

	private WebApplicationException notFound() {
		return new WebApplicationException(404);
	}

	public T update(Long id, T entity) {
		return this.getRepository()
				.findByIdOptional(id)
				.map(old -> this.getRepository().getEntityManager().merge(entity))
				.orElseThrow(this::notFound);
	}
}