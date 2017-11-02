import java.util.Scanner;

public class App {

    private static String input = "";
    private static String bitRep;
    private static String secretWord = "nic"; // program pod 3 literowe haslo, pamietac
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

        System.out.println(sb); //testline
        System.out.println(sbSecret); //testline
        System.out.println(sbCoded); //testline

        Integer[] end = new Integer[sbCoded.length()/8];
        int pocz = 0;
        int konc = 8;
        Integer z;

        for (int i=0; i<sbCoded.length()/8; i++) {
            output = sbCoded.substring(pocz, konc);
           // System.out.println("bity: " + output); test line
            z = Integer.parseInt(output, 2);
            end[i] = z;
            pocz += 8;
            konc += 8;
        }
        System.out.println("Zakodowana wiadomość: ");
        for(int e: end){
            System.out.print(e + " ");

        }

    }

}
