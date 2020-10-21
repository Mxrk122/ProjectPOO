import java.util.Scanner;
import java.util.Random;
class Controlador{
    public static void juego(){
        int j=1;//Varaible para cambiar los turnos
        int opcion=0;
        Juego modelo=new Juego();
        Vista v=new Vista();
        Random rand=new Random();
        //Saludo
        v.inicio();

        //Seleccion de tropas de jugador 1
        modelo.agregarJ1();

        //Seleccion de tropas de jugador 2
        v.imprimidor("Preparate para pelear con el jefe");
        modelo.crearjefe();
        int c=rand.nextInt(3);
        for (int i = 0; i < c; i++){
            modelo.agregarJ2();
            v.imprimidor("Se añadio este personaje a la batalla: ");
            v.verpersonajes(modelo.getTJ2(i));
            v.imprimidor(" ");
        }

        //Comienza el funcionamiento del juego
        int a=1;//Variable para ciclo
        while(a!=0){
            if(modelo.getTamano1()!=0){
                //Inicia el funcionamiento dedicado al juego
                for (int i = 0; i < modelo.getTamano1(); i++){
                    //Se muestran los status de los personajes en cada turno
                    v.imprimidor("-------------------------------------------------------------------");
                    v.imprimidor("INFORMACION DE LAS TROPAS DE CAA+DA JUGADOR");
                    v.imprimidor(" ");
                    v.imprimidor("\nINFORMACION DE LAS TROPAS DEL JUGADOR 1:");
                    for (int statusj1=0; statusj1 < modelo.getTamano1(); statusj1++){
                        v.imprimidor(modelo.getTJ1(statusj1));
                    }
                    v.imprimidor(" ");
                    v.imprimidor("\nINFORMACION DE LAS TROPAS DEL JUGADOR 2:");
                    for (int statusj2=0; statusj2 < modelo.getTamano2(); statusj2++){
                        v.imprimidor(modelo.getTJ2(statusj2));
                    }
                    v.imprimidor(" ");
                    v.imprimidor("-------------------------------------------------------------------");

                    //Inicia el funcionamiento del menu.
                    opcion=v.menu(1,modelo.getTJ1(i).getClase());//Muestra informacion para saber que tropa esta usando
                    if (opcion==1){//La opcion 1 es para atacar.
                        for (int objetivos = 0; objetivos < modelo.getTamano2(); objetivos++){//Se muestra la lista de los personajes
                            v.imprimidor(modelo.getTJ2(objetivos).getClase());
                        }
                        int objetivo=v.atacar(modelo.getTamano2());//Devuelve el valor del objetivo
                        v.imprimidor(modelo.getTJ1(i).getFraseatk());//Se muestra la frase de ataque de la tropa de turno
                        int dano=modelo.atacar(1, i, objetivo);//El daño recibido se guarda en la variable y se pone en el metodo de abajo
                        v.strataque(modelo.getTJ1(i).getClase(), modelo.getTJ2(objetivo).getClase(), modelo.getTJ1(i).atacar(), dano);
                        if(i==0 && modelo.getTamanoma()!=0){
                            modelo.atacarmas(objetivo);//El daño echo por la mascota lo recibe el jugador 2
                        }
                    }
                    else if (opcion==2){//La opcion 2 es para objetos
                        if(modelo.getTJ1(i).getitem()!=0 && i!=0){
                            if((modelo.getTJ1(i).getitem()==1)){
                                v.imprimidor("El objeto de este jugador te cura 300 hp");
                                modelo.getTJ1(i).recibirvida(300);
                            } else if((modelo.getTJ1(i).getitem()==2)){
                                v.imprimidor("El objeto de este jugador te cura 100 hp");
                                modelo.getTJ1(i).recibirvida(100);
                            } else if((modelo.getTJ1(i).getitem()==3)){
                                v.imprimidor("Se ha invocado un minion");
                                modelo.getTJ1(i).recibirvida(500);
                            } else if((modelo.getTJ1(i).getitem()==4)){
                                if(modelo.generarma()!=0){
                                    v.imprimidor("Se ha generado una mascota!");
                                    } else{
                                        v.imprimidor("No se ha generado una mascota, ya tienes una!");
                                }
                            }
                        } else if(modelo.getTJ1(i).getitem()!=0 && i==0){
                            if(modelo.generarma()!=0){
                            v.imprimidor("Se ha generado una mascota!");
                            } else{
                                v.imprimidor("No se ha generado una mascota, ya tienes una!");
                            }
                        }
                    } else if(opcion==3){
                        v.imprimidor("Cobarde!!! Has perdido un turno");
                    }


                    //Codigo para validar las muertes
                    //Verificacion si las tropas han muerto y proceso para eliminarlas
                    for (int ver1=0; ver1 < modelo.getTamano1(); ver1++){
                        if(modelo.getTJ1(ver1).vigente()!=true){//ver 1 guarda la instancia para revisar el estado de un jugador.
                            v.imprimidor("La tropa del jugador 1 "+modelo.getTJ1(ver1).getClase()+" ha muerto");//Se revisa si ha muerto
                            v.imprimidor(modelo.getTJ1(ver1).getFrasedie());//Se muestra su frase al morir
                        }
                    }
                    for (int ver2=0; ver2 < modelo.getTamano2(); ver2++){
                        if(modelo.getTJ2(ver2).vigente()!=true){
                            v.imprimidor("La tropa del jugador 2 "+modelo.getTJ2(ver2).getClase()+" ha muerto");
                            v.imprimidor(modelo.getTJ2(ver2).getFrasedie());
                        }
                    }

                    //Efectua la accion de matar
                    modelo.revMuerto1();
                    modelo.revMuerto2();

                    //Codigo para verificar la victoria de un jugador
                    if(modelo.getTamano1()==0){
                        v.ganador(2);
                        a=0;
                    } else if(modelo.getTamano2()==0){
                        v.ganador(1);
                        a=0;
                    }
                }
            }

            //Codigo para el jugador 2
            if(modelo.getTamano2()!=0){
                for (int i2 = 0; i2 < modelo.getTamano1(); i2++){
                    //Se muestran los status de los personajes en cada turno
                    v.imprimidor("-------------------------------------------------------------------");
                    v.imprimidor("INFORMACION DE LAS TROPAS DE CAA+DA JUGADOR");
                    v.imprimidor(" ");
                    v.imprimidor("\nINFORMACION DE LAS TROPAS DEL JUGADOR 1:");
                    for (int statusj1=0; statusj1 < modelo.getTamano1(); statusj1++){
                        v.imprimidor(modelo.getTJ1(statusj1));
                    }
                    v.imprimidor(" ");
                    v.imprimidor("\nINFORMACION DE LAS TROPAS DEL JUGADOR 2:");
                    for (int statusj2=0; statusj2 < modelo.getTamano2(); statusj2++){
                        v.imprimidor(modelo.getTJ2(statusj2));
                    }
                    v.imprimidor(" ");
                    v.imprimidor("-------------------------------------------------------------------");

                    //Inicia el funcionamiento del menu.
                    opcion=v.menu(2,modelo.getTJ2(i2).getClase());//Muestra informacion para saber que tropa esta usando
                    if (opcion==1){//La opcion 1 es para atacar.
                        for (int objetivos = 0; objetivos < modelo.getTamano1(); objetivos++){//Se muestra la lista de los personajes
                            v.imprimidor(modelo.getTJ1(objetivos).getClase());
                        }
                        int objetivo=v.atacar(modelo.getTamano1());//Devuelve el valor del objetivo
                        v.imprimidor(modelo.getTJ2(i2).getFraseatk());//Se muestra la frase de ataque de la tropa de turno
                        int dano=modelo.atacar(2, i2, objetivo);//El daño recibido se guarda en la variable y se pone en el metodo de abajo
                        v.strataque(modelo.getTJ2(i2).getClase(), modelo.getTJ1(objetivo).getClase(), modelo.getTJ2(i2).atacar(), dano);
                        if(i2==0 && modelo.getTamanomi()!=0){
                            v.imprimidor("El minion ha atacado!");
                            modelo.atacarminion(objetivo);//El daño echo por el minion lo recibe el jugador 1
                        }
                    }
                    else if (opcion==2){//La opcion 2 es para objetos
                        if(modelo.getTJ1(i2).getitem()!=0 && i2!=0){
                            if((modelo.getTJ2(i2).getitem()==1)){
                                v.imprimidor("El objeto de este jugador te cura 300 hp");
                                modelo.getTJ2(i2).recibirvida(300);
                            } else if((modelo.getTJ1(i2).getitem()==2)){
                                v.imprimidor("El objeto de este jugador te cura 100 hp");
                                modelo.getTJ2(i2).recibirvida(100);
                            } else if((modelo.getTJ1(i2).getitem()==3)){
                                v.imprimidor("El objeto de este jugador te cura 100 hp");
                                modelo.getTJ2(i2).recibirvida(500);
                            } else if(modelo.getTJ1(i2).getitem()==4){
                                v.imprimidor("Se ha llamado a una mascota");
                            }
                        } else if(i2==0){//
                            int bh=v.bosshabilities();
                            if(bh==1){
                                v.imprimidor("A quien deseas tragarte?");
                                for (int objetivos = 0; objetivos < modelo.getTamano1(); objetivos++){//Se muestra la lista de los personajes
                                    v.imprimidor(modelo.getTJ1(objetivos).getClase());
                                }
                                int objetivo=v.atacar(modelo.getTamano1());//Devuelve el valor del objetivo
                                modelo.getTJ2(i2).absorber(modelo.getTJ2(objetivo).getitem());//Obtiene el item y almacena su valor
                                modelo.tragar(objetivo);
                            } 
                            else if(bh==2){
                                if(modelo.generar()!=0){
                                    v.imprimidor("Se ha generado un minion!");
                                }
                            } else if(bh==3){
                                modelo.getTJ2(i2).absorber(5);
                            } else if(bh==4){//Se utiliza la habilidad que el villano posee
                                if((modelo.getTJ2(i2).getitem()==1)){
                                    v.imprimidor("El objeto de este jefe te cura 300 hp");
                                    modelo.getTJ2(i2).recibirvida(300);
                                } else if((modelo.getTJ1(i2).getitem()==2)){
                                    v.imprimidor("El objeto de este jefe te cura 100 hp");
                                    modelo.getTJ2(i2).recibirvida(100);
                                } else if((modelo.getTJ1(i2).getitem()==3)){
                                    v.imprimidor("El objeto de este jefe te cura 100 hp");
                                    modelo.getTJ2(i2).recibirvida(500);
                                } else if((modelo.getTJ1(i2).getitem()==5)){
                                    v.imprimidor("El objeto de este jefe te cura 500 hp, habilidad de jefe");
                                    modelo.getTJ2(i2).recibirvida(500);
                                }
                            }
                        }  
                        else{
                            v.imprimidor("Este personaje no tiene objetos, el personaje perdio un turno revisando objetos");
                        }
                    }
                    else if(opcion==3){
                        v.imprimidor("Cobarde!!! Has perdido un turno");
                    }

                    //Codigo para validar las muertes
                    //Verificacion si las tropas han muerto y proceso para eliminarlas
                    for (int ver1=0; ver1 < modelo.getTamano1(); ver1++){
                        if(modelo.getTJ1(ver1).vigente()!=true){//ver 1 guarda la instancia para revisar el estado de un jugador.
                            v.imprimidor("La tropa del jugador 1 "+modelo.getTJ1(ver1).getClase()+" ha muerto");//Se revisa si ha muerto
                            v.imprimidor(modelo.getTJ1(ver1).getFrasedie());//Se muestra su frase al morir
                        }
                    }
                    for (int ver2=0; ver2 < modelo.getTamano2(); ver2++){
                        if(modelo.getTJ2(ver2).vigente()!=true){
                            v.imprimidor("La tropa del jugador 2 "+modelo.getTJ2(ver2).getClase()+" ha muerto");
                            v.imprimidor(modelo.getTJ2(ver2).getFrasedie());
                        }
                    }

                    //Efectua la accion de matar
                    modelo.revMuerto1();
                    modelo.revMuerto2();

                    //Codigo para verificar la victoria de un jugador
                    if(modelo.getTamano1()==0){
                        v.ganador(2);
                        a=0;
                    } else if(modelo.getTamano2()==0){
                        v.ganador(1);
                        a=0;
                    }
                }
            }
        }
    }
}