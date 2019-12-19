package amandaalouise.taskservice.domain.repositories;

import amandaalouise.taskservice.domain.model.entities.PersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefaultRepository<T extends PersistentEntity> extends JpaRepository<T, Long> {
}
