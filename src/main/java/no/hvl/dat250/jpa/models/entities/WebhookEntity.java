package no.hvl.dat250.jpa.models.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "POLL_WEBHOOK")
@Data
@ToString
public class WebhookEntity {
    public WebhookEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Id
    private String id;
    private String auth0Id;
    private String notifyUrl;
    private Boolean onVote;
    private Boolean onPollStart;
    private Boolean onPollEnd;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "POLL_ID")
    private PollEntity poll;
}
