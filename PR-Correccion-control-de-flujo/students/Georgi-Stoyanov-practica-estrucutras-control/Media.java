import java.util.Scanner;
public class Media{
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");
        int cantidad = Integer.parseInt(in.nextLine());
        
        int count;
        double numero=0;
        if(cantidad>0){
        for(count=1;count<=cantidad;count++){
            System.out.println("Numero "+count+":");
            numero += Double.parseDouble(in.nextLine());
        }
        double media=numero/cantidad;
        System.out.println(media);
        }
        else{System.out.println("Numero introducido no valido.El programa no se va a ejecutar correctamente.");}
    }
}