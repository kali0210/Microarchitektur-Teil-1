public class Gegenstaende {

    private String Beschreibung;

    private double Gewicht;

    public Gegenstaende(String beschreibung, double gewicht) {
        this.Beschreibung = beschreibung;
        this.Gewicht = gewicht;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    public double getGewicht() {
        return Gewicht;
    }
}
