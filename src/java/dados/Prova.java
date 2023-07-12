package dados;

public class Prova {

    private Integer numeroMatricula;
    private String nomeAluno;
    private double nota;
    private String dataProva;

    public Prova(Integer numeroMatricula, String nomeAluno, double nota, String dataProva) {
        this.numeroMatricula = numeroMatricula;
        this.nomeAluno = nomeAluno;
        this.nota = nota;
        this.dataProva = dataProva;
    }

    public Prova() {
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getDataProva() {
        return dataProva;
    }

    public void setDataProva(String dataProva) {
        this.dataProva = dataProva;
    }

}
