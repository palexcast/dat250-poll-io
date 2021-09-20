package no.hvl.dat250.jpa.models.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "PollOptions")
@Data
@ToString
public class PollOptionEntity {
    public PollOptionEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;
    private String value;
    @OneToMany(cascade = CascadeType.ALL)
    private List<VoteEntity> votes;
}
