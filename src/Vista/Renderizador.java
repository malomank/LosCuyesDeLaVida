package Vista;

import Modelo.Mapa;
import Modelo.PersonajePrincipal;

public interface Renderizador{
	public void ImprimirMapa(Mapa mapa,PersonajePrincipal cuy1,PersonajePrincipal cuy2);
	public void actualizarMapa(Mapa mapa,PersonajePrincipal cuy1,PersonajePrincipal cuy2);
}
