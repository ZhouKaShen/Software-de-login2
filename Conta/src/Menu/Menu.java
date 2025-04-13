package Menu;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menuTela() {
        System.out.println("\nMenu:\n");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Deseja escolher qual das opções?");
        System.out.println("1. Cadastrar");
        System.out.println("2. Autenticar");
        System.out.println("3. Sair");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        int informacao = scanner.nextInt();
        switch (informacao) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
