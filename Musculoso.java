import java.util.ArrayList;

class Musculoso extends Jugador{
    int item=3;//Se define su tipo de item, solo se usa 1 vez
    public Musculoso(){
        super(200, 200, 15, "Musculoso", "Mis musculos no pudieron", "Petado");
    }

    //Metodos
    public int habilidad(){
        int efecto=0;
        efecto=item;
        item=0;
        return efecto;
    }
}