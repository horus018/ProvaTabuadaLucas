package controle;
import controle.ListaProvas;
import dados.Prova;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.inject.Named;

@Named(value = "ProgressoProva")
@SessionScoped
public class ProgressoProva implements Serializable {

    Random rnd = new Random(System.currentTimeMillis());
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

    private String nomeAluno;
    private Integer numeroMatricula;
    private int n1;
    private int n2;
    private int questaoAtual = 1;
    private double acertos;
    private Prova prova;
    private Integer resposta;
    private String msgErro;

    public ProgressoProva() {

    }

    public String responder() {
        numeroAcertos();
        resposta = null;
        if (questaoAtual == 20) {
            return finalizar();
        } else if (questaoAtual >= 10) {
            n1 = rnd.nextInt(5) + 5;
            n2 = rnd.nextInt(5) + 5;
            questaoAtual++;
        } else {
            n1 = rnd.nextInt(5) + 1;
            n2 = rnd.nextInt(5) + 1;
            questaoAtual++;
        }
        return null;

    }

    public String finalizar() {
        //adiciona na lista de a prova nova antes de zerar os acertos   
        prova = new Prova();
        prova.setNomeAluno(nomeAluno);
        prova.setNumeroMatricula(numeroMatricula);
        prova.setNota(acertos * 0.5);
        prova.setDataProva(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        ListaProvas.add(prova);
        prova = new Prova();
        questaoAtual = 1;
        msgErro = null;
        acertos = 0;
        nomeAluno = null;
        numeroMatricula = null;
        return ("lista.xhtml");
    }

    public void numeroAcertos() {
        if (resposta == (n1 * n2)) {
            acertos++;
        }
    }

    public String voltarIndex() {
        return ("index.xhtml");
    }

    public String comecarProva() {
        if (ListaProvas.contemProvaComMatricula(numeroMatricula) != null) {
            msgErro = "O aluno com a matrícula " + numeroMatricula + " já fez a prova antes no dia: " + ListaProvas.contemProvaComMatricula(numeroMatricula);
            return null;
        } else {
            n1 = rnd.nextInt(5) + 1;
            n2 = rnd.nextInt(5) + 1;   
            return ("prova.xhtml");
        }
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public int getQuestaoAtual() {
        return questaoAtual;
    }

    public void setQuestaoAtual(int questaoAtual) {
        this.questaoAtual = questaoAtual;
    }

    public String getMsgErro() {
        return msgErro;
    }
    
    public Integer getResposta(){
        return resposta;
    }
    
    public void setResposta(Integer resposta){
        this.resposta = resposta;
    }
    
    

}
