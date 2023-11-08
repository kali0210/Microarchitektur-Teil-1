package at.ItKolleg.Imst.Builder;

/**
 * Die Klasse Auto ist ein Fahrzeug mit Eigenschaften
 * dessen Zustand nicht mehr verändert werden kann.
 */
public class Auto {

    private final String marke;
    private final String modell;
    private final int baujahr;
    private final String farbe;

    /**
     * Privater Konstruktor für die Autoklasse
     * @param marke  Die Marke des Autos
     * @param modell Das Modell des Autos
     * @param baujahr Das Baujahr des Autos
     * @param farbe  Die Farbe des Autos
     */
    private Auto(String marke, String modell, int baujahr, String farbe) {
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.farbe = farbe;
    }


    public String getMarke() { return marke; }

    public String getModell() { return modell; }

    public int getBaujahr() { return baujahr; }

    public String getFarbe() { return farbe; }

    /**
     * Die Builder-Klasse für Auto um das Builder-Entwurfsmuster umzusetzen.
     */
    public static class AutoBuilder {

        private String marke;
        private String modell;
        private int baujahr;
        private String farbe;


        /**
         * Setzt die Marke des Autos und gibt den Builder zurück.
         * @param marke Die Marke des erstellenden Autos.
         * @return Der AutoBuilder mit gesetzter Marke.
         */
        public AutoBuilder marke(String marke) {
            this.marke = marke;
            return this;
        }

        /**
         * Setzt das Modell des Autos und gibt den Builder zurück.
         * @param modell Das Modell des zu erstellenden Autos.
         * @return Der AutoBuilder mit gesetztem Modell.
         */
        public AutoBuilder model(String modell) {
            this.modell = modell;
            return this;
        }

        /**
         * Setzt das Baujahr des Autos und gibt den Builder zurück.
         * @param baujahr Das Baujahr des erstellenden Autos.
         * @return Der AutoBuilder mit gesetztem Baujahr.
         */
        public AutoBuilder baujahr(int baujahr) {
            this.baujahr = baujahr;
            return this;
        }

        /**
         * Setzt die Farbe des Autos und gibt den Builder zurück.
         * @param farbe Die Farbe des erstellenden Autos.
         * @return Der AutoBuilder mit gesetzter Farbe.
         */
        public AutoBuilder farbe(String farbe) {
            this.farbe = farbe;
            return this;
        }

        /**
         * Erstellt ein Auto-Objekt mit den Attributen.
         * @return Ein neues 'Auto'-Objekt mit den definierten Eigenschaften.
         */
        public Auto build() {
            return new Auto(marke, modell, baujahr, farbe);
        }
    }
}
