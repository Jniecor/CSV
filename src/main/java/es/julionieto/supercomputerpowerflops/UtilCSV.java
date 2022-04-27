package es.julionieto.supercomputerpowerflops;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class UtilCSV {
    
    static String textoLinea;
    static SupercomputerPowerFlops supercomputerPowerFlops = new SupercomputerPowerFlops();
    
    public static void leerTodoCSV(TableView tableView){
        String nombreFichero = "supercomputer-power-flops.csv";
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            textoLinea = br.readLine();
            textoLinea = br.readLine();
            // Repetir mientras no se llegue al final del fichero
            while(textoLinea != null) {
                String valores[] = textoLinea.split(",");
                SupercomputerPowerFlop supercomputerPowerFlop = new SupercomputerPowerFlop(valores[0],valores[1],Integer.valueOf(valores[2]),Long.valueOf(valores[3]));
                supercomputerPowerFlop.setEntity(valores[0]);
                supercomputerPowerFlop.setCode(valores[1]);
                supercomputerPowerFlop.setYear(Integer.valueOf(valores[2]));
                supercomputerPowerFlop.setFloatingPointOperationsPerSecond(Long.valueOf(valores[3]));
                supercomputerPowerFlops.getSupercomputerPowerFlops().add(supercomputerPowerFlop);
                //Crear lista;
                System.out.println(textoLinea);
                textoLinea = br.readLine();
            }
            ObservableList<SupercomputerPowerFlop> data = FXCollections.observableArrayList(supercomputerPowerFlops.getSupercomputerPowerFlops());
            tableView.setItems(data);
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
    
    public static void leerDistintosCSV(TableView tableView){
        textoLinea="";
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
            textoLinea = br.readLine();
            String operationsPerSecondOld = "";
            // Repetir mientras no se llegue al final del fichero
            while(textoLinea != null) {
                String valores[] = textoLinea.split(",");
                SupercomputerPowerFlop supercomputerPowerFlop = new SupercomputerPowerFlop(valores[0],valores[1],Integer.valueOf(valores[2]),Long.valueOf(valores[3]));
                supercomputerPowerFlop.setEntity(valores[0]);
                supercomputerPowerFlop.setCode(valores[1]);
                supercomputerPowerFlop.setYear(Integer.valueOf(valores[2]));
                supercomputerPowerFlop.setFloatingPointOperationsPerSecond(Long.valueOf(valores[3]));
                SupercomputerPowerFlops supercomputerPowerFlops = new SupercomputerPowerFlops();
                supercomputerPowerFlops.getSupercomputerPowerFlops().add(supercomputerPowerFlop);
                if(1 >= contador){
                    System.out.println(textoLinea);
                    textoTodo+= "\n"+textoLinea;
                    labelTexto.setText(textoTodo);
                    // Leer la siguiente línea
                    textoLinea = br.readLine();
                }
                if(1 < contador){
                    //Entra en el igual pero no en el distinto
                    if (String.valueOf(supercomputerPowerFlop.getFloatingPointOperationsPerSecond()).equals(operationsPerSecondOld)/*operationsPerSecond.equals(operationsPerSecondOld)*/){
                        // Leer la siguiente línea
                        textoLinea = br.readLine();
                    }
                    if (!String.valueOf(supercomputerPowerFlop.getFloatingPointOperationsPerSecond()).equals(operationsPerSecondOld)){
                        System.out.println(textoLinea);
                        textoTodo+= "\n"+textoLinea;
                        labelTexto.setText(textoTodo);
                        // Leer la siguiente línea
                        textoLinea = br.readLine();
                    }
                }
                operationsPerSecondOld = String.valueOf(supercomputerPowerFlop.getFloatingPointOperationsPerSecond());
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
    
    public static void comboBoxCSV(Label labelTexto){
        
        
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
