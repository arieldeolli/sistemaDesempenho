/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadesempenho;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ariel
 */
public class MinhasAvaliacoesFXMLController extends InterfaceUsuario{

    public MinhasAvaliacoesFXMLController(){
        super("MinhasAvaliacoesFXML.fxml");
    }    
    
    @FXML
    private Button informaNota, adicionaAvaliacao, voltaTela1;
    
    @FXML
    private TableView<Avaliacao> tabela;
        
    @FXML
    private TableColumn colNome, colDisc, colMedia, colPeso, colNota;
    
    @FXML
    private AnchorPane elementoRaiz;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Avaliacao> conteudo = FXCollections.observableArrayList(Avaliacao.obterListaAvaliacoes());              
        tabela.setItems(conteudo);
        
        colNome.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("nome"));
        colDisc.setCellValueFactory(new PropertyValueFactory<Avaliacao, String>("disciplina"));
        colMedia.setCellValueFactory(new PropertyValueFactory<Avaliacao, Character[]>("media"));
        colPeso.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("peso"));
        colNota.setCellValueFactory(new PropertyValueFactory<Avaliacao, Double>("nota"));
        
    }
    
    @FXML
    public void irParaInformarNota() throws IOException {
        if(tabela.getItems().isEmpty() == false){
            if(Avaliacao.obterListaAvaliacoes().get(tabela.getSelectionModel().getSelectedItem().getIdentificadorNoArquivo()).getNota()!=null){
                Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
                dialogoErro.setTitle("Erro");
                dialogoErro.setHeaderText("A nota dessa avaliação já foi informada!!!");
                dialogoErro.setContentText("informe a nota para outra avaliação");
                dialogoErro.showAndWait();
            }else{
                GerenciadorJanela.setIdentificador(tabela.getSelectionModel().getSelectedItem().getIdentificadorNoArquivo());
                InformarNotaFXMLController tela4 = new InformarNotaFXMLController();
                GerenciadorJanela.obterInstancia().abreJanela(tela4);
            }
        }else{
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("Não há prova cadastradas!!!");
            dialogoErro.setContentText("adicione uma prova antes de inserir uma nota");
            dialogoErro.showAndWait();
        }
        
    }
    
    @FXML
    public void irParaAdicionarNovaAvaliacao() throws IOException {
        
        AdicionarNovaAvaliacaoFXMLController telaNovaAvaliacaoFXMLController = new AdicionarNovaAvaliacaoFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(telaNovaAvaliacaoFXMLController);      
    }
    
    @FXML 
    public void voltarParaDashboard() throws IOException {
        
        GerenciadorJanela.obterInstancia().voltar();
    }
}

