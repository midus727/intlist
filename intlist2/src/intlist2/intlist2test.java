package intlist2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class intlisttest {

	@Test
	void test() {
		intlist mylist = new intlist();
		mylist.add(7);
		mylist.add(42);
		assert mylist.getSize() == 2;
		assert mylist.get(0) == 7;
		assert mylist.get(1) == 42;
		mylist.add(33);
		mylist.add(77);
		mylist.remove(0);
		assert mylist.getSize() == 3;
		assert mylist.get(0) == 42;
		assert mylist.get(1) == 33;
		assert mylist.get(2) == 77;
		mylist.insert(1,99);
		mylist.insert(0,110);
		
		assert mylist.get(0) == 110;
		assert mylist.get(1) == 42;
		assert mylist.get(2) == 99;
		assert mylist.get(3) == 77;
	}

}