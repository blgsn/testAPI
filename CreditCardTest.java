import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;
  
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
  
public class CreditCardTest {
    @Test
    public void testForValidCreditCardNumbers() {
        // Example for Akbank card
        assertEquals(true, CreditCardValidation.checkForValidity(378282246310005L));
        assertNotEquals(true, CreditCardValidation.checkForValidity(37828224631015L));
            
        // Example for garanti card
        assertEquals(true, CreditCardValidation.checkForValidity(378734493671000L));
            
        // Example for yapı kredi card
        assertTrue(CreditCardValidation.checkForValidity(6011111111111117L));
        assertFalse(CreditCardValidation.checkForValidity(6011111111111128L),"Invalid Creditcard");
        String validationName = "creditCardValidation";
          
       // All assertions are run as part of a grouped assertion, and any failures are reported collectively. 
        //a Mastercard and Visa example
        assertAll("creditCardValidation", () -> assertTrue(CreditCardValidation.checkForValidity(5105105105105100L)),
                () -> assertTrue(CreditCardValidation.checkForValidity(4111111111111111L)));
       
        // assertAll("creditCardValidationYieldingFalse", () -> assertTrue(CreditCardValidation.checkForValidity(378282246310005L)),
        //                 () -> assertTrue(CreditCardValidation.checkForValidity(378282246310005L)));
          
        /* The assumingThat() method executes the rest of the statements 
           if the assumption is valid. If the assumption is invalid, 
           this method does nothing. 
           Advantage : To log the information
        */
        
       // Example for Visa card
       assumingThat("creditCardValidation".equals(validationName), () -> {
            System.out.println("Checking for creditcard validation!!!");
            assertEquals(true, CreditCardValidation.checkForValidity(4012888888881881L));
        });
        
        // with assumeFalse
       //The next set of test methods are only executed 
       //if the boolean condition in assumeFalse becomes false; otherwise, the test is skipped.
           
        assumeFalse("loginValidation".equals(validationName));
        
        // Example for Paymentech (Processor specific card)
        assertTrue(CreditCardValidation.checkForValidity(6331101999990016L));
        
        // Example for akbank, maximum and Master card (May be 3 people at a home are having 3 different cards, 
        // we can check in this way, instead of checking single single
        assertArrayEquals(new long[]{378282246310005L,30569309025904L,5555555555554444L},new long[]{378282246310005L,30569309025904L,5555555555554444L});
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Integer.parseInt("378282246310005L");
        });
        
    }  
      
}