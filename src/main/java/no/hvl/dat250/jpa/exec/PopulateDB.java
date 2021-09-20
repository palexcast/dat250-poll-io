package no.hvl.dat250.jpa.exec;

import no.hvl.dat250.jpa.daos.UserDao;
import no.hvl.dat250.jpa.models.entities.PollEntity;
import no.hvl.dat250.jpa.models.entities.PollOptionEntity;
import no.hvl.dat250.jpa.models.entities.UserEntity;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class PopulateDB {
    private static final String PERSISTENCE_UNIT_NAME = "pollio";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        populate();
    }

    private static void populate() {
        UserDao userDao = new UserDao(factory);
        UserEntity user = createUser();
        userDao.create(user);

        userDao.destroy();
    }

    private static UserEntity createUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Sir Newton");
        userEntity.setAuth0id("auth0:mock-id");
        userEntity.setPolls(createPolls());
        return userEntity;
    }

    private static List<PollEntity> createPolls() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();

        PollEntity poll1 = new PollEntity();
        poll1.setName("Favorite hat?");
        poll1.setPublicPoll(false);
        poll1.setPublicId("ANC2");
        calendar.set(2020 + 1900, Calendar.JANUARY, 5);
        poll1.setStartDate(new Date(calendar.getTimeInMillis()));
        calendar.set(2020 + 1900, Calendar.FEBRUARY, 5);
        poll1.setEndDate(new Date(calendar.getTimeInMillis()));
        poll1.setOptions(createPoll1Options());

        PollEntity poll2 = new PollEntity();
        poll1.setName("Which is your favorite?");
        poll1.setDescription("To find out which tree should I sit under.");
        poll1.setPublicPoll(true);
        poll1.setPublicId("FB42");
        calendar.set(2020 + 1900, Calendar.MARCH, 10);
        poll2.setStartDate(new Date(calendar.getTimeInMillis()));
        calendar.set(2020 + 1900, Calendar.JULY, 10);
        poll2.setEndDate(new Date(calendar.getTimeInMillis()));
        poll1.setOptions(createPoll2Options());

        return Arrays.asList(poll1, poll2);
    }

    private static List<PollOptionEntity> createPoll1Options() {
        PollOptionEntity option1 = new PollOptionEntity();
        option1.setValue("Top hat");

        PollOptionEntity option2 = new PollOptionEntity();
        option1.setValue("Fedora");

        return Arrays.asList(option1, option2);
    }

    private static List<PollOptionEntity> createPoll2Options() {
        PollOptionEntity option1 = new PollOptionEntity();
        option1.setValue("Apple");

        PollOptionEntity option2 = new PollOptionEntity();
        option1.setValue("Orange");

        PollOptionEntity option3 = new PollOptionEntity();
        option1.setValue("Banana");

        return Arrays.asList(option1, option2, option3);
    }
}
