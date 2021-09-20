package no.hvl.dat250.jpa.models.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Users")
@Data
@ToString
public class UserEntity {
    public UserEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;
    private String auth0id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PollEntity> polls = new ArrayList<>();
}
