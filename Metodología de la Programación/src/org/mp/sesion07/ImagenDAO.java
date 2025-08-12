package org.mp.sesion07;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase que nos permite leer un objeto de la clase Imagen
 * @author mec162
 *
 */
public class ImagenDAO {

	/**
	 * Metodo para escribir en un archivo de caracteres
	 * @param nombreArchivo nombre del archivo de datos
	 * @param imagen objeto de la clase Imagen que queremos leer
	 * @throws IOException lanza una excepcion si no se encuentra el archivo especificado
	 */
	public static void escribirArchivo(String nombreArchivo, Imagen imagen) throws IOException {

		File file = new File (nombreArchivo);
		
		PrintWriter pw = new PrintWriter(file);
		
		String nombre = file.getName();
		int indice = nombre.indexOf(".");
		nombre = nombre.substring(0,indice); 
		
		pw.println(nombre + ".dat");
		pw.println(imagen.getTipoImagen());
		pw.println(imagen.getFormatoImagen());
		
		int nBandas = imagen.getNumeroBandas();
		pw.println(nBandas);
		
		String s = "[";
		for(Iterator<Banda<?>> it = imagen.getBandas().iterator(); it.hasNext();) {
			Banda<?>banda = it.next();
			s+= banda.getNombreBanda() + ";";
			
		}
		
		s= s.substring(0,s.length()-1);
		s+= "]";
		pw.println(s);
		
		pw.println(imagen.getLineas()); 
		pw.println(imagen.getColumnas());
		
		pw.close();
		
		String nombreAPoner = file.getParent();
		nombreAPoner+= File.separator + nombre + ".dat";
		
		escribirBSQ(nombreAPoner,imagen);
			
	}

	/**
	 * Metodo privado para escribir en un archivo el contenido binario de una imagen
	 * @param nombreArchivo nombre del archivo de datos
	 * @param imagen objeto de la clase Imagen que queremos leer
	 * @throws IOException lanza una excepcion si no se encuentra el archivo especificado
	 */
	private static void escribirBSQ(String nombreArchivo, Imagen imagen) throws IOException {

		File salidaBinaria = new File (nombreArchivo);
		FileOutputStream fis = new FileOutputStream(salidaBinaria);
		DataOutputStream dos = new DataOutputStream(fis);
		
		String tipoImagen = imagen.getTipoImagen();
		int lineas = imagen.getLineas();
		int columnas = imagen.getColumnas();
		int numeroBandas = imagen.getNumeroBandas();
		for(int i =0; i< numeroBandas ; i++) {
			for (int j = 0; j < lineas; j++) {
				for (int k = 0; k < columnas; k++) {

					if (tipoImagen.equals("Integer")) {
						dos.writeInt((imagen.getBanda(i).getDatoXY(k, j).intValue()));
					}
					if(tipoImagen.equals("Double")) {
						dos.writeDouble((imagen.getBanda(i).getDatoXY(k, j).doubleValue()));

					}

				}	
			
			}
		
		}
		dos.close();
		
	}

	/**
	 * Metodo que permite leer un archivo de caracteres
	 * @param nombreArchivo nombre del archivo que queremos leer
	 * @return devuelve una imagen construida con la informacion leida del archivo
	 * @throws IOException lanza una excepcion si no se encuentra el archivo
	 */
	public static Imagen leerArchivo(String nombreArchivo) throws IOException {
		File file = new File(nombreArchivo);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);


		String nombre = br.readLine();
		String tipoImagen = br.readLine();
		String formatoImagen = br.readLine();
		int numeroBandas = Integer.parseInt(br.readLine());

		String bandas = br.readLine();
		
		bandas = bandas.substring(1,bandas.length()-1); 

		Scanner sn = new Scanner(bandas);
		sn.useDelimiter(";");
		String[] abandas = new String[numeroBandas];
			int i=0;
			while (sn.hasNext()) {
				abandas[i] = sn.next();
				i++;
			}
		int lineas = Integer.parseInt(br.readLine());
		int columnas = Integer.parseInt(br.readLine());
		br.close();
		String nombreArchivo1 = file.getParent() + File.separator + nombre;
		Imagen imagen = null;
		imagen = new Imagen(lineas, columnas, "BSQ", "Integer");
		imagen.setTipoImagen(tipoImagen);
		imagen = leerBSQ(nombreArchivo1, imagen, abandas, tipoImagen);

		return imagen;

	}

	/**
	 * Metodo para leer el contenido binario de un archivo
	 * @param nombreArchivo archivo que queremos leer
	 * @param imagen objeto de la clase Imagen que queremos leer
	 * @param nbandas array que contiene las bandas de la imagen
	 * @param tipoImagen variable de tipo String que pasamos a parametro
	 * @return devuelve una imagen con sus correspondientes bandas leidas del archivo binario
	 * @throws IOException lanza una excepcion si no se encuentra el archivo
	 */
	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen, String[] nbandas, String tipoImagen)
			throws IOException {

		FileInputStream fis = new FileInputStream(nombreArchivo);
		DataInputStream dis = new DataInputStream(fis);

		int lineas = imagen.getLineas();
		int columnas = imagen.getColumnas();
		int numeroBandas = nbandas.length;

		for (int i = 0; i < numeroBandas; i++) {
			Number[][] pixeles = new Number[lineas][columnas];
			for (int j = 0; j < lineas; j++) {
				for (int k = 0; k < columnas; k++) {
					if (tipoImagen.equals("Integer"))
						pixeles[k][j] = dis.readInt();
					if(tipoImagen.equals("Double"))
						pixeles[k][j] = dis.readDouble();

				}

			}

			Banda banda = new Banda(nbandas[i], pixeles);
			imagen.anadirBanda(banda);
		}
		fis.close();
		dis.close();
		return imagen;

	}

}
