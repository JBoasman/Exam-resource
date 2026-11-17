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

