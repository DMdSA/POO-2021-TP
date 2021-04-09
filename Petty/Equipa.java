public class Equipa {
    private String nome;
    private int titulares;
    private int suplentes;

    public Equipa(){
        this.nome = "";
        this.titulares = 0;
        this.suplentes = 0;
    }

    public Equipa(String nome, int titulares, int suplentes) {
        this.nome = nome;
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public Equipa(Equipa equipa) {
        this.nome = equipa.getNome();
        this.titulares = equipa.getTitulares();
        this.suplentes = equipa.getSuplentes();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTitulares() {
        return titulares;
    }

    public void setTitulares(int titulares) {
        this.titulares = titulares;
    }

    public int getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(int suplentes) {
        this.suplentes = suplentes;
    }

    public String toString() {
        return "Equipa{" +
                "nome='" + nome + '\'' +
                ", titulares=" + titulares +
                ", suplentes=" + suplentes +
                '}';
    }

    public Equipa clone(){return new Equipa(this);}
}
