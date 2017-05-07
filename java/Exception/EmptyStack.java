package Exception;

public class EmptyStack extends RuntimeException {
    public EmptyStack(){
        this("Error: stack is empty");
    }

    public EmptyStack(String message){
        super(message);
    }

}
