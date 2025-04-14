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
                escritor.write("Nome;Senha;Verificado\n");
            }

            // Escrever os dados do cadastro no formato apropriado
            escritor.write(c.getUsuario() + ";" + c.getSenha() + ";" + c.isVerificado() + "\n");

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

                String usuario = partes[0];
                String senha = String.valueOf(partes[1]);
                boolean verificado = Boolean.parseBoolean(partes[2]);

                // Criar o objeto cadastro
                Cadastro c = new Cadastro(usuario, senha, verificado);

                // Adiciona na lista
                lista.add(c);

                // Imprimir informações do cadastro
                System.out.format("Nome do usuário: %s - Senha: %s - Verificado: %b\n", usuario, senha, verificado);

            }

            leitor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
