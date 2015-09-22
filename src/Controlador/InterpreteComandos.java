package Controlador;

public class InterpreteComandos {
	 public int esTeclaValida(char x){
	    	if (x == 'W' || x == 'w') return 1;
	    	if (x == 'S' || x == 's') return 2;
	    	if (x == 'A' || x == 'a') return 3;
	    	if (x == 'D' || x == 'd') return 4;
	    	if (x == 'Q' || x == 'q') return 5;
	    	if (x == 'E' || x == 'e') return 6;
	    	
	    	if (x == 'I' || x == 'i') return 7;
	    	if (x == 'K' || x == 'k') return 8;
	    	if (x == 'J' || x == 'j') return 9;
	    	if (x == 'L' || x == 'l') return 10;
	    	if (x == 'U' || x == 'u') return 11;
	    	if (x == 'O' || x == 'o') return 12;
	    	return -1;
	    }
}
