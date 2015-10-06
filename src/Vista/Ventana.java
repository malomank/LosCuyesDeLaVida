package Vista;
import java.awt.Color;

import javax.swing.*;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	JButton boton1; 
	JLabel etiqueta1; 
	JTextField caja1; 
	Color color = new Color(131,111,255); 
	JPanel uno, dos; 

	public Ventana() 
	{ 
		setTitle("ventana de prueva"); 
		setSize(300,300); 
		iniciar(); 
	} 
	public void iniciar() 
	{ 
		uno = new JPanel(); 
		dos = new JPanel(); 
		caja1 = new JTextField(); 
		etiqueta1 = new JLabel(); 
		boton1 = new JButton(); 
		getContentPane().setLayout(null); 
		// 	>>>> setDefaultCloseOperation(WindowConstants...
		
		boton1.setText("boton uno"); 
		boton1.setToolTipText("debes hacer click aqui"); 
		getContentPane().add(uno); 
		uno.setBounds(10,10, 100,100);//para fijar la posicion 
		//dentro de JFrame 
		// >>>> uno.setBorder(BorderFactory.createLineBo... 
		//para poner el borde 
		
		getContentPane().add(dos); 
		dos.setBounds(110,10, 100,100);//para fijar la posicion 
		//dentro de JFrame 
		// >>>> dos.setBorder(BorderFactory.createLineBo... 
		//para poner el borde 
		uno.add(boton1); 
		//para agregar el boton al 
		//JPanel 
		boton1.setBounds(60,50, 100,20); 
		//para fijar laposicion del boton 
		//dentro del JPanel 
		uno.add(etiqueta1); 
		//para agregar la etiqueta 
		//al JPanel 
		etiqueta1.setBounds(60,80, 100,20); 
		etiqueta1.setText("Esto es la etiqueta"); 
		uno.add(caja1); 
		//para agregar el JTextField 
		//al JPanel 
		caja1.setBounds(60,100, 100,20); 
		caja1.setText("Esto es el JTextField"); 
	}
}
