package com.nology.controlflow_02;

/**
 *   All challenges in this repository are separated into three levels: Foundation, Intermediate, and Advanced.
 *   The expectation is to complete all Foundation level challenges, with Intermediate and upwards pushing your knowledge
 *   and may require you to google things in order to solve them. If you find an answer online somewhere, be kind and
 *   share it with the group!
 */
public class Challenge {
    public Challenge() {
    }

    // -------------- FOUNDATION --------------

    /***
     * Write a method that concatenates two strings together with a space in between them.
     *
     * @param firstName the firstname of a person
     * @param lastName the lastname of a person
     * @return returns a string which is the concatenation of the 2 parameters
     */
    public String getFullName(String firstName, String lastName) {

        return firstName + " " + lastName;
    }

    /***
     * Write a method that checks if a number is within 0 and a given range. Both inclusive.
     *
     * @param number the number to find within the range
     * @param rangeLimit the limit of the range
     * @return returns a boolean based on whether the number is between 0 and the range limit
     */
    public boolean isWithinRange(int number, int rangeLimit) {
        return number >= 0 && number <= rangeLimit;
    }

    /***
     * Write a method that takes two numbers and an operator. Based on the operator preform the
     * equation and return the result.
     * e.g 10, 2 , "/" = 5
     * e.g 10, 2 , "+" = 12
     *
     * If either number is below 0 return -1
     * If an operator is not "*", "/", "+", "-" return -1
     *
     * @param numberOne the first number in the equation
     * @param numberTwo the second number in the equation
     * @param operator the operator to complete the equation
     * @return returns the result of the equation
     */
    public int stringCalculator(int numberOne, int numberTwo, String operator) {
        if(numberOne < 1 || numberTwo < 1) {
            return -1;
        }

        int result = 0;

        switch (operator) {
            case "*" :
                result = numberOne * numberTwo;
                break;
            case "/" :
                result = numberOne / numberTwo;
                break;
            case "+" :
                result = numberOne + numberTwo;
                break;
            case "-" :
                result = numberOne - numberTwo;
                break;
            default:
                result = -1;
        }
        return result;

    }

     /*
        if (numberOne < 0 || numberTwo < 0) {
            return -1;
        } else if (numberOne > 0 && numberTwo > 0) {
            int result = 0;
            if (operator == "*") {
                return result = numberOne + numberTwo;
            } else if (operator == "/") {
                return result = numberOne / numberTwo;
            } else if (operator == "+") {
                return result = numberOne + numberTwo;
            } else if (operator == "-") {
                return result = numberOne - numberTwo;
            } else {
                return result = -1;
            }
        }
        return result;

         */


    // -------------- INTERMEDIATE --------------

    /***
     * We have a dog that likes to bark. We need to wake up if the dog is barking at night!
     * This method should return true or false if we need to wake up or not.
     *
     * If the dog is barking before 8 or after 22 hours we need to wake up.
     * All other cases we do not need to wake up.
     * If the hourOfDay is not within 0 - 23 we do not need to wake up.
     *
     * @param barking type boolean it represents if our dog is currently barking or not.
     * @param hourOfDay represents the hour of the day and is of type int with the name hourOfDay and has a valid
     *                  range of 0-23.
     * @return If we need to wake up or not based on the conditions above.
     */
    public boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (hourOfDay > 24) {
            return false;
        } else if (barking && hourOfDay>=8 || hourOfDay<=22) {
            return false;
        }
        return (barking && hourOfDay < 8 || hourOfDay > 22);
    }

    /***
     * Write a method to display the middle character or characters of a word.
     *
     * If multiple words separated with a " " or no words are given it should return "Invalid Input"
     *
     * @param word the word that we want to check
     * @return return the middle character or characters... for example, passing in "Sam" would return "The middle
     * character in the string: a"
     */
    public String getMiddleCharacter(String word) {
        //如果词语中包含空格，也就是说把名字分开了，或者名字是空串，那么就返回invalid input
        if(word.contains(" ") || word.equals("")) {
            return "Invalid Input";
        }
        /*
        先定义两个值，一个是要取字母的位置，position；另一个是取字母的长度，length
        如果word里面包含的是偶数个字母，那么就要取中间位置的两个，并且要取长度为2
        如果字母中包含的字母是奇数个，那么就取最中间的一个，长度为1
        取值的时候要用String.substring(int beginIndex, int endIndex)的方法
        beginIndex就是position数字，position算到几就从哪里开始取；然后给position加上length就是终止位置
        */
        int position;
        int length;

        if(word.length() % 2 == 0) {
            position = word.length() / 2 -1;
            length = 2;
        } else {
            position = word.length() / 2;
            length  = 1;
        }
        return word.substring(position, position+length);

    }

    /***
     * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type int.
     * The method needs to see how many megabytes are in the given kilobyte and work out the remainder
     * Then it needs to return a message in the format "XX KB = YY MB and ZZ KB".
     *
     * If the kiloBytes param is less than 0 return "Invalid value"
     * 1 megaByte = 1024 kiloBytes
     *
     * @param kiloBytes the number of kilobytes to be converted
     * @return returns a string in the format above if the input is valid, or "Invalid value"
     */
    public String printMegaBytesAndKiloBytes(int kiloBytes) {
        if(kiloBytes <= 0) {
            return "Invalid Value";
        }

        int getMB;
        int getKB;

        getMB = kiloBytes / 1024;
        getKB = kiloBytes % 1024;

        return kiloBytes + " KB = " + getMB + " MB and " + getKB + " KB";
    }

    // -------------- ADVANCED --------------

    /***
     * Write a method to compute the future investment value returned at a given interest rate for a specified number
     * of years.
     * It should return a string the matches this format "You now have RESULT" the RESULT needs to be rounded.
     *
     * If initialInvestment is less than or equal 0 return "Invalid investment"
     * If years is less than or equal 0 return "Invalid years"
     * If rateOfInterest is less than 0 or greater than or equal to 1 return "Invalid rate of interest"
     *
     * HINT: https://www.w3schools.com/java/java_for_loop.asp
     *
     * @param initialInvestment the starting value
     * @param years the number of years that the investment will take
     * @param rateOfInterest the rate at which, each year, the investment will increase by
     * @return returns the total amount after x number of years (including the initial investment)
     */
    public String calculateReturn(int initialInvestment, int years, double rateOfInterest) {

        if(initialInvestment <= 0) {
            return "Invalid investment";
        } else if (years <= 0) {
            return "Invalid years";
        } else if (rateOfInterest < 0 || rateOfInterest == 1) {
            return "Invalid rate of interest";
        }

        double rate = 1 + rateOfInterest;
        double square = Math.pow(rate, years);
        double result = initialInvestment * square;
        long intResult = Math.round(result);

        return "You now have " + intResult;
    }
}
