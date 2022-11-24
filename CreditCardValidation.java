
public class CreditCardValidation {   
   
    /* If the card number is legitimate, the Luhn algorithm should return true.
Prerequisites
There must be between 13 and 16 digits in a credit card number.

It has to begin with:

for Visa cards, four

for Master cards, five

37 for cards from American Express

6 for cards from Discover
    */
    public static boolean checkForValidity(long number)
    {
       return (getNumberOfDigits(number) >= 13 &&
               getNumberOfDigits(number) <= 16) &&
               (checkForPrefixMatching(number, 4) ||
                checkForPrefixMatching(number, 5) ||
                checkForPrefixMatching(number, 37) ||
                checkForPrefixMatching(number, 6)) &&
              ((sumOfDoubleEvenPlaces(number) +
                getSumOfOddPlaces(number)) % 10 == 0);
    }
   
    // Get the result from Step 2
    public static int sumOfDoubleEvenPlaces(long inputNumber)
    {
        int sum = 0;
        String number = inputNumber + "";
        for (int i = getNumberOfDigits(inputNumber) - 2; i >= 0; i -= 2)
        	sum += getTheDigits(Integer.parseInt(number.charAt(i) + "") * 2);
           
        return sum;
    }
   
    //Return the input number exactly as it is if it is a single digit between 0 and 9.
    //Return the sum of the two digits 6 for Discover 
    public static int getTheDigits(int inputNumber)
    {
        if (inputNumber < 9)
            return inputNumber;
        return inputNumber / 10 + inputNumber % 10;
    }
   
    // add the digits 
      // in number and return their sum
    public static int getSumOfOddPlaces(long inputnumber)
    {
        int summation = 0;
        String number = inputnumber + "";
        // As odd places, we need to decrement by 2
        for (int i = getNumberOfDigits(inputnumber) - 1; i >= 0; i -= 2)
            summation += Integer.parseInt(number.charAt(i) + "");       
        return summation;
    }
   
    // Return true if the digit  is a prefix for number
    public static boolean checkForPrefixMatching(long inputnumber, int digit)
    {
        return getPrefixNumber(inputnumber, getNumberOfDigits(digit)) == digit;
    }
   
    // Return the number of digits
    public static int getNumberOfDigits(long digit)
    {
        String number = digit + "";
        return number.length();
    }
   
   // it is retrieved the first k digits of an integer using the substring feature.
    //Return number if the number of digits is fewer than k.
    public static long getPrefixNumber(long inputnumber, int k)
    {
        if (getNumberOfDigits(inputnumber) > k) {
            String num = inputnumber + "";
            return Long.parseLong(num.substring(0, k));
        }
        return inputnumber;
    }}