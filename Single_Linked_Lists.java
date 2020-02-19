import java.util.Scanner;

public class Single_Linked_Lists {
	
	public static Node head = null;

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("1- Insert At Index");
			System.out.println("2- Insert Last");
			System.out.println("3- Delete At Index");
			System.out.println("4- Delete Last");
			System.out.println("5- Clear List");
			System.out.println("6- Length of List");
			System.out.println("7- Print List");
			System.out.println("8- Search");
			System.out.println("9- Concatenate Another List");
			System.out.println("10- Convert List to Array");
			System.out.println("11- Exit");
			
			String choice = input.next();
			
			switch(choice){
			
			//1- Insert At Index
			case "1":
				testInsertMiddle();
				break;
			
			//	2- Insert Last
			case "2":
				testInsertLast();
				break;
				
			//3- Delete At Index	
			case "3":
				testDeleteMiddle();
				break;
			
			//4- Delete Last	
			case "4":
				System.out.println(deleteLast());
				break;
			
			//5- Clear List	
			case "5":
				clear();
				break;
				
			//6- Length	
			case "6":
				System.out.println(length());
				break;
				
			//7- Print List	
			case "7":
				print();
				break;
			
			//8- Search in list
			case "8":
				testSearch();
				break;
			
			//9- Concatenate another list	
			case "9":
				testConcatList();
				break;
				
			//10- convert to array	
			case "10":
				printArray();
				break;
				
			//11- Exit	
			case "11":
				return;
				
			default:
				System.out.println("Invalid input \nInsert a number from 1 to 11 only!");
			}
		}

	}

//****************************************************************************************	
	
	public static void testInsertMiddle() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			insertMiddle(input.nextInt(), input.nextInt());
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}
	
	public static void testInsertLast() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			insertLast(input.nextInt());
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}
		
	public static void testDeleteMiddle() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			System.out.println(deleteMiddle(input.nextInt()));
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}
	
	public static void testSearch() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			System.out.println(search(input.nextInt()));
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}
	
	public static void testConcatList() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			concatList((input.nextLine()));
		}catch(Exception e) {
			System.out.println("Mismatching data type! \nInsert integer numbers only!\n");
		}
	}
	
//****************************************************************************************
	
	public static class Node{
		int data;
		Node next;
	}
	
	public static boolean isEmpty() {
		return head==null;
	}
	
	public static int length() {
		
		if(isEmpty()) {
			return 0;
		}
		
		int count = 0;
		Node current = head;
		
		while(current!=null) {
			count++;
			current = current.next;
		}
		
		return count;
	}
	
	public static void print() {
		
		if(isEmpty()) {
			System.out.println("List is empty\n");
			return;
		}
		
		Node current = head;
		
		for(int i=0; i<length()-1; ++i) {
			System.out.printf("%d --> ", current.data);
			current = current.next;
		}
		System.out.printf("%d \n", current.data);
	}
	
	public static void insertMiddle(int data, int index) {
		
		if(index>length() && index!=0) {
			System.out.printf("Invalid index: %d \nLinked list has only %d elements\n\n", index, length());
			return;
		}
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			newNode.next = null;
			head = newNode;
			return;
		}
		
		Node current = head;
		Node previous = null;
		
		for(int i=0; i<index; ++i) {
			previous = current;
			current = current.next;
		}
		
		previous.next = newNode;
		newNode.next = current;
		
	}
	
	public static void insertLast(int data) {
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.next  = null;
		
		if(isEmpty()) {
			newNode.next = null;
			head = newNode;
			return;
		}
		
		Node current = head;
		
		for(int i=0; i<length()-1; ++i) {
			current = current.next;
		}
		
		current.next = newNode;
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
			data = head.data;
			head = head.next;
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
		
		return data;
	}

	public static int deleteLast() {
		int data = -1;
		
		if(isEmpty()) {
			System.out.println("List is empty\n");
			return data;
		}
		
		if(length()==1) {
			data = head.data;
			head = head.next;
			return data;
		}
		
		Node current = head;
		Node previous = null;
		
		for(int i=0; i<length()-1; ++i) {
			previous = current;
			current = current.next;
		}
		
		data = current.data;
		previous.next = null;
		
		return data;
	}
	
	public static void clear() {
		head=null;
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
	
//****************************************************************************************	
	
	public static void concatList(String input) {
		
		if(isEmpty()) {
			System.out.println("List is empty\n");
			return;
		}
		
		int beginIndex = 0;
		String newString = "";
		int index = 0;
		
		while(true) {
			index = input.indexOf(' ', beginIndex);
			if(index!=-1) {
				newString = input.substring(beginIndex, index);
			}else {
				newString = input.substring(beginIndex, input.length());
			}
			
			int data = Integer.parseInt(newString);
			
			insertLast(data);
			
			beginIndex = index+1;
			if(index==-1)
				return;
		}
		
		
	}
	
	public static int[] convertToArray() {
		
		if(isEmpty()) {
			return null;
		}
		
		int []arr =  new int[length()];
		Node current = head;
		
		for(int i=0; i<length(); ++i) {
			arr[i] = current.data;
			current = current.next;
		}
		return arr;
	}
	
	public static void printArray() {
		int[] arr = convertToArray();
		
		if(arr==null) {
			System.out.println("List is empty\n");
			return;
		}
		
		System.out.print("[ ");
		for(int x: arr) {
			System.out.printf("%d ", x);
		}
		System.out.println("]");
	}
	
	


}
