package at.ItKolleg.Imst.Adapter;

/**
 * Die Klasse implementiert das Interface MediaPlayer
 */
public class VlcPlayerAdapter implements MediaPlayer {

    private VlcPlayer vlcPlayer;

    /**
     * Konstruktor der VlcPlayerAdapter
     * @param vlcPlayer vlcPlayer welcher auf das Datenfeld zugewiesen wird
     */
    public VlcPlayerAdapter(VlcPlayer vlcPlayer) {
        this.vlcPlayer = vlcPlayer;
    }

    /**
     * Spielt die Mediadatei ab
     * @param audioTyp Der Typ der Mediendatei
     * @param name Der Dateiname der Mediendatei
     */
    @Override
    public void play(String audioTyp, String name) {
        if (audioTyp.equals("vlc")){
            vlcPlayer.playVlc(name);
        }else {
            System.out.println("Der Audiotyp " + name +  " wird nicht unterstützt!");
        }
    }
}
