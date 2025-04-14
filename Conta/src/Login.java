import Menu.Cadastro;
import Menu.CadastroCSV;
import java.util.Scanner;
import Menu.Menu;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("|             Menu:             |");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("1. Cadastro");
            System.out.println("2. Autenticar");
            System.out.println("3. Sair do programa");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite uma das opções acima: ");
            int opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            switch(opcaoEscolhida) {
                case 1:
                    while (true) {
                        System.out.println("\nCadastro:\n");

                        System.out.println("Digite o usuário: ");
                        String usuario = scanner.nextLine();

                        System.out.println("Digite a senha: ");
                        String senha = scanner.nextLine();

                        boolean leitura = false;
                        boolean exclusao = false;
                        boolean execucao = true;
                        Cadastro cadastro = new Cadastro(usuario, senha, leitura, exclusao, execucao);
                        CadastroCSV.adiconarCadastro(cadastro); // sem permissão
                        System.out.println("Cadastrado com sucesso!");
                        break;

                        /*

                        System.out.println("Gostaria de adicionar permissões?");
                        System.out.println(("Insira a informação (s/n):"));
                        String afirmacao = scanner.nextLine();

                        if (afirmacao.equalsIgnoreCase("s")) {
                            System.out.println("Gostaria de ter permissão para ler? (s/n)");
                            String leituraResposta = scanner.nextLine();
                            if (leituraResposta.equalsIgnoreCase("s")) leitura = true;

                            System.out.println("Gostaria de ter permissão para excluir? (s/n):");
                            String exclusaoResposta = scanner.nextLine();
                            if (exclusaoResposta.equalsIgnoreCase("s")) exclusao = true;

                            System.out.println("Gostaria de ter permissão para executar? (s/n): ");
                            String executarResposta = scanner.nextLine();

                            if (executarResposta.equalsIgnoreCase("s")) execucao = true;

                            Cadastro cadastro = new Cadastro(usuario, senha, leitura, exclusao, execucao);
                            CadastroCSV.adiconarCadastro(cadastro); // com permissão
                            System.out.println("Cadastrado com sucesso!");
                            break;
                        }
                        */
                    } break;
                case 2:
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

                            Cadastro autenticado = null;
                            for (Cadastro c : CadastroCSV.listarCadastro()) {
                                if (c.getUsuario().equals(nomeLogin) && c.getSenha().equals(senhaLogin)) {
                                    autenticado = c;
                                    break;
                                    // Irá verificar se existe um usuário na lista de cadastro
                                    // Se verificado -> salvar no autenticado
                                }
                            }

                            // Verificado -> login sucedido.
                            if (autenticado != null) {
                                Menu menu = new Menu();
                                System.out.println("Login bem-sucedido!");
                                System.out.println("Usuário autenticado!");
                                menu.menuTela(autenticado);
                                break;
                            } else {
                                tentativas++;

                                System.out.format("Senha incorreta.\nTentativas restantes: <%d>\n",
                                        maxTentativas - tentativas);

                                if (tentativas >= maxTentativas) {
                                    System.out.println("Programa interrompido pelo excesso de tentativas!\n");
                                    return;
                                }
                            }
                        }
                    } break;
                case 3:
                    System.out.println("\nSaindo do programa...");
                    System.out.println("\nFim do programa!");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
