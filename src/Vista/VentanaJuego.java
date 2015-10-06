package Vista;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.Teclado;

public class VentanaJuego extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 1300; //276 para barra lateral
	private static final int ALTO = 768; 
	private static final String NOMBRE = "Los Cuyes de la vida";

	private     JPanel      panelJuego;
	private     JPanel      panelLateral;
	private BufferedImage image;
	
	public VentanaJuego(){
		
		//teclado = new Teclado();
		//addKeyListener(teclado);
		setPreferredSize(new Dimension(ANCHO,ALTO));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLayout(null);
		//this.setLayout(new BorderLayout());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		crearPanelJuego();
		crearPanelLateral();
		this.getContentPane().add(panelJuego);
		this.getContentPane().add(panelLateral);
		//this.iniciar();
	}
	
	public void crearPanelJuego(){
		panelJuego = new JPanel();
		panelJuego.setPreferredSize( new Dimension( 1024, 768 ) );
		try {
			image = ImageIO.read(new File("/Mapas/dibujo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel jLabel = new JLabel(new ImageIcon(image));
		panelJuego.add(jLabel);
		panelJuego.setVisible(true);
	}
	public void crearPanelLateral(){
		panelLateral = new JPanel();
		panelLateral.setPreferredSize( new Dimension( 236, 768 ) );
		panelLateral.setVisible(true);
	}
	
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
	
}
