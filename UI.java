import java.util.Scanner;

public class UI {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Radio radio = new Radio();

        menuPrincipal(radio, sc);

    }

    public static void menuPrincipal(Radio radio, Scanner sc) throws Exception {

        boolean salir = false;
        int op;
        String freq;

        while (!salir) {

            System.out.println("\nLa radio se encuentra: " + radio.isOn() + "\n");
            System.out.println("¡Bienvenid@! Por favor, seleccione una opción.");
            System.out.println("");
            System.out.println("\t1. Encender radio");
            System.out.println("\t2. Seleccionar AM o FM");
            System.out.println("\t3. Cambiar emisora");
            System.out.println("\t4. Guardar emisora");
            System.out.println("\t5. Seleccionar emisora guardada");
            System.out.println("\t6. Salir");
            System.out.println("");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("\nLa radio ha sido encendida\n");
                    radio.on();
                    break;

                case 2:
                    System.out.println("¿Qué frecuencia desea escuchar? Escriba AM o FM");
                    freq = sc.next();
                    radio.setFrequence(freq);
                    System.out.println("\tLa emisora se encuentra en: " + radio.getFrequence());
                    break;
                // Si la persona quiere ir adelante o atras en las emisoras
                case 3:
                    System.out.println("Para donde deseas ir? Adelante (1), Atras(2)");
                    int opcion = sc.nextInt();
                    if (opcion == 1) {
                        radio.Forward();
                    } else if (opcion == 2) {
                        radio.Backward();
                    }

                    break;

                case 4: // Guardar emisora
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
                        }
                        if (radio.getFrequence().equalsIgnoreCase("FM")) {
                            emisoraFM = sc.nextDouble();
                            if (emisoraFM < 87.9 || emisoraFM > 107.9) {
                                System.out.println("Cuidado escribe una emisora entre la 87.9 y 107.9");
                                correcto = false;
                            }
                        }
                    }

                    System.out.println("Muy bien, ¿en qué espacio deseas guardarla?\nEscribe un número del 1 al 12");
                    while (correcto) {
                        int slot = sc.nextInt();
                        if (slot < 1 || slot > 12) {
                            System.out.println("Cuidado escribe un slot entre la 1 y 12");
                            correcto = false;
                        } else {
                            if (radio.getFrequence().equalsIgnoreCase("AM")) {
                                radio.saveAMStation(emisoraAM, slot);
                            } else if (radio.getFrequence().equalsIgnoreCase("FM")) {
                                radio.saveFMStation(emisoraFM, slot);
                            }
                        }
                    }

                    break;

                case 5: // Seleccionar emisora guardada
                    System.out.println("Estas en frecuencia " + radio.getFrequence());
                    System.out.println(
                            "De las emisoras guardadas, ¿cuál deseas seleccionar?\nEscribe el número de slot que deseas");
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

                case 6:
                    salir = true;
                    System.out.println("\nSaliendo del programa...");
                    break;

            }
        }
    }

}
