import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    ArrayList<Livro> lista = new ArrayList<>();

    // construtor
    Gerenciador() throws IOException {
        //ler as linhas
        List<String> linhas = Files.readAllLines(Path.of("dados/livros.txt"));

        //quebrar as linhas e criar um novo objeto com "as partes"

        for (String cadaLinha : linhas) {

            String[] partes = cadaLinha.split(";");

            Livro novo = new Livro();

            novo.codigo = Integer.parseInt(partes[0]);
            novo.titulo = partes[1];
            novo.autor = partes[2];
            novo.tipo = partes[3];
            novo.preco = Double.parseDouble(partes[4]);

            //com o objeto criado, adicionar na ED Lista
            lista.add(novo);
        }
    }

    void adicionarLivro(int cod, String tit, String autor, String tipo, double preco) {
        // ver se livro ja existe?
        for (Livro cadaLivro : lista) { // lista == ArrayList<Livro>
            if ( cadaLivro.codigo == cod) {
                return; //saia do servico
            }
        }
        // senao, criar um objeto novo com os dados recebidos
        Livro novo = new Livro();

        novo.codigo = cod;
        novo.titulo = tit;
        novo.autor = autor;
        novo.tipo = tipo;
        novo.preco = preco;
        // adicionar este novo objeto na lista
        lista.add(novo);
    }

    boolean removerLivro(int cod){
        //verificar se existe
        for(Livro cadaLivro : lista){
            if (cadaLivro.codigo == cod){ //Achei!
                lista.remove(cadaLivro);
                return true;
            }
        }
        //senao existir, retorna false!
        return false;
    }

    int quantidadeLivros(){
        return lista.size();
    }

    Livro buscarLivro(int cod){
        for (Livro cadaLivro : lista ){ //percore a lista de livros
            if ( cadaLivro.codigo == cod ){
                return cadaLivro; //retorna o livro
            }
        }
        return null; // nao achei
    }

    public void imprimirTodosLivros() {
        for (Livro cadaLivro : lista){
            cadaLivro.imprimirDados();
        }
    }
}
