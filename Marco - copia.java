import java.util.ArrayList;

class Marco extends Jugador{
    int item=2;//Se define su tipo de item, solo se usa 1 vez
    public Marco(){
        super(200, 200, 15, "Marco", "Mori... pero cree el juego jaja", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    //Metodos
    public int habilidad(){
        int efecto=0;
        efecto=item;
        item=0;
        return efecto;
    }
}