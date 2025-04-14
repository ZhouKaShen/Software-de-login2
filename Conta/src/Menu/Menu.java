// Menu.java
package Menu;

import java.io.*;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private Cadastro autenticado;

    public void menuTela(Cadastro autenticado) {
        this.autenticado = autenticado;

        while(true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("|             Menu:             |");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Comandos disponíveis: ");
            System.out.println("1. Listar arquivos");
            System.out.println("2. Criar arquivo");
            System.out.println("3. Ler arquivo");
            System.out.println("4. Excluir arquivo");
            System.out.println("5. Sair");
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Digite a opção desejada: ");
            int informacao = scanner.nextInt();
            scanner.nextLine();

            switch (informacao) {
                case 1:
                    if (autenticado.isLeitura()) {
                        System.out.println("\nListando arquivos... ");

                        File pastaListagem = new File("./arquivosEscritos");
                        File[] arquivos = pastaListagem.listFiles();

                        if (arquivos == null || arquivos.length == 0) {
                            System.out.println("Nenhum arquivo encontrado e/ou inexistente!");
                        } else {
                            for (int i = 0; i < arquivos.length; i++) {
                                System.out.println((i + 1) + ")" + arquivos[i].getName());
                            }
                        }
                    } else {
                        System.out.println("Permissão negada para listar arquivos.");
                    }
                    break;

                case 2:
                    if (autenticado.isLeitura()) {
                        System.out.println("\nCriando arquivo... ");

                        File pastaCriando = new File("./arquivosEscritos");
                        if (!pastaCriando.exists()) {
                            pastaCriando.mkdirs();
                        }

                        System.out.print("Digite o nome do novo arquivo: ");
                        String nomeArquivo = scanner.nextLine();
                        String caminhoDoArquivo = "./arquivosEscritos/" + nomeArquivo + ".txt";

                        System.out.println("Digite algo: ");
                        String escreverArquivo = scanner.nextLine();

                        try (FileWriter writer = new FileWriter(caminhoDoArquivo, true)) {
                            writer.write(escreverArquivo + "\n");
                            System.out.println("O arquivo foi escrito!");
                        } catch(FileNotFoundException e) {
                            System.out.println("Não conseguiu achar a localização do arquivo!");
                        } catch(IOException e) {
                            System.out.println("Não conseguiu escrever o arquivo!");
                        }
                    } else {
                        System.out.println("Permissão negada para criar arquivos.");
                    }
                    break;

                case 3:
                    if (autenticado.isExecucao()) {
                        System.out.print("Digite o nome do novo arquivo: ");
                        String nomeArquivoLeitura = scanner.nextLine();
                        String caminhoDoArquivoLeitura = "./arquivosEscritos/" + nomeArquivoLeitura + ".txt";

                        System.out.println("\nExecutando arquivo...");
                        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoDoArquivoLeitura))) {
                            String linha;
                            System.out.println("Conteúdo do arquivo:\n");
                            while ((linha = reader.readLine()) != null) {
                                System.out.println(linha);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Arquivo não encontrado e/ou inexistente!");
                        } catch (IOException e) {
                            System.out.println("Não conseguiu ler o arquivo!");
                        }
                    } else {
                        System.out.println("Permissão negada para ler arquivos.");
                    }
                    break;

                case 4:
                    if (autenticado.isExclusao()) {
                        System.out.println("Qual arquivo deseja excluir? ");

                        File pastaExclusao = new File("./arquivosEscritos");
                        File[] arquivosParaExcluir = pastaExclusao.listFiles();

                        if (arquivosParaExcluir.length == 0 || arquivosParaExcluir == null) {
                            System.out.println("Nenhum arquivo encontrado.");
                            break;
                        }

                        for (int i = 0; i < arquivosParaExcluir.length; i++)
                            System.out.println((i + 1) + ")" + arquivosParaExcluir[i].getName());

                        System.out.print("\nDigite o número do arquivo que deseja excluir: ");
                        String input = scanner.nextLine();

                        int opcaoExcluir;
                        try {
                            opcaoExcluir = Integer.parseInt(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Digite um número.");
                            break;
                        }

                        if (opcaoExcluir < 1 || opcaoExcluir > arquivosParaExcluir.length) {
                            System.out.println("Opção inválida!");
                            break;
                        }

                        File arquivoSelecionado = arquivosParaExcluir[opcaoExcluir - 1];
                        if (arquivoSelecionado.delete()) {
                            System.out.println("\nExcluindo arquivo...");
                            System.out.println("Arquivo " + arquivoSelecionado.getName() + " excluído!");
                        } else {
                            System.out.println("Não foi possível excluir o arquivo!");
                        }
                    } else {
                        System.out.println("Permissão negada para excluir arquivos.");
                    } break;
                case 5:
                    System.out.println("\nSaindo do menu..."); return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
