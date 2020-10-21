import java.util.ArrayList;

class Heroe extends Jugador{
    int item=2;//Se define su tipo de item, solo se usa 1 vez
    public Heroe(){
        super(200, 200, 15, "Leroy jenkins", "Mori... por la patria", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    //Metodos
    public int habilidad(){
        int efecto=0;
        efecto=item;
        item=0;
        return efecto;
    }
}