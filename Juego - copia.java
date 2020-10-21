import java.util.ArrayList;
import java.util.Random;
class Juego{
    //Atributos
    Random rand = new Random();
    int i=0;
    ArrayList<Jugador> jugador1 = new ArrayList<>();//Listas para poder llevar el orden de los turnos
    ArrayList<Jugador> jugador2 = new ArrayList<>();//Su objetivo es facilitar la toma de turnos
    ArrayList<Mascota> mascotas = new ArrayList<>();//Lista de las mascotas
    ArrayList<Minion> miniones = new ArrayList<>();//Lista de las mascotas

    //Constructor

    //Metodos
    public int atacar(int jugador, int atacante, int objetivo){//Metodo para realizar un ataque
        int dano=0;//Se crea el daño donde se almacenara el daño que hace el atacante
        int recibido=0;//Variable que guardara el daño que recibe la tropa
        if(jugador==1){
            dano=jugador1.get(atacante).atacar();//El daño a realizar se guarda en la variable daño
            recibido=jugador2.get(objetivo).recibir(dano);//La tropa del jugador 2 se come el daño despues del filtro de su defensa
        } else{
            dano=jugador2.get(atacante).atacar();//El daño a realizar se guarda en la variable daño
            recibido=jugador1.get(objetivo).recibir(dano);//La tropa del jugador 2 se come el daño despues del filtro de su defensa
        }
        return recibido;//Devuelve el daño que el objetivo ha recibido para usarlo en el String que reporta la accion
    }

    public int atacarminion(int objetivo){//Metodo para realizar un ataque
        int dano=0;//Se crea el daño donde se almacenara el daño que hace el atacante
        int recibido=0;//Variable que guardara el daño que recibe la tropa
        dano=miniones.get(0).atacar();//El daño a realizar se guarda en la variable daño
        recibido=jugador2.get(objetivo).recibir(dano);//La tropa del jugador 2 se come el daño despues del filtro de su defensa
        return recibido;
    }

    public int atacarmas(int objetivo){//Metodo para realizar un ataque
        int dano=0;//Se crea el daño donde se almacenara el daño que hace el atacante
        int recibido=0;//Variable que guardara el daño que recibe la tropa
        dano=mascotas.get(0).atacar();//El daño a realizar se guarda en la variable daño
        recibido=jugador2.get(objetivo).recibir(dano);//La tropa del jugador 2 se come el daño despues del filtro de su defensa
        return recibido;
    }

    public void agregarJ1(){
        //EL siguiente codigo crea las tropas del jugador 1
        Cazador c=new Cazador();
        jugador1.add(c);
        Heroe jirou=new Heroe();
        jugador1.add(jirou);
        Musculoso m=new Musculoso();
        jugador1.add(m);
    }

    public void crearjefe(){
        Boss jefe=new Boss();
        jugador2.add(jefe);
    }

    public void agregarJ2(){
        //EL siguiente codigo crea las tropas del jugador 1
        int clase=rand.nextInt(3);
        if(clase==1){
            Malardo h=new Malardo();
            jugador2.add(h);
        } else if(clase==2){
            Tio jirou=new Tio();
            jugador2.add(jirou);
        } else if(clase==0){
            Marco c=new Marco();
            jugador2.add(c);
        }
    }

    public void agregarJ2(Boss jefe){
        jugador2.add(jefe);
    }


    //Estos metodos son para revisar que la lista de los jugadores está vacia y asi poder ganar el juego
    public void revMuerto1(){
        int ver=0;
        while(ver<=(jugador1.size()-1)){
            if(jugador1.get(ver).vigente()==false){
                jugador1.remove(ver);
                ver--;
            }
            ver++;
        }
    }

    public void revMuerto2(){
        int ver=0;
        while(ver<=(jugador2.size()-1)){
            if(jugador2.get(ver).vigente()==false){
                jugador2.remove(ver);
                ver--;
            }
            ver++;
        }
    }

    //Metodos para tragar, liberar y generar minions
    public void tragar(int afectado){
        try{
            jugador2.remove(afectado)
        } catch(Exception e){
            System.out.println("Ha ocurrido un error inesperado!");
        }
    }

    public int generar(){
        int exito=0;
        if(miniones.size()!=3){//Verifica que se hagan los miniones
            Minion m=new Minion();
            miniones.add(m);
            exito=1;
        }

        return exito;
    }

    public int generarma(){
        int exito=0;
        if(mascotas.size()!=2){
            Mascota m=new Mascota();
            mascotas.add(m);
            exito=1;
        }

        return exito;
    }

    //Metodo que agrega mascotas
    public void addpet(){
        Mascota tommy=new Mascota();
        mascotas.add(tommy);
    }

    //Gets & Sets
    public Jugador getTJ1(int i){
        return jugador1.get(i);
    }

    public Jugador getTJ2(int i){
        return jugador2.get(i);
    }

    public int getTamano1(){
        return jugador1.size();
    }

    public int getTamano2(){
        return jugador2.size();
    }

    public int getTamanoma(){
        return mascotas.size();
    }

    public int getTamanomi(){
        return miniones.size();
    }

    public Minion getmin(int a){
        return miniones.get(a);
    }

    public Mascota getpet(int a){
        return mascotas.get(a);
    }
}