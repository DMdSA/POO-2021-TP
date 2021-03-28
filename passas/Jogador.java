public class Jogador {
    
    private String nome;
    private int idade;
    private float altura;
    private float peso;
    //private int ID; //para garantir a unicidade do jogador
    
    /**
     * Construtores
     */
    public Jogador () {
        this.nome = "n/a";
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
    }
    
    public Jogador (String nome, int idade, float altura, float peso) {
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
    
    public float getAltura () {
        return this.altura;
    }
    
    public float getPeso () {
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
    
    void setAltura (float altura) {
        this.altura = altura;
    }
    
    void setPeso (float peso) {
        this.peso = peso;
    }
    
    /**
     * Equals
     */
    
    
    /**
     * Clone
     */
}