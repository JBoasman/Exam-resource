public final class RunState implements State {
    private static final RunState INSTANCE = new RunState();
    private RunState() {}
    public static RunState getInstance() { return INSTANCE; }
    @Override public void handleInput(Character character, Key event) {
        if (event == Key.RESET) { character.setState(StandState.getInstance()); return; }
        if (event == Key.LEFT) character.setState(StandState.getInstance());
    }
}
