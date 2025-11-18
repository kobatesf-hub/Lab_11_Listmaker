import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt){
        String input = "";
        do{
            System.out.println(prompt + ": ");
            input = pipe.nextLine().trim();
        }while (input.length() == 0);
        return input;
    }

    public static String getRegeExString(Scanner pipe, String prompt, String regEx) {
        Pattern p = Pattern.compile(regEx);
        String input = "";
        boolean ok = false;
        do {
            System.out.print(prompt + ": ");
            input = pipe.nextLine().trim();
            Matcher m = p.matcher(input);
            if (m.matches()){
                ok = true;
            }
        }
        while (!ok);
        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int value = 0;
        boolean ok = false;
        do{
            System.out.println(prompt + "(" + low + "-" + high + "): ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine();
                if (value >= low && value <= high){
                    ok = true;
                } else {
                    System.out.println("Error: Input must be between " + low + " and " + high + ".");
                }
            } else {
                pipe.nextLine();
                System.out.println("Error: Please enter a valid integer.");
            }
        }while (!ok);
        return value;
    }

    public static boolean getYNconfirm(Scanner pipe, String prompt) {
        String s = getRegeExString(pipe, prompt, "[YyNn]");
        return s.equalsIgnoreCase("Y");
    }
}