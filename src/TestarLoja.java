import java.io.IOException;

public class TestarLoja {
    public static void main(String[] args) throws IOException {
        Gerenciador gerenciador = new Gerenciador(); // 10 livros
        gerenciador.adicionarLivro(88,"Python", "David Silva","ebook",12.99);
        gerenciador.adicionarLivro(89, "Corte de Espinhos e Rosas", "Rayane", "ebook", 10.00);
        boolean resultado = gerenciador.percorrerParaRemocao(41);
        int quantidade = gerenciador.quantidadeLivros();

        Livro encontrado = gerenciador.buscarLivro(88); //retorna o livro ou null
        System.out.println("Livro: " + encontrado);

        gerenciador.imprimirTodosLivros();
    }
}
