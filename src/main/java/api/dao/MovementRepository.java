package api.dao;

import api.dao.entity.Movement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovementRepository implements PanacheRepository<Movement> {

}
