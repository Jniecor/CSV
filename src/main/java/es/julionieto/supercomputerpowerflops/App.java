package es.julionieto.supercomputerpowerflops;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    
    static Label labelTexto = new Label();
    
    @Override
    public void start(Stage stage) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(10);
        var scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Procesamiento CSV");
        stage.show();        
        
        SupercomputerPowerFlops supercomputerPowerFlops = new SupercomputerPowerFlops();
        
        Label labelTitulo = new Label("Operaciones de coma flotante por segundo (1993-2021)");
        labelTitulo.setFont((new Font("Liberation Serif", 22)));
        labelTitulo.setStyle("-fx-font-weight: bold");
        root.getChildren().add(labelTitulo);
        labelTexto.setFont((new Font("Liberation Serif", 18)));
        root.getChildren().add(labelTexto);
        
        final Button botonMostrarDistintos = new Button("Mostrar todo");
        root.getChildren().add(botonMostrarDistintos);
        botonMostrarDistintos.setOnAction((t) -> {
            UtilCSV.leerDistintosCSV(labelTexto);
        });
        
        ArrayList<String> yearList = new ArrayList();
//        yearList.add("Años");
        int yearInt = 1993;
        for (int i = yearInt; i<2022; i++){
            yearList.add(String.valueOf(i));
        }
        
        // Crear un ComboBox con el contenido de la lista
        ComboBox<String> comboBox = new ComboBox(FXCollections.observableList(yearList));
        root.getChildren().add(comboBox);
        // Cuando el usuario seleccione algo del ComboBox, se mostrará en el Label
        comboBox.setOnAction((t) -> {
            labelTexto.setText(comboBox.getValue());
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}