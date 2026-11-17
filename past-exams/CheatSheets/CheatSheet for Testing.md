
# Testing

## Throwing Errors method with JUNIT Test

    default void check(Character character, Key event) {
            if (character == null) {
                throw new NullCharacterException();
            }
            if (event == null) {
                throw new NullKeyEventException();
            }
        }
    
    public class ExceptionTest {
    
        private Character character;
    
        @Before
        public void init() {
            this.character = new Character();
        }
        @Test(expected = NullKeyEventException.class, timeout = 1000)
        public void testNullKeyException() {
            character.getState().handle(character, null);
        }
        @Test(expected = NullCharacterException.class, timeout = 1000)
        public void testNullCharacterException() {
            character.getState().handle(null, Key.UP);
        }

## Instantiating variables, setting them in before and tests with min branch coverage
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

## Further JUNIT setup and Testing with Branch Coverage
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

## Another test
	@Test
	void test() {
		//Failing first branch
		String failFirstBranch = "J";
		assertEquals("J", StringUtil.collapseNewlines(failFirstBranch));
		String noNewLine = "Apple\n\nApple\nApple";
		assertEquals("Apple\nApple\nApple", StringUtil.collapseNewlines(noNewLine));
		//Due to the way the method works,this will explore every different part of each branch? So this is full branch coverrage?
	}
}

## Another test with Context

public class BranchComplete {

	BST tree;
	
	public BranchComplete() {
		this.tree = new BST();

		this.tree.insert(12, 'G');
		this.tree.insert(11, 'A');
		this.tree.insert(19, 'C');
		this.tree.insert(62, 'A');
		this.tree.insert(53, 'T');
		this.tree.insert(44, 'T');
		this.tree.insert(7, 'C');
	}

	public int DNATreeCalc(int a, int b, int c) {
		int ret = 0;

		int sum = this.tree.sum(this.tree.root); //208
				
		if (sum < a) {
			if (sum > b) {
				ret = sum + b;
			}
			
			ret = sum + a;
		}

		if (b - a > c) {
			ret = sum + c;
		}

		return ret;
	}
}

public class BSTBranchCompleteTest {
@Test(timeout=1000)
public void test() {

		BranchComplete bc = new BranchComplete();

		// START YOUR CODE
		//False, --, False
		assertEquals(0, bc.DNATreeCalc(1, 1, 1));
		//True, False, True
		assertEquals(208, bc.DNATreeCalc(209, 210, 0));
		//True, True, False
		assertEquals(417, bc.DNATreeCalc(209, 1, -208));
		// END YOUR CODE
	}
}

## Another Test with Double delta mod
public class MyUtilTest {

	@Test
	public void test() {
		//start your code
		//True
		assertEquals(0, (int) MyUtil.parseDouble(null));
		//False, False, True
		assertEquals(0, (int) MyUtil.parseDouble("NoNumber"));
		//False, True, False
		assertEquals(123.456, MyUtil.parseDouble("abc123.456efg"), 0.000001);
		//end your code
	}

## Another test,
public class MyStringUtilTest {

	@Test
	public void test() {
		//start your code
		//B1 True
		assertFalse(MyStringUtil.isMixedCase(null));
		//B1 False, B2 True
		assertFalse(MyStringUtil.isMixedCase(""));
		//B1 and B2 False
		//B3 True and False, B4 True and False, B5 True and False, B6 True and False
		assertTrue(MyStringUtil.isMixedCase("Both"));
		//Exit Branch True
		assertTrue(MyStringUtil.isMixedCase("aB"));
		//end your code
	}

}

## Test with messages

	@Test
	public void test() {

		// TODO
		// START YOUR CODE
		// HINT: assertEquals(result, BranchComplete.findSomething(a, b, c, d));
		//True, True, True
		assertEquals("Test1",-10, BranchComplete.findSomething(-10, 10, 0, 0));
		//False, True, False
		assertEquals("Test3",0, BranchComplete.findSomething(0, 20, 0, 0));
		//False, False-True
		assertEquals("Test4",10, BranchComplete.findSomething(10, 10, 0, 0));
		//False, False-False-True
		assertEquals("Test5",20, BranchComplete.findSomething(20, 10, 20, 20));
		// END YOUR CODE
	}
}

## Test with contect and null check

public class RiddleCheckAnswerTest {

    @Test
    public void tests() {
        Riddle rt = new Riddle("?", "Apple", Riddle.RiddleType.TEXT_RIDDLE);
        Riddle rn = new Riddle("?", "10", Riddle.RiddleType.NUMERIC_RIDDLE);
        Riddle ra = new Riddle("?", "Apple", Riddle.RiddleType.ANAGRAM_RIDDLE);
        Riddle rnull = new Riddle("?", "Apple", null);

        //Text Riddle, Correct Answer
        assertTrue("test1", rt.checkAnswer("Apple"));
        //Text Riddle, Wrong Answer
        assertFalse("test2", rt.checkAnswer("Apples"));

        //Numeric Riddle, Correct Answer
        assertTrue("test3", rn.checkAnswer("10"));
        //Numeric Riddle, Wrong Answer
        assertFalse("test4", rn.checkAnswer("12"));

        //Anagram Riddle, Correct Answer
        assertTrue("test5", ra.checkAnswer("Lappe"));
        //Anagram Riddle, Wrong Answer
        assertFalse("test6", ra.checkAnswer("Lapel"));

        //Null riddle to test failing else if for Anagram
        assertFalse("test7", rnull.checkAnswer("Apple"));

    }

public class Riddle {
public enum RiddleType {
TEXT_RIDDLE,
NUMERIC_RIDDLE,
ANAGRAM_RIDDLE;
}

    private String question;
    private String answer;
    private boolean isSolved;
    private RiddleType type;

    public Riddle(String question, String answer, RiddleType type) {
        this.question = question;
        this.answer = answer;
        this.isSolved = false;
        this.type = type;
    }

    public String askQuestion() {
		return this.question;
    }

    public boolean checkAnswer(String input) {
        boolean isCorrect = false;

        if (type == RiddleType.TEXT_RIDDLE) {
            if (input.equalsIgnoreCase(answer)) {
                isCorrect = true;
            }
        } else if (type == RiddleType.NUMERIC_RIDDLE) {
            if (input.matches("\\d+") && Integer.parseInt(input) == Integer.parseInt(answer)) {
                isCorrect = true;
            }
        } else if (type == RiddleType.ANAGRAM_RIDDLE) {
            char[] inputChars = input.toLowerCase().toCharArray();
            char[] answerChars = answer.toLowerCase().toCharArray();
            Arrays.sort(inputChars);
            Arrays.sort(answerChars);
            if (Arrays.equals(inputChars, answerChars)) {
                isCorrect = true;
            }
        }

        if (isCorrect) {
            isSolved = true;
        }
        return isCorrect;
    }

    public boolean isSolved() {
		return isSolved;
    }

    public void setSolved() { isSolved = true; }

    public String getAnswer() {
        return answer;
    }

## Another test
public class SomethingTest {

	@Test
	public void test() {
		// Implement your test cases
		// START YOUR CODE

		//False, Skip, True
		assertEquals(47, Something.someMethod(10, 10, 31, 16));

		//True, True, False
		assertEquals(138, Something.someMethod(36, 36, 15, 30));

		//True, False, False
		assertEquals(108, Something.someMethod(72, 36, 2, 1));
		
		// END YOUR CODE
	}
}


}

}

