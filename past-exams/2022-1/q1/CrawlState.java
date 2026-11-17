public final class CrawlState implements State {
    private static final CrawlState INSTANCE = new CrawlState();
    private CrawlState() {}
    public static CrawlState getInstance() { return INSTANCE; }
    @Override public void handleInput(Character character, Key event) {
        if (event == Key.RESET) { character.setState(StandState.getInstance()); return; }
        if (event == Key.LEFT) character.setState(LieProneState.getInstance());
    }
}
