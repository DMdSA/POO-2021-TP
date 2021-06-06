package Equipa;
public class Equipa {

    private String nome;
    private int titulares;
    private int suplentes;


//Constructores,

    public Equipa(){
        
        this.nome = "none_";
        this.titulares = 0;
        this.suplentes = 0;
    }


    public Equipa(String nome) {
        
        this.nome = nome;
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


//Getters - Setters,

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



//equals,

    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass() || o == null) return false;

        Equipa that = (Equipa) o;

        return this.nome.equals(that.getNome()) &&
                this.titulares == that.getTitulares() &&
                this.suplentes == that.getSuplentes();
    }




//toString,
    public String toString() {
       

        StringBuilder finalstring = new StringBuilder("Equipa [" + this.getNome() + "] = \n\t");
        finalstring.append("Numero Titulares : " + this.getTitulares() + "\n\t");
        finalstring.append("Numero Suplentes : " + this.getSuplentes() + "\n");

        return finalstring.toString();
    }


//Clone,

    public Equipa clone(){
        return new Equipa(this);
    }
}
