import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


public  static int Add(String inputString) throws Exception {
    if(!inputString.isEmpty()){  // input string must have a value

        if(inputString.matches("[\\w~`!@#$%^&*()\\-?+{}\\[<>\\]\\./]+[\\W\\w]*\\n?[[^1-9]\\d{3}\\w\\W]*")) {

            if(!inputString.contains("\n")){     //if input string contains not "\n"
                if(!inputString.contains("-")) { //if input string contains not "-"
                  return StringCalculator.sumAll(inputString); //sum all digits

                }else {
                    throw new Exception("'ERROR: negatives not allowed ");
                }
            }

            if(inputString.substring(0,inputString.indexOf("\n")).length() < 2){ // substring from 0 to indexOf "\n"
                 return StringCalculator.sumAll(inputString); // sum all digits
            }

            String rightString = inputString;
            inputString = inputString.substring(0,inputString.indexOf("\n"));// substring from 0 to indexOf "\n"
            inputString = inputString.replaceAll("[\\[\\]//]","");
            char[] unwantedChars = inputString.toCharArray();
            rightString  = rightString.substring(rightString.indexOf("\n") + 1);

            if(rightString.matches(".*1\\d{3}.*")) {
                rightString =  rightString.substring(4);
            }

            char[] wantedString = rightString.toCharArray();

            for(int i=0; i<unwantedChars.length; i++){
                for(int j =0; j<wantedString.length; j++){
                       if(unwantedChars[i] == wantedString[j]){
                           wantedString[j] =',';
                       }
                }
            }
            String wantedNumbers = Arrays.toString(wantedString);
            return  StringCalculator.sumAll(wantedNumbers);

        }else{
            throw new Exception("Invalid Input");
        }
    }
    return  0;
}
private  static int  sumAll(String str) {
    int sum =0;
    str = str.replaceAll("[^\\d]", "");
    char[] characters = str.toCharArray();

    for (int i = 0; i < characters.length; i++) {

        int[] numbers = new int[characters.length];
        numbers[i] = Character.getNumericValue(characters[i]);
        sum += numbers[i];
    }

    return sum;
}
public static void main(String[] Args) throws Exception {

    System.out.println("Result = "+Add(""));
    System.out.println("Result = "+Add("1,2,3,4"));
    System.out.println("Result = "+Add("1\n2,3"));
    System.out.println("Result = "+Add("//4\n142"));
    System.out.println("Result = "+Add("//***\n1***2***3"));
    System.out.println("Result = "+Add("//;\n1000,1;2"));
    System.out.println("Result = "+Add("//[(-_-')][%]\n1(-_-')2%3"));
    System.out.println("Result = "+Add("//[abc][777][:(]\n1abc27773:(1"));
    
}
}
