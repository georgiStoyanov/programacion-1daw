import java.util.Scanner;

/**
 * Esta plantilla es orientativa, y no es necesario usarla
 * @author Nombres de los autores
 */
public class CuatroEnRaya{


	private static char VACIO = '.';

	// PRIMERA DIMENSION ES COLUMNAS, SEGUNDA FILAS
	private static char[][] tablero = new char[7][6];

	private static final int ALTOTABLERO = tablero[0].length;
	private static final int ANCHOTABLERO = tablero.length;


	/**
	 * Decide que ficha usa el jugador con ese turno
	 * @return 'O' para el jugador 1, 'X' para el jugador 2
	 */
	private static char fichaDeJugador( int turno ){
		if( turno == 1 ){
			return 'O';
		}
		else if( turno == 2 ){
			return 'X';
		}
		
		throw new IndexOutOfBoundsException( "O 1 o 2" );
	}

	/**
	 * Decide si un jugador ha hecho cuatro en raya
	 */
	private static boolean hayGanador( int turno ){
		// USA LOS OTROS METODOS DE hayCuatroEnRayaXXXXXXXXEn
		for( int columna = 0 ; columna < ANCHOTABLERO ; columna += 1 ){
			for( int fila = 0 ; fila < ALTOTABLERO ; fila += 1 ){
				if( hayGanadorVerticalEn(turno,fila,columna) ||
					hayGanadorAscendenteEn(turno, fila, columna) ||
					hayGanadorDiagonalDescendenteEn(turno, fila, columna) ||
					hayGanadorHorizontalEn(turno, fila, columna) ){
					return true;
				}
			}
		}
		return false;
	}
	
	private static char fichaEn( int fila, int columna ){
		if( posicionDentroDelTablero(fila, columna) ){
			return tablero[columna][fila];
		}
		return VACIO;
	}

	private static boolean posicionDentroDelTablero(int fila, int columna) {
		return fila >= 0 && fila < ALTOTABLERO && columna >= 0 && columna < ANCHOTABLERO;
	}

	
	
	private static boolean hayCuatroEnRayaEnDireccion( int turno, int fila, int columna, int dfila, int dcolumna ){
		char ficha = fichaDeJugador(turno);
		for( int i = 0 ; i < 4 ; i++ ){
			if( fichaEn( fila+dfila*i, columna+dcolumna*i ) != ficha ){
				return false;
			}
		}
		return true;
	}

	/**
	 * @return true si hay cuatro en raya vertical del jugador especificado empezando en (fila,columna)
	 */
	private static boolean hayGanadorVerticalEn( int turno, int fila, int columna ){
		
		return hayCuatroEnRayaEnDireccion(turno,fila,columna,1,0); 
		/*
		char ficha = fichaDeJugador(turno);
		if( fichaEn(fila,columna) == ficha &&
			fichaEn(fila+1,columna) == ficha &&
			fichaEn(fila+2,columna) == ficha &&
			fichaEn(fila+3,columna) == ficha ){
			return true;
		}
		else{
			return false;
		}
		*/
	}

	/**
	 * @return true si hay cuatro en raya horizontal del jugador especificado empezando en (fila,columna)
	 */
	private static boolean hayGanadorHorizontalEn( int turno, int fila, int columna ){
		return hayCuatroEnRayaEnDireccion(turno,fila,columna,0,1);
		/*
		char ficha = fichaDeJugador(turno);
		if( fichaEn(fila,columna) == ficha &&
			fichaEn(fila,columna+1) == ficha &&
			fichaEn(fila,columna+2) == ficha &&
			fichaEn(fila,columna+3) == ficha ){
			return true;
		}
		else{
			return false;
		}
		*/
	}

	/**
	 * @return true si hay cuatro en raya diagonal ascendente del jugador especificado empezando en (fila,columna)
	 */
	private static boolean hayGanadorAscendenteEn( int turno, int fila, int columna ){
		return hayCuatroEnRayaEnDireccion(turno,fila,columna,-1,1);
		/*
		char ficha = fichaDeJugador(turno);
		if( fichaEn(fila,columna) == ficha &&
			fichaEn(fila-1,columna+1) == ficha &&
			fichaEn(fila-2,columna+2) == ficha &&
			fichaEn(fila-3,columna+3) == ficha ){
			return true;
		}
		else{
			return false;
		}
		*/
	}

	/**
	 * @return true si hay cuatro en raya en diagonal descendente del jugador especificado empezando en (fila,columna)
	 */
	private static boolean hayGanadorDiagonalDescendenteEn( int turno, int fila, int columna ){
		return hayCuatroEnRayaEnDireccion(turno,fila,columna,1,1);
		/*
		char ficha = fichaDeJugador(turno);
		if( fichaEn(fila,columna) == ficha &&
			fichaEn(fila+1,columna+1) == ficha &&
			fichaEn(fila+2,columna+2) == ficha &&
			fichaEn(fila+3,columna+3) == ficha ){
			return true;
		}
		else{
			return false;
		}
		*/
	}

	/**
	 * @param columna La columna a inspeccionar
	 * @return la primera fila libre de fichas en la columna especificada, 
	 *         o -1 si esa columna esta llena o es invalida
	 */
	private static int primeraFilaLibre( int columna ){
		for( int fila = ALTOTABLERO-1 ; fila >= 0 ; fila -= 1 ){
			if( fichaEn(fila,columna) == VACIO){
				return fila;
			}
		}
		return -1;
	}


	/**
	 * Intenta meter una ficha del jugador en la columna indicada.
	 * Si no es posible (porque la columna esta llena o la columna es invalida) devuelve false
	 * @return true si se puede poner la ficha, false si es un movimiento invalido
	 */
	private static boolean meteFicha( int turno, int columna ){
		int hastaDondeCae = primeraFilaLibre(columna);
		if( hastaDondeCae == -1 ){
			return false;
		}
		
		tablero[columna][hastaDondeCae] = fichaDeJugador(turno);
		return true;
	}

	/**
	 * @return true si el tablero esta lleno, por lo que la partida ha acabado
	 */
	private static boolean tableroLleno1(){
		for( int columna =0 ; columna < ANCHOTABLERO ; columna+=1){
			if( tablero[columna][0] == VACIO ){
				return false;
			}
		}
		return true;
	}

	
	private static boolean tableroLleno2(){
		for( int columna =0 ; columna < ANCHOTABLERO ; columna+=1){
			if( primeraFilaLibre(columna) != -1 ){
				return false;
			}
		}
		return true;
	}
	
	private static boolean tableroLleno(){
		return tableroLleno1();
	}
	
	/**
	 * Muestra el tablero por consola
	 */
	private static void muestraTablero(){
		for( int fila = 0 ; fila < ALTOTABLERO ; fila += 1 ){
			for( int columna = 0 ; columna < ANCHOTABLERO ; columna += 1 ){
				System.out.print( fichaEn(fila,columna) );
			}
			System.out.println();
		}
	}


	/**
	 * Vacia el tablero, dejando todas las casillas a VACIO 
	 */
	private static void vaciaTablero(){
		for( int fila = 0 ; fila < ALTOTABLERO ; fila += 1 ){
			for( int columna = 0 ; columna < ANCHOTABLERO ; columna += 1 ){
				tablero[columna][fila] = VACIO;
			}
		}
		
	}


	/**
	 *
	 */
	public static void main( String[] args ){

		Scanner in = new Scanner(System.in);
		vaciaTablero();

		// JUGADOR QUE TIENE EL TURNO
		int turno = 1;
		boolean hayGanador = false;
		
		while( !tableroLleno() && !hayGanador ){

			muestraTablero();
		
			/* PREGUNTAR POR LA COLUMNA E INTENTAR METER LA FICHA */
			System.out.println( "Jugador " + turno + "(" + fichaDeJugador(turno) + "):" );
			int columna = Integer.parseInt( in.nextLine() );
			meteFicha(turno, columna);

			/* SI EL JUGADOR HA GANADO, INDICARLO */
			hayGanador = hayGanador(turno);
			if( hayGanador ){
				muestraTablero();
				System.out.println( "Gana el jugador " + turno );
			}

			turno = avanzaTurno(turno);
		}

		/* SI HAY EMPATE, INDICARLO */
		if( !hayGanador ){
			System.out.println( "Se ha producido un empate" );
		}
	}

	private static int avanzaTurno(int turno) {
		switch( turno ){
			case 1 : return 2;
			case 2: return 1;
			default: throw new IndexOutOfBoundsException( "turno raro" );
		}
	}
}