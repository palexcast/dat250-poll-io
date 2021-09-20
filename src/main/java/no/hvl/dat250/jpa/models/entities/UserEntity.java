package no.hvl.dat250.jpa.models.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "POLL_USER")
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
    @JoinColumn(name = "USER_ID")
    private List<PollEntity> polls = new ArrayList<>();
}
