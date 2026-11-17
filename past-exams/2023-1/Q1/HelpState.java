package Q1;

public class HelpState implements ParticipantState {
    @Override public ParticipantState solveRiddle(String input, Riddle[] riddles, int which) throws RiddleException {
        if (which < 0 || which >= riddles.length || riddles[which].isSolved()) throw new RiddleException("Invalid or solved riddle");
        riddles[which].setSolved();
        for (Riddle riddle : riddles) if (!riddle.isSolved()) return new InProgressState();
        return new EscapedState();
    }
}
