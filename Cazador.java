import java.util.ArrayList;

class Cazador extends Jugador{
    int item=4;//Se define su tipo de item, solo se usa 1 vez
    public Cazador(){
        super(200, 200, 15, "CAZADOR", "Mori... por la patria", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    //Metodos
    public int habilidad(){
        int efecto=0;
        efecto=item;
        item=0;
        return efecto;
    }
}