package at.ItKolleg.Imst.chainofresponsibility;

import at.ItKolleg.Imst.Exceptions.InvalidVarianteException;
import at.ItKolleg.Imst.wr.WR;

public class EURO2DOLLAR extends WR {

    private double faktor;

    private EURO2DOLLAR(double faktor) {
        this.faktor = faktor;
    }

    @Override
    public double getFaktor(){
        return faktor;
    }

    @Override
    public boolean zustaendig(String variante) {
        if (variante.equals("EURO2DOLLAR")) {
            return true;
        } else {
            return false;
        }
    }



    public static class Builder{
        private double faktor;
        private WR next;

        public Builder mitFaktor(double faktor){
            this.faktor = faktor;
            return this;
        }

        public Builder mitNaechsteKettenMitglied(WR next){
            this.next = next;
            return this;
        }

    public EURO2DOLLAR build(){
        EURO2DOLLAR waehrungskonventierer = new EURO2DOLLAR(faktor);
        if (next != null){
            waehrungskonventierer.addChain(next);
        }
        return waehrungskonventierer;
    }}
}