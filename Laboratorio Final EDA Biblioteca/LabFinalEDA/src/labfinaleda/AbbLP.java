
package labfinaleda;

/**
 *
 * @author Brian Rivera y Rudy Sanchez
 */

public class AbbLP {
    private class nodoArbol {
        private AbbLP hd;
        private AbbLP hi;
        private Libro dato;
 
        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = null;
        }
    }
 
    public nodoArbol raiz;
 
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
            nuevo.hd = new AbbLP();
            nuevo.hi = new AbbLP();
            raiz = nuevo;
        }
        else {
            if (a.nPalabras > raiz.dato.nPalabras) {
                (raiz.hd).insertar(a);
            }
            if (a.nPalabras < raiz.dato.nPalabras){
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
 
    public Libro buscar(int a){
        if (!esVacio()) {
            if (a == raiz.dato.nPalabras) {
            return this.raiz.dato;
            }
            else {
                if (a < raiz.dato.nPalabras) {
                   return(raiz.hi.buscar(a));
                }
                else {
                    return(raiz.hd.buscar(a));
                }
            }
        }
        return null;
    }
 
    public boolean existe(int a){
    if (!esVacio()) {
            if (a == raiz.dato.nPalabras) {
            return true;
            }
            else {
                if (a < raiz.dato.nPalabras) {
                    raiz.hi.existe(a);
                }
                else {
                    raiz.hd.existe(a);
                }
            }
        }
        return false;
    }
 
}
