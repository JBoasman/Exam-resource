# Design Patterns

UML Diagram Notes
Break notes into
- Singletons
- States?
- Exntends
- Implements
- Abstract?
 Label Examples with titles covering which of the above are invovled in the example. Small comments in code as well where beneifitcal for unique differences that links to the above ideas. 

## Building a calculator based off of Class/extension

public abstract class Operation {

	protected double a;
	
	protected double b;
	
	public Operation(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public abstract double evaluate();
}

public class Addition extends Operation {

	public Addition(double a, double b) {
		super(a, b);
	}

	@Override
	public double evaluate() {
		return this.a + this.b;
	}
}

public class Calculator {

	public double add(double a, double b) {

		//START YOUR CODE
		Operation x = new Addition(a, b);
		return x.evaluate();
		//END YOUR CODE
	}

	public double subtract(double a, double b) {

		//START YOUR CODE
		Operation x = new Subtraction(a, b);
		return x.evaluate();

		//END YOUR CODE
	}

	public double multiply(double a, double b) {

		//START YOUR CODE
		Operation x = new Multiplication(a, b);
		return x.evaluate();

		//END YOUR CODE
	}

	public double divide(double a, double b) {

		//START YOUR CODE
		Operation x = new Division(a, b);
		return x.evaluate();

		//END YOUR CODE
	}
}


## Difficult Implementation

import static org.junit.Assert.assertEquals;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GroceryTest {

	@Test
	public void test() {
		List<Fruit> fruits = new LinkedList<>(EnumSet.allOf(Fruit.class));

		Grocery<Fruit> grocery = new GreenGrocery();
		grocery.restock(fruits);
		
		List<Fruit> list = new LinkedList<>();
		
		Iterator<Fruit> iterator = grocery.getIterator();
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		
		assertEquals(fruits, list);
	}
}

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class GreenGrocery implements Grocery<Fruit> {

	private final List<Fruit> fruits = new ArrayList<>();

	public GreenGrocery() {
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

	@Override
	public void restock(List<Fruit> fruits) {

		//START YOUR CODE
		for (Fruit f : fruits) {
			if (!this.fruits.contains(f)) {
				this.fruits.add(f);
			}
		}

		//END YOUR CODE
	}

	@Override
	public Iterator<Fruit> getIterator() {
		return new FruitIterator(this);
	}

	public class FruitIterator implements Iterator<Fruit> {

		private final GreenGrocery grocery;

		public FruitIterator(GreenGrocery grocery) {
			this.grocery = grocery;
		}

		int index;

		@Override
		public boolean hasNext() {

			// START YOUR CODE
			return index < this.grocery.getFruits().size();
			// END YOUR CODE
		}

		@Override
		public Fruit next() {

			// START YOUR CODE
			if (this.hasNext()) {
				return this.grocery.getFruits().get(index++);
			}

			//You are allowed to change this return value.
			return null;
			// END YOUR CODE
		}
	}
}

## Another Example 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class ParcelTest {

	private Sender sender;
	private Recipient recipient;
	private PostOffice po;

	@Before
	public void init() {
		this.sender = new Sender();
		this.recipient = new Recipient();
		this.po = new PostOffice();
	}

	@Test
	public void test1() {

		Parcel parcel = sender.order(20, 1, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.AIRPLANE, transport);

		recipient.receive(parcel);
		assertEquals(Status.DELIVERED, parcel.getStatus());
	}

	@Test
	public void test2() {

		Parcel parcel = sender.order(70, 4, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.TRAIN, transport);

		recipient.receive(parcel);
		assertEquals(Status.DELIVERED, parcel.getStatus());
	}
	
	@Test
	public void test3() {
		
		Parcel parcel = sender.order(15, 8, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.SHIP, transport);

		recipient.receive(parcel);
		assertEquals(Status.DELIVERED, parcel.getStatus());
	}
	
	@Test
	public void test4() {

		Parcel parcel = sender.order(15, 5, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.TRANSFERRING, parcel.getStatus());
		assertEquals(Transport.TRAIN, transport);

		Recipient fake = new Recipient();
		fake.receive(parcel);
		assertEquals(Status.RETURNED, parcel.getStatus());
	}
	
	@Test
	public void test5() {

		Parcel parcel = sender.order(60, 1, recipient);
		assertEquals(Status.ORDERED, parcel.getStatus());

		po.registerParcel(parcel);
		assertEquals(Status.REGISTERED, parcel.getStatus());

		Transport transport = TransportOffice.getInstance().transportBy(parcel);
		assertEquals(Status.RETURNED, parcel.getStatus());
		assertNull(transport);
	}
	
	@Test
	public void test6() {
		assertSame(TransportOffice.getInstance(), TransportOffice.getInstance());
	}
}

public class TransportOffice {

	private static TransportOffice instance;

	private TransportOffice() {
	}

	public static TransportOffice getInstance() {

		// TODO
		// START YOUR CODE
		if (instance == null) {
			instance = new TransportOffice();
		}
		// YOU ARE ALLOWED TO CHANGE THIS RETURNED VALUE
		return instance;

		// END YOUR CODE
	}

	public Transport transportBy(Parcel parcel) {

		// TODO
		// START YOUR CODE
		if (parcel.getAllowedDays() < 1 || parcel.getWeight() > 20) {
			parcel.setStatus(Status.RETURNED);
			return null;
		}
		parcel.setStatus(Status.TRANSFERRING);
		if (parcel.getAllowedDays() < 3 && parcel.getWeight() <= 20) {
			return Transport.AIRPLANE;
		}
		if (parcel.getAllowedDays() < 7) {
			return Transport.TRAIN;
		} else {
			return Transport.SHIP;
		}
		// END YOUR CODE
	}
}

public class Recipient {

	public Recipient() {
	}

	public void receive(Parcel parcel) {
		// TODO
		// START YOUR CODE
		if (parcel.getRecipient() == this) {
			parcel.setStatus(Status.DELIVERED);
		} else {
			parcel.setStatus(Status.RETURNED);
		}
		// END YOUR CODE
	}
}


## State related Tests 

public class StandState implements State {

    private static StandState instance;

    private StandState() {
    }

    public static StandState getInstance() {

        if (instance == null) {
            instance = new StandState();
        }
        return instance;

    }

    @Override
    public void handle(Character character, Key event) {
        State.super.handle(character, event);
    }

    @Override
    public void handleInput(Character character, Key event) {
        if (event == Key.UP) {
            character.setState(SuspendState.getInstance());
        }
        if (event == Key.RIGHT) {
            character.setState(WalkState.getInstance());
        }
        if (event == Key.DOWN) {
            character.setState(SquatState.getInstance());
        }
    }

    @Override
    public void check(Character character, Key event) {
        State.super.check(character, event);
    }
}

import exceptions.NullCharacterException;
import exceptions.NullKeyEventException;

public interface State {

	default void handle(Character character, Key event) {

		check(character, event);

		this.handleInput(character, event);
	}

	public void handleInput(Character character, Key event);

	default void check(Character character, Key event) {

		// TODO
		// START YOUR CODE
		if (character == null) {
			throw new NullCharacterException();
		}
		if (event == null) {
			throw new NullKeyEventException();
		}


		// END YOUR CODE
	}
}

public class StateTest {

	private Character character;

	@Before
	public void init() {
		this.character = new Character();
	}

	@Test(timeout = 1000)
	public void testAllStates() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.UP, Key.RIGHT, Key.LEFT, Key.UP, Key.DOWN);
		List<State> expected = Arrays.asList(SquatState.getInstance(), StandState.getInstance(),
				WalkState.getInstance(), StandState.getInstance(), SuspendState.getInstance(), StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys1() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.DOWN, Key.UP, Key.RIGHT, Key.DOWN, Key.LEFT, Key.UP);
		List<State> expected = Arrays.asList(SquatState.getInstance(), SquatState.getInstance(),
				StandState.getInstance(), WalkState.getInstance(), WalkState.getInstance(), StandState.getInstance(),
				SuspendState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys2() {

		List<Key> keys = Arrays.asList(Key.LEFT, Key.UP, Key.DOWN, Key.RIGHT, Key.UP, Key.DOWN);
		List<State> expected = Arrays.asList(StandState.getInstance(), SuspendState.getInstance(),
				StandState.getInstance(), WalkState.getInstance(), WalkState.getInstance(), WalkState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}
}

## Abstract class extentioon state handling

public abstract class State {

	protected final VendingMachine machine;
	
	public State(VendingMachine machine) {
		this.machine = machine;
	}
	
	public abstract void handle(Event event);

	public VendingMachine getMachine() {
		return machine;
	}
}
public class Idle extends State {


    public Idle(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void handle(Event event) {
        if (event == Event.AnyButton) {
            machine.setState(new WaitingToSelect(machine));
        }
    }
}

public class VendingMachine {

	private State state = new Idle(this);

	public State getState() {

		// START YOUR CODE
		return state;
		// END YOUR CODE
	}

	public void setState(State state) {
		
		// START YOUR CODE
		this.state = state;
		// END YOUR CODE
	}
}

## Animal Creatioo, using a template, looping for creation, using super



public abstract class Animal {
private final String id;
private final String name;
private final int age;
private final int level;


    public Animal(String id, String name, int age, int level) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
    }

    abstract String speak();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return this.getId() + ": " + this.getName() + " says " + this.speak() +
                " (age: " + this.age + ", level: " + this.level + ")";
    }

}

import java.util.*;

public abstract class AnimalCreator {
int ageConfig = 0;  // default `ageConfig` and `levelConfig`
int levelConfig = 0;

    public AnimalCreator(Integer age, Integer level) {
        // TODO - Your code starts here
        if (age == null) {
            age = ageConfig;
        }
        if (level == null) {
            level = levelConfig;
        }
        if (age < 0 || level < 0) {
            throw new IllegalArgumentException("Age/Level can not be negative");
        }
        ageConfig = age;
        levelConfig = level;
        // TODO - Your code ends here
    }

    public abstract Animal createAnimal(String id, String name);

    public abstract String getNextName();

    /**
     * A template method used to create the ID, Name of an animal,
     * then returns the Animal created using these information.
     * <p>
     * 1) Create the ID using the string representation of `randomUUID()` from `UUID`.
     *    (Reference: https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html#randomUUID--)
     * 2) Get the next name for the animal.
     *    (Use the appropriate helper method which should be implemented in the subclasses)
     * 3) Create the animal, passing the ID and Name
     *    (Hint: `createAnimal()` should be implemented in the subclasses)
     */
    public Animal createAnimalTemplate() {
        // TODO - Your code starts here
        String id = UUID.randomUUID().toString();
        String name = this.getNextName();
        return createAnimal(id, name);
    }

    /**
     * Return a list of `number` animals.
     * @param number: number of animals to be created.
     */
    public List<Animal> createBatch(int number) {

        List<Animal> batch = new ArrayList<>();
        while (number > 0) {
            batch.add(this.createAnimalTemplate());
            number--;
        }
        return batch; // feel free to change this line

    }

}

import java.util.List;
import java.util.Random;


public class DogCreator extends AnimalCreator {
public static final List<String> NAMES = List.of("Rex", "Buddy", "Max", "Rocky");
private int nextNameIndex = 0;

    /**
     *  See README.
     *  Hint: you may use `nextNameIndex`
     */
    public String getNextName() {
        return(NAMES.get(nextNameIndex++ % 4));
    }

    public String getRandomName() {
        return NAMES.get(new Random().nextInt(NAMES.size()));
    }

    public DogCreator(Integer age, Integer level) {
        super(age, level);
    }

    @Override
    public Animal createAnimal(String id, String name) {
        return new Dog(id, name, this.ageConfig, this.levelConfig);
    }

}


## Another test, state changes using interface,

import java.util.*;

public class Kitchen {
List<Recipe> orders;
Map<Food, Integer> availableFood;

    public Kitchen(List<Recipe> orders, Map<Food, Integer> availableFood) {
        this.orders = orders;
        this.availableFood = availableFood;
    }

    /**
     * Check whether we have the sufficient quantity of food for a recipe.
     *
     * Verifies the availability of sufficient number of available (raw or ready)
     * food as required in the recipe.
     *
     * @return true if there are enough available food to prepare the recipe, and false otherwise.
     */
    public static boolean readyToCook(Recipe recipe, Set<Food> ava) {
        // TODO - Start your code
        for (Ingredient i : recipe.ingredients.keySet()) {
            int needed = recipe.ingredients.get(i);
            for (Food f : ava) {
                if (f.ingredient == i) {
                    if (!(f.state instanceof BurntState)) {
                        needed--;
                    }
                }
            }
            if (needed > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether we have the sufficient food to complete a recipe.
     *
     * Verifies the availability of sufficient number of food in the ReadyState as required in the recipe.
     *
     * @return true if there are enough available food to complete the recipe, and false otherwise.
     */
    public static boolean readyToServe(Recipe recipe, Set<Food> ava) {
        // TODO - Start your code
        for (Ingredient i : recipe.ingredients.keySet()) {
            int needed = recipe.ingredients.get(i);
            for (Food f : ava) {
                if (f.ingredient == i) {
                    if ((f.state instanceof ReadyState)) {
                        needed--;
                    }
                }
            }
            if (needed > 0) {
                return false;
            }
        }
        return true;
        // TODO - End your code
    }

    /**
     * Determines the additional ingredients required to complete all orders.
     *
     * Note that burnt food in `availableFood` can not be considered available.
     *
     * Example:
     *      If we need to complete a Wagyu Udon (the recipe requires 3 wagyu and 1 udon) and a biscuit
     *      (requiring 1 biscuit) while we only have one unit of biscuit available,
     *      we will need **3 WAGYUs** and **1 UDON** to complete the orders.
     *
     * @return A map where the key is the ingredient item, and the
     *         value is the additional quantity needed to fulfill all orders.
     *         The map shall contain only the ingredient items that are insufficient.
     */
    public Map<Ingredient, Integer> ingredientsRequired() {
        // TODO - Start your code
        Map<Ingredient, Integer> toGet = new HashMap<>();
        // Total the ingredients needed across all orders.
        for (Recipe recipe : orders) {
            for (Ingredient i : recipe.ingredients.keySet()) {
                toGet.put(i, toGet.getOrDefault(i, 0) + recipe.ingredients.get(i));
            }
        }

        // Subtract each usable stock entry once.
        for (Food f : availableFood.keySet()) {
            Ingredient i = f.getIngredient();
            if (!(f.state instanceof BurntState) && toGet.containsKey(i)) {
                toGet.put(i, toGet.get(i) - availableFood.get(f));
            }
        }

        // Keep only ingredients that are still needed.
        toGet.entrySet().removeIf(entry -> entry.getValue() <= 0);
        return toGet;

        // TODO - End your code
    }

}

public class ReadyState implements FoodState {
/** Singleton */
private static volatile ReadyState instance = new ReadyState();
public static ReadyState getState() {
if (instance == null) {
synchronized (ReadyState.class) {
if (instance == null) {
instance = new ReadyState();
}
}
}
return instance;
}


    /**
     * Prepare the food.
     *
     * Increasing elapsedPrepTime for the food,
     * and transition it to the BurntState if exceeded the required
     * preparation time (as recorded in the Ingredient enum) by 2.
     *
     * Note that food with elapsedPrepTime being the required prepTime
     * plus one can remain in the ReadyState.
     *
     * Assumption: the food is already in a correct state
     * with respect to its elapsedPrepTime.
     */
    @Override
    public void prepare(Food food) {
        // TODO - Start your code
        food.elapsedPrepTime++;
        if (food.elapsedPrepTime > Ingredient.getPrepTime(food.ingredient ) + 1) {
            food.setState(BurntState.getState());
        }

        // TODO - End your code
    }
}
public interface FoodState {

    /**
     * Update the appropriate fields of food as it gets prepared,
     * including to perform state transition if needed.
     */
    void prepare(Food food);

}

## Complex Implementatioon from UML to full system 
Too add: a representation of a UML diagram to udnerstand how this was built. 
public class FavouriteList {
private List<Item> items = new ArrayList<>();
private List<Observer> observers = new ArrayList<>();

    public FavouriteList() {}

//    Item getItem(String id, String name) {
//        // TODO - The logic to check whether the instance field `items` contains
//        // an item with the same id and name, and return it if found.
//
//        return null;  // return null if not found
//    }


    public void addItem(Item item) {
        // adds the `item` to the list of items if it is non-null and no items with the same id exists.
        // If successfully added, notify the observers with the "added" event.
        if (item == null) {
            return;
        }
        for (Item existing : items) {
            if (Objects.equals(existing.getId(), item.getId())) {
                return;
            }
        }
        this.items.add(item);
        this.notify("added", item);

    }

    public void removeItem(Item item) {
        // removes the given `item` from the list of items if an item with the same id and name exists.
        // If successfully removed, notify the observers with the "removed" event.
        if (item == null) {
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            Item existing = items.get(i);
            if (Objects.equals(existing.getId(), item.getId())
                    && Objects.equals(existing.getName(), item.getName())) {
                items.remove(i);
                this.notify("removed", existing);
                return;
            }
        }
    }

    public void attach(Observer o) {
        // adds `o` to the list of observers if it is not null and not already present.
        if (o != null && !observers.contains(o)) {
            this.observers.add(o);
        }
    }

    public void detach(Observer o) {
        // removes `o` if it is present in the instance field `observers`.
        if (o != null) {
            this.observers.remove(o);
        }
    }

    public void notify(String event, Item item) {
        for (Observer o : this.observers) {
            o.update(event, item);
        }
    }

}

public class NotificationService implements Observer {

    private String channel;

    public NotificationService(String channel) {
        this.channel = channel;
    }

    @Override
    public void update(String event, Item item) {
        System.out.println("[channel " + channel + "] event: " + event
                + ", item #" + item.getId() + " (" + item.getName() + ")");
    }
}


public interface Observer {

    public abstract void update(String event, Item item);
}


public class User {
private String name;
private FavouriteList favourites;
protected String id;



    public User(String id) {
        this.id = id;
        this.favourites = new FavouriteList();

    }

    public FavouriteList getFavourites() {
        return favourites;
    }

    public void setFavourites(FavouriteList favourites) {
        this.favourites = favourites;
    }

    public String getName() {
        return this.name;
    }


}

public class Item {
protected String id;
private String name;

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}



public class User {
private String name;
private FavouriteList favourites;
protected String id;



    public User(String id) {
        this.id = id;
        this.favourites = new FavouriteList();

    }

    public FavouriteList getFavourites() {
        return favourites;
    }

    public void setFavourites(FavouriteList favourites) {
        this.favourites = favourites;
    }

    public String getName() {
        return this.name;
    }


}

















