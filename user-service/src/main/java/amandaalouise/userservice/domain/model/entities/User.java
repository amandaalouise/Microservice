package amandaalouise.userservice.domain.model.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class User extends PersistentEntity {
    @Getter
    @Setter
    private String name;
}
