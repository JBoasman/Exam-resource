public class WalkState implements State {

    private static WalkState instance;

    private WalkState() {
    }

    public static WalkState getInstance() {

        if (instance == null) {
            instance = new WalkState();
        }
        return instance;

    }
    @Override
    public void handleInput(Character character, Key event) {
        if (event == Key.LEFT) {
            character.setState(StandState.getInstance());
        }
    }
}
