package Graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HojaSprites {
	public final int [] pixeles;
	private final int ancho;
	private final int alto;
	//ruta del sprite y su achon y alto
	public HojaSprites(final String ruta, final int ancho, final int alto){
		this.ancho = ancho;
		this.alto = alto;
		//ancho * alto es la cantidad de pixeles

		pixeles = new int[ancho * alto];
		
		try {
			BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource(ruta));
			//offset -> para desplazaar antes de dibujar         scansize -> hasta que punto debemos leer la linea horizontal para pasar a la siguiente linea
			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getAncho() {
		return ancho;
	}
}
