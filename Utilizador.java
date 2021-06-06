import java.time.LocalDate;

public class Utilizador {

    private String username;
    private String mail;
    private int level;
    private double points;
    private LocalDate date;


    public Utilizador(){
        this.username = "Anónimo";
        this.mail = "";
        this.level = -1;
        this.points = -1;
        this.date = LocalDate.now();
    }
    public Utilizador(String name){
        this.username = name;
        this.mail = "";
        this.level = 0;
        this.points = 0D;
        this.date = LocalDate.now();
    }

    public Utilizador(String name, String mail){
        this.username = name;
        this.mail = mail;
        this.level = 0;
        this.points = 0D;
        this.date = LocalDate.now();
    }


    public Utilizador(String name, String mail, int level, int points, LocalDate date){
        this.username = name;
        this.mail = mail;
        this.level = level;
        this.points = points;
        this.date = date;
    }


    public Utilizador(String name, String mail, int level, int points){
        this.username = name;
        this.mail = mail;
        this.level = level;
        this.points = points;
        this.date = LocalDate.now();
    }

    public Utilizador(Utilizador u){

        this.username = u.getUsername();
        this.mail = u.getMail();
        this.level = u.getLevel();
        this.points = u.getPoints();
        this.date = u.getDate();
    }

    public Utilizador clone(){ return new Utilizador(this);}


    /**
     * Getters
     */

    public String getUsername(){ return this.username;}
    public String getMail(){ return this.mail;}
    public int getLevel(){ return this.level;}
    public double getPoints(){ return this.points;}
    public LocalDate getDate(){ return this.date;}

    /**
     * Setters
     */

    public void setUsername(String s){ this.username = s;}
    public void setMail(String s){ this.mail = s;}
    public void setLevel(int l){
        if(l<0) this.level = 0;
        else if(l > 99) this.level = 99;
    }
    public void setPoints(double p){ this.points = p;}
    public void setDate(LocalDate ld){ this.date = ld;}


    /**
     * equals
     */
    public boolean equals(Object o){

        if(this == o) return true;
        if(this.getClass() != o.getClass() || o== null) return false;

        Utilizador that = (Utilizador) o;
        return this.username.equals(that.username) &&
                this.mail.equals(that.mail) &&
                this.level == that.level &&
                this.points == that.points &&
                this.date.isEqual(that.date);
    }

    /**
     * toString
     */
    public String toString(){

        StringBuilder info = new StringBuilder("#User " + this.username + ", email: " + this.mail + "\n\t");
        info.append("Leval: ").append(this.level).append(", Points: ").append(this.points).append(", Date: ").append(this.date).append("\n\n");
        return info.toString();
    }

}
