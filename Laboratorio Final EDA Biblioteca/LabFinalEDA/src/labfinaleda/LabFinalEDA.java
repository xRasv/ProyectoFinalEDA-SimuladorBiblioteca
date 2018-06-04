
package labfinaleda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

class LabFinalEDA {

       public static void main(String[] args) {
        System.out.println("Proyecto Final Estructura de Datos y Algoritmo");
        System.out.println("Rudy Sánchez y Brian Rivera");
        System.out.println("Los libros a cargar deben cumplir las siguientes características:");
        System.out.println("  - Deben ser archivos txt");
        System.out.println("  - La primer linea debe ser el titulo del libro");
        System.out.println("  - La primer linea debe ser el nombre del autor");
        System.out.println("***** SIMULADOR DE BIBLIOTECA *****");
        AbbLP arbolP = new AbbLP(); //Arbol ordenado por numero de palabras
        AbbLA arbolA = new AbbLA(); //Arbol ordenado por autor alfabeticamente
        AbbLT arbolT = new AbbLT(); //Arbol ordenado por titulo alfabeticamente      
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("");
            System.out.println("¿Qué desea hacer a continuación? Ingrese el número de su opción y oprima la tecla enter.");
            System.out.println("     1. Ingresar un nuevo libro.");
            System.out.println("     2. Desplegar lista de libros ordenados por número de palabras.");
            System.out.println("     3. Desplegar lista de libros ordenados alfabéticamente por su título.");
            System.out.println("     4. Desplegar lista de libros ordenados alfabéticamente por su autor.");
            System.out.println("     5. Salir.");
            Scanner scan = new Scanner(System.in);
            opcion = scan.nextInt();
            
            switch (opcion) {
                case 1: //Ingresar un nuevo libro
                    String ruta = null;
                    long filas = 0;

                    try {
                        //Crea un objeto de selección de archivo
                        JFileChooser fc = new JFileChooser();
                        //Establece el título para la selección del archivo
                        fc.setDialogTitle("Seleccione el archivo TXT del libro que desea cargar.");
                        //Establece la extensión a utilizar
                        fc.setFileFilter(new FileNameExtensionFilter("Archivo TXT", "txt"));

                        int seleccion = fc.showDialog(null, "Abrir!");

                        switch (seleccion) {
                            //Si el usuario abre el archivo, recolecta la ruta del mismo y lo guarda en la variable ruta, para su posterior uso
                            case JFileChooser.APPROVE_OPTION:
                                File archivo = fc.getSelectedFile();
                                ruta = archivo.getPath();
                                break;
                            //Si el usuario cancela, le tirará el mensaje que debe elegir un archivo válido
                            case JFileChooser.CANCEL_OPTION:
                                System.out.println("Porfavor seleccione un archivo TXT válido");
                                break;

                            case JFileChooser.ERROR_OPTION:
                                System.out.println("Porfavor seleccione un archivo TXT válido");
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // Empezamos a leer el archivo txt linea por linea y almacenando el numero de palabras
                    String line = null;
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(ruta));
                        int contPalabras = 0;
                        String nTitulo  = reader.readLine();
                        String nAutor = reader.readLine();
                        while ((line = reader.readLine()) != null) {
                            List<String> arrLine = Arrays.asList(line.split("\\s"));
                            contPalabras = contPalabras + arrLine.size();
                        }
                        Libro libro = new Libro(nTitulo, nAutor, contPalabras);
                        arbolP.insertar(libro);
                        arbolA.insertar(libro);
                        arbolT.insertar(libro);
                    } catch (Exception e) {
                        System.out.println("");
                    }
                    break;

                case 2:
                    arbolP.recorrer();
                    break;

                case 3:
                    arbolA.recorrer();
                    break;
                    
                case 4:
                    arbolT.recorrer();
                    break;

                default:
                    System.out.println("Elija una opción correcta");
            }

        }
    }

}
