package State;

public class CollapsedState implements MenuState {

    @Override
    public void stateHandle() {
        System.out.println("Меню свёрнуто: ");
    }

}
