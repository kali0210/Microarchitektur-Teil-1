package at.ItKolleg.Imst.TemplateMethod;

public class Basketball extends Spiel{

    @Override
    protected void spielInitialisierung() {
        System.out.println("Basketballspiel wurde initialisiert, 5 min bis zum start");
    }

    @Override
    protected void spielstart() {
        System.out.println("Das Spielt beginnt");
    }

    @Override
    protected void spielende() {
        System.out.println("Das Spiel ist beendet");
    }
}
