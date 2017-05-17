## Data Structures

### Queue

A queue is a first in, first out linear abstract data type. When items are inserted, it's said that 
 they are enqueued, and when removed are dequeued. Items are added at the tail of the 
 queue, and are removed from the head. 
 
 Attempting to remove an item from an empty queue results in a queue underflow, and 
 adding an item to a full queue results in a queue overflow.

### Stack
A stack is a last in, first out data structure. Items are inserted or pushed 
onto the stack, and when removed they are said to be popped off. Items can only be added or 
removed from the top of the stack.

 Attempting to remove an item from an empty stack results in a stack underflow, and 
 adding an item to a full stack results in a stack overflow.
 
### Linked List
A linked list is a linear data structure. The order of elements, or nodes in a linked list is
determined by references to the next node. Each node of the list contains two components,
the element value itself, and a reference to the next node. This determines the order of the
 list. The final node in a linked list has  a reference to null. 

The point of entry to a linked list is at the head. This head is not a separate node,
but a reference to the first node.

Linked lists can be singly, or doubly linked, meaning that each node possesses a reference
to the next node, or a reference to both the previous and next node, respectively.

A circular linked list possesses a reference back to the first node, at the last node, and vice versa.

The advantage of using a linked list as opposed to an array, is that a linked list is 
a dynamic data structure, and items can be added or removed. By contrast, an array is of
fixed size.
Insertion and deletion are also easier to carry out in a linked list, as this requires a reordering
of references. Insertion and deletion is more costly in an array, since elements are stored in 
consecutive memory locations

Disadvantages of linked lists compared with arrays is that they use more memory, due to the 
references. Linked lists must also be traversed sequentially, and do not have random access. 

