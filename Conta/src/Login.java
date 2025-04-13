import Menu.Cadastro;
import Menu.CadastroCSV;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\nCadastro:\n");

            System.out.println("Digite o usuário: ");
            String usuario = scanner.nextLine();

            System.out.println("Digite a senha: ");
            String senha = scanner.nextLine();

            System.out.println("Ao continuar, você declara que leu e concorda com os termos e condições deste contrato.");
            System.out.println(("Insira a informação (s/n):"));
            String afirmacao = scanner.nextLine();

            if (afirmacao.equalsIgnoreCase("s")) {
                Cadastro cadastro = new Cadastro(usuario, senha, true);
                CadastroCSV.adiconarCadastro(cadastro);
            } else break;

            // Login
            System.out.println("Deseja fazer login? (s/n)");
            String informacao = scanner.nextLine();

            if (informacao.equalsIgnoreCase("s")) {
                int maxTentativas = 5;
                int tentativas = 0;

                while(tentativas < maxTentativas) {
                    System.out.println("Digite o usuário que você deseja acessar: ");
                    String nomeLogin = scanner.nextLine();

                    System.out.println("Digite a senha: ");
                    String senhaLogin = scanner.nextLine();

                    boolean autenticado = false;
                    for (Cadastro c : CadastroCSV.listarCadastro()) {
                        if (c.getUsuario().equals(nomeLogin) && c.getSenha().equals(senhaLogin)) {
                            autenticado = true;
                            break;
                        }
                    }

                    if (autenticado) {
                        System.out.println("Login bem-sucedido!");
                        break;
                    } else {
                    tentativas++;
                    System.out.format("Senha incorreta.\nTentativas restantes: <%d>\n",
                            maxTentativas - tentativas);

                        if (tentativas >= maxTentativas) {
                            System.out.println("Programa interrompido pelo excesso de tentativas!\n");
                            break;
                        }
                    }
                }
            }
            System.out.println("Deseja criar mais uma conta? (s/n)");
            String confirmacao = scanner.nextLine();
            if (!confirmacao.equalsIgnoreCase("s")) break;
        }

        // Listagem dos cadastros
        CadastroCSV.listarCadastro();
    }
}
