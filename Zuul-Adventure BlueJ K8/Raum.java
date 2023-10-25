import java.util.HashMap;

/**
 * Diese Klasse modelliert Räume in der Welt von Zuul.
 * 
 * Diese Klasse ist Teil der Anwendung "Die Welt von Zuul".
 * "Die Welt von Zuul" ist ein sehr einfaches textbasiertes 
 * Adventure-Game.
 * 
 * Ein "Raum" repräsentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen Räumen über Ausgänge verbunden.
 * Mögliche Ausgänge liegen im Norden, Osten, Süden und Westen.
 * Für jede Richtung hält ein Raum eine Referenz auf den 
 * benachbarten Raum.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 2016.02.29
 */
public class Raum {
    private String beschreibung;
    private HashMap<String, Raum> ausgaenge;




    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausgänge. Eine Beschreibung hat die Form 
     * "in einer Küche" oder "auf einem Sportplatz".
     * @param beschreibung  die Beschreibung des Raums
     */

    public Raum(String beschreibung)
    {
        this.beschreibung = beschreibung;
        ausgaenge = new HashMap<>();
    }

    /**
     * Definiere einen Ausgang aus diesem Raum
     * @param richtung die Richtung, in der der Ausgang liegen soll.
     * @param nachbar der Raum, der über diesen Ausgang erreicht wird.
     */
    public void setzeAusgang(String richtung, Raum nachbar){
        ausgaenge.put(richtung, nachbar);
    }

    public Raum gibAusgang(String richtung)
    {
        return ausgaenge.get(richtung);
    }


    /**
     * @return  die Beschreibung dieses Raums
     */
    public String gibBeschreibung()
    {
        return beschreibung;
    }

    /**
     * Liefert eine lange Beschreibung dieses Raums, in der Form
     * Sie sind in der Küche
     * Ausgänge north west
     * @return eine lange Beschreibung dieses Raums
     */
    public String gibLangeBeschreibung(){
        return "Sie sind " + beschreibung + "\n" + gibAusgaengealsString();
    }

    /**
     * Liefert eine Beschreibung der Ausgabe dieses Raumes.
     * beispielweise "Ausgänge: north west".
     * @return eine Beschreibung der verfügbaren Ausgänge.
     */
    public String gibAusgaengealsString(){

        String retournString = "Ausgänge";

        if (ausgaenge != null){
            retournString += "north";
        }
        if (ausgaenge != null){
            retournString += "east";
        }
        if (ausgaenge != null){
            retournString += "south";
        }
        if (ausgaenge != null){
            retournString += "west";
        }
        return  retournString;
    }

}
