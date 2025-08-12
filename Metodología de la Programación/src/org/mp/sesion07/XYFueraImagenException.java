package org.mp.sesion07;

/**
 * Excepcion que salta cuando el punto esta fuera de la imagen
 * @author mec162
 *
 */
public class XYFueraImagenException extends Exception{

	/**
	 * Metodo que muestra un mensaje de error
	 * @param message variable de tipo String que contiene un mensaje de error
	 */
	public XYFueraImagenException(String message) {
		super(message);
	}
}
