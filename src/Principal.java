import Vista.Juego;
import javax.swing.*;

import Ventanas.Vent_MenuPrincipal;

import java.awt.event.*;
import java.awt.*;

public class Principal {

	public static void main(String[] args) {		
		Vent_MenuPrincipal vm1 = new Vent_MenuPrincipal() ;
		Juego juego = new Juego( 10,40,40) ;
	}	
}
