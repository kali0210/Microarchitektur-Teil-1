package at.ItKolleg.Imst.Decorater;
/**
 * Implementiert das Interface
 */
public class Professor implements ISchulpersonal {


    /**
     * Diese Methode implementiert die getRolle-Methode, die vom Interface ISchulpersonal vorgegeben wird.
     * @return Ein String, der die Rolle der Person im Schulsystem angibt.
     */
    @Override
    public String getRolle() {

        return "Professor";
    }
}

