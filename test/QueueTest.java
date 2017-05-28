import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import Exception.FullQueue;
import Exception.EmptyQueue;

public class QueueTest {
    Queue queue;

    @Before
    public void setup() {
        queue = new Queue(3);
    }

    @Test
    public void isEmpty_whenQueueIsEmpty_ThenReturnsTrue() {
        boolean result = queue.isEmpty();

        assertThat(result, is(true));
    }

    @Test
    public void isEmpty_whenQueueIsNotEmpty_ThenReturnsFalse() {
        queue.enqueue(1);

        boolean result = queue.isEmpty();

        assertThat(result, is(false));
    }

    @Test
    public void isFull_whenFull_thenReturnsTrue() {
        givenQueueIsFull();

        boolean result = queue.isFull();

        assertThat(result, is(true));
    }

    @Test
    public void isFull_whenNotFull_thenReturnsFalse() {
        boolean result = queue.isFull();

        assertThat(result, is(false));
    }

    private void givenQueueIsFull() {
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
    }

    @Test
    public void enqueue_whenItemIsEnqueuedToEmptyQueue_thenItemAddedToTopOfQueue() {
        queue.enqueue(3);

        assertThat(queue.elements[0], is(3));
    }

    @Test
    public void enqueue_whenItemIsEnqueuedToNonEmptyQueue_thenItemAddedToTopOfQueue() {
        givenQueueHasTwoElementsInQueue();

        queue.enqueue(3);

        assertThat(queue.elements[2], is(3));
    }

    @Test(expected = FullQueue.class)
    public void enqueue_whenItemIsEnqueuedToFullQueue_thenFullQueueException() {
        givenFullQueue();

        queue.enqueue(3);

        assertThat(queue.elements[0], is(3));
    }

    @Test
    public void dequeue_whenItemDequeuedFromNonEmptyQueue_thenItemRemovedFromTopOfQueue() {
        givenQueueHasTwoElementsInQueue();

        queue.dequeue();

        assertThat(queue.elements[0], is(2));
        assertThat(queue.elements[1], is(nullValue()));

    }

    @Test(expected = EmptyQueue.class)
    public void dequeue_whenItemIsEnqueuedFromEmptyQueue_thenEmptyQueueException() {
        queue.dequeue();
    }

    private void givenQueueHasTwoElementsInQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
    }

    private void givenFullQueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
    }

}