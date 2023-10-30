import java.util.Scanner;
//import org.junit.Test;

public class Main {

	public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Please enter your name: ");

       
        String userName = scanner.nextLine();

       
        System.out.println("Hello, " + userName + "!");
        
      
        System.out.println("This tool calculates the amount of money you can lend. ");
        System.out.println("Before we start this process we will need to inquire some data to start our calculations. ");
        System.out.println("For example, we need to know how long your fixed interest period is.");
        System.out.println("Let's start figuring out how much money you can lend. What is your PostalCode?  ");
        
        String postalCode = scanner.nextLine();
        
        poempiepaarntie myCalculator = new poempiepaarntie();
        
        myCalculator.CheckPostalCode(postalCode);
        
        System.out.println("Now that the postalcode has passed the test, let's move on to the next part: how long do you want your fixed interest period to be? ");
        
        System.out.println("Enter the desired fixed interest period (1, 5, 10, 20, or 30 years): ");
        double fixedInterestPeriod = scanner.nextInt();
        
        
        poempiepaarntie poempieInstance = new poempiepaarntie();
        
        double interest = poempieInstance.calcInterest(fixedInterestPeriod);
        System.out.println(" ");
        
        System.out.println("Now that we know your desired fixed interest period, we can move on to the next part.");
        poempiepaarntie myPoemPie = new poempiepaarntie();
        
        System.out.println("What is your total annual income? IF you have a partner, include their income as well.");
        String combinedIncome = scanner.next();  

        myPoemPie.setCombinedIncome(combinedIncome);
        myPoemPie.displayCombinedIncome();
//        myPoemPie.displaymaximumLoan();
        
        System.out.print("Do you have student debt? (true or false): ");
        boolean hasStudentDebt = scanner.nextBoolean();
        myPoemPie.setHasStudentDebt(hasStudentDebt);

        myPoemPie.displayMaximumLoan();
        
    

        double monthlyInterestRate = myPoemPie.calculateMonthlyInterest(interest);  

        System.out.println("Monthly Interest Rate: " + (monthlyInterestRate * 100) + "%");
        
        double monthlyPayment = myPoemPie.calculateMonthlyPayment(myPoemPie.calculateMaximumLoan(), monthlyInterestRate, (int) fixedInterestPeriod * 12);

        System.out.println("Monthly Payment (Principal + Interest): " + monthlyPayment);



        
        
        
        

        // scanner close
        scanner.close();

	}

}
