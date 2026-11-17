import java.util.List;
import java.util.Random;


public class PenguinCreator extends AnimalCreator {
    private static final List<String> NAMES = List.of("Ace", "Alaska", "Aurora", "Bam-Bam", "Banjo");
    private int nextNameIndex = 0;

    public String getNextName() {

        return(NAMES.get(nextNameIndex++ % 5));
    }

    public String getRandomName() {
        return NAMES.get(new Random().nextInt(NAMES.size()));
    }

    public PenguinCreator(Integer age, Integer level) {
        super(age == null ? 1 : age, level == null ? 2 : level);
    }

    @Override
    public Animal createAnimal(String id, String name) {
        return new Penguin(id, name, this.ageConfig, this.levelConfig);
    }

}
