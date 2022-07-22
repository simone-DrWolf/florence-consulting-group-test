package it.florence_consulting_group.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.florence_consulting_group.model.entities.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}