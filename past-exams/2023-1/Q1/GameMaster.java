package Q1;
import java.util.HashSet;
import java.util.Set;

public class GameMaster implements Observer {
    private final Set<Participant> helped = new HashSet<>(), escaped = new HashSet<>();
    public void updateHelp(Participant participant) { helped.add(participant); }
    public void updateEscape(Participant participant) { escaped.add(participant); }
    public boolean hasAskedForHelp(Participant participant) { return helped.contains(participant); }
    public boolean hasEscaped(Participant participant) { return escaped.contains(participant); }
}
