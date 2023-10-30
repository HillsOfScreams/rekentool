import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class poempiepaarntieTest {
	//intergration test 1
    @Test
    public void testCalculateMaximumLoanWithoutStudentDebt() {
        // Arrange
        poempiepaarntie calculator = new poempiepaarntie();
        calculator.setCombinedIncome("50000"); // Set a sample income
        calculator.setHasStudentDebt(false); // No student debt

        // Act
        double maxLoan = calculator.calculateMaximumLoan();

        // Assert
        assertEquals(50000 * 4.25, maxLoan, 0.001); // Ensure maxLoan is calculated correctly
    }
    
    
    
    
//intergration test 2
    @Test
    public void testCalculateMaximumLoanWithStudentDebt() {
        // Arrange
        poempiepaarntie calculator = new poempiepaarntie();
        calculator.setCombinedIncome("60000"); // Set a sample income
        calculator.setHasStudentDebt(true); // Has student debt

        // Act
        double maxLoan = calculator.calculateMaximumLoan();

        // Assert
        assertEquals(60000 * 4.25 * 0.75, maxLoan, 0.001); // Ensure maxLoan is reduced with student debt
    }
    
    
    //intergration test 3: 
    @Test
    public void testCalculateMaximumLoanIntegration() {
        // Arrange
    	poempiepaarntie calculator = new poempiepaarntie();
        calculator.setCombinedIncome("60000"); // Set a sample income
        calculator.setHasStudentDebt(true); // Has student debt

        // Act
        double maxLoan = calculator.calculateMaximumLoan();

        // Assert
        assertEquals(60000 * 4.25 * 0.75, maxLoan, 0.001); // Ensure maxLoan is reduced with student debt
    }
    
    
    @Test
    public void testCheckPostalCodeDenied() {
        // Arrange
    	poempiepaarntie calculator = new poempiepaarntie();

        // Redirect standard output to capture it
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Act
        calculator.CheckPostalCode("9679");
        String output = outContent.toString();

        // Restore the original standard output
        System.setOut(originalOut);

        // Assert
        assertEquals("Postal Code 9679 Has not passed the test. You are not able to lend any money. \n", output);
    }


    @Test
    public void testConvertPostalCodeToInt() {
        // Arrange
    	poempiepaarntie calculator = new poempiepaarntie();

        // Act
        int result1 = calculator.convertPostalCodeToInt("ABCD1234"); // Postal code with non-numeric characters
        int result2 = calculator.convertPostalCodeToInt("12345"); // Postal code with only digits

        // Assert
        assertEquals(1234, result1); // Expected result is the numeric part of the postal code
        assertEquals(12345, result2); // Expected result is the entire numeric postal code
    }
    
    @Test
    public void testCalculateInterest() {
        // Arrange and Act
        double interest1 = poempiepaarntie.calculateInterest(1);
        double interest5 = poempiepaarntie.calculateInterest(5);
        double interest10 = poempiepaarntie.calculateInterest(10);
        double interest20 = poempiepaarntie.calculateInterest(20);
        double interest30 = poempiepaarntie.calculateInterest(30);

        // Assert
        assertEquals(0.02, interest1, 0.001); // 2% interest for 1 year
        assertEquals(0.03, interest5, 0.001); // 3% interest for 5 years
        assertEquals(0.035, interest10, 0.001); // 3.5% interest for 10 years
        assertEquals(0.045, interest20, 0.001); // 4.5% interest for 20 years
        assertEquals(0.05, interest30, 0.001); // 5% interest for 30 years

        // Add more test cases for valid input values
    }
    
    
    
    
        @Test
        public void testCalculateMonthlyInterest() {
            // Arrange
            double yearlyInterestRate = 5.0; // 5% yearly interest rate

            // Act
            poempiepaarntie calculator = new poempiepaarntie();
            double monthlyInterestRate = calculator.calculateMonthlyInterest(yearlyInterestRate);

            // Assert
            assertEquals(0.00416667, monthlyInterestRate, 0.00001); // Ensure correct monthly interest rate (approximately 0.416667%)
            //5% yearly interest rate / 12 months = 0.41666667% monthly interest rate
        }
        
        @Test
        public void testCalculateMonthlyPayment() {
            // Arrange
            poempiepaarntie calculator = new poempiepaarntie();
            double loanAmount = 100000; // $100,000 loan
            double monthlyInterestRate = 0.00416667; // Monthly interest rate for a 5% yearly interest rate
            int loanTermInMonths = 360; // 30 years loan term

            // Act
            double monthlyPayment = calculator.calculateMonthlyPayment(loanAmount, monthlyInterestRate, loanTermInMonths);

            // Assert
            // The expected result can be calculated using a financial calculator or formula.
            // For a $100,000 loan at 5% yearly interest for 30 years, the monthly payment is approximately $536.82.
            assertEquals(536.82, monthlyPayment, 0.01); // Adjust delta as needed for precision
        }
        
        
 }
    
    
    
    
    
    
    
    
    
