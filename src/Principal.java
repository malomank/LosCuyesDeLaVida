import Vista.Juego;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class Vent_MenuPrincipal extends JFrame{
	  JLabel etiqueta ; 
	  JButton bt_play , bt_cPartida , bt_salir ;
	  Juego jj2;
      public Vent_MenuPrincipal( Juego jj){
    	  
    	  super("Los Cuyes de la vida Sabia");
    	  int w = 300, h=400, tbh= 30 , tbw = 100; 
    	  jj2 = jj ; 
    	  this.setResizable(false);
    	  this.setSize(w,h);
    	  this.setLocationRelativeTo(null);    	   
    	  this.addWindowListener(new WindowAdapter() {					
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();				
			}								
    	  });    	  
    	  bt_play = new JButton("Partida Nueva")  ; 
    	  bt_cPartida = new JButton("Cargar Partida")  ; 
    	  bt_salir = new JButton("Terminar") ; 
    	  
    	  JPanel panel = new JPanel() ;
    	  panel.setLayout(null);
    	  
    	  panel.add(bt_play);    	  
    	  panel.add(bt_cPartida);
    	  panel.add(bt_salir) ;     	    	  
    	  
    	  bt_salir.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		} );
    	  int dis = 50 ; 
    	  bt_play.setBounds(new Rectangle((w-tbw)/2,h/2,tbw,tbh));
    	  bt_cPartida.setBounds(new Rectangle((w-tbw)/2,h/2 + dis,tbw,tbh));
    	  bt_salir.setBounds(new Rectangle((w-tbw)/2,h/2 + 2*dis,tbw,tbh));
    	  Container cp = getContentPane() ; // C act V  
    	  cp.add(panel);    	  
    	  this.setVisible(true);
      }
}

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
 	   Juego nuevoJuego = new Juego(10, 50,40) ;
 	   Vent_MenuPrincipal mPrincipal = new Vent_MenuPrincipal(nuevoJuego);
 	   
 	    nuevoJuego.iniciarPersonajes(); 
 	    nuevoJuego.PantallaInicial();
 	    
	}
	
}
