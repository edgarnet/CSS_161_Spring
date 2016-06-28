import java.util.Scanner;

public class PerezEdgar_HW_Branching_WarmUp {

    //Driver for if statement warm-up

    public static void main(String[] args){
    	Scanner keyboard = new Scanner(System.in);
    	
    	//TODO 1
    	
    	System.out.println("Enter the number for TODO1:");
    	int number = keyboard.nextInt();
    	if(number < 0){
    		System.out.println("The number is negative.");
    	}
    	
    	//TODO 2
    	
    	System.out.println("Enter a second number:");
    	int secondNumber = keyboard.nextInt();
    	if(secondNumber == 0){
    		System.out.println("The number is zero.");
    	}
    	
    	//TODO 3
    	
    	System.out.println("Enter a third number, a double, for the class average:");
    	double average = keyboard.nextDouble();
    	if(average >= 65){
    		System.out.println("A passing grade.");
    	}
    	else{
    		System.out.println("Not a passing grade.");
    	}
    	
    	//TODO 4 & TODO 5
    	
    	System.out.println("Is the answer the user reported true?\nEnter a boolean value:");
    	boolean answer = keyboard.nextBoolean();
    	if(answer == true){
    		System.out.println("The value was true.");
    	}
    	else{
    		System.out.println("The value was false.");
    	}
    	
    	//TODO 6
    	
    	System.out.println("Enter another number:");
    	int numberFourth = keyboard.nextInt();
    	if(numberFourth % 2 == 0){
    		System.out.println("The number is even.");
    	}
    	else{
    		System.out.println("The number is odd.");
    	}
    	
    	//TODO 7 & TODO 8
    	
    	System.out.println("Enter your grade as a float:");
    	float grade = keyboard.nextFloat();
    	if(grade > 97){
    		System.out.println("Your grade is above a 97.");
    	}
    	else if(grade >= 79 && grade < 83){
    		System.out.println("Your grade is between 79 and 83.");
    	}
    	
    	//TODO 9
    	
    	System.out.println("Enter the temperature as a double:");
    	double temp = keyboard.nextDouble();
    	if(temp > 78){
    		System.out.println("The temperature is higher than 78 degrees.");
    	}
    	else{
    		System.out.println("The temperature is less than or equal to 78 degrees.");
    	}
    	
    	//TODO 10
    	
    	if(temp % 2 > 0 && temp > 0){
    		System.out.println("Yes; positive and odd.");
    	}
    	else{
    		System.out.println("No; not positive and odd.");
    	}
    	
    	//TODO 11
    	System.out.println("Enter a letter grade:");
    	char letterGrade = keyboard.next().charAt(0);
    	if(letterGrade == 'A'){
    		System.out.println("You entered 'A' as your grade.");
    	}
    	else if(letterGrade == 'B'){
    		System.out.println("You entered 'B' as your grade.");
    	}
    	else if(letterGrade == 'C'){
    		System.out.println("You entered 'C' as your grade.");
    	}
    	else if(letterGrade == 'D'){
    		System.out.println("You entered 'D' as your grade.");
    	}
    	else if(letterGrade == 'F'){
    		System.out.println("You entered 'F' as your grade.");
    	}
    	else{
    		System.out.println("Please enter a valid grade next time.");
    	}
    	
    	//TODO 13
    	
    	System.out.println("Enter two integers:");
    	int integerA = keyboard.nextInt();
    	int integerB = keyboard.nextInt();
    	int largest = max(integerA,integerB);
    	if(integerA == largest){
    		System.out.println("Largest is "+integerA+"\nSmallest is "+integerB);
    	}
    	else if(integerB == largest){
    		System.out.println("Largest is "+integerB+"\nSmallest is "+integerA);
    	}

    }   

    public static int max(int a, int b) {

         //TODO 12
    	int biggest = 0;
    	if(a > b){
    		biggest = a;
    	}
    	else{
    		biggest = b;
    	}
    	return biggest;

    }
}
