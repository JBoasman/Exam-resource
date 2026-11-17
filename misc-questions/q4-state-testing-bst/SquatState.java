public class SquatState implements State {

    private static SquatState instance;

    private SquatState() {
    }

    public static SquatState getInstance() {

        if (instance == null) {
            instance = new SquatState();
        }
        return instance;

    }
    @Override
    public void handleInput(Character character, Key event) {
        if (event == Key.UP) {
            character.setState(StandState.getInstance());
        }
    }
}
