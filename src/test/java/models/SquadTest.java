package models;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

class SquadsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Squads.clearAll();
    }

    public Squads setUpSquad(){
        return new Squads("Menace", "To destroy and conquer", "http.sgd.com",5);
    }
    @Test
    public void newSquad_instantiates_correctly_withCorrectValues_true() throws Exception{
        Squads first = setUpSquad();
        Squads second = setUpSquad();
        Assertions.assertEquals(true, first instanceof Squads);
        Assertions.assertEquals("Menace", first.getSquadName());
        Assertions.assertEquals("To destroy and conquer", first.getTheme());
        Assertions.assertEquals(5, first.getMaxHeroes());
        Assertions.assertEquals(6, Squads.getAllSquads().size());
        Assertions.assertEquals("http.sgd.com", second.getUrl());
    }

    @Test
    public void findId_getsCorrectSquad() throws Exception{
        Squads first = setUpSquad();
        Assertions.assertEquals(4, Squads.squadWithId(first.getId()).getId());
    }
    @Test
    public void addToSquad_addsCorrectHero() throws Exception{
        Heroes newHero = new Heroes("IronMan", "Smart", "Leader");
        Squads newSquad = setUpSquad();
        newSquad.addHero(newHero);
        Assertions.assertEquals(true, newSquad.getHeroesInSquad().contains(newHero));
    }

    @Test
    public void getsCorrectDate() {
        Squads newSquad = setUpSquad();
        Assertions.assertEquals(LocalDateTime.now().getDayOfWeek(), newSquad.getCreatedAt().getDayOfWeek());
        String createdAt = "16-August-2021";
        Assertions.assertEquals(createdAt, newSquad.getFormatDateTime()); // Expected result changes depending on the day
    }

    @Test
    public void deleteSquad_deletesCorrectSquad() throws Exception{
        Squads first = setUpSquad();
        Squads second = setUpSquad();
        first.deleteSquad();
        Assertions.assertEquals(Squads.getAllSquads().size(), 2);
        Assertions.assertEquals(Squads.getAllSquads().get(0).getId(), 1);
    }

}