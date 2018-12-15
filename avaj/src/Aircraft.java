/**
 * Created by vkorniie on 15/12/2018.
 */
public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.id = 1;
        this.coordinates = coordinates;
    }
    private long nextId() {
        return (this.id + 1);
    }
}
