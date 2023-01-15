import java.util.Scanner;

public class UI {


    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in); 
        Radio radio = new Radio(); 

        menuPrincipal(radio, sc); 
        
    }
    public static void menuPrincipal(Radio radio, Scanner sc) throws Exception{

        boolean salir = false; 
        int op; 
        String freq; 

        while(!salir){

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

            switch(op){
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

                case 3: 

                    break;  

                case 4: 

                    break; 

                case 5: 

                    break; 

                case 6: 
                    salir = true; 
                    System.out.println("\nSaliendo del programa...");
                    break;  

        
            }
        }
    }

}
