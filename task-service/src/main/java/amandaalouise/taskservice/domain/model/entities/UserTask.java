package amandaalouise.taskservice.domain.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table
public class UserTask extends PersistentEntity {
    @Getter
    @Setter
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Getter
    @Setter
    private State state;

    @Getter
    @Setter
    private Long userId;
}
