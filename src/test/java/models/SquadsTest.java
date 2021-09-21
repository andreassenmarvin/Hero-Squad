//package models;
//
//import org.junit.After;
//import org.junit.Before;
//
//
//public class SquadsTest {
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        Squads.clearAll();
//    }
//
//    @Test
//    public void findId_getsCorrectSquad() throws Exception{
//        Squads first = setUpSquad();
//         Assertions.assertEquals(4, Squads.squadWithId(first.getId()).getId());
//    }
//    @Test
//    public void addToSquad_addsCorrectHero() throws Exception{
//        Heroes newHero = new Heroes("The Defenders", 10, "Crush");
//        Squads newSquad = setUpSquad();
//        newSquad.addHero(newHero);
//        Assertions.assertEquals(true, newSquad.getHeroesInSquad().contains(newHero));
//    }
//
//    @Test
//    public void getsCorrectDate() {
//        Squads newSquad = setUpSquad();
//        Assertions.assertEquals(LocalDateTime.now().getDayOfWeek(), newSquad.getCreatedAt().getDayOfWeek());
//        String createdAt = "16-August-2021";
//        Assertions.assertEquals(createdAt, newSquad.getFormatDateTime()); // Expected result changes depending on the day
//    }
//
//    @Test
//    public void deleteSquad_deletesCorrectSquad() throws Exception{
//        Squads first = setUpSquad();
//        Squads second = setUpSquad();
//        first.deleteSquad();
//       Assertions.assertEquals(Squads.getAllSquads().size(), 2);
//       Assertions.assertEquals(Squads.getAllSquads().get(0).getId(), 1);
//    }
//}