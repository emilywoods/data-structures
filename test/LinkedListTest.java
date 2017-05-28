import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<Integer> list;

    @Before
    public  void setup(){
        list = new LinkedList<>();
    }

    @Test
    public void searchWithValue_whenSearchingListForValue_thenReturnsNodeIfFound(){
        givenListHasFourElementsWithValuesOneToFour();

        LinkedList.Node result = list.searchWithValue(3);

        assertThat(result.element, is(3));
        assertThat(result.next.element, is(4));
    }

    @Test
    public void searchWithValue_whenSearchingListForValue_thenReturnsNullIfNotFound(){
        givenListHasFourElementsWithValuesOneToFour();

        LinkedList.Node result = list.searchWithValue(6);

        assertThat(result, is(nullValue()));
    }

    @Test
    public void insertElementAtHead_whenAnElementIsInsertedAtHead_thenSizeIncreasesByOneAndElementIsAtHead() {
        givenListIsNotEmptyAndHasOneElement();

        list.insertElementAtHead(5);

        assertThat(list.head.element, is(5));
        assertThat(list.size(), is(2));
    }

    @Test
    public void insertElementAtTail_whenAnElementIsInsertedAtTail_thenSizeIncreasesByOneAndElementIsAtTail(){
        givenListIsNotEmptyAndHasOneElement();

        list.insertElementAtTail(22);

        assertThat(list.head.next.element, is(22));
        assertThat(list.size(), is(2));
    }

    @Test
    public void deleteNode_whenANodeIsDeleted_thenSizeDecreasesByOneAndElementIsRemovedAtIndex(){
        givenListHasFourElementsWithValuesOneToFour();

        list.deleteNode(0);

        assertThat(list.size(), is(3));
        assertThat(list.head.element, is(2));
        assertThat(list.head.next.element, is(3));
        assertThat(list.head.next.next.element, is(4));
    }

    @Test
    public void deleteHeadElement_whenANodeIsDeletedAtHead_thenSizeDecreasesByOneAndHeadIsUpdatedWithNextElement(){
        givenListHasFourElementsWithValuesOneToFour();

        list.deleteHeadElement();

        assertThat(list.size(), is(3));
        assertThat(list.head.element, is(2));
        assertThat(list.head.next.element, is(3));
        assertThat(list.head.next.next.element, is(4));
    }

    @Test
    public void size_whenSize_thenSizeReturnsListSize() {
        list.insertElementAtHead(1);

        assertThat(list.size(), is(1));
    }

    private void givenListIsNotEmptyAndHasOneElement() {
        list.insertElementAtHead(1);
    }

    private void givenListHasFourElementsWithValuesOneToFour() {
        list.insertElementAtHead(4);
        list.insertElementAtHead(3);
        list.insertElementAtHead(2);
        list.insertElementAtHead(1);
    }
}