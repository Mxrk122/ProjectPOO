import java.util.Scanner;
class Vista{
    Scanner scan=new Scanner(System.in);
    int tropasj1=0;//Valores que guardan las tropas que eligio el jugador 1 y 2
    int tropasj2=0;


    int opcion=0;
    //Metodos de bienvenida
    public void inicio(){
        System.out.println("BIENVENIDO A: JUEGO DE PELEAS POR TURNOS EPICO ENGASADOOOOOOOOOOOOOOOOOOOO");
        System.out.println("Lo sabemos, el titulo es horrible. Has venido a juagr o a criticar?");
        System.out.println("Crearemos los personajes");
    }

    //Metodo para el menu
    public int menu(int j, String clase){
        int a=1;
        opcion=0;
        while(a==1)
        {
            System.out.println("Bievenido al epico y glorioso menu. Jugador "+j);
            System.out.println("Estas controlando a la tropa: "+clase+"\n");
            System.out.println("Psst. Para elegir una opcion solo selecciona el numero");
            System.out.println("1. Atacar");
            System.out.println("2. Item");
            System.out.println("3. Me rindo! (En realidad es para salir, pero hey! no es muy valiente eso de huir de los combates)");
            try{
                opcion=scan.nextInt();
                a=0;
            }
            catch(Exception e){
                System.out.println("Error, no has ingresado una opcion valida");
                scan.next();
            }
        }
        return opcion;
    }

    public int bosshabilities(){
        int a=1;
        opcion=0;
        while(a==1)
        {
            System.out.println("Boss que deseas hacer?");
            System.out.println("Estas controlando al jefe");
            System.out.println("Psst. Para elegir una opcion solo selecciona el numero");
            System.out.println("1. Absorber");
            System.out.println("2. Generar");
            System.out.println("3. Liberar");
            System.out.println("4. Usar habilidad");
            try{
                opcion=scan.nextInt();
                if(opcion<1 || opcion>4){
                    System.out.println("Error, no has ingresado una opcion valida");
                } else{
                    a=0;
                }
            }
            catch(Exception e){
                System.out.println("Error, no has ingresado una opcion valida");
                scan.next();
            }
        }
        return opcion;
    }

    //Menu de la opcion de atacar
    public int atacar(int cantidadob){//Menu para preguntar a que personaje se desea atacar
        int a=0;
        opcion=0;
        System.out.println("A que personaje vas a atacar?");
        System.out.println("Ingresa el numero de posicion del enemigo para elegir");
        while(a==0){
            try{
                opcion=(scan.nextInt());//Verifica que la opcion ingresada esta entre el intervalo de los enemigos
                if(cantidadob<opcion || opcion<=0){
                    System.out.println("Ingresaste el numero de un enemigo que no existe, tranquilo, no hemos programado un fantasma");
                } else{
                    a=1;
                }
            }
            catch(Exception e){
                System.out.println("Error, no has ingresado una opcion valida");
                scan.next();
            }
        }
        return opcion-1;
    }

    //Metodos para personajes
    public int tropas(int ju){
        opcion=0;
        System.out.println("¿CUANTAS TROPAS TENDRA EL JUGADOR "+ju);//Pregunta las tropas que el jugador desea
        int a=0;
        while(a==0){
            try{
                opcion=scan.nextInt();//Pide la cantidad
                if(opcion<1 || opcion>3){//Verifica que este entre el intervalo permitido
                    System.out.println("No has ingresado una opcion valida");
                } else{
                    a=1;
                }
            }
            catch(Exception e){//En caso de poner un valor incorrecto vuelve a preguntar
                System.out.println("Error, no has ingresado una opcion valida");
                scan.next();
            }
        }
        if(ju==1){
            tropasj1=opcion;
        } else{
            tropasj2=opcion;
        }
        System.out.println(tropasj1);
        System.out.println(tropasj2);
        return opcion;
    }

    public int crearpersonaje(){//Este metodo se encarga de preguntar y devolver el valor de la posicion de una clase
        opcion=0;
        System.out.println("ELIGE UNA CLASE");//Muestra las clases disponibles para la clase
        System.out.println("1. Leroy Jenkins");
        System.out.println("2. Musculoso");
        System.out.println("3. Mamadisimo");
        int a=0;
        while(a==0){
            try{
                opcion=scan.nextInt();
                if(opcion<1 || opcion>3){//Verifica si el valor ingresado esta entre el intervalo de opciones
                    System.out.println("No has ingresado una opcion valida");
                } else{
                    a=1;
                }
            }
            catch(Exception e){//Controla la excepcion
                System.out.println("Error, no has ingresado una opcion valida");
                scan.next();
            }
        }
        return opcion;
    }

    public int crearpersonaje2(){//Este metodo se encarga de preguntar y devolver el valor de la posicion de una clase
        opcion=0;
        System.out.println("ELIGE UNA CLASE");//Muestra las clases disponibles para la clase
        System.out.println("1. Racso");
        System.out.println("2. El tio");
        System.out.println("3. Marco");
        int a=0;
        while(a==0){
            try{
                opcion=scan.nextInt();
                if(opcion<1 || opcion>3){//Verifica si el valor ingresado esta entre el intervalo de opciones
                    System.out.println("No has ingresado una opcion valida");
                } else{
                    a=1;
                }
            }
            catch(Exception e){//Controla la excepcion
                System.out.println("Error, no has ingresado una opcion valida");
                scan.next();
            }
        }
        return opcion;
    }

    public void verpersonajes(Jugador j){//Metodo para mostrar la informacion de un personaje
        System.out.println(j);
    }

    public void mostraritems(Ip objeto){
        System.out.print(" ");
        System.out.print(objeto);
    }

    public int elegiritem(int tamaño){
        int a=0;
        while(a==0){
            try{
                System.out.println(" ");
                opcion=scan.nextInt();
                if(tamaño<opcion || opcion>tamaño){//Verifica si el valor ingresado esta entre el intervalo de opciones
                    System.out.println("No has ingresado una opcion valida");
                } else {
                    a=1;
                }
            }
            catch(Exception e){//Controla la excepcion
                System.out.println("Error, no has ingresado una opcion valida");
                scan.next();
            }
        }
        return opcion-1;
    }

    //Metodos para victoria
    public void ganador(int jugador){
        if (jugador==1){
            System.out.println("El jugador 1 ha derrotado epicamente al jugador 2 y ha declarado la victoria para la logia");
        } else{
            System.out.println("El jugador 2 ha derrotado epicamente al jugador 1, corran por sus vidas");
        }
    }

    //Metodos para mostrar la lista de ultimas observaciones
    public void strataque(String atacante, String objetivo, int dano, int recibido){//Crea el string para un ataque
        System.out.println("El "+atacante+" le ha dado un palizon de "+dano+" puntos de daño a "+objetivo+" y este ha recibido "+recibido+" puntos de daño\n");
    }

    public void strcura(String atacante, int recibido){
        System.out.println(atacante+" se ha curado "+recibido+" puntos de vida");
    }

    public void strdano(String atacante, int recibido){
        System.out.println(atacante+" ha lanzado una pocion de "+recibido+" puntos de daño");
    }

    //Metodos simples para reutilizarse y demas
    public void imprimidor(String enunciado){//Metodo para imprimir Strings de otras clases
        System.out.println(enunciado);
    }

    public void imprimidor(Jugador j){//Metodo para imprimir Strings de otras clases
        System.out.println(j);
    }
}