public class Jogador {
    private String nome;
    private int idade;
    private float altura;
    private float peso;

    public Jogador(){
        this.nome = "";
        this.idade = 0;
        this.altura = 0;
        this.peso = 0;
    }

    public Jogador(String nome, int idade, float altura, float peso){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public Jogador(Jogador jogador){
        this.nome = jogador.getNome();
        this.idade = jogador.getIdade();
        this.altura = jogador.getAltura();
        this.peso = jogador.getPeso();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
