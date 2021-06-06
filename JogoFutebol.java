import Equipa.EquipaFutebol;
import Jogadores.JogadorFutebol;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class JogoFutebol extends Jogo{

    private EquipaFutebol equipaCasa;
    private EquipaFutebol equipaFora;
    private LocalDate data;


    public JogoFutebol(){
        super(2, 90, 2);
        this.equipaCasa = new EquipaFutebol();
        this.equipaFora = new EquipaFutebol();
        this.data = LocalDate.now();
    }

    public JogoFutebol(EquipaFutebol eq1, EquipaFutebol eq2, String date){

        super(2,90,2);
        this.equipaCasa = eq1;
        this.equipaFora = eq2;
        this.data = LocalDate.parse(date);
    }

    public JogoFutebol(JogoFutebol jf){

        super(jf);
        this.equipaCasa = jf.getEquipaCasa();
        this.equipaFora = jf.getEquipaFora();
        this.data = jf.getData();
    }
            //Para LOGS
    public static JogoFutebol parse(String read){

        JogoFutebol novo = new JogoFutebol();
        novo.set_NEquipas(2); novo.set_NEquipas(2); novo.set_Duracao(90);

        String[] campos = read.split(",");

        novo.equipaCasa = new EquipaFutebol(campos[0]);
        novo.equipaFora = new EquipaFutebol(campos[1]);
        novo.equipaCasa.setGolos(Integer.parseInt(campos[2]));
        novo.equipaCasa.setGolos(Integer.parseInt(campos[3]));
        novo.setData(campos[4]);
        for(int i = 5; i < 16; i++){
            novo.equipaCasa.adicionaTitular(new JogadorFutebol(Integer.parseInt(campos[i])));
        }
        for(int i = 16; i < 19; i++){
            String[] fst = campos[i].split("-", 2);
            JogadorFutebol trocar = novo.equipaCasa.getJogador(Integer.parseInt(fst[0]));
            String[] snd = fst[1].split(">");
            JogadorFutebol trocado = (new JogadorFutebol(Integer.parseInt(snd[1])));
            novo.equipaCasa.adicionaSuplente(trocado);
            novo.equipaCasa.substitui(trocar, trocado);
        }

        for(int i = 19; i < 30; i++){
            novo.equipaFora.adicionaTitular(new JogadorFutebol(Integer.parseInt(campos[i])));
        }
        for(int i = 30; i < 33; i++){
            String[] fst = campos[i].split("-", 2);
            JogadorFutebol trocar = novo.equipaCasa.getJogador(Integer.parseInt(fst[0]));
            String[] snd = fst[1].split(">");
            JogadorFutebol trocado = (new JogadorFutebol(Integer.parseInt(snd[1])));
            novo.equipaFora.adicionaSuplente(trocado);
            novo.equipaFora.substitui(trocar, trocado);
        }
        return novo;
    }




    public JogoFutebol clone(){
        return new JogoFutebol(this);
    }

    public EquipaFutebol getEquipaCasa() { return this.equipaCasa;}
    public String get_nome_equipa_casa() {return this.equipaCasa.getNome();}
    public EquipaFutebol getEquipaFora(){ return this.equipaFora;}
    public String get_nome_equipa_fora(){ return this.equipaFora.getNome();}
    public LocalDate getData(){ return this.data;}

    public void setEquipaCasa(EquipaFutebol eq1){ this.equipaCasa = eq1;}
    public void setEquipaFora(EquipaFutebol eqFora){ this.equipaFora = eqFora;}
    public void setData(String data){ this.data = LocalDate.parse(data);}


    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass() || o == null) return false;

        JogoFutebol that = (JogoFutebol) o;

        return super.equals(o) &&
                this.equipaCasa.equals(that.equipaCasa) &&
                this.equipaFora.equals(that.equipaFora) &&
                this.data.isEqual(that.data);
    }



    public String toString(){

        StringBuilder finalstring = new StringBuilder("Jogo: " + this.getEquipaCasa().getNome() + " 'vs' " + this.getEquipaFora().getNome());
        EquipaFutebol casa = this.getEquipaCasa();
        EquipaFutebol fora = this.getEquipaFora();
        Collection<JogadorFutebol> jscasa = casa.getJogadoresTitulares();
        Collection<JogadorFutebol> jsfora = fora.getJogadoresTitulares();

        finalstring.append("\nEquipa ").append(casa.getNome()).append(":\n");

        for(JogadorFutebol jf : jscasa)
            finalstring.append("\t").append(jf.getNumero());

        finalstring.append("\nEquipa ").append(fora.getNome()).append(":\n");
        for(JogadorFutebol jf : jsfora)
            finalstring.append("\t").append(jf.getNumero());

        finalstring.append("\nData do jogo: ").append(this.getData()).append("\n\n");
        return finalstring.toString();
    }







}