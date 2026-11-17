public final class LieProneState implements State {
    private static final LieProneState INSTANCE = new LieProneState();
    private LieProneState() {}
    public static LieProneState getInstance() { return INSTANCE; }
    @Override public void handleInput(Character character, Key event) {
        if (event == Key.RESET) { character.setState(StandState.getInstance()); return; }
        if (event == Key.UP) character.setState(StandState.getInstance());
        if (event == Key.RIGHT) character.setState(CrawlState.getInstance());
        if (event == Key.S) character.setState(ShootState.getInstance());
    }
}
