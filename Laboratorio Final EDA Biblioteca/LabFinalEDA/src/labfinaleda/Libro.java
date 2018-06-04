
package labfinaleda;


public class Libro {
    
    public Libro(String ntitulo, String nautor, long nnPalabras){
        this.titulo = ntitulo;
        this.autor = nautor;
        this.nPalabras = nnPalabras;
    }
    public String titulo;
    public String autor;
    public long nPalabras;
    public String ruta;
    public void imprimir(){
        System.out.println("Título: " + this.titulo + " | Autor: " + this.autor + " | Número de palabras: " + this.nPalabras);
    }
}

