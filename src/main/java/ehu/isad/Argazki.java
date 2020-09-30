package ehu.isad;

public class Argazki {
    String izena;
    String irudia;

    public Argazki(String izena, String irudia){
        this.izena=izena;
        this.irudia=irudia;
    }

    public String getFitx() {
        return irudia;
    }

    @Override
    public String toString() {
        return izena;
    }
}
