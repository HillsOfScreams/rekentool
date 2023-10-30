import java.util.Scanner;

public class poempiepaarntie {
	private int combinedIncome;
    private boolean hasStudentDebt;



    public void CheckPostalCode(String postalCode) {
        int postalCodeAsInt = convertPostalCodeToInt(postalCode);

        if (postalCodeAsInt == 9679 || postalCodeAsInt == 9681 || postalCodeAsInt == 9682) {
            System.out.println("Postal Code " + postalCodeAsInt + " Has not passed the test. You are not able to lend any money. ");
            System.exit(1);
        } else {
            System.out.println("Postal Code " + postalCodeAsInt + " is good to go!");
        }
    }

    public int convertPostalCodeToInt(String postalCode) {
        String numericPart = postalCode.replaceAll("[^\\d]", "");
        return Integer.parseInt(numericPart);
    }

    public static double calculateInterest(double fixedInterestPeriod) {
        double interest = 0.0; // Default interest rate

        switch ((int) fixedInterestPeriod) {
            case 1:
                interest = 0.02; // 2% rente voor 1 jaar
                break;
            case 5:
                interest = 0.03; // 3% rente voor 5 jaar
                break;
            case 10:
                interest = 0.035; // 3,5% rente voor 10 jaar
                break;
            case 20:
                interest = 0.045; // 4,5% rente voor 20 jaar
                break;
            case 30:
                interest = 0.05; // 5% rente voor 30 jaar
                break;
            default:
                System.out.println("Not a valid interest period. Please enter a valid value (1, 5, 10, 20, 30 years): ");
                // You can handle user input here. For example:
                Scanner scanner = new Scanner(System.in);
                int newFixedInterestPeriod = scanner.nextInt();
                // Recursively call the method with the new input
                interest = calculateInterest(newFixedInterestPeriod);
        }

        return interest;
    }


    public double calcInterest(double fixedInterestPeriod) {
        try {
            double interest = calculateInterest(fixedInterestPeriod);
            System.out.println("interest for " + (int) fixedInterestPeriod + " year: " + (interest * 100) + "%");
            return interest; // Return the calculated interest rate
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return 0.0; // Or return a default value in case of an error
        }
    }
    public void setCombinedIncome(String input) {
        try {
            int income = Integer.parseInt(input);
            if (income >= 0) {
                combinedIncome = income;
            } else {
                System.out.println("Invalid input. Income cannot be negative.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
    
    public void displayCombinedIncome() {
        System.out.println("Combined Annual Income: " + combinedIncome);
    }
//    public double maximumLoan;
//    public double displaymaximumLoan()
//    {
//    	double maximumLoan = combinedIncome * 4.25;
//    	
//    	System.out.println("The maximum amount you are allowed to lend is: " + maximumLoan);
//    	return maximumLoan;
//    }
    public double calculateMaximumLoan() {
        double maxLoan = combinedIncome * 4.25;

        if (hasStudentDebt) {
            maxLoan *= 0.75; 
        }

        return maxLoan;
    }
//    
    
    public void setHasStudentDebt(String input) {
        try {
            boolean hasDebt = Boolean.parseBoolean(input);
            hasStudentDebt = hasDebt;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please enter 'true' or 'false'.");
        }
    }
    
    public void setHasStudentDebt(boolean hasDebt) {
        hasStudentDebt = hasDebt;
    }

    public boolean hasStudentDebt() {
        return hasStudentDebt;
    }
    
    public double displayMaximumLoan() {
        if (hasStudentDebt()) {
            System.out.println("The client has student debt. Maximum loan reduced by 25%.");
        } else {
            System.out.println("The client does not have student debt.");
        }
        double maxLoan = calculateMaximumLoan();
        System.out.println("The maximum amount you are allowed to lend is: " + maxLoan);
        return maxLoan;
    }
    public double calculateMonthlyInterest(double yearlyInterestRate) {
        double monthlyInterestRate = (yearlyInterestRate / 100) / 12;
        return monthlyInterestRate;
    }

        public double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int loanTermInMonths) {
            double numerator = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermInMonths);
            double denominator = Math.pow(1 + monthlyInterestRate, loanTermInMonths) - 1;

            double monthlyPayment = loanAmount * (numerator / denominator);
            return monthlyPayment;
        }
        
    }
