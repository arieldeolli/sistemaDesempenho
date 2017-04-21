/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadesempenho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.transaction.xa.XAException;
/**
 *
 * @author Ariel
 */

public class Avaliacao{
    
    private String nome;
    private String disciplina;
    private char[] media;
    private Double peso;
    private Double nota;
    private int identificadorNoArquivo;

    
    
    public Avaliacao(){
        
    }
   
    public Avaliacao(String nome, String disciplina, char[] media, Double peso, Double nota) throws FileNotFoundException, IOException{
        this.nome = nome;
        this.disciplina = disciplina;
        this.media = media;
        this.peso = peso;
        this.nota = nota;
        

    }
    
    public static ArrayList<Avaliacao> obterListaAvaliacoes(){
        ArrayList<Avaliacao> listaConteudoTabela = new ArrayList<>();
        Avaliacao avaliacao;
        try {
            FileReader leitor = new FileReader("ListaProvas.csv");
            BufferedReader leitorLin = new BufferedReader(leitor);
            int cont = 0;
            while (leitorLin.ready()) {                
                avaliacao = new Avaliacao(); 
                String linha = leitorLin.readLine();                
                String[] array = linha.split(",+");
                avaliacao.disciplina = array[0];
                avaliacao.media = array[1].toCharArray();
                avaliacao.nome = array[2];
                avaliacao.peso = Double.parseDouble(array[3]);
                if(array.length > 4)
                    avaliacao.nota = Double.parseDouble(array[4]);
                avaliacao.identificadorNoArquivo = cont;
                listaConteudoTabela.add(avaliacao);     
                cont++;
            }
            leitorLin.close();
            leitor.close();
        } catch (Exception e) {
            System.out.println(e);
        }                   
       return listaConteudoTabela;
    }
    
    /**
     *
     * @param disciplina
     * @param media
     * @return
     */
    public static double calculaMediaDaDisciplina(String disciplina, char[] media){
        ArrayList<Avaliacao> listaAvaliacoes = obterListaAvaliacoes();
        Avaliacao avaliacaoDaVez = new Avaliacao();
     
        Double med = 0.0;
        Double peso = 0.0;
        int numeroDeAvaliacoesDaDisciplina = 0;
        for(int i = 0;i<listaAvaliacoes.size();i++){
            avaliacaoDaVez = listaAvaliacoes.get(i);
            if(avaliacaoDaVez.disciplina.equals(disciplina) && Arrays.equals(avaliacaoDaVez.media, media)){
                peso += avaliacaoDaVez.peso;
                med += (avaliacaoDaVez.nota*avaliacaoDaVez.peso)/peso;  
                numeroDeAvaliacoesDaDisciplina++;
            }
        }
        if(numeroDeAvaliacoesDaDisciplina == 0){
            return -1;
        }
        return med;
        
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public char[] getMedia() {
        return media;
    }
    
    public String getMediaEmString(){
        return String.valueOf(this.media);
    }

    public void setMedia(char[] media) {
        this.media = media;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    public int getIdentificadorNoArquivo() {
        return identificadorNoArquivo;
    }

    public void setIdentificadorNoArquivo(int identificadorNoArquivo) {
        this.identificadorNoArquivo = identificadorNoArquivo;
    }


    public void salvar() throws IOException{
         File arquivo1 = new File("ListaProvas.csv");
        if(!arquivo1.exists()){
            arquivo1.createNewFile();
        }
        FileWriter escritor = new FileWriter(arquivo1, true);
        
        BufferedWriter gravador = new BufferedWriter(escritor);
        
        gravador.write(getDisciplina()+","+String.valueOf(getMedia())+","+getNome()+","+getPeso());
        gravador.newLine();
        
        gravador.close();
        escritor.close();
        
        MinhasAvaliacoesFXMLController telaMinhasAvaliacoes = new MinhasAvaliacoesFXMLController();
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();
        GerenciadorJanela.obterInstancia().abreJanela(telaMinhasAvaliacoes);
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();
    } 
    
    public void atualizar() throws IOException{
        /* asagsagsg */
        Path path = Paths.get("ListaProvas.csv");
        List<String> linhas = Files.readAllLines(path);

        String novoConteudo = linhas.get(identificadorNoArquivo).substring(0, linhas.get(identificadorNoArquivo).length()) +","+getNota();
        linhas.remove(identificadorNoArquivo);
        linhas.add(identificadorNoArquivo, novoConteudo);

        Files.write(path, linhas);
        
        MinhasAvaliacoesFXMLController tela2 = new MinhasAvaliacoesFXMLController();
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();
        GerenciadorJanela.obterInstancia().abreJanela(tela2);
        GerenciadorJanela.obterInstancia().pilhaRetorno.pop();        
    }
}
