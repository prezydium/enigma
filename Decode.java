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
    Scanner sc = new Scanner(System.in);

    public void decrypt(){
        System.out.println("Podaj tajne hasło, którym wiadomość została zakodowana:");
        secretWord = sc.nextLine();
        System.out.println("Podaj tajną wiadomość:");
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
        



      //Integer[] end = new Integer[Integer.to]



    }

}
