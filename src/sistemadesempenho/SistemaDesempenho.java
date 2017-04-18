/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package sistemadesempenho;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Ariel
 */
public class SistemaDesempenho extends Application{
    
    @Override
    public void start(Stage palco) throws Exception {
      
        DashboardFXMLController telaDashboard = new DashboardFXMLController();
        GerenciadorJanela.obterInstancia().inicializaPalco(palco, telaDashboard);
                
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
}
