/**
 * Created by vkorniie on 15/12/2018.
 */
public class Aircraft {
    protected long id;
    private static long idCounter = 0;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.id = nextId() + 1;
        this.coordinates = coordinates;
    }
    private long nextId() {
        return idCounter;
    }
    public String getName() {
        return this.name;
    }
}
