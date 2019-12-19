package amandaalouise.userservice.domain.repositories;

import amandaalouise.userservice.domain.model.entities.PersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultRepository<T extends PersistentEntity> extends JpaRepository<T, Long> {
}
