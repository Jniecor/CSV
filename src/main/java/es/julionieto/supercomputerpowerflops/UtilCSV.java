package es.julionieto.supercomputerpowerflops;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.scene.control.Label;

public class UtilCSV {
    
    static String textoLinea;
    static String textoTodo = "";
    
    public static void leerTodoCSV(Label labelTexto){
        
        String nombreFichero = "supercomputer-power-flops.csv";
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            textoLinea = br.readLine();
            // Repetir mientras no se llegue al final del fichero
            while(textoLinea != null) {
                String valores[] = textoLinea.split(",");
                String entity = valores[0];
                String year = valores[1];
                String edad = valores[2];
                String operationsPerSecond = valores[3];
                System.out.println(textoLinea);
                textoLinea = br.readLine();
            }
        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    
    }
    
    public static void leerDistintosCSV(Label labelTexto){
        
        String nombreFichero = "supercomputer-power-flops.csv";
        int contador = 0;
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            textoLinea = br.readLine();
            String operationsPerSecondOld = "";
            // Repetir mientras no se llegue al final del fichero
            while(textoLinea != null) {
                String valores[] = textoLinea.split(",");
                String entity = valores[0];
                String year = valores[1];
                String edad = valores[2];
                String operationsPerSecond = valores[3];
                if(1 >= contador){
                    System.out.println(textoLinea);
                    textoTodo+= "\n"+textoLinea;
                    labelTexto.setText(textoTodo);
                    // Leer la siguiente línea
                    textoLinea = br.readLine();
                }
                if(1 < contador){
                    //Entra en el igual pero no en el distinto
                    if (operationsPerSecond.equals(operationsPerSecondOld)){
                        // Leer la siguiente línea
                        textoLinea = br.readLine();
                    }
                    if (!operationsPerSecond.equals(operationsPerSecondOld)){
                        System.out.println(textoLinea);
                        textoTodo+= "\n"+textoLinea;
                        labelTexto.setText(textoTodo);
                        // Leer la siguiente línea
                        textoLinea = br.readLine();
                    }
                }
                operationsPerSecondOld = operationsPerSecond;
                contador++;
            }
        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    
    }
    
    public static void escribirCSV(){
    
        String nombreFichero = "resultado.csv";
        String texto = "Texto de prueba";
        BufferedWriter bw = null;
        try {
            //Crear un objeto BufferedWriter. Si ya existe el fichero, 
            //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
            //Escribir en el fichero el texto con un salto de línea
            bw.write(texto + "\n");
        }
        // Comprobar si se ha producido algún error
        catch(Exception ex) {
           System.out.println("Error de escritura del fichero");
           ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(bw != null)
                    bw.close();
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    
    }
}
