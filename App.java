import java.util.Scanner;

public class App {
private static Scanner sc = new Scanner (System.in);
private static String menu = "";
    public static void main(String[] args) {
        System.out.println("Witaj wędrowcze. Czy chcesz: " +
                "\n1. Ukryć wiadomość" +
                "\n2. Poznać sekrety");

        menu = sc.nextLine();
        if (menu.equals("1")){
            Code code = new Code();
            code.crypth();
        } else if (menu.equals("2")){

        }else {
            System.out.println("Nie żartuj sobie ze mnie!");
        }




        }

    }


