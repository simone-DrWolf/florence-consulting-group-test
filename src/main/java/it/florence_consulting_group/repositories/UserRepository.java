package it.florence_consulting_group.repositories;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import it.florence_consulting_group.model.entities.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

	public PanacheQuery<User> search(String param, int page, int size) {
		String query = param + "%";
		int p = (page > 0) ? page : 0;
		return this.find("lower(name) like lower(?1) or lower(lastname) like lower(?1)", query).page(Page.of(p, size));
	}
}