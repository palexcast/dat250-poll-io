package no.hvl.dat250.jpa.models.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "POLL_OPTION")
@Data
@ToString
public class PollOptionEntity {
    public PollOptionEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;
    /**
     * Incremental per poll. Can be used by IOT devices to vote, by automapping options to buttons without knowing their string value.
     * Button 1 = OptionId 0
     * Button 2 = OptionId 1
     * Button 3 = OptionId 2
     * etc.
     */
    private int optionId;
    private String value;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_OPTION_ID")
    private List<VoteEntity> votes;
}
