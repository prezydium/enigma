
import java.util.Scanner;

public class App {

    private static String input = "";
    private static String bitRep;
    private static String secretWord = "nic";
    private static int x;
    private static String output;


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbSecret = new StringBuilder();
        StringBuilder sbTemp = new StringBuilder();
        StringBuilder sbTemp2 = new StringBuilder();
        StringBuilder sbCoded = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst do zakodowania:");
        input = sc.nextLine();
        sbTemp.append(input);
        //System.out.println(base);
        if (input.length() % secretWord.length() == 1) {
            sbTemp.append("  ");
            input = sbTemp.toString();
        } else if (input.length() % secretWord.length() == 2) {
            sbTemp.append(" ");
            input = sbTemp.toString();
        }
        if ((input.length() / secretWord.length()) != 1) {

            for (int i = 0; i < (input.length() / secretWord.length()); i++) {
                sbTemp2.append(secretWord);
            }
            secretWord = sbTemp2.toString();
        }

        char[] base = input.toCharArray();
        char[] secret = secretWord.toCharArray();
        for (int i = 0; i < base.length; i++) {
            bitRep = Integer.toBinaryString(Character.getNumericValue(base[i]));
            bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sb.append(bitRep/*+ " "*/);

        }
        for (int i = 0; i < secret.length; i++) {
            bitRep = Integer.toBinaryString(Character.getNumericValue(secret[i]));
            bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sbSecret.append(bitRep /*+ " "*/);

        }
        char[] text1 = sb.toString().toCharArray();
        char[] text2 = sbSecret.toString().toCharArray();

        for (int i = 0; i < text1.length; i++) {
            if (text1[i] == text2[i]) {
                sbCoded.append("0");
            } else {
                sbCoded.append("1");

            }
        }

        System.out.println(sb);
        System.out.println(sbSecret);
        System.out.println(sbCoded);

        output = sbCoded.substring(0, 8);
        System.out.println("bity: " + output);
        Integer u = Integer.valueOf(output);
        System.out.println(u);
        Character A = Character.lowSurrogate(u);
        System.out.println(A);


    }


}
