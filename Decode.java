import java.util.Scanner;

public class Decode {

    private String input = "";
    private String bitRep;
    private String secretWord = "nic"; // program pod 3 literowe haslo, pamietac
    private int x;
    private String output;
    StringBuilder sb = new StringBuilder();
    StringBuilder sbSecret = new StringBuilder();
    StringBuilder sbTemp = new StringBuilder();
    StringBuilder sbTemp2 = new StringBuilder();
    StringBuilder sbCoded = new StringBuilder();
    StringBuilder sbDecoded = new StringBuilder();
    StringBuilder sbMessage = new StringBuilder();
    Scanner sc = new Scanner(System.in);

    public void decrypt(){
        System.out.println("Podaj tajne hasło, którym wiadomość została zakodowana:");
        secretWord = sc.nextLine();
        System.out.println("Podaj tajną wiadomość(pamiętasz, że to ciąg liczb całkowitych rozdzielonych spacjami?):");
        input = sc.nextLine();
      /*  Integer[] end = new Integer[10000];
        for (int i = 0; i<end.length; i++){
            end[i] = 9999;
        }
        */
      String[] start = input.split(" ");
      int[] startAsInt = new int[start.length];
        for (int i = 0; i < start.length; i++) {
            startAsInt[i] = Integer.parseInt(start[i]);
        }

        for(int i = 0; i < startAsInt.length; i++) {
            bitRep = Integer.toBinaryString(startAsInt[i]);
            bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sbCoded.append(bitRep);
        }
        System.out.println(sbCoded); // testline
      //  System.out.println(sbCoded.length()/8); // testline

        if (startAsInt.length > secretWord.length()) {
            sbTemp2.append(secretWord);
            while (startAsInt.length > sbTemp2.length()) {
                sbTemp2.append(secretWord);
            }
            secretWord = sbTemp2.toString();
        }

        //char[] base = input.toCharArray();
        char[] secret = secretWord.toCharArray();


        for (int i = 0; i < secret.length; i++) {
            bitRep = Integer.toBinaryString(Character.getNumericValue(secret[i]));
            bitRep = ("00000000" + bitRep).substring(bitRep.length());
            sbSecret.append(bitRep /*+ " "*/);

        }

        System.out.println(sbSecret);

        char[] text1 = sbCoded.toString().toCharArray();
        char[] text2 = sbSecret.toString().toCharArray();

        for (int i = 0; i < text1.length; i++) {
            if (text1[i] == text2[i]) {
                sbDecoded.append("0");
            } else {
                sbDecoded.append("1");

            }
        }
        System.out.println(sbDecoded); //testline

        Integer[] end = new Integer[sbDecoded.length()/8];
        int pocz = 0;
        int konc = 8;
        Integer z;
        for (int i=0; i<sbDecoded.length()/8; i++) {
            output = sbDecoded.substring(pocz, konc);
            // System.out.println("bity: " + output); test line
            z = Integer.parseInt(output, 2);
            end[i] = z;
            pocz += 8;
            konc += 8;
        }

        System.out.println("Odkodowana wiadomość: ");
        char ch;
        for(int e: end) {
            ch = (char)e;
            sbMessage.append(ch);
        }
        System.out.println(sbMessage);






    }

}
