package avaj.aircrafts;

import avaj.aircrafts.*;
import avaj.weather.*;

public class Aircraft {
    protected long id;
    private static long idCounter = 0;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.id = nextId();
        this.coordinates = coordinates;
    }
    private long nextId() {
        return (++idCounter);
    }
    public String getName() {
        return this.name;
    }
}
