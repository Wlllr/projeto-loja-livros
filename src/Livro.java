public class Livro {
    int codigo;
    String titulo;
    String autor;
    double preco;
    String tipo;

    //metodo (servico ou funcao)
   void imprimirDados() {
       System.out.println(
               "Livro: " + codigo +
               " Titullo: " + titulo +
               " Autor: " + autor +
               " Tipo: " + tipo +
               " Preco: " + preco);
   }
}
