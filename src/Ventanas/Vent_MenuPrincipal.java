package Ventanas;

import javax.swing.*;

import com.sun.accessibility.internal.resources.accessibility;
import com.sun.corba.se.impl.util.PackagePrefixChecker;

import java.awt.event.*;
import java.beans.VetoableChangeListener;
import java.awt.*;


public class Vent_MenuPrincipal extends JFrame{
	  JLabel etiqueta ; 
	  JButton bt_play , bt_cPartida , bt_salir ;
	  JButton escape ;
	  JPanel panel ;
	  public void  tutorial(Vent_MenuPrincipal ve){
		    // Inicializacion de Ventana 1 ;
		  	Vent_MenuPrincipal.this.setSize(1024,768);
			Vent_MenuPrincipal.this.setLocationRelativeTo(null);
			Vent_MenuPrincipal.this.bt_play.setVisible(false);
			Vent_MenuPrincipal.this.bt_cPartida.setVisible(false);
			Vent_MenuPrincipal.this.bt_salir.setVisible(false);
			Vent_MenuPrincipal.this.setTitle("Nivel 1");			
			Container cp = Vent_MenuPrincipal.this.getContentPane() ;
			//Vent_MenuPrincipal.this.setLayout(null);			
			panel = new JPanel(); 			
			panel.setLayout(null); ; 			
			escape = new JButton("ESCAPE");
			escape.setBounds(300,200,80,30);			
			panel.add(escape) ; 
			cp.add(panel);			
			
			escape.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub		
					//
				}
			});
	  }	  	  
      public Vent_MenuPrincipal(){    	 
    	  super("Los Cuyes de la vida Sabia");
    	  int w = 300, h=400, tbh= 30 , tbw = 100;     	  
    	  this.setResizable(false);
    	  this.setSize(w,h);
    	  this.setLocationRelativeTo(null);    	   
    	  this.addWindowListener(new WindowAdapter() {					
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();				
			}								
    	  });    	      	        	  
    	  // Botones 
    	  bt_play = new JButton("Partida Nueva")  ; 
    	  bt_cPartida = new JButton("Cargar Partida")  ; 
    	  bt_salir = new JButton("Terminar") ; 
    	  
    	  panel = new JPanel() ;
    	  panel.setLayout(null);
    	  
    	  // Agregar Botones 
    	  panel.add(bt_play);    	  
    	  panel.add(bt_cPartida);
    	  panel.add(bt_salir) ;     	    	  

    	  
    	  bt_play.addActionListener( new ActionListener() {      		
        		@Override        		
        		public void actionPerformed(ActionEvent e) {        	
        			/*
        			Vent_MenuPrincipal.this.setSize(1024,768);
        			Vent_MenuPrincipal.this.setLocationRelativeTo(null);
        			Vent_MenuPrincipal.this.bt_play.setVisible(false);
        			Vent_MenuPrincipal.this.bt_cPartida.setVisible(false);
        			Vent_MenuPrincipal.this.bt_salir.setVisible(false);   */     			
        			Vent_MenuPrincipal ve  = Vent_MenuPrincipal.this;
        			tutorial(ve);
        		}
          });
    	  
    	  bt_salir.addActionListener(new ActionListener() {    		  
			@Override			
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		  });
    	  
    	  int dis = 50 ; 
    	  
    	  bt_play.setBounds(new Rectangle((w-tbw)/2,h/2,tbw,tbh));
    	  bt_cPartida.setBounds(new Rectangle((w-tbw)/2,h/2 + dis,tbw,tbh));
    	  bt_salir.setBounds(new Rectangle((w-tbw)/2,h/2 + 2*dis,tbw,tbh));
    	  Container cp = getContentPane() ; // C act V  
    	  cp.add(panel);    	  
    	  this.setVisible(true);    	      	  
      }
}


