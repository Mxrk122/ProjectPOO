import java.util.ArrayList;

class Tio extends Jugador{
    int item=2;//Se define su tipo de item, solo se usa 1 vez
    public Tio(){
        super(100, 50, 15, "Tio", "Noooo mis ahorros", "Zuper ataque jaja xdxdxdd");
    }

    //Metodos
    public int habilidad(){
        int efecto=0;
        efecto=item;
        item=0;
        return efecto;
    }
}