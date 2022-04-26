package es.julionieto.supercomputerpowerflops;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    
    static Label labelTexto = new Label();
    SupercomputerPowerFlop supercomputerPowerFlop;
    SupercomputerPowerFlops supercomputerPowerFlops;
    static ArrayList<String> yearList = new ArrayList();
//    static TableView tableView = new TableView();
    
    
    @Override
    public void start(Stage stage) {
        
//        ScrollBar vertical = new ScrollBar();
//        vertical.setOrientation(Orientation.VERTICAL);
//        vertical.setMin(0);
//        vertical.setMax(50/*supercomputerPowerFlops.getSupercomputerPowerFlops().size())*/);
//        vertical.setVisibleAmount(10);
        VBox root = new VBox();
//        HBox root = new HBox(root2, vertical);
        root.setAlignment(Pos.TOP_CENTER);
        root.setSpacing(10);
//        root.setAlignment(Pos.TOP_CENTER);
//        root.setSpacing(10);
        var scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Procesamiento CSV");
        stage.show();        
        
//        SupercomputerPowerFlop supercomputerPowerFlop = new SupercomputerPowerFlop(entity, code, year, floatingPointOperationsPerSecond);
        
        Label labelTitulo = new Label("Operaciones de coma flotante por segundo (1993-2021)");
        labelTitulo.setFont((new Font("Liberation Serif", 22)));
        labelTitulo.setStyle("-fx-font-weight: bold");
        root.getChildren().add(labelTitulo);
//        TableColumn entity = new TableColumn("Entity");
//        entity.setCellValueFactory(new PropertyValueFactory());
//        TableColumn code = new TableColumn("Code");
//        TableColumn year = new TableColumn("Year");
//        TableColumn floatingPointOperationsPerSecond = new TableColumn("Floating-Point Operations per Second");        
//        tableView.getColumns().addAll(entity, code, year, floatingPointOperationsPerSecond);
//        root2.getChildren().add(tableView);     
        labelTexto.setFont((new Font("Liberation Serif", 16)));
        root.getChildren().add(labelTexto);
        
//        vertical.valueProperty().addListener(new ChangeListener<Number>() {
//            public void changed(ObservableValue<? extends Number> ov,
//                Number old_val, Number new_val) {
//                    labelTexto.setLayoutY(new_val.doubleValue());
//            }
//        });
        
        final Button botonMostrarTodo = new Button("Mostrar todo");
        root.getChildren().add(botonMostrarTodo);
        botonMostrarTodo.setOnAction((t) -> {
            UtilCSV.leerTodoCSV(labelTexto);
        });
        
        CheckBox cbMostrarDistintos = new CheckBox("Mostrar distintos");
        root.getChildren().add(cbMostrarDistintos);
        cbMostrarDistintos.setOnAction((t) -> {
            if(cbMostrarDistintos.isSelected()) {
                UtilCSV.leerDistintosCSV(labelTexto);
            } else {
                UtilCSV.leerTodoCSV(labelTexto);     
            }
        });
        
        // Crear un ComboBox con el contenido de la lista
        ComboBox<String> comboBox = new ComboBox(FXCollections.observableList(yearList));
        root.getChildren().add(comboBox);
        // Cuando el usuario seleccione algo del ComboBox, se mostrará en el Label
        comboBox.setOnAction((t) -> {
            int yearInt = 1992;
            for (int i = yearInt; i<2022; i++){
                if (yearInt == 1992){
                    yearList.add("Todos");
                    yearInt++;
                }
                yearList.add(String.valueOf(i));
            }
//            UtilCSV.comboBoxCSV(labelTexto);
            labelTexto.setText(comboBox.getValue());
        });
        
    }

    public static void main(String[] args) {
        launch();
    }

}