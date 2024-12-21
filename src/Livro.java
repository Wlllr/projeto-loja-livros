public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private double preco;
    private String tipo;

    //metodo (servico ou funcao)
   void imprimirDados() {
       System.out.println(
               "Livro: " + getCodigo() +
               " Titullo: " + getTitulo() +
               " Autor: " + getAutor() +
               " Tipo: " + getTipo() +
               " Preco: " + getPreco());
   }


    public Livro(int codigo, String titulo, String autor, String tipo, double preco) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
