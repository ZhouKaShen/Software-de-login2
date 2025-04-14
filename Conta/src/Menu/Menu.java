package Menu;
import java.io.*;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public void menuTela() {
        while(true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("|             Menu:             |");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Comandos disponíveis: ");
            System.out.println("1. Listar arquivos");
            System.out.println("2. Criar arquivo");
            System.out.println("3. Ler arquivo");
            System.out.println("4. Excluir arquivo");
            System.out.println("5. Listar usuários (APENAS COM PERMISSÃO DE LEITURA!)");
            System.out.println("6. Sair");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite a opção desejada: ");
            int informacao = scanner.nextInt();
            scanner.nextLine();

            switch (informacao) {
                case 1:
                    if (.isLeitura()) {
                        System.out.println("\nListando arquivos... ");

                        File pastaListagem = new File("./arquivosEscritos");
                        File[] arquivos = pastaListagem.listFiles();

                        if (arquivos == null || arquivos.length == 0) {
                            System.out.println("Nenhum arquivo encontrado e/ou inexistente!");
                        } else {
                            for (int i = 0; i < arquivos.length; i++) {
                                System.out.println((i + 1) + ")" + arquivos[i].getName());
                            } } break;
                    } else break;
                case 2:
                    if (cadastro.isExecucao()) {
                        System.out.println("\nCriando arquivo... ");

                        File pastaCriando = new File("./arquivosEscritos");
                        // Entra no diretório e cria uma pasta
                        if (!pastaCriando.exists()) {
                            pastaCriando.mkdirs(); // mkdir (Ele cria uma pasta, se não existir)
                        }

                        System.out.print("Digite o nome do novo arquivo: ");
                        String nomeArquivo = scanner.nextLine();
                        String caminhoDoArquivo = "./arquivosEscritos/" + nomeArquivo + ".txt";
                        // String textContent = "Eu gosto de pizza!\nÉ muito bom!\nMe compre pizza!";

                        System.out.println("Digite algo: ");
                        String escreverArquivo = scanner.nextLine();

                        try (FileWriter writer = new FileWriter(caminhoDoArquivo, true)) {
                            writer.write(escreverArquivo + "\n");
                            System.out.println("O arquivo foi escrito!");
                        } catch(FileNotFoundException e) {
                            System.out.println("Não conseguiu achar a localização do arquivo!");
                            break;
                        } catch(IOException e) {
                            System.out.println("Não conseguiu escrever o arquivo!");
                        } break;
                    } break;

                case 3:
                    if (cadastro.isExecucao()) {
                        System.out.print("Digite o nome do novo arquivo: ");
                        String nomeArquivoLeitura = scanner.nextLine();
                        scanner.nextLine();
                        String caminhoDoArquivoLeitura = "./arquivosEscritos/" + nomeArquivoLeitura + ".txt";

                        System.out.println("\nExecutando arquivo...");
                        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoDoArquivoLeitura))) {
                            String linha;
                            System.out.println("Conteúdo do arquivo:\n");
                            while ((linha = reader.readLine()) != null) {
                                System.out.println(linha); }
                        } catch (FileNotFoundException e) {
                            System.out.println("Arquivo não encontrado e/ou inexistente!");
                        } catch (IOException e) {
                            System.out.println("Não conseguiu ler o arquivo!");
                        } break;
                    } break;
                case 4:
                    if (cadastro.isExclusao()) {
                        System.out.println("Qual arquivo deseja excluir? ");

                        File pastaExclusao = new File("./arquivosEscritos");
                        File[] arquivosParaExcluir = pastaExclusao.listFiles();

                        if (arquivosParaExcluir == null || arquivosParaExcluir.length == 0) {
                            System.out.println("Nenhum arquivo encontrado."); break; }

                        for (int i = 0; i < arquivosParaExcluir.length; i++) {
                            System.out.println((i + 1) + ")" + arquivosParaExcluir[i].getName()); }

                        System.out.print("\nDigite o número do arquivo que deseja excluir: ");
                        int opcaoExcluir = scanner.nextInt();
                        scanner.nextLine();

                        if (opcaoExcluir < 1 || opcaoExcluir > arquivosParaExcluir.length) {
                            System.out.println("Opção inválida!"); break; }

                        File arquivoSelecionado = arquivosParaExcluir[opcaoExcluir - 1];

                        if (arquivoSelecionado.delete()) {
                            System.out.println("\nExcluindo arquivo...");
                            System.out.println("Arquivo " + arquivoSelecionado.getName() + " excluído!");
                        } else {
                            System.out.println("Não foi possível excluir o arquivo!");
                        } break;
                    } break;

                case 5:
                    if (cadastro.isLeitura()) {
                        // Listagem dos cadastros
                        // Administrador: Permissão -> true
                        // Usuário: Permissão -> false
                        // Classe estático (não mexer!)
                        CadastroCSV.listarCadastro(); break;
                    } break;
                default:
                    System.out.println("\nSaindo do programa...");
                    System.out.println("\nFim do programa!"); return;
            }
        }
    }
}
