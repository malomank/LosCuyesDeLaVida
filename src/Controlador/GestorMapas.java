package Controlador;
import Modelo.*;

public class GestorMapas {

	// crea mapa (de la forma que estaba en el proyecto anterior)
	
		public void crearMapa(Mapa mapa,int indice){
			switch (indice){
			case 0:
					for(int i=0;i<12;i++){
						for(int j=0;j<16;j++){
							if(i>2 && i<7) {
								mapa.establecerCaracter(i, j, 'N');
								//if(j==0 && i==5) mapa.establecerCaracter(i, j, 'B');
								if(j==5 && i==5) mapa.establecerCaracter(i, j, 'D');
								if(j==12) mapa.establecerCaracter(i, j, 'T');
								else {
									if((j==13||j==14)&&(i==4||i==5)) mapa.establecerCaracter(i, j, 'E');
								}
							}
							if(i==7) mapa.establecerCaracter(i, j, 'p');
							if(i>7){
								mapa.establecerCaracter(i, j, 'S');
								//if(i==10 && j==0) mapa.establecerCaracter(i, j, 'A');
								if(i==9 && j==5) mapa.establecerCaracter(i, j, 'D');
								if(i==9 && j==11) mapa.establecerCaracter(i, j, 'C');
							}
							if((j==6 || j==7) && i>0) mapa.establecerCaracter(i, j, 'v');
						}
					}
			        break;
			case 1: 
					for(int i=0;i<12;i++){
						for(int j=0;j<16;j++){
							if(j>11) {
								if(i<2) mapa.establecerCaracter(i, j, 'N');
								if(i==2) mapa.establecerCaracter(i, j, 'p');
								if(i>2 && i<5) mapa.establecerCaracter(i, j, 'S');
								if(i>4)  mapa.establecerCaracter(i, j, 'n');
							}
							else{
								if(i==7 || i==8)  mapa.establecerCaracter(i, j, 'N');
								if(i==9) mapa.establecerCaracter(i, j, 'p');
								if(i>9) mapa.establecerCaracter(i, j, 'S');
								if(j==6 && i>6)  mapa.establecerCaracter(i, j, 'g');
							}
							//if(j==0 && i==7) mapa.establecerCaracter(i, j, 'B');
							//if(j==0 && i==11) mapa.establecerCaracter(i, j, 'A');
							if((j==5 || j==10) && (i==8 || i==10)) mapa.establecerCaracter(i, j, 'D');
						}
					}
			        break;
			case 2:
					for(int i=0;i<12;i++){
						for(int j=0;j<16;j++){
							if(i>0 && i<6){
								mapa.establecerCaracter(i, j, 'N');
								//if(i==5 && j==0) mapa.establecerCaracter(i, j, 'B');
								if(i==3 && j==3) mapa.establecerCaracter(i, j, 'C');
								if(j==9 && i==5) mapa.establecerCaracter(i, j, 'D');
								if(j==4) mapa.establecerCaracter(i, j, 'h');
								if(j==7 && i<4) mapa.establecerCaracter(i, j, 'H');
								if(j==9 && i<5) mapa.establecerCaracter(i, j, 'H');
								if(i>3 && j>11) mapa.establecerCaracter(i, j, 'E');
							}
							if(i==6) {
								mapa.establecerCaracter(i, j, 'p');
								if(j==4) mapa.establecerCaracter(i, j, 'h');
								if(j>11) mapa.establecerCaracter(i, j, 'E');
							}
							if(i>6){
								mapa.establecerCaracter(i, j, 'S');
								//if(i==10 && j==0) mapa.establecerCaracter(i, j, 'A');
								if(i==9 && j==3) mapa.establecerCaracter(i, j, 'C');
								if(j==9 && i==7) mapa.establecerCaracter(i, j, 'D');
								if(j==4) mapa.establecerCaracter(i, j, 'h');
								if(j==7 && i>8) mapa.establecerCaracter(i, j, 'H');
								if(j==9 && i>7) mapa.establecerCaracter(i, j, 'H');
								if(i<9 && j>11) mapa.establecerCaracter(i, j, 'E');
							}
						}
					}
			        break;
			}
		}
		
}
