import java.util.Scanner;

public class Palindrome_Stack {

	public static Node top = null;
	public static int topIndex = -1;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String text;
		
		while(true) {
			
			System.out.print("Enter the word: ");
			testIsPalindrome(input.nextLine());
			System.out.println();
			input.reset();
			input = new Scanner(System.in);
			
			System.out.print("Do you want to continue (yes/no)?");
			text = input.nextLine();
			System.out.println();
			input.reset();
			input = new Scanner(System.in);
			
			switch(text) {
			
			case "yes":
				//reset top
				top = null;
				topIndex = -1;
				break;
			case "no":
				return;
			default:
				System.out.println("You have to write yes or no only!");
				break;
				
			}
			
		}

	}
	//****************************************************************************************
	
	public static void testIsPalindrome(String text) {
		System.out.println( isPalindrome(text.toLowerCase()));
	}
	
	//****************************************************************************************
	
	public static class Node{
		char data;
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
			System.out.printf("%s, ", current.data);
			current = current.next;
		}
		System.out.printf("%s ] \n", current.data);
	}
	
	public static void push(char data) {
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
	
	public static char pop() {
		
		char data = ' ';
		if(isEmpty()) {
			return data;
		}
		
		data = top.data;
		top = top.next;
		
		topIndex--;
		
		return data;
	}
	
	public static boolean isPalindrome(String text) {
		boolean isPalindrome = false;
		
		updateStackWithText(text);
		print();
		
		if(length()%2==0) {
			return isPalindrome;
		}
		
		int size = length();
		
		Node copyTop = getFirstPartOfStack();
		
		//comparison
		for(int i=0; i<size/2; ++i) {
			
			if(pop()!=copyTop.data)
				return isPalindrome;
			
			if(i!=(size/2)-1)
				copyTop = copyTop.next;
		}
		
		isPalindrome = true;
		return isPalindrome;
	}

	
	public static void updateStackWithText(String text) {
		
		for(int i=0; i<text.length(); ++i) {
			if(text.charAt(i)!=' ') {
				push(text.charAt(i));
			}
		}
		
	}
	
	public static Node getFirstPartOfStack() {
		
		int size = length();
		Node newNode = new Node();
		Node copyTop = null;
		
		for(int i=0; i<size/2; ++i) {
			
			newNode.data = pop();
			
			if(copyTop!=null) {
				newNode.next = copyTop;
			}else {
				newNode.next = null;
			}
			
			copyTop = newNode;
			newNode = new Node();
		}
		
		//pop middle character
		pop();
		
		return copyTop;
	}

}
