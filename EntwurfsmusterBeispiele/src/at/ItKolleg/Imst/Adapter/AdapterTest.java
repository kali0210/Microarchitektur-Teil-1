package at.ItKolleg.Imst.Adapter;

public class AdapterTest {

    public static void main(String[] args) {

        MediaPlayer mp3Player = new Mp3Player();
        VlcPlayer vlcPlayer = new VlcPlayer();
        MediaPlayer vlcAdapter = new VlcPlayerAdapter(vlcPlayer);

        mp3Player.play("mp3", "song deines lebens.mp3");

        vlcAdapter.play("mp3", "ein stern der deinen namen trägt.vlc");

        mp3Player.play("vlc", "Himmel der Sternen");
    }
}
