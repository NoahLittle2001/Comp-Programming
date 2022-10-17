import java.util.regex.*;
import java.util.Scanner;

public class email {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Pattern regex = Pattern.compile("[a-zA-Z0-9]+@[\\w\\d]+\\.com");
        String s = input.next();

        Matcher matcher = regex.matcher(s);
        System.out.println(matcher.find() ? "Matches" : "No match");
    }
}
