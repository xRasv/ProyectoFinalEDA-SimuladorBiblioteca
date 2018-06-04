
package labfinaleda;

/**
 *
 * @author Brian Rivera y Rudy Sanchez
 */

public class AbbLT {
    private class nodoArbol {
        private AbbLT hd;
        private AbbLT hi;
        private Libro dato;
 
        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = null;
        }
    }
 
    public nodoArbol raiz;
 
    public static boolean bool (int b){
        return b == 1;
    }
    public void abb(){
        nodoArbol raiz = new nodoArbol();
    }
 
    public boolean esVacio(){
        return (raiz == null);
    }
 
    public void insertar(Libro a){
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hd = new AbbLT();
            nuevo.hi = new AbbLT();
            raiz = nuevo;
        }
        else {
            String s1 = a.titulo;
            String s2 = raiz.dato.titulo;
            boolean b = bool(s1.compareTo(s2));
            if (b) {
                (raiz.hd).insertar(a);
            }
            else{
                (raiz.hi).insertar(a);
            }
        }
    }
 

    public void recorrer(){
        if (!esVacio()) {
            raiz.hi.recorrer();
            raiz.dato.imprimir();
            raiz.hd.recorrer();
        }
    }
 
    public Libro buscar(Libro a){
        if (!esVacio()) {
            
            if (a.titulo.equals(raiz.dato.titulo)) {
            return this.raiz.dato;
            }
            else {
                String s1 = a.titulo;
                String s2 = raiz.dato.titulo;
                boolean b = bool(s1.compareTo(s2));
                if (!b) {
                   return(raiz.hi.buscar(a));
                }
                else {
                    return(raiz.hd.buscar(a));
                }
            }
        }
        return null;
    }
 
    public boolean existe(Libro a){
    if (!esVacio()) {
            if (a.titulo.equals(raiz.dato.titulo)) {
            return true;
            }
            else {
                String s1 = a.titulo;
                String s2 = raiz.dato.titulo;
                boolean b = bool(s1.compareTo(s2));
                if (!b) {
                    raiz.hi.existe(a);
                } else {
                    raiz.hd.existe(a);
                }
            }
        }
        return false;
    }
 
}
