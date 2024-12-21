import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Path.of;

public class Gerenciador {
    ArrayList<Livro> listaDeLivros = new ArrayList<>();

    // construtor
    Gerenciador() throws IOException {
        //carrega os livros
        var cargaDeLivros = readAllLines(of("dados/livros.txt"));
        //percorre as linhas
        construirListaLivros(cargaDeLivros);
    }

    private void construirListaLivros(List<String> fromCargaDeLivros) {
        for (String cadaLinha : fromCargaDeLivros) {
            var livro = criaLivro(cadaLinha);
            //com o objeto criado, adicionar na ED Lista
            listaDeLivros.add(livro);
        }
    }

    private static Livro criaLivro(String fromCadaLinha) {
        //quebrar as linhas e criar um novo objeto com "as partes"
        var arrayPartesLivro = fromCadaLinha.split(";");
        return criaLivro(arrayPartesLivro);
    }

    private static Livro criaLivro(String[] fromArrayPartesLivro) {
        return new Livro(
                parseInt(fromArrayPartesLivro[0]),
                fromArrayPartesLivro[1],
                fromArrayPartesLivro[2],
                fromArrayPartesLivro[3],
                parseDouble(fromArrayPartesLivro[4]));
    }

    void adicionarLivro(int cod, String tit, String autor, String tipo, double preco) {
        // ver se livro ja existe?
        if (verficiarExistenciaLivro(cod)) return;
        listaDeLivros.add(new Livro(cod, tit, autor, tipo, preco));
    }

    private boolean verficiarExistenciaLivro(int cod) {
        for (Livro cadaLivro : listaDeLivros) { // lista == ArrayList<Livro>
            if ( cadaLivro.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    private void removerLivro(Livro cadaLivro) {
        listaDeLivros.remove(cadaLivro);
    }

    boolean percorrerParaRemocao(int cod){
        //verificar se existe
        for (Livro cadaLivro : listaDeLivros) {
            if (cadaLivro.getCodigo() == cod) {
                removerLivro(cadaLivro);
                return true;
            }
        }
        return false;
    }

    int quantidadeLivros(){
        return listaDeLivros.size();
    }

    Livro buscarLivro(int cod){
        for (Livro cadaLivro : listaDeLivros){ //percore a lista de livros
            if ( cadaLivro.getCodigo() == cod ){
                return cadaLivro; //retorna o livro
            }
        }
        return null; // nao achei
    }

    public void imprimirTodosLivros() {
        for (Livro cadaLivro : listaDeLivros){
            cadaLivro.imprimirDados();
        }
    }
}
