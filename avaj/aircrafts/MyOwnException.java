package avaj.aircrafts;

public class MyOwnException extends Exception {
    private int counter;

    public MyOwnException(int lineCounter) {
        this.counter = lineCounter;
    }

    public int getCounter() {
        return counter;
    }
}