package Vista;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

import Control.Teclado;

public class Ventana extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	private static final int ANCHO = 1024;
	private static final int ALTO = 768;
	private static final String NOMBRE = "Juego";
	private static JFrame pantalla;	
	private static Thread thread;
	private static volatile boolean enFuncionamiento = false; //volatile no permite que sea utilizado por los 2 threads (MUTEX)
	private static Teclado teclado;
	//Probar que funciona actualizaciones
	private static int aps = 0;
	private static int fps = 0;
	
	public Ventana() {
		
		teclado = new Teclado();
		addKeyListener(teclado);
		setPreferredSize(new Dimension(ANCHO,ALTO));
		pantalla = new JFrame(NOMBRE);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setResizable(false);
		pantalla.setLayout(new BorderLayout());
		pantalla.add(this,BorderLayout.CENTER);
		pantalla.pack();
		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(true);
		this.iniciar();
	}

	// synchronized permite que los metodos no puedan modificar de forma simultanea la variable enFuncionamiento
	private synchronized void iniciar(){//inicia el thread
		enFuncionamiento = true;
		thread = new Thread(this,"Graficos");
		thread.start();
	}
	
	public synchronized void detener(){//detiene el thread
		enFuncionamiento = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void actualizar(){
		teclado.actualizar();
		
		if(teclado.arriba){
			System.out.println("arriba");
		}
		if(teclado.abajo){
			System.out.println("abajo");
		}
		if(teclado.derecha){
			System.out.println("derecha");
		}
		if(teclado.izquierda){
			System.out.println("izquierda");
		}
		
		//Probar que funciona actualizaciones
		aps++;
	}
	
	private void mostrar(){
		//Probar que funciona actualizaciones
		fps++;
	}
	
	@Override
	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60; //actualizaciones por segundo
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		//prueba para ver si funciona
		long referenciaContador = System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;
		
		requestFocus();
		
		while(enFuncionamiento){
			final long inicioBucle = System.nanoTime();
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido/ NS_POR_ACTUALIZACION;
			
			while(delta >= 1){;
				actualizar();
				delta--;
			}
			
			mostrar();
			if ( System.nanoTime() - referenciaContador > NS_POR_SEGUNDO){

				System.out.println("Actualizacion por segundo: " + aps + " " + "frames por segundo: " + fps);
				System.out.println("El thread 2 se ejecuta bien xD");
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		
		}
		
		
	}
}
