import java.util.Scanner;
public class Despertador{
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Bienvenido al programador de despertadores");
        System.out.println("Que dia de la semana es hoy?");
        int dia=Integer.parseInt(in.nextLine());
        
        System.out.println("Cuantos dias debo programar el despertador?");
        int restantes=Integer.parseInt(in.nextLine());
        
        int contador=0;
        for(contador=dia+1;contador<restantes+dia;contador++){
            if(contador %7==6){
                System.out.print("10:30 ");
            }
            else if(contador %7==0){
                System.out.print("OFF ");
            }
            else{
                System.out.print("7:30 ");
            }
        }
    }
}