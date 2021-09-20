package no.hvl.dat250.jpa.models.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "POLL")
@Data
@ToString
public class PollEntity {
    public PollEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private boolean publicPoll;
    private String publicId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    private List<PollOptionEntity> options = new ArrayList<>();
}
