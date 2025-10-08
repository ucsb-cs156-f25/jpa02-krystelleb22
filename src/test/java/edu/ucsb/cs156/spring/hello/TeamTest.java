package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }


    //Case 1: same object
    @Test
    public void teamEqual_same() {
       
        assert(team.equals(team));
    }

     //Case 2: different object
    @Test
    public void teamEqual_different() {
        Team t = new Team("f25-xx");
        t.addMember("Alice");
        t.addMember("Bob");
        t.addMember("Chris G.");
        t.addMember("Danny");
        t.addMember("Eve");
        t.addMember("Frances");

         assertEquals(false, team.equals(t));
         assertEquals(false, team.equals("Not a team"));
         assertEquals(false, team.equals(1));
         
    }

    //Case 3: same name and members
    @Test
    public void teamEqual_compareFields() {
        Team t = new Team("test-team");   
        assert(team.equals(t));
    }

    //Case 3: same name and different members
    @Test
    public void teamEqual_compareFields_sameName_diffMembers() {
        Team t2 = new Team("test-team");    
        t2.addMember("Alice");
        t2.addMember("Bob");
        t2.addMember("Chris G.");
        t2.addMember("Danny");
        t2.addMember("Eve");
        t2.addMember("Frances");

         assertEquals(false, team.equals(t2));
    }

     //Case 3: different name and same members
    @Test
    public void teamEqual_compareFields_diffName_sameMembers() {
        Team t2 = new Team("f25-xx");    

        assertEquals(false, team.equals(t2));
    }

    //Case 3: different name and different members
    @Test
    public void teamEqual_compareFields_diffName_diffMembers() {
        Team t2 = new Team("f25-xx");    
        t2.addMember("Alice");
        t2.addMember("Bob");
        t2.addMember("Chris G.");
        t2.addMember("Danny");
        t2.addMember("Eve");
        t2.addMember("Frances");

         assertEquals(false, team.equals(t2));
    }

    @Test
    public void team_hashCode_equal(){
        // instantiate t as a Team object
int result = team.hashCode();
int expectedResult = -1226298695;
assertEquals(expectedResult, result);

    }

    @Test
    public void team_hashCode_different(){
        Team t1 = new Team();
        t1.setName("Alice");
        t1.addMember("Bob");
        Team t2 = new Team();
        t2.setName("Alice");
        t2.addMember("Chris G.");
        assert(!(t1.hashCode() == t2.hashCode()));
    }



    // // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
