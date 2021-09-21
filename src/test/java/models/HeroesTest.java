package models;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroesTest {

        @Before
        public void setUp() throws Exception {
        }

        @After
        public void tearDown() throws Exception {
            Heroes.clearAllHeroes();
        }

        public Heroes setUpHero(){
            return new Heroes("The Flash", 25, "Defeat villains");
        }
        @Test
        public void newHero_instantiates_correctly() throws Exception{
            Heroes newHero = setUpHero();
            Assertions.assertEquals(true, newHero instanceof Heroes);
            Assertions.assertEquals("IronMan", newHero.getName());
            Assertions.assertEquals("Smart", newHero.getSuperPower());
            Assertions.assertEquals("Leader", newHero.getRole());
        }

        @Test
        public void getAllHeroes_capturesAllHeroes_2() throws Exception{
            Heroes first = setUpHero();
            Heroes second = setUpHero();
            Heroes third = setUpHero();
            Assertions.assertEquals(4, Heroes.getAllHeroes().size());
        }


}