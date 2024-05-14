package State;

public class ExpandedState implements MenuState {
    private String name;

    @Override
    public void stateHandle() {
        System.out.println("Меню развернуто: ");
    }
}
