package org.mp.sesion07;

import java.util.ArrayList;

/**
 * Clase que permite crear una imagen
 * @author mec162
 *
 */
public class Imagen {
	private String formatoImagen;
	private String tipoImagen;
	private int lineas;
	private int columnas;
	private ArrayList<Banda> bandas;
	
	/**
	 * Constructor
	 * @param lineas variable de tipo entero que pasamos a parametro
	 * @param columnas variable de tipo entero que pasamos a parametro
	 * @param formatoImagen variable de tipo String que pasamos a parametro
	 * @param tipoImagen variable de tipo String que pasamos a parametro
	 */
	public Imagen (int lineas, int columnas, String formatoImagen, String tipoImagen) {
		this.lineas= lineas;
		this.columnas=columnas;
		this.formatoImagen=formatoImagen;
		this.tipoImagen=tipoImagen;
		this.bandas= new ArrayList<Banda>();
	}
	
	/**
	 * Metodo que nos permite obtener los datos que contiene un elemento (x,y) de la imagen
	 * @param x variable de tipo entero que pasamos a parametro
	 * @param y variable de tipo entero que pasamos a parametro
	 * @return devuelve un array con los datos obtenidos
	 * @throws XYFueraImagenException lanza una excepcion si el elemento x,y esta fuera del rango
	 */
	public Number[] getDatosPixel(int x, int y) throws XYFueraImagenException{
		if(!XYValida(x,y,x,y))
			throw new XYFueraImagenException("XY no valida");
		Number[] datos = new Number[getNumeroBandas()];
		for (int i=0;i<getNumeroBandas(); i++)
			datos[i]=getBanda(i).getDatoXY(x,y);
		
		return datos;
	}
	
	/**
	 * Metodo para obtener la imagen encerrada en los limites indicados como parametro
	 * @param x1 variable de tipo entero que pasamos a parametro
	 * @param y1 variable de tipo entero que pasamos a parametro
	 * @param x2 variable de tipo entero que pasamos a parametro
	 * @param y2 variable de tipo entero que pasamos a parametro
	 * @return devuelve un objeto de la clase Imagen
	 * @throws XYFueraImagenException lanza una excepcion si el elemento (x,y) esta fuera de rango
	 */
	public Imagen extraerImagen (int x1, int y1, int x2, int y2) throws XYFueraImagenException {
		XYValida(x1,y1,x2,y2);
		int lineas= y2-y1+1;
		int columnas= x2-x1+1;
		Imagen img= new Imagen(lineas, columnas, formatoImagen, tipoImagen);
		for(int i=0;i<bandas.size();i++) {
			Number[][] datos= new Number[lineas][columnas];
			for(int k=x1, f=0;k<(x2+1); k++, f++) {
				for(int j=y1, c=0;j<(y2+1); j++,c++) {
					datos[f][c]=getBanda(i).getDatoXY(k, j);
				}
			}
			Banda bandaIntegers = new Banda <>(getBanda(i).getNombreBanda(),datos);
			img.anadirBanda(bandaIntegers);
		}
		return img;
	}
	
	/**
	 * Añade una banda a la lista
	 * @param banda variable de tipo Banda que pasamos a parametro
	 */
	public void anadirBanda(Banda<?> banda) {
		bandas.add(banda);
	}
	
	/**
	 * Elimina una banda de la lista
	 * @param i indice de la banda a eliminar
	 */
	public void eliminarBanda(int i) {
		bandas.remove(i);
	}
	
	/**
	 * Getter
	 * @param i indice de la banda que queremos obtener
	 * @return devuelve la banda que se encuentra en la posicion i
	 */
	public Banda<Number> getBanda(int i){
		return (Banda<Number>) bandas.get(i);
	}
	
	/**
	 * Getter
	 * @return devuelve la lista completa de bandas
	 */
	public ArrayList<Banda<?>> getBandas(){
		return (ArrayList<Banda<?>>)bandas.clone();
	}
	
	/**
	 * Getter
	 * @return devuelve el numero de bandas de la lista, el tamaño
	 */
	public int getNumeroBandas() {
		return bandas.size();
	}
	
	/**
	 * Getter
	 * @return devuelve el numero de lineas o filas de la matriz de datos de la banda
	 */
	public int getLineas() {
		return lineas;
	}
	
	/**
	 * Getter
	 * @return devuelve el numero de columnas de la matriz de datos de la banda
	 */
	public int getColumnas(){
		return columnas;
	}
	
	/**
	 * Getter
	 * @return devuelve el tipo de imagen
	 */
	public String getTipoImagen() {
		return tipoImagen;
	}
	
	/**
	 * Setter
	 * @param tipoImagen variable de tipo String que pasamos a parametro
	 */
	public void setTipoImagen(String tipoImagen) {
		this.tipoImagen= tipoImagen;
	}
	
	/**
	 * Getter
	 * @return devuelve el formato de la imagen
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}
	
	/**
	 * Setter
	 * @param formatoImagen variable de tipo String que pasamos a parametro
	 */
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen=formatoImagen;
	}
	
	/**
	 * Setter
	 * @param bandas variable de tipo ArrayList que pasamos a parametro
	 */
	public void setBandas(ArrayList<Banda> bandas) {
		this.bandas=bandas;
	}
	
	/**
	 * Metodo que comprueba que las coordenadas especificadas son correctas y estan dentro del rango
	 * @param x1 variable de tipo entero que pasamos a parametro
	 * @param y1 variable de tipo entero que pasamos a parametro
	 * @param x2 variable de tipo entero que pasamos a parametro
	 * @param y2 variable de tipo entero que pasamos a parametro
	 * @return devuelve true si las coordenadas son correctas y false si no son validas
	 * @throws XYFueraImagenException lanza una excepcion si las coordenadas no son correctas
	 */
	private boolean XYValida(int x1, int y1, int x2, int y2) throws XYFueraImagenException{
		if(( x1 > lineas || x2 > lineas) || (y1 > columnas || y2 > columnas))
			throw new XYFueraImagenException(null);
		return true;
	}
	
	public String toString() {
		
		return null;
	}
	
}
