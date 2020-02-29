import java.util.Scanner;

public class Stack_Using_Linked_Lists {

	public static Node top = null;
	public static int topIndex = -1;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("1- Push");
			System.out.println("2- Pop");
			System.out.println("3- Peek");
			System.out.println("4- Length of Stack");
			System.out.println("5- Print Stack");
			System.out.println("6- Search");
			System.out.println("7- Exit");
			
			String choice = input.next();
			
			switch(choice){
			
			//1- Push
			case "1":
				testPush();
				break;
			
			//	2- Pop
			case "2":
				System.out.println(pop());
				break;
				
			//3- Peek at top element	
			case "3":
				System.out.println(peek());
				break;
			
			//4- Length	
			case "4":
				System.out.println(length());
				break;
			
			//5- Print stack	
			case "5":
				print();
				break;
				
			//6- Search	
			case "6":
				testSearch();
				break;
				
			//7- Exit
			case "7":
				return;
				
			default:
				System.out.println("Invalid input \nInsert a number from 1 to 7 only!");
			}
		}

	}
	
	//****************************************************************************************
	
	public static void testPush() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		try {
			push(input.nextInt());
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
	
	//****************************************************************************************

	public static class Node{
		int data;
		Node next;
	}
	
	public static boolean isEmpty() {
		return top==null;
	}
	
	public static int length() {		
		return topIndex+1;
	}
	
	public static void print() {
		if(isEmpty()) {
			System.out.println("Stack is empty\n");
			return;
		}
		
		Node current = top;
		
		System.out.print("[ ");
		for(int i=0; i<length()-1; ++i) {
			System.out.printf("%d, ", current.data);
			current = current.next;
		}
		System.out.printf("%d ] \n", current.data);
	}
	
	public static void push(int data) {
		Node newNode = new Node();
		newNode.data = data;
		topIndex++;
		
		if(isEmpty()) {
			newNode.next = null;
			top = newNode;
			return;
		}
		
		newNode.next = top;
		top = newNode;
	}
	
	public static int pop() {
		
		int data = -1;
		if(isEmpty()) {
			return data;
		}
		
		data = top.data;
		top = top.next;
		
		topIndex--;
		
		return data;
	}
	
	public static int peek() {
		
		if(isEmpty()) {
			return -1;
		}
		
		return top.data;
	}
	
	public static int search(int data) {
		int index = -1;
		
		if(isEmpty()) {
			return index;
		}
		
		Node copyTop = null;
		Node newNode = new Node();
		int count = length();
		
		for(int i=0; i<count; ++i) {
			
			if(top.data==data) {
				index = i;
			}
			
			newNode.data = pop();
			
			if(copyTop!=null) {
				newNode.next = copyTop;
			}else {
				newNode.next = null;
			}
			
			copyTop = newNode;
			
			//without this step any change in the newNode will affect
			//the copyTop because they would've been both in the
			//same place in memory
			newNode = new Node();
			
		}
		
		for(int i=0; i<count; ++i) {
			push(copyTop.data);
			copyTop = copyTop.next;
		}
		
		return index;
	}

}
