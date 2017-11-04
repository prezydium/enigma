import java.util.Scanner;

public class Decode {

    private String input = "";
    private String bitRep;
    private String secretWord = "";
    private String output;
    private StringBuilder sb = new StringBuilder();
    private StringBuilder sbSecret = new StringBuilder();
    private StringBuilder sbTemp = new StringBuilder();
    private StringBuilder sbTemp2 = new StringBuilder();
    private StringBuilder sbCoded = new StringBuilder();
    private StringBuilder sbDecoded = new StringBuilder();
    private StringBuilder sbMessage = new StringBuilder();
    private Scanner sc = new Scanner(System.in);

    public void decrypt() {
        System.out.println("Podaj tajne hasło, którym wiadomość została zakodowana:");
        secretWord = sc.nextLine();
        System.out.println("Podaj tajną wiadomość(pamiętasz, że to ciąg liczb całkowitych rozdzielonych spacjami?):");
        input = sc.nextLine();

        String[] start = input.split(" ");
        int[] startAsInt = new int[start.length];
        for (int i = 0; i < start.length; i++) {
            startAsInt[i] = Integer.parseInt(start[i]);
        }

        for (int i = 0; i < startAsInt.length; i++) {
            bitRep = Integer.toBinaryString(startAsInt[i]);
            bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sbCoded.append(bitRep);
        }
        //  System.out.println(sbCoded); // testline
        //  System.out.println(sbCoded.length()/8); // testline

        if (startAsInt.length > secretWord.length()) {
            sbTemp2.append(secretWord);
            while (startAsInt.length > sbTemp2.length()) {
                sbTemp2.append(secretWord);
            }
            secretWord = sbTemp2.toString();
        }

        char[] secret = secretWord.toCharArray();


        for (int i = 0; i < secret.length; i++) {
            bitRep = Integer.toBinaryString(Character.getNumericValue(secret[i]));
            bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sbSecret.append(bitRep /*+ " "*/);

        }

        // System.out.println(sbSecret); //test line

        char[] text1 = sbCoded.toString().toCharArray();
        char[] text2 = sbSecret.toString().toCharArray();

        for (int i = 0; i < text1.length; i++) {
            if (text1[i] == text2[i]) {
                sbDecoded.append("0");
            } else {
                sbDecoded.append("1");

            }
        }
        //  System.out.println(sbDecoded); //testline

        Integer[] end = new Integer[sbDecoded.length() / 8];
        int pocz = 0;
        int konc = 8;
        Integer z;
        for (int i = 0; i < sbDecoded.length() / 8; i++) {
            output = sbDecoded.substring(pocz, konc);
            z = Integer.parseInt(output, 2);
            end[i] = z;
            pocz += 8;
            konc += 8;
        }

        System.out.println("Odkodowana wiadomość: ");
        char ch;
        for (int e : end) {
            ch = Character.forDigit(e, 36);
            sbMessage.append(ch);
        }
        System.out.println(sbMessage);


    }

}
