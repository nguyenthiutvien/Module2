package ss5_polymorphism.exercise3.validation;

import ss5_polymorphism.exercise3.exception.*;
import ss5_polymorphism.exercise3.exception.NumberFormatException;


public class CommonValidation {
    public  static  void  validateIsEmpty ( String value, String fieldName) throws EmptyFIeldException{
        if ( value.isEmpty()){
            throw new EmptyFIeldException(fieldName + "not must empty");

        }
    }
    public static int parseInt (String value, String fieldName) throws NumberOutOfRangeException {
        return Integer.parseInt(value);
    }
    public static double parseDouble (String value, String fieldName) throws NumberOutOfRangeException{
            return Double.parseDouble(value);
        }
    public static void validateNumberOutOfRangeException(double value, String fieldName, double minValue, double maxValue) throws NumberOutOfRangeException {
        if ( value < minValue || value > maxValue){
            throw new NumberOutOfRangeException(
                    String.format("%s is range out of valid value [%s, %s]", fieldName, minValue, maxValue)
            );
        }
    }
    public static void validateMinLength (String value, String fieldName, int minLenghth) throws MinLengthException {
        if (value.length() < minLenghth){
            throw new MinLengthException(String.format("%s must has at least %s characters" , fieldName));
        }
    }
    public static void validateIsNegativeNumber (double value, String fieldName) throws NegativeNumberException {
        if (value < 0){
            throw new NegativeNumberException(fieldName + " not a negative number");
        }
    }
}
