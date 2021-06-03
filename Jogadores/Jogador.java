package Jogadores;

public class Jogador {
    
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    //private int ID; //para garantir a unicidade do jogador
    
    /**
     * Construtores
     */
    public Jogador () {             //Não sei se fará muito sentido usar este, mas também n deve fazer grande diferença
        this.nome = "n/a";
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
    }

    public Jogador(String nome){
        this.nome = nome;
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
    }


    public Jogador (String nome, int idade, double altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }
    
    public Jogador (Jogador j) {
        this.nome = j.getNome();
        this.idade = j.getIdade();
        this.altura = j.getAltura();
        this.peso = j.getPeso();
    }
    
    /**
     * Getters
     */
    public String getNome () {
        return this.nome;
    }
    
    public int getIdade () {
        return this.idade;
    }
    
    public double getAltura () {
        return this.altura;
    }
    
    public double getPeso () {
        return this.peso;
    }
    
    /**
     * Setters
     */
    void setNome (String nome) {
        this.nome = nome;
    }
    
    void setIdade (int idade) {
        this.idade = idade;
    }
    
    void setAltura (double altura) {
        this.altura = altura;
    }
    
    void setPeso (double peso) {
        this.peso = peso;
    }
    
    /**
     * Equals
     */
    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;

        Jogador that = (Jogador) o;

        return this.getNome().equals(that.getNome()) &&
                this.idade == that.idade &&
                this.altura == that.altura &&
                this.peso == that.peso;
    }
    
    
    /**
     * Clone
     */
    public Jogador clone(){
        return new Jogador(this);
    }


    /**
     * toString
     */
    public String toString(){

        final StringBuffer finalString = new StringBuffer("\tJogadores.Jogador \"" + this.getNome() + "\" = {\n");
        finalString.append("\t\tIdade: " + this.getIdade() + ";\n");
        finalString.append("\t\tAltura: " + this.getAltura() + ";\n");
        finalString.append("\t\tPeso: " + this.getPeso() + ";\n\t}\n");

        return finalString.toString();
    }



}