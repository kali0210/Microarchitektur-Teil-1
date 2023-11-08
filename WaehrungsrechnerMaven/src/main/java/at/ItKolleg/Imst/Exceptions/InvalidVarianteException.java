package at.ItKolleg.Imst.Exceptions;

public class InvalidVarianteException extends Exception {

    public InvalidVarianteException()
    {
        super("Diese Variante wird nicht unterstützt!");
    }
}
