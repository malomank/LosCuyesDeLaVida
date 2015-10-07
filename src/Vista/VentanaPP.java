package Vista;
import javax.swing.*;

import java.awt.*; 

public class VentanaPP extends JFrame{
	Container cp ;
	JPanel p1 , p2 ; 
	public VentanaPP(){
		
		this.setLayout(null);
		this.setSize(500,500);
		
		
		cp = getContentPane();

		// Panel 1 
		p1  = new JPanel() ;
		p1.setBounds(0, 0, 250, 250);
		p1.setLayout(null);
		
		// Panel 2 
		p2 = new JPanel()  ;
		p2.setBounds(250, 0, 250,250);
		p2.setLayout(null);
		// Crear componentes 
		
		JButton b1 =new JButton("Buton1") ;
		JButton b2 = new JButton("Buton2");
		b1.setBounds(0,0,50,50);
		b2.setBounds(0,0,50,50);
		
		// Agregar Componentes a cada PANEL
		p1.add(b1) ; 
		p2.add(b2) ;		
		
		// Agrego los paneles al contenendor
		cp.add(p1);
		cp.add(p2);
		
		
		this.setVisible(true);
	}
	public void tutorial(){
		
		
	}
	
	public void nivel1(){
		
	}
	public void nivel2(){
		
	}
	
}
