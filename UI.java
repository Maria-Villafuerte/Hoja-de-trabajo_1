import java.util.Scanner;

public class UI {

    /**
     * Inicia el programa 
     * @param args
     * @throws Exception Muestra mensaje de error al no seleccionar alguna de las dos opciones 
     */
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Radio radio = new Radio();

        int p = Amenu(radio,sc);
        if (p==1){
            System.out.println("\nLa radio ha sido encendida\n");
            radio.on();
            menuPrincipal(radio, sc);
        }
        else if (p==2){
            System.out.println("Saliendo...");
        }
    }

    /**
     * Menu incial para encender la radio antes de utilizar los metodos 
     * @param radio Radio instanciada  
     * @param sc Scanner 
     * @return Opcion seleccionada por usuario 
     */
    public static int Amenu(Radio radio, Scanner sc){
        int opc;
        System.out.println("\nLa radio se encuentra: " + radio.isOn() + "\n");
        System.out.println("¡Bienvenid@! Por favor, seleccione una opción.");
        System.out.println("");
        System.out.println("\t1. Encender radio");
        System.out.println("\t2. Apagar radio");

        opc = sc.nextInt();
        return opc;
    }

    /**
     * Menu con las opciones de la radio 
     * @param radio Radio instanciada  
     * @param sc Scanner 
     * @throws Exception Error al seleccionar opciones fuera de rango 
     */
    public static void menuPrincipal(Radio radio, Scanner sc) throws Exception {

        boolean salir = false;
        int op;
        String freq;

        while (!salir) {
            System.out.println("\t1. Seleccionar AM o FM");
            System.out.println("\t2. Cambiar emisora");
            System.out.println("\t3. Guardar emisora");
            System.out.println("\t4. Seleccionar emisora guardada");
            System.out.println("\t5. Apagar Radio");
            System.out.println("");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("¿Qué frecuencia desea escuchar? Escriba AM o FM");
                    freq = sc.next();
                    radio.setFrequence(freq);
                    System.out.println("\tLa emisora se encuentra en: " + radio.getFrequence());
                    break;
                // Si la persona quiere ir adelante o atras en las emisoras
                case 2:
                    System.out.println("¿Para donde quieres ir? Adelante (1), Atras(2)");
                    int opcion = sc.nextInt();
                    if (opcion == 1) {
                        radio.Forward();
                    } else if (opcion == 2) {
                        radio.Backward();
                    }
                    if (radio.Frequence.equals("AM")){
                        System.out.println("Radio actual: " + radio.getAMActualStation());
                    }
                    else if(radio.Frequence.equals("FM")){
                        System.out.println("Radio actual: " + radio.getFMActualStation());
                    }

                    break;

                case 3: // Guardar emisora
                    System.out.println("¿Qué emisora deseas guardar?");
                    Boolean correcto = true;
                    int emisoraAM = 0;
                    Double emisoraFM = 0.0;
                    while (correcto) {
                        if (radio.getFrequence().equalsIgnoreCase("AM")) {
                            emisoraAM = sc.nextInt();
                            if (emisoraAM < 530 || emisoraAM > 1610) {
                                System.out.println("Cuidado escribe una emisora entre la 530 y 1610");
                                correcto = false;
                            }
                            System.out.println("Muy bien, ¿En qué espacio deseas guardarla?\nEscribe un número del 1 al 12");
                            while (correcto) {
                                int slot = sc.nextInt();
                                if (slot < 1 || slot > 12) {
                                    System.out.println("Cuidado escribe un slot entre la 1 y 12");
                                    correcto = false;
                                } else {
                                    if (radio.getFrequence().equals("AM")) {
                                        radio.saveAMStation(emisoraAM, slot);
                                        correcto = false;
                                    } else if (radio.getFrequence().equalsIgnoreCase("FM")) {
                                        radio.saveFMStation(emisoraFM, slot);
                                        correcto = false;
                                    }
                                }
                            }
                        }
                        if (radio.getFrequence().equalsIgnoreCase("FM")) {
                            emisoraFM = sc.nextDouble();
                            if (emisoraFM < 87.9 || emisoraFM > 107.9) {
                                System.out.println("Cuidado escribe una emisora entre la 87.9 y 107.9");
                                correcto = false;
                            }
                            System.out.println("Muy bien, ¿En qué espacio deseas guardarla?\nEscribe un número del 1 al 12");
                            while (correcto) {
                                int slot = sc.nextInt();
                                if (slot < 1 || slot > 12) {
                                    System.out.println("Cuidado escribe un slot entre la 1 y 12");
                                    correcto = false;
                                } else {
                                    if (radio.getFrequence().equalsIgnoreCase("AM")) {
                                        radio.saveAMStation(emisoraAM, slot);
                                        correcto = false;

                                    } else if (radio.getFrequence().equalsIgnoreCase("FM")) {
                                        radio.saveFMStation(emisoraFM, slot);
                                        correcto = false;

                                    }
                                }
                            }
                        }
                    }



                    break;

                case 4: // Seleccionar emisora guardada
                    System.out.println("Estas en frecuencia " + radio.getFrequence());
                    System.out.println(
                            "De las emisoras guardadas, ¿Cuál deseas seleccionar?\nEscribe el número de slot que deseas");
                    int slot = sc.nextInt();
                    if (slot < 1 || slot > 12) {
                        System.out.println("Cuidado escribe un slot entre la 1 y 12");
                        correcto = false;
                    } else {
                        if (radio.getFrequence().equalsIgnoreCase("AM")) {
                            radio.setAMActualStation(radio.getAMSlot(slot));
                            System.out.println("Se ha seleccionado la emisora " + radio.getAMSlot(slot));
                        } else if (radio.getFrequence().equalsIgnoreCase("FM")) {
                            radio.setFMActualStation(radio.getFMSlot(slot));
                            System.out.println("Se ha seleccionado la emisora " + radio.getFMSlot(slot));
                        }
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("\nSaliendo del programa...");
                    break;

            }
        }
    }

}