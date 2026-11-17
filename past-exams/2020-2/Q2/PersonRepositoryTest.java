
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonRepositoryTest {



    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    Person person;
    PersonRepository repo;
    SequenceGenerator sg;

    @Before
    public void before() {
        sg = new SequenceGenerator();
        repo = new PersonRepository();
        repo.setSequenceGenerator(sg);
        person = new Person("Josh", 20, "student", false, false);
        repo.save(person);
    }

    @Test
    public void findByIdTest() {
        assertEquals(person, repo.findById(person.getId()));
    }

    @Test
    public void setSequenceGeneratorTest() {
        SequenceGenerator s2 = new SequenceGenerator();
        assertTrue(repo.setSequenceGenerator(s2));
    }

    @Test
    public void saveTest() {
        Person person2 = new Person("James", 20, "student", false, false);
        assertEquals(person2, repo.save(person2)); //succeeds first branch.
        //assertEquals(person2, repo.findById(2));
        Person person3 = new Person("James", 20, "student", false, false);
        person3.setId(4);
        assertThrows(RuntimeException.class, () -> repo.save(person3)); //fails first branch
        //assertNull(repo.findById(4)); //because looking for an Id in the hashmap wont return anything?
       // assertNull(repo.findById(3)); //incase it tried to overrule it? //This has been commented out to preserve MINIUM number of tests
    }

    // ########## YOUR CODE ENDS HERE ##########


}
