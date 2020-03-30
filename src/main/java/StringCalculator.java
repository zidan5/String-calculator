import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


    public  static int Add(String inputString) throws Exception {
        if(!inputString.isEmpty()){

            if(inputString.matches("[\\w~`!@#$%^&*()\\-?+{}\\[<>\\]\\./]+[\\W\\w]*\\n?[[^1-9]\\d{3}\\w\\W]*")) {
                int sum = 0;

                if(!inputString.contains("\n")){
                    if(!inputString.contains("-")) {

                        inputString = inputString.replaceAll("[^\\d]", "");
                        char[] characters = inputString.toCharArray();

                        for (int i = 0; i < characters.length; i++) {

                            int[] numbers = new int[characters.length];
                            numbers[i] = Character.getNumericValue(characters[i]);
                            sum += numbers[i];
                        }

                        return sum;

                    }else {
                        throw new Exception("'ERROR: negatives not allowed -1,-2");
                    }
                }

                if(inputString.substring(0,inputString.indexOf("\n")).length() < 2){

                    inputString = inputString.replaceAll("[^\\d]","");
                    char[] characters = inputString.toCharArray();

                    for (int i = 0; i < characters.length; i++) {

                        int[] numbers = new int[characters.length];
                        numbers[i] = Character.getNumericValue(characters[i]);
                        sum += numbers[i];
                    }

                    return  sum;
                }

                String rightString = inputString;
                inputString = inputString.substring(0,inputString.indexOf("\n"));
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
                wantedNumbers = wantedNumbers.replaceAll("[\\D]","");

                char[] FilteredNumbers = wantedNumbers.toCharArray();

                for (int i = 0; i < FilteredNumbers.length; i++) {

                    int[] numbers = new int[FilteredNumbers.length];
                    numbers[i] = Character.getNumericValue(FilteredNumbers[i]);
                    sum += numbers[i];
                }

                return sum;

            }else{
                throw new Exception("Invalid Input");
            }
        }
        return  0;
    }
    public static void main(String[] Args) throws Exception {

        System.out.println("Result = "+Add(""));
        System.out.println("Result = "+Add("1,2,3,4"));
        System.out.println("Result = "+Add("1\n2,3"));
        System.out.println("Result = "+Add("//4\n142"));
        //System.out.println("Result = "+Add("-1,-2,3,4")); //Throws exception for negetive numbers
        System.out.println("Result = "+Add("//***\n1***2***3"));
        System.out.println("Result = "+Add("//4\n142"));
        System.out.println("Result = "+Add("//[(-_-')][%]\n1(-_-')2%3"));
        System.out.println("Result = "+Add("//[abc][777][:(]\n1abc27773:(1"));
    }
}
