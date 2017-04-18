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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ariel
 */
public class MeuDesempenhoFXMLController extends InterfaceUsuario{

     public MeuDesempenhoFXMLController(){
        super("MeuDesempenhoFXML.fxml");
    }
    
    @FXML
    private AnchorPane elementoRaiz;
    
    @FXML
    private BarChart<?, ?> tabela;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
  
    String listaDisciplinas[] = {"ÉTICA EM INFORMÁTICA (1º período)", "MATEMÁTICA COMPUTACIONAL (1º período)", "ALGORITMOS E PROGRAMAÇÃO (1º período)", "ÁLGEBRA (1º período)", "INTRODUÇÃO AO CÁLCULO (1º período)", "INICIAÇÃO TÉCNICO-CIENTÍFICA (1º período)", "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO (1º período)", "INTRODUÇÃO À FÍSICA (1º período)",
    "CÁLCULO (2º período)", "ALGORITMOS E PROGRAMAÇÃO (2º período)", "CIRCUITOS DIGITAIS (2º período)", "DESENHO TÉCNICO (2º período)", "FÍSICA GERAL (2º período)", "ÁLGEBRA (2º período)", "CÁLCULO (3º período)", "ESTRUTURAS DE DADOS (3º período)", "PROGRAMAÇÃO ORIENTADA A OBJETOS (3º período)", "ARQUITETURA DE COMPUTADORES (3º período)", "FÍSICA (3º período)", "QUÍMICA (3º período)", "ARQUITETURA DE COMPUTADORES (3º período)", 
    "PROGRAMAÇÃO ORIENTADA A OBJETOS (4º período)", "CÁLCULO (4º período)", "ANÁLISE DE CIRCUITOS ELÉTRICOS (4º período)", "QUÍMICA (4º período)", "ÓTICA E FÍSICA PARA SEMICONDUTORES (4º período)", "RESISTÊNCIA DOS MATERIAIS (4º período)", "BANCO DE DADOS (5º período)", "SISTEMAS OPERACIONAIS (5º período)", "MATEMÁTICA APLICADA À ENGENHARIA (5º período)", "ENGENHARIA DE SOFTWARE (5º período)",
    "PROBABILIDADE E ESTATÍSTICA (5º período)", "ELETRÔNICA BÁSICA (5º período)", "INTERFACE HUMANO - COMPUTADOR (5º período)", "ENGENHARIA DE SOFTWARE (6º período)", "REDES DE COMPUTADORES (6º período)", "CÁLCULO NUMERICO (6º período)", "LINGUAGENS FORMAIS (6º período)", "ELETRÔNICA APLICADA (6º período)", "ANÁLISE E CONTROLE DE PROCESSOS (6º período)", "ENGENHARIA ECONÔMICA (7º período)", "REDES DE COMPUTADORES (7º período)",
    "GRAFOS (7º período)", "CONTROLE LÓGICO DE SISTEMAS (7º período)", "MICROCONTROLADORES (7º período)", "PROJETO DE SISTEMAS DIGITAIS (7º período)", "INTELIGÊNCIA ARTIFICIAL (8º período)", "TRABALHO TÉC.-CIENTÍF.DE CONCLUSÃO DE CURSO (8º período)", "PROJETO DE SISTEMAS EMBARCADOS (8º período)", "SISTEMAS EM TEMPO REAL (8º período)", "[8]COMUNICAÇÃO DIGITAL", "PROCESSADOR DIGITAL DE SINAIS (8º período)",
    "SISTEMAS ROBÓTICOS (8º período)", "SIMULAÇÃO DISCRETA (9º período)", "GERÊNCIA DE PROJETOS (9º período)", "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO (9º período)", "TÓPICOS ESPECIAIS EM HARDWARE (9º período)", "TRABALHO TÉC-CIENTÍF. DE CONCLUSÃO DE CURSO (9º período)", "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA (10º período)", "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE (10º período)",
    "TRABALHO TÉC-CIENTÍFICO DE CONCLUSÃO DE CURSO (10º período)", "SISTEMAS DISTRIBUÍDOS (10º período)"
    };
    
    
    /**
     * Initializes the controller class.
     */
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        for(int i=0;i<listaDisciplinas.length;i++){
        
        
        double m1,m2,m3,mf;
        
        m1 = Avaliacao.calculaMediaDaDisciplina(listaDisciplinas[i], "M1".toCharArray());
        m2 = Avaliacao.calculaMediaDaDisciplina(listaDisciplinas[i], "M2".toCharArray());
        m3 = Avaliacao.calculaMediaDaDisciplina(listaDisciplinas[i], "M3".toCharArray());
        
        
        XYChart.Series set1 = new   XYChart.Series<>();
        
        if(!Double.isNaN(m1))
            set1.getData().add(new XYChart.Data(listaDisciplinas[i]+" - M1", m1));
        if(!Double.isNaN(m2))
            set1.getData().add(new XYChart.Data(listaDisciplinas[i]+" - M2", m2));
        if(!Double.isNaN(m3))
            set1.getData().add(new XYChart.Data(listaDisciplinas[i]+" - M3", m3));
        if(!Double.isNaN(m1) && !Double.isNaN(m2) && !Double.isNaN(m3)){
            mf = (m1+m2+m3)/3;
            set1.getData().add(new XYChart.Data(listaDisciplinas[i]+" - MF", mf));
        }
        tabela.getData().addAll(set1);
        }
    }    
    
    @FXML 
    public void voltarParaDashboard() throws IOException {
        
        GerenciadorJanela.obterInstancia().voltar();
    }
    
}
