package Q1;
import java.util.ArrayList;
import java.util.List;

public class Participant {
    private ParticipantState state;
    private final Riddle[] riddleList;
    private final List<Observer> observers = new ArrayList<>();
    public Participant(Riddle[] riddleList) { this.riddleList = riddleList; state = new InProgressState(); }
    public void registerObserver(Observer observer) { if (!observers.contains(observer)) observers.add(observer); }
    public void askForHelp() { state = new HelpState(); for (Observer observer : observers) observer.updateHelp(this); }
    public void solveRiddle(String input, int whichRiddle) throws RiddleException {
        state = state.solveRiddle(input, riddleList, whichRiddle);
        if (state instanceof EscapedState) for (Observer observer : observers) observer.updateEscape(this);
    }
    public ParticipantState getState() { return state; }
    public Riddle getRiddle(int whichRiddle) { return riddleList[whichRiddle]; }
}
