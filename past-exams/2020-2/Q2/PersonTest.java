import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
     // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //Person p = new Person("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());

    private Person person;

    @Before
    public void setUp() {
        person = new Person("Josh", 20, "student", false, false);
    }

    @Test
    public void getIdTest() {
        assertNull(person.getId());
    }

    @Test
    public void setIDTest() {
        person.setId(2);
        assertEquals(2, (int) person.getId());
    }

    @Test
    public void getAgeTest() {
        assertEquals(20, (int) person.getAge());
    }

    @Test
    public void getNameTest() {
        assertEquals("Josh", person.getName());
    }
    
    @Test
    public void getOccupationTest() {
        assertEquals("student", person.getOccupation());
    }

    @Test
    public void getDiabetesTest() {
        assertFalse(person.getDiabetes());
    }

    @Test
    public void getHeartDiseaseTest() {
        assertFalse(person.getHeartDisease());
    }

    @Test
    public void getHealthInsurancePriceTest() {

        //B1 Fail
        assertEquals(350, (int) person.getHealthInsurancePrice());
        //B1 True
            //B2 Fail
        Person person2 = new Person("Josh", 20, null, false, false);
        assertEquals(200, (int) person2.getHealthInsurancePrice());
        //B1 True
            //B2 True
                //B3 True
        Person person3 = new Person("Josh", 50, null, true, true);
        assertEquals(1100, (int) person3.getHealthInsurancePrice());
        //B1 True
            //B2 True
                //B3 False
                //B4 True
        Person person4 = new Person("Josh", 50, null, false, false);
        assertEquals(360, (int) person4.getHealthInsurancePrice());
        //B1 True
            //B2 True
                //B3 False
                //B4 False
                //B5 True
        Person person5 = new Person("Josh", 50, "", false, true);
        assertEquals(500, (int) person5.getHealthInsurancePrice());
        //B1 True
            //B2 True
                //B3 False
                //B4 False
                //B5 False
                //B6 True
        Person person6 = new Person("Josh", 50, "policeman", true, false);
        assertEquals(400, (int) person6.getHealthInsurancePrice());

    }



    // ########## YOUR CODE ENDS HERE ##########

}
