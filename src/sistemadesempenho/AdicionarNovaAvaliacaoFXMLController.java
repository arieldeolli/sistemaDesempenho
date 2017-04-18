/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadesempenho;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Ariel
 */
public class AdicionarNovaAvaliacaoFXMLController extends InterfaceUsuario {
    
    public AdicionarNovaAvaliacaoFXMLController(){
        super("AdicionarNovaAvaliacaoFXML.fxml");
    }
    
      @FXML
    private AnchorPane elementoRaiz;

    @FXML
    private TextField campoNome, campoPeso;

    @FXML
    private ChoiceBox<String> campoDisciplina, campoMedia;

    @FXML
    private Button voltaTela2, salvaTela5;
    
    ObservableList<String> listaDisciplinas = FXCollections.observableArrayList("ÉTICA EM INFORMÁTICA (1º período)", "MATEMÁTICA COMPUTACIONAL (1º período)", "ALGORITMOS E PROGRAMAÇÃO (1º período)", "ÁLGEBRA (1º período)", "INTRODUÇÃO AO CÁLCULO (1º período)", "INICIAÇÃO TÉCNICO-CIENTÍFICA (1º período)", "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO (1º período)", "INTRODUÇÃO À FÍSICA (1º período)",
    "CÁLCULO (2º período)", "ALGORITMOS E PROGRAMAÇÃO (2º período)", "CIRCUITOS DIGITAIS (2º período)", "DESENHO TÉCNICO (2º período)", "FÍSICA GERAL (2º período)", "ÁLGEBRA (2º período)", "CÁLCULO (3º período)", "ESTRUTURAS DE DADOS (3º período)", "PROGRAMAÇÃO ORIENTADA A OBJETOS (3º período)", "ARQUITETURA DE COMPUTADORES (3º período)", "FÍSICA (3º período)", "QUÍMICA (3º período)", "ARQUITETURA DE COMPUTADORES (3º período)", 
    "PROGRAMAÇÃO ORIENTADA A OBJETOS (4º período)", "CÁLCULO (4º período)", "ANÁLISE DE CIRCUITOS ELÉTRICOS (4º período)", "QUÍMICA (4º período)", "ÓTICA E FÍSICA PARA SEMICONDUTORES (4º período)", "RESISTÊNCIA DOS MATERIAIS (4º período)", "BANCO DE DADOS (5º período)", "SISTEMAS OPERACIONAIS (5º período)", "MATEMÁTICA APLICADA À ENGENHARIA (5º período)", "ENGENHARIA DE SOFTWARE (5º período)",
    "PROBABILIDADE E ESTATÍSTICA (5º período)", "ELETRÔNICA BÁSICA (5º período)", "INTERFACE HUMANO - COMPUTADOR (5º período)", "ENGENHARIA DE SOFTWARE (6º período)", "REDES DE COMPUTADORES (6º período)", "CÁLCULO NUMERICO (6º período)", "LINGUAGENS FORMAIS (6º período)", "ELETRÔNICA APLICADA (6º período)", "ANÁLISE E CONTROLE DE PROCESSOS (6º período)", "ENGENHARIA ECONÔMICA (7º período)", "REDES DE COMPUTADORES (7º período)",
    "GRAFOS (7º período)", "CONTROLE LÓGICO DE SISTEMAS (7º período)", "MICROCONTROLADORES (7º período)", "PROJETO DE SISTEMAS DIGITAIS (7º período)", "INTELIGÊNCIA ARTIFICIAL (8º período)", "TRABALHO TÉC.-CIENTÍF.DE CONCLUSÃO DE CURSO (8º período)", "PROJETO DE SISTEMAS EMBARCADOS (8º período)", "SISTEMAS EM TEMPO REAL (8º período)", "[8]COMUNICAÇÃO DIGITAL", "PROCESSADOR DIGITAL DE SINAIS (8º período)",
    "SISTEMAS ROBÓTICOS (8º período)", "SIMULAÇÃO DISCRETA (9º período)", "GERÊNCIA DE PROJETOS (9º período)", "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO (9º período)", "TÓPICOS ESPECIAIS EM HARDWARE (9º período)", "TRABALHO TÉC-CIENTÍF. DE CONCLUSÃO DE CURSO (9º período)", "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA (10º período)", "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE (10º período)",
    "TRABALHO TÉC-CIENTÍFICO DE CONCLUSÃO DE CURSO (10º período)", "SISTEMAS DISTRIBUÍDOS (10º período)"
    );
   
    ObservableList<String> listaMedias = FXCollections.observableArrayList("M1", "M2", "M3");
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        campoDisciplina.setValue("[1]INTRODUÇÃO À FÍSICA");
        campoDisciplina.setItems(listaDisciplinas);
        
        campoMedia.setValue("M1");
        campoMedia.setItems(listaMedias);
    }    
       
    @FXML 
    public void voltarParaMinhasAvaliacoes() throws IOException {        
        GerenciadorJanela.obterInstancia().voltar();      
    }
     
    @FXML
    private boolean valida(){
        if("".equals(campoNome.getText())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO NOME VAZIO!!!");
            dialogoErro.setContentText("É necessário nomear a prova");
            dialogoErro.showAndWait();
            return false;
        }
        if("".equals(campoDisciplina.getValue())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO DISCIPLINA VAZIO!!!");
            dialogoErro.setContentText("É necessário nomear a disciplina");
            dialogoErro.showAndWait();
            return false;
        }
        if("".equals(campoMedia.getValue())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO MEDIA VAZIO!!!");
            dialogoErro.setContentText("É necessário nomear a prova");
            dialogoErro.showAndWait();
            return false;
        }
        if("".equals(campoPeso.getText())){
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("Erro");
            dialogoErro.setHeaderText("CAMPO PESO VAZIO!!!");
            dialogoErro.setContentText("É necessário dar peso à prova");
            dialogoErro.showAndWait();
            return false;
        }
        return true;            
    } 
    
    @FXML
    private void salvarProva() throws IOException{   
        if(valida()){
        Avaliacao meuObj = new Avaliacao();
        meuObj.setNome(campoNome.getText());
        meuObj.setDisciplina(campoDisciplina.getValue());
        meuObj.setMedia(campoMedia.getValue().toCharArray());
        meuObj.setPeso(Double.parseDouble(campoPeso.getText()));
        
        meuObj.salvar();
        }
    }
        
}
