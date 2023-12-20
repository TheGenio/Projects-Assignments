package LAB03;

public class DLLTest {
	public static void main(String[] args) {
		DLL<String> test = new DLL<String>();
		for (int i = 1; i <5;i++) {
			test.addToTail("a"+i);
		}

		DLL<String> test2 = new DLL<String>();
		for (int i = 5; i <9;i++) {
			test2.addToTail("a"+i);
		}

		test.printAll();
		test2.printAll();
		test.insertAlternate(test2);
		test.printAll();




		}
	}