import java.util.Scanner;

public class App {
private static Scanner sc = new Scanner (System.in);
private static String menu = "";
    public static void main(String[] args) {
        System.out.println("Witaj wedrowcze. Czy chcesz: / Welcome Wanderer. Do you want to: " +
                "\n1. Ukryc wiadomosc / Hide message." +
                "\n2. Poznac sekrety / Learn secrets.");

        menu = sc.nextLine();
        if (menu.equals("1")){
            Code code = new Code();
            code.crypth();
        } else if (menu.equals("2")){
            Decode decode = new Decode();
            decode.decrypt();
        }else {
            System.out.println("Nie zartuj sobie ze mnie! / Don't joke with me!");
        }

        System.out.println("\n\nMe zadanie skonczone / My work is done");
        sc.nextLine();

        }

    }


