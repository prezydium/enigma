import java.util.Scanner;

public class Code {

    private String input = "";
    private String bitRep;
    private String secretWord = "";
    private String output;
    private StringBuilder sb = new StringBuilder();
    private StringBuilder sbSecret = new StringBuilder();
    private StringBuilder sbTemp = new StringBuilder();
    private StringBuilder sbTemp2 = new StringBuilder();
    private StringBuilder sbCoded = new StringBuilder();
    private Scanner sc = new Scanner(System.in);

    public void crypth() {

        System.out.println("Wybierz swe tajne haslo / Choose your secret keyword: ");
        secretWord = sc.nextLine();
        System.out.println("Podaj tekst do zakodowania (bez polskich znakow): / Type message to code (no polish or dwarven characters): ");
        input = sc.nextLine();
        sbTemp.append(input);

        if (input.length() > secretWord.length()) {
            sbTemp2.append(secretWord);
            while (input.length() > sbTemp2.length()) {
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

       // System.out.println(sb); //test line
       // System.out.println(sbSecret); //test line
       // System.out.println(sbCoded); //test line

        Integer[] end = new Integer[sbCoded.length() / 8];
        int pocz = 0;
        int konc = 8;
        Integer z;

        for (int i = 0; i < sbCoded.length() / 8; i++) {
            output = sbCoded.substring(pocz, konc);
            // System.out.println("bity: " + output); test line
            z = Integer.parseInt(output, 2);
            end[i] = z;
            pocz += 8;
            konc += 8;
        }
        System.out.println("Zakodowana wiadomosc to: / Crypthed message is: ");
        for (int e : end) {
            System.out.print(e + " ");

        }

    }
}
