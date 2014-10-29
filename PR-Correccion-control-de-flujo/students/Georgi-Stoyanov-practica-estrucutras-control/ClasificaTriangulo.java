import java.util.Scanner;
public class ClasificaTriangulo 
{

    public static void main(String[] args) {
       Scanner in = new Scanner (System.in);
        System.out.println("Este programa clasifica triangulos.");
       
        /* inicialización de variables */
        System.out.println("Longitud del primer lado:");
        int val1 = Integer.parseInt(in.nextLine());
        
        System.out.println("Longitud del segundo lado:");
        int val2 = Integer.parseInt(in.nextLine());
        
        System.out.println("Longitud del tercer lado:");
        int val3 = Integer.parseInt(in.nextLine());
        
		boolean imposible=((val1<(val2+val3))&&(val2<(val1+val3))&&(val3<(val1+val2)));
		
		/* main */
		if(!imposible){
			System.out.println("Es un triangulo: imposible");
		}
		else if(val1==val2 && val2==val3){
			System.out.println("Es un triangulo: equilatero");
		}
		else if((val1==val2||val2==val3) || (val3==val1)){
			System.out.println("Es un triangulo: isosceles");
		}
		/*hipotenusa ???*/
		else if(val1*val1+val2*val2==val3*val3 || val2*val2+val3*val3==val1*val1 || val3*val3+val1*val1==val2*val2){
			System.out.println("Es un triangulo: rectangulo");
		}
		else{
			System.out.println("Es un triangulo: escaleno");
		}
    }
    
}
