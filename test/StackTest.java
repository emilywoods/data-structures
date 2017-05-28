import org.junit.Before;
import org.junit.Test;
import Exception.EmptyStack;
import Exception.FullStack;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class StackTest {
    Stack stack;

    @Before
    public void setup() {
        stack = new Stack(3);
    }

    @Test
    public void isEmpty_whenStackIsEmpty_thenReturnsTrue(){
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void isEmpty_whenStackIsNotEmpty_thenReturnsFalse(){
        stack.push(1);

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void isEmpty_whenStackIsFull_thenReturnsTrue(){
        givenStackIsFull();

        assertThat(stack.isFull(), is(true));
    }

    @Test
    public void isEmpty_whenStackIsNotFull_thenReturnsFalse(){
        assertThat(stack.isFull(), is(false));
    }

    @Test
    public void push_whenElementIsPushedOntoEmptyStack_thenAddedToTopOfStack(){
        stack.push(1);

        assertThat(stack.elements[0], is(1));
    }

    @Test
    public void push_whenElementIsPushedOntoNonEmptyStack_thenAddedToTopOfStack(){
        givenStackHasTwoElements();

        stack.push(3);

        assertThat(stack.elements[2], is(3));
        assertThat(stack.elements.length, is(3));
    }


    @Test(expected = FullStack.class)
    public void push_whenElementIsPushedOntoFullStack_thenFullStackException(){
        givenStackIsFull();

        stack.push(3);
    }

    @Test
    public void pop_whenElementIsPoppedFromNonEmptyStack_thenItemRemovedFromTopOfStack(){
        givenStackIsFull();

        stack.pop();

        assertThat(stack.elements[0], is(1));
        assertThat(stack.elements[1], is(2));
        assertThat(stack.elements[2], is(nullValue()));
    }

    @Test(expected = EmptyStack.class)
    public void pop_whenElementIsPoppedFromEmptyStack_thenEmptyStackException(){
        stack.pop();

    }

    private void givenStackIsFull() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    private void givenStackHasTwoElements() {
        stack.push(1);
        stack.push(2);
    }

}