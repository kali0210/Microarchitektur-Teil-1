package at.ItKolleg.Imst.TemplateMethod;

/**
 * Abstrakte Klasse Spiel definiert das Skelett eines Spiels.
 * Sie verwendet die Template Method
 **/
public abstract class Spiel {

    /**.
     * Dies stellt sicher, dass die Struktur des Spiels in allen Subklassen gleich bleibt,
     * während die spezifischen Details von den Subklassen bereitgestellt werden.
     */
    public final void spielen(){
        spielInitialisierung();
        spielstart();
        spielende();
    }


    protected abstract void spielInitialisierung();
    protected abstract void spielstart();
    protected abstract void spielende();

}
