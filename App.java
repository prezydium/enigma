
import java.util.Scanner;

public class App {

    private static String haslo = "nicolette";
    private static String input = "";
    private  static String bitRep;
    private static String secretWord = "nic";
    private static double x;




    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        StringBuilder sbSecret = new StringBuilder();
        StringBuilder sbTemp = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj tekst do zakodowania:");
        input = sc.nextLine();
        sbTemp.append(input);
       //System.out.println(base);
       if (input.length() % secretWord.length() == 1){
           sbTemp.append("  ");
           input = sbTemp.toString();
       }else if (input.length() % secretWord.length() == 2){
           sbTemp.append(" ");
           input = sbTemp.toString();
       }
        char[] base = input.toCharArray();
        char[] secret = secretWord.toCharArray();
       for (int i = 0; i < base.length; i++){
           bitRep = Integer.toBinaryString(Character.getNumericValue(base[i]));
           bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sb.append(bitRep + " ");

       }
        for (int i = 0; i < secret.length; i++){
            bitRep = Integer.toBinaryString(Character.getNumericValue(secret[i]));
            bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sbSecret.append(bitRep + " ");

        }
        System.out.println(sb);
        System.out.println(sbSecret);


    }


}
