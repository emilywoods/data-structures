package Exception;

public class FullQueue extends RuntimeException {
    public FullQueue() {
        this("Error: Full Queue");
    }

    public FullQueue(String message){
        super(message);
    }
}
