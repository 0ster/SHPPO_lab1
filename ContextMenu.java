import java.util.ArrayList;
import java.util.List;

public class ContextMenu {
    private List<Options> option = new ArrayList<>();
    private MenuState currentState;

    public ContextMenu(MenuState currentState) {
        this.currentState = currentState;
    }

    public void setState(MenuState state) {
        this.currentState = currentState;
    }
    public void show(){
        currentState.handleContextMenu();
    }
    public void addOption(Options option){
        option.add(option);
    }

    public List<Options> getOptions() {
        return option;
    }
}
