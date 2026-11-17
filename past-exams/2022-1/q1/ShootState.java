public final class ShootState implements State {
    private static final ShootState INSTANCE = new ShootState();
    private ShootState() {}
    public static ShootState getInstance() { return INSTANCE; }
    @Override public void handleInput(Character character, Key event) {
        if (event == Key.RESET) { character.setState(StandState.getInstance()); return; }
        if (event == Key.L) character.setState(LieProneState.getInstance());
    }
}
