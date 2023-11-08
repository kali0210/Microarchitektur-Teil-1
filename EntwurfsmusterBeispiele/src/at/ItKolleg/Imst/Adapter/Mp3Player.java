package at.ItKolleg.Imst.Adapter;

/**
 * Die Klasse die das Interface MediaPlayer implementiert.
 */
public class Mp3Player implements MediaPlayer{

    /**
     *
     * @param audioTyp audioTyp gibt der Typ an
     * @param name name gibt den Namen des Songs an
     */
    @Override
    public void play(String audioTyp, String name) {
        if (audioTyp.equals("mp3")){
            System.out.println("Spiel mp3 Datei. Name:" + name);
        } else {
            System.out.println("Ungültige AudioTyp." + audioTyp +  " Format wird nicht unterstützt!");
        }
    }
}
