package Exception;

public class EmptyQueue extends  RuntimeException{
    public EmptyQueue() {
        this("Error: Empty Queue");
    }

    public EmptyQueue(String message){
        super(message);
    }
}
