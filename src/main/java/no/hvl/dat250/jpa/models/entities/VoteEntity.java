package no.hvl.dat250.jpa.models.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "POLL_VOTE")
@Data
@ToString
public class VoteEntity {
    public VoteEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;
    private String comment;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;
}
