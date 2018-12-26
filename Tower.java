import java.util.ArrayList;
import java.util.List;

public class Tower {
    List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {}
    public void unregister(Flyable flyable) {}
    protected void conditionsChanged() {}
}
