/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.Scanner;

/*
  Entre semana suelo colocar el despertador a las 7:30.
  El sábado el despertador suena a las 10:30, para poder dedicar tiempo al estudio. Los domingos
  el despertador no suena.
  Desarrolla un programa que pregunte en qué día de la semana estamos, y cuantos días hay 
  que programar el despertador. La salida será una línea con la horas a las que sonará el
  despertador los próximos días (sin incluir el actual), u OFF si ese día no suena.

  @author Gonzalo Martinez Pizones
 */
public class Despertador {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        System.out.println("Bienvenido al progamador de despertadores");
        System.out.println("Que dia de la semana es");
        int dia = Integer.parseInt(in.nextLine());
        System.out.println("Cuantos dias debo programar el despertador?");
        int programador = Integer.parseInt(in.nextLine());
        for (int numero = (dia+1);numero<=(dia+programador);numero++){
            if (((numero%7)>0)&&((numero%7)<6)){//Considera el lunes como 1 y el domingo como 0
                System.out.print("07:30 ");
            }else if ((numero%7)==6){
                System.out.print("10:30 ");
            }else if ((numero%7)==0){
                System.out.print("OFF ");
            }
        }
    }
}    