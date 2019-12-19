package amandaalouise.taskservice.domain.repositories;

import amandaalouise.taskservice.domain.model.entities.UserTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Long> {

    @Query("from UserTask ut where ut.userId = :id")
    Page<UserTask> findByUserId(Long id, Pageable pageable);

    List<UserTask> deleteByUserId(Long id);
}