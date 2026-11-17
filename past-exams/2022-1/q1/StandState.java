public final class StandState implements State {
    private static final StandState INSTANCE = new StandState();
    private StandState() {}
    public static StandState getInstance() { return INSTANCE; }
    @Override public void handleInput(Character character, Key event) {
        if (event == Key.RESET) { character.setState(StandState.getInstance()); return; }
        if (event == Key.DOWN) character.setState(LieProneState.getInstance());
        if (event == Key.RIGHT) character.setState(RunState.getInstance());
    }
}
