import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Diese Klasse modelliert R�ume in der Welt von Zuul.
 * 
 * Diese Klasse ist Teil der Anwendung "Die Welt von Zuul".
 * "Die Welt von Zuul" ist ein sehr einfaches textbasiertes 
 * Adventure-Game.
 * 
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden.
 * M�gliche Ausg�nge liegen im Norden, Osten, S�den und Westen.
 * F�r jede Richtung h�lt ein Raum eine Referenz auf den 
 * benachbarten Raum.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2016.02.29
 */
public class Raum {
    private String beschreibung;
    private HashMap<String, Raum> ausgaenge;

    private HashSet<Gegenstaende> gegenstaende;



    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausg�nge. Eine Beschreibung hat die Form 
     * "in einer K�che" oder "auf einem Sportplatz".
     * @param beschreibung  die Beschreibung des Raums
     */

    public Raum(String beschreibung)
    {
        this.beschreibung = beschreibung;
        ausgaenge = new HashMap<>();
        gegenstaende = new HashSet<>();
    }

    /**
     * Definiere einen Ausgang aus diesem Raum
     * @param richtung die Richtung, in der der Ausgang liegen soll.
     * @param nachbar der Raum, der �ber diesen Ausgang erreicht wird.
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
     * Sie sind in der K�che
     * Ausg�nge north west
     * @return eine lange Beschreibung dieses Raums
     */
    public String gibLangeBeschreibung(){
        return "Sie sind " + beschreibung + "\n" + gibAusgaengealsString() + "\n" + gibAusgaengealsString();
    }

    /**
     * Liefert eine Beschreibung der Ausgabe dieses Raumes.
     * beispielweise "Ausg�nge: north west".
     * @return eine Beschreibung der verf�gbaren Ausg�nge.
     */
    public String gibAusgaengealsString(){

        String retournString = "Ausg�nge";

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

    public String gibGegenstaendealsString(){
        String gibAus = "Gegenst�nde";
        for (Iterator<Gegenstaende> iter = gegenstaende.iterator(); iter.hasNext();){
            gibAus += " " + iter.next().getBeschreibung();
        }
        return gibAus;
    }

    public void gegenstandAblegen(Gegenstaende gegenstand){
        gegenstaende.add(gegenstand);
    }

}
