package intlist2;
 
import java.util.Arrays;

/**
 * each instance of this class stores a list of integers.
 */
class Node {
	
	int value;
	Node next;
}
public class intlist {
		
	private Node firstnode;

	public int getSize() {
				int count = 0;
				Node node = firstnode;
				while (node != null) {
					count++;
					node = node.next;
				}
				return count;
	}
	/**
	 * @pre the given index is between 0 and one less than the lenght of the list.
	 * 		| 0<= index && index < getSize()
	 */
	public int get(int index) {
		
		Node node = firstnode;
		for (int i = 0; i < index ; i++ )
			node = node.next;
		return node.value;
	}
	public int getElements() {
		int[] result = new int[getSize()];
		Node node = firstnode;
		for (int i =0; i <result.length ;i++) {
			result[i] = node.value;
			node =node.next;
		}
	}
	/**
	 * Adds the given value to the end of this list.
	 * @post the size of this list equals its old size plus one.
	 * 		|getSize() == old(getSize()) + 1
	 * @post the elements of this list are the old elements with the given element at the end
	 *		|Array.equals(getElements(),0,old(getSize()),old(getElements()),0,old(getSize()))
	 *@post the last element in this list equals the given value.
	 *		|getElements()[old(getSize())] == value
	 *
	 */
	public void add(int value) {
		
			if (firstnode.next == null) {
				firstnode = new Node();
				firstnode.value = value;
			}
			else {
				Node node = firstnode;
				while (node.next != null)
					node = node.next;
				node.next = new Node();
				node.next.value = value;
			}
		
	}
	/**
	 * Removes the element at the given index of this list
	 * @pre the given index is between 0 (inclusive) and this list's size
	 * 		|0<=index && index <= getSize()
	 * @post this list's size equals its old size minus one
	 * 		|getSize() == old(getSize())
	 * @post this list's elements at indices less than the given index remained unchanged.
	 * 		|Arrays.equals(getElements(),0,index,old(getElements()),0,index)
	 * @post this list's elements at indices not less than the given index equals those of the old ones at an index one greater
	 * 		|Arrays.equals(getEleemnts(),index,getSize(),old(getElements()),index+1,old(getSize()))
	 */
	public void remove(int index) {
				if (index == 0) {
					firstnode = firstnode.next;
				}
				else {
					Node node = firstnode;
					for (int i = 0; i < index; i++)
						node = node.next;
						node.next = node.next.next;
				}
				
	}
	/**
	 * Inserts the given value into this list at the given index
	 * 
	 * 
	 * @pre the given index is between 0 and this list's size(inclusive)
	 * 		| 0 <= index && index <= getSize()
	 * 
	 * @post this list's size equals its old size +1
	 * 		| getSize() == old(getSize()) +1
	 * @post the elements at the indices less than the given index have remained unchanged
	 * 		|Arrays.equals(getElements(),0,index,old(getElements()),0,index)
	 * @post the elements at the indices greater than the given index equal the elements at an index one less in the old list
	 * 		|Arrays.equals(getElements(),index+1,getSize(),old(getElements()),index,old(getSize()))
	 * @post the element at the given index equals the given value
	 * 		| getElements()[index] == value
	 * 
	 * 
	 * 
	 */
	
	public void insert(int index, int value) {
		if (firstnode == null) {
			firstnode = new Node();
			firstnode.value = value;
			
		}
		else {
			if (index == 0) {
				Node node = firstnode;
				firstnode = new Node();
				firstnode.value = value;
				firstnode.next = node;
				
			}
			else {
				Node node = firstnode;
				for (int i = 0; i < index-1;i++) {
					Node nextNode = node.next;
				node.next = new Node();
				node.next.value = value;
				node.next.next = nextNode;
			}
		}
	}	
	
}
}
