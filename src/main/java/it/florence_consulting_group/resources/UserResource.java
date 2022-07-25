package it.florence_consulting_group.resources;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.florence_consulting_group.model.entities.User;
import it.florence_consulting_group.model.entities.User_;
import it.florence_consulting_group.repositories.UserRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import java.util.List;

@Path("/user")
public class UserResource extends CrudResource<User> {

	@Inject
	UserRepository repository;

	@Override
	@POST
	@Transactional
	public User add(User user) {
		return super.add(user);
	}

	@Override
	@DELETE
	@Transactional
	@Path("{id}")
	public boolean delete(@PathParam Long id) {
		return super.delete(id);
	}

	@Override
	@GET
	@Path("{id}")
	public User get(@PathParam Long id) {
		return super.get(id);
	}

	@Override
	protected PanacheRepository<User> getRepository() {
		return this.repository;
	}

	@Override
	@GET
	public List<User> list(@QueryParam int page, @QueryParam @DefaultValue(CrudResource.DEFAULT_PAGE_SIZE) Integer size,
			@QueryParam @DefaultValue(User_.LASTNAME) String sort) {
		return super.list(page, size, sort);
	}

	@Transactional
	@GET
	@Path("/search")
	public List<User> search(@QueryParam String search, @QueryParam int page,
			@QueryParam @DefaultValue(CrudResource.DEFAULT_PAGE_SIZE) Integer size,
			@QueryParam @DefaultValue(User_.LASTNAME) String sort) {
		return this.repository.search(search, page, size).list();
	}

	@Override
	@Transactional
	@PUT
	@Path("{id}")
	public User update(@PathParam Long id, User user) {
		return super.update(id, user);
	}

	@Transactional
	@PUT
	@Path("/update-address/{id}")
	public User updateAddress(@PathParam Long id, String address) {
		User user = super.get(id);
		user.setAddress(address);
		return super.update(id, user);
	}

	@Transactional
	@PUT
	@Path("/update-email/{id}")
	public User updateEmail(@PathParam Long id, String email) {
		User user = super.get(id);
		user.setEmail(email);
		return super.update(id, user);
	}

	@Transactional
	@PUT
	@Path("/update-lastname/{id}")
	public User updateLastname(@PathParam Long id, String lastname) {
		User user = super.get(id);
		user.setLastname(lastname);
		return super.update(id, user);
	}

	@Transactional
	@PUT
	@Path("/update-name/{id}")
	public User updateName(@PathParam Long id, String name) {
		User user = super.get(id);
		user.setName(name);
		return super.update(id, user);
	}
}