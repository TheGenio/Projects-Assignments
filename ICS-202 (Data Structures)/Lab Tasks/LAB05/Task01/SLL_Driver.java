package LAB05.Task01;

public class SLL_Driver {
	public static void main(String[] args) {
		SLL<String> myList = new SLL<String>();
      String[] cityNames = {"3","4","7","8", "1","2","5"};
		for(int i = 0; i < cityNames.length; i++)
			myList.addToTail(cityNames[i]);

		System.out.println(myList.toString());
		myList.delete();
		System.out.println(myList.toString());
//		System.out.println("The list is: " + myList.toString());
//       System.out.println("It is " + myList.contains("Dammam") + " that the list contains Dammam.");
//       System.out.println("It is " + myList.contains("Jeddah") + " that the list contains Jeddah.");
	}
}