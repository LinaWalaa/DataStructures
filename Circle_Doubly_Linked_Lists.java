import java.util.Scanner;

public class Circle_Doubly_Linked_Lists {

	public static Node head = null;
	public static Node tail = null;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while(true) {
			System.out.println("1- Insert At Index");
			System.out.println("2- Insert First");
			System.out.println("3- Insert Last");
			System.out.println("4- Delete At Index");
			System.out.println("5- Delete First");
			System.out.println("6- Delete Last");
			System.out.println("7- Length of List");
			System.out.println("8- Print List");
			System.out.println("9- Search");
			System.out.println("10- Exit");

			String choice = input.next();

			switch(choice){

			//1- Insert At Index
			case "1":
				testInsertMiddle();
				break;

				//2- Insert First	
			case "2":
				testInsertFirst();
				break;

				//3- Insert Last
			case "3":
				testInsertLast();
				break;

				//4- Delete At Index	
			case "4":
				testDeleteMiddle();
				break;

				//5- Delete First	
			case "5":
				System.out.println(deleteFirst());
				break;

				//6- Delete Last	
			case "6":
				System.out.println(deleteLast());
				break;

				//7- Length	
			case "7":
				System.out.println(length());
				break;

				//8- Print List	
			case "8":
				print();
				break;

				//9- Search in list
			case "9":
				testSearch();
				break;

				//10- Exit	
			case "10":
				return;

			default:
				System.out.println("Invalid input \nInsert a number from 1 to 11 only!");
			}
		}


	}

	//****************************************************************************************

	public static class Node{
		int data;
		Node next;
		Node previous;
	}

	//****************************************************************************************

	private static void testInsertMiddle() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			insertMiddle(input.nextInt(), input.nextInt());
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}

	private static void testInsertFirst() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			insertFirst(input.nextInt());
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}

	}

	private static void testInsertLast() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			insertLast(input.nextInt());
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}

	}

	private static void testDeleteMiddle() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			System.out.println(deleteMiddle(input.nextInt()));
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}

	private static void testSearch() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			System.out.println(search(input.nextInt()));
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}

	//****************************************************************************************

	public static boolean isEmpty() {
		return head==null;
	}

	public static void print() {

		if(isEmpty()) {
			System.out.println("List is Empty!");
			return;
		}
		
		if(length()==1) {
			System.out.printf("%d\n", head.data);
			return;
		}

		Node current = head;
		for(int i=0; i<length()-1; ++i) {
			if(i!=0) {
				System.out.printf("%d <--> ", current.data);
			}else {
				System.out.printf("-> %d <--> ", current.data);
			}
			
			current = current.next;
		}
		System.out.printf("%d <-\n", current.data);

	}

	public static int length() {
		int count = 0;

		if(isEmpty()) {
			return count;
		}

		Node current = head;
		//in case 1 element
		count++;

		while(current!=tail) {
			count++;
			current = current.next;
		}

		return count;
	}

	public static void insertMiddle(int data, int index) {
		if(index>length()) {
			System.out.printf("Invalid index: %d \nLinked list has only %d elements\n\n", index, length());
			return;
		}

		Node newNode = new Node();
		newNode.data = data;

		if(isEmpty()) {
			newNode.next = null;
			newNode.previous = null;
			head = newNode;
			tail = newNode;
			return;
		}

		Node current = head;
		Node previous = null;

		for(int i=0; i<index; ++i) {
			previous = current;
			current = current.next;
		}

		if(index!=0 && index!=length()) {
			previous.next = newNode;
			newNode.next = current;
			newNode.previous = previous;
			current.previous = newNode;			
		}else if(index==0) {
			newNode.next = current;
			newNode.previous = tail;
			current.previous = newNode;	
		}else if (index==length()) {
			previous.next = newNode;
			newNode.next = head;
			newNode.previous = previous;
			tail = newNode;
		}

	}

	public static void insertFirst(int data) {

		Node newNode = new Node();
		newNode.data = data;

		if(isEmpty()) {
			head = newNode;
			head.next = null;
			head.previous = null;
			tail = head;
			return;
		}

		newNode.next = head;
		newNode.previous = tail;

		head.previous = newNode;
		head = newNode;

	}

	public static void insertLast(int data) {

		Node newNode = new Node();
		newNode.data = data;

		if(isEmpty()) {
			head = newNode;
			head.next = null;
			head.previous = null;
			tail = head;
			return;
		}

		newNode.next = head;
		newNode.previous = tail;

		tail.next = newNode;
		tail = newNode;
	}

	public static int deleteMiddle(int index) {
		int data = -1;

		if(isEmpty()) {
			System.out.println("List is empty\n");
			return data;
		}

		if(index>=length()) {
			System.out.printf("Invalid index: %d \nLinked list has only %d elements\n\n", index, length());
			return data;
		}

		if(index==0) {
			return deleteFirst();
		}else if(index==length()-1) {
			data = tail.data;
			tail = tail.previous;
			tail.next = head;
			return data;
		}

		Node current = head;
		Node previous = null;

		for(int i=0; i<index; ++i) {
			previous = current;
			current = current.next;
		}

		data = current.data;
		previous.next = current.next;
		current.next.previous = previous;

		return data;
	}

	public static int deleteFirst() {
		int element = -1;

		if(isEmpty()) {
			return element;
		}

		element = head.data;

		if(length()==1) {
			head = null;
			tail = null;
			return element;
		}

		head.next.previous = tail;
		head = head.next;

		return element;
	}

	public static int deleteLast() {
		int element = -1;

		if(isEmpty()) {
			return element;
		}

		element = tail.data;

		if(length()==1) {
			head = null;
			tail = null;
			return element;
		}

		tail.previous.next = head;
		tail = tail.previous;

		return element;
	}

	public static int search(int data) {
		int index = -1;

		if(isEmpty()) {
			return index;
		}

		Node current = head;

		for(int i=0; i<length(); ++i) {
			if(current.data==data) {
				return i;
			}
			current = current.next;
		}

		return index;
	}
}
