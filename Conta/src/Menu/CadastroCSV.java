package Menu;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CadastroCSV {
    // Caminho do arquivo
    private static String nomeArquivo = "./dados/Cadastro.csv";
    // Método para adicionar um cadastro ao arquivo CSV
    public static void adiconarCadastro(Cadastro c) {
        try {
            // Verificar se o arquivo já existe
            boolean arquivoExiste = new File(nomeArquivo).exists();

            // Abre o escritor para adicionar dados ao arquivo
            FileWriter escritor = new FileWriter(nomeArquivo, StandardCharsets.ISO_8859_1, true);
            if (!arquivoExiste) {
                escritor.write("Nome;Senha;Leitura;Exclusao;Execuçao\n");
            }
            // Escrever os dados do cadastro no formato apropriado
            escritor.write(c.getUsuario() + ";" + c.getSenha() + ";" + c.isLeitura() + ";" + c.isExclusao() + ";" + c.isExecucao() + "\n");

            // Escrever todos os dados do buffer no arquivo imediatamente
            escritor.flush();

            // Fecha o recurso de escrita
            escritor.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para listar os cadastros do arquivo CSV

    public static ArrayList<Cadastro> listarCadastro() {
        ArrayList<Cadastro> lista = new ArrayList<>();

        try {
            // Abrir o leitor para ler o arquivo
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            boolean primeiraLinha = true;

            while((linha = leitor.readLine()) != null) {
                // Ignora a primeira linha
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                // Dividir a linha em partes usando o ponto e vírgula como separador
                String[] partes = linha.split(";");

                if (partes.length < 5) {
                    System.out.println("Linha mal formatada ou incompleta: " + linha);
                    continue;
                }

                String usuario = partes[0];
                String senha = String.valueOf(partes[1]);
                boolean leitura = Boolean.parseBoolean(partes[2]);
                boolean exclusao = Boolean.parseBoolean(partes[3]);
                boolean execucao = Boolean.parseBoolean(partes[4]);

                // Criar o objeto cadastro
                Cadastro c = new Cadastro(usuario, senha, leitura, exclusao, execucao);

                // Adiciona na lista
                lista.add(c);

                // Imprimir informações do cadastro
                // System.out.format("Nome do usuário: %s - Senha: %s - Leitura: %b - Exclusão: %b - Execução: %b\n", usuario, senha, leitura, exclusao, execucao);
            }

            leitor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
