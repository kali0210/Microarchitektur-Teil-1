package at.ItKolleg.Imst.Builder;

public class BuilderTest {
    public static void main(String[] args) {

       Auto auto1 = new Auto.AutoBuilder().marke("Tesla")
               .model("Model S").baujahr(2023).farbe("Rot").build();

        System.out.println("Marke:" + auto1.getMarke());
        System.out.println("Modell:" + auto1.getModell());
        System.out.println("Baujahr:" + auto1.getBaujahr());
        System.out.println("Farbe:" + auto1.getFarbe());
    }
}
