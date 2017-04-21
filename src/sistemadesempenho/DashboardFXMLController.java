/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadesempenho;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * 
 * 
 * 
 * FXML Controller class
 *
 * @author Ariel
 */
public class DashboardFXMLController extends InterfaceUsuario {

    public DashboardFXMLController(){
        super("DashboardFXML.fxml");
    }
    
    @FXML
    private Button minhasAvaliacoes, meuDesempenho;
    
    @FXML
    private AnchorPane elementoRaiz;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML 
    public void irParaMinhasAvaliacoes() throws IOException {
        
        MinhasAvaliacoesFXMLController telaMinhasAvaliacoes = new MinhasAvaliacoesFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(telaMinhasAvaliacoes);

    }
    
    @FXML
    public void irParaMeuDesempenho() throws IOException {
       
        MeuDesempenhoFXMLController telaMeuDesempenho = new MeuDesempenhoFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(telaMeuDesempenho);
    }
}

