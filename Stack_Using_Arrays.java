import java.util.Scanner;

public class Stack_Using_Arrays {

	public static int size = 50;
	public static int[] stack = new int[size];
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
		
		public static boolean isEmpty() {
			return topIndex==-1;
		}
		
		public static int length() {	
			return topIndex+1;
		}
		
		public static void print() {
			if(isEmpty()) {
				System.out.println("Stack is empty\n");
				return;
			}
			
			System.out.print("[ ");

			for(int i=0; i<=length()-2; ++i) {
				System.out.printf("%d, ", stack[i]);
			}

			System.out.printf("%d ]\n", stack[length()-1]);
		}
		
		public static void push(int data) {
			
			topIndex++;
			if(topIndex==size) {
				System.out.println("Stack is full\n");
				return;
			}
			stack[topIndex] = data;
		}
		
		public static int pop() {
			
			int data = -1;
			if(isEmpty()) {
				return data;
			}
			
			data = stack[topIndex];
			topIndex--;
			
			return data;
		}
		
		public static int peek() {
			
			if(isEmpty()) {
				return -1;
			}
			
			return stack[topIndex];
		}
		
		public static int search(int data) {
			int index = -1;
			
			if(isEmpty()) {
				return index;
			}
			
			int count = 0;
			int[] tempStack = new int[length()];
			
			for(int i=length()-1; i>=0; --i) {
				
				if(stack[i]==data) {
					index = length()-i-1;
				}
				
				tempStack[count] = pop();
				count++;
				
			}
			
			for(int i=count-1; i>=0; --i) {
				push(tempStack[i]);
			}
			
			return index;
		}


}
