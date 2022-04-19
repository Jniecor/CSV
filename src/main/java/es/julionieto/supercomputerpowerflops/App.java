package es.julionieto.supercomputerpowerflops;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(50);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Procesamiento CSV");
        stage.show();
        
        
        SupercomputerPowerFlops supercomputerPowerFlops = new SupercomputerPowerFlops();
        
        Label labelTitulo = new Label("Procesamiento CSV");
        labelTitulo.setFont((new Font("Liberation Serif", 22)));
        labelTitulo.setStyle("-fx-font-weight: bold");
        root.getChildren().add(labelTitulo);
        
        Label labelTexto = new Label();
        labelTexto.setFont((new Font("Liberation Serif", 22)));
        labelTexto.setStyle("-fx-font-weight: bold");
        root.getChildren().add(labelTexto);
        
        final Button botonMostrar = new Button("Mostrar todo");
        root.getChildren().add(botonMostrar);
        botonMostrar.setOnAction((t) -> {
            UtilCSV.leerCSV();
            labelTexto.setText(UtilCSV.texto);
        });
        
        
    }

    public static void main(String[] args) {
        launch();
    }

}