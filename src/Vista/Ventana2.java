package Vista;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana2 extends JFrame{	
	JPanel panel1 , panel2  ;
	JButton boton1 , boton2 ; 
	Container cp  ; 
	public Ventana2(){
		
		cp = this.getContentPane();
		
		panel1 = new JPanel() ; 
		panel2 = new JPanel() ;		
		
		boton1 = new JButton("Boton1");
		boton2 = new JButton("Boton2");
		
				
		//for (int i = 0 ; i <=5 ; i++)
			//panel1.add(new JButton("Boton" + i)) ;		
		panel1.add(boton1);
		
		panel2.add(boton2);		
		
		for(int i = 0 ; i< 5 ; i++){
			panel1.add(new JButton("Boton " + i)) ;
		}
		
		cp.setLayout(new BorderLayout());		
		cp.add(panel1,BorderLayout.WEST);		
		cp.add(panel2,BorderLayout.EAST);				
		
		this.setSize(500,800);
		this.setTitle("Ventana de Prueba");
		this.setVisible(true); 
		
	}
}

