package amandaalouise.userservice.domain.repositories;

import amandaalouise.userservice.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    void deleteById(Long id);
}