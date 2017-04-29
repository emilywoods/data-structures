package Exception;

public class FullStack extends RuntimeException {
    public FullStack(){
        this("Error: stack is full");
    }

    public FullStack(String message){
        super(message);
    }
}
