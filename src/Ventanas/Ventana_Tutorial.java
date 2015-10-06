package Ventanas;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Ventana_Tutorial extends JFrame {
	  JLabel etiqueta ; 
	  JButton bt_salir ;
	  int estado ;
	public void setEstado(int estado){
		this.estado = estado ; 
	}
	public int getEstado(){
		return this.estado ; 		
	}
	public int play(){
		System.out.println("Entro a  jugar") ; 
		return 1 ; 
	}
    public Ventana_Tutorial(){
  	  
  	  super("Mi estimado Tutorial LOL");
  	  int w = 300, h=400, tbh= 30 , tbw = 100; 
  	  estado = 1 ; 
  	  this.setResizable(false);
  	  this.setSize(w,h);
  	  this.setLocationRelativeTo(null);    	   
  	  this.addWindowListener(new WindowAdapter() {					
			@Override
			public void windowClosing(WindowEvent e) {
				estado = 1 ; 
				dispose();				
			}								
  	  });    	  
  	  
  	  bt_salir = new JButton("Partida Nueva")  ; 
  	     	 
  	  JPanel panel = new JPanel() ;
  	  panel.setLayout(null);
  	  
  	  panel.add(bt_salir);    	  
   	  /*bt_salir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		} );*/
  	  int dis = 50 ;   	  
	  bt_salir.setBounds(new Rectangle((w-tbw)/2,h/2 + 2*dis,tbw,tbh));
	  bt_salir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Ventana_Tutorial.this.setVisible(false);			
		}
	  });
  	  Container cp = getContentPane() ; // C act V  
  	  cp.add(panel);    	  
  	  this.setVisible(true);
    }	
}
