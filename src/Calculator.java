import java.util.Scanner;

public class Calculator {
	
	Scanner user_input;
	Structure s = new Structure(0, 0, ' ');
	
	public Calculator(){
		
		user_input = new Scanner(System.in);
		
		System.out.println("Caluclator mode(c) or Display Mode(d)?");
		String choice = user_input.nextLine();
		Boolean display = choice.charAt(0) == 'd' ? true : false; 
		
		
		System.out.println("Please input a string with entities seperated by spaces.\nExamples: \"5 + 10\" or \"6 * 5\" or \"7 / 3\" or \"20 - 5\".");
		
		String ask = user_input.nextLine();
		
		int number1 = 0, number2 = 0;
		char operator = 0;
		
		for(int i = 0; i < ask.length(); i++){
			if(ask.charAt(i) == ' '){
				number1 = Integer.parseInt(ask.substring(0, i));
				operator = ask.charAt(i+1);
				number2 = Integer.parseInt(ask.substring(i+3, ask.length()));
				i = ask.length();
			}
		}
		
		s.setNum1(number1);
		s.setNum2(number2);
		s.setOp(operator);
		
		if(display){
			switch(s.getOp()){
			case '+': System.out.println("Answer = " + additionShow(s.getNum1(), s.getNum2())); break;
			}
		}
		else{
			switch(s.getOp()){
			case '+': System.out.println("Answer = " + addition(s.getNum1(), s.getNum2())); break;
			}
		}
		
		
	}
	
	public int additionShow(int n1, int n2){
		int counter = 1;
		while(n2 != 0){
			System.out.println("Counter: " +counter);
			
			int carry = n1 & n2;
			System.out.println("Carry = " + Integer.toString(carry, 2));
			
			n1 = n1 ^ n2;
			System.out.println("n1 = " + Integer.toString(n1, 2));
			
			n2 = carry << 1;
			System.out.println("n2 = " + Integer.toString(n2, 2) + "\n");
			
			counter++;

		}

		return n1;
	}
	
	public int addition(int n1, int n2){
		while(n2 != 0){
			int carry = n1 & n2;
			
			n1 = n1 ^ n2;
			
			n2 = carry << 1;
		}
		
		return n1;
	}
	
	
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
	}
	
	private class Structure{
		
		int num1, num2;
		public int getNum1() {
			return num1;
		}

		public void setNum1(int num1) {
			this.num1 = num1;
		}

		public void setNum2(int num2) {
			this.num2 = num2;
		}

		public void setOp(char op) {
			this.op = op;
		}

		public int getNum2() {
			return num2;
		}

		public char getOp() {
			return op;
		}

		char op;
		
		public Structure(int a, int b, char c){
			num1 = a;
			num2 = b;
			op = c;
		}
		
	}
}
	

