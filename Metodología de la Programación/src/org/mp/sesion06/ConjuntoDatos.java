package org.mp.sesion06;

import java.io.*;
import java.util.*;

public class ConjuntoDatos {
	private File archivoTexto;
	private String separador;
	private Locale locale;
	private List cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double[][] datos;
	
	/**
	 * Constructor
	 * @param archivoTexto objeto de la clase File que pasamos a parametro
	 * @param separador objeto de tipo String que indica que separa de un elemento a otro
	 * @param locale objeto de tipo Locale que pasamos a parametro
	 * @throws Exception lanza una excepcion si no se encuentra el archivo
	 */
	public ConjuntoDatos(File archivoTexto, String separador, Locale locale) throws Exception{
		this.archivoTexto= archivoTexto;
		this.separador= separador;
		this.locale= locale;
		this.numeroLineas= numLineas(archivoTexto);
		this.numeroColumnas=numColumnas(archivoTexto);
		this.cabecera=cabecera(archivoTexto);
		this.datos=leerDatos(archivoTexto,numeroLineas, numeroColumnas);
	}
	
	/**
	 * Permite obtener la cabecera de un arcchivo
	 * @param archivoTexto objeto de la clase File que pasamos a parametro
	 * @return devuelve la cabecera del archivoTexto
	 * @throws IOException lanza una excepcion si el archivo no se encuentra
	 */
	private List cabecera(File archivoTexto) throws IOException{
		FileReader fr= new FileReader(archivoTexto);
		BufferedReader br = new BufferedReader(fr);
		
		String cadena;
		cadena= br.readLine();
		ArrayList cabecera = new ArrayList();
		
		Scanner scanner1 = new Scanner (cadena);
		scanner1.useDelimiter(separador);
		scanner1.useLocale(locale);
		while (scanner1.hasNext())
			cabecera.add(scanner1.next());
		return cabecera;
	}
	
	/**
	 * Metodo para obtener el numero de lineas del archivo
	 * @param archivoTexto objeto de la clase File que pasamos a parametro
	 * @return devuelve el numero de lineas del archivo 
	 * @throws IOException lanza una excepcion si no se encuentra el archivo
	 */
	private int numLineas(File archivoTexto) throws IOException {
		FileReader fr =new FileReader(archivoTexto);
		BufferedReader br= new BufferedReader(fr);
		
		int numLineas = 0;
		while ((br.readLine()) !=null)
			numLineas += 1;
		
		br.close();
		return numLineas -1;
	}
	
	/**
	 *  metodo privado para obtener el numero de columnas de un archivo
	 * @param archivoTexto objeto de la clase File que pasamos a parametro
	 * @return devuelve el numero de columnas
	 * @throws IOException lanza una excepcion si no se encuentra el archivo
	 */
	private int numColumnas(File archivoTexto) throws IOException{
		FileReader fr = new FileReader(archivoTexto);
		BufferedReader br = new BufferedReader(fr);
		
		String cadena;
		int numColumnas = 0;
		cadena = br.readLine();
		
		Scanner scanner = new Scanner(cadena);
		scanner.useDelimiter(separador);
		scanner.useLocale(locale);
		while (scanner.hasNext()) {
			scanner.next();
			numColumnas += 1;
		}
		br.close();
		return numColumnas;
	}
	
	/**
	 * metodo privado para obtener los datos de un archivo en una matriz
	 * @param archivoTexto objeto de la clase File que pasamos a parametro
	 * @param filas objeto de tipo int que pasamos a parametro
	 * @param columnas objeto de tipo in que pasamos a parametro
	 * @return devuelve una matriz con los datos que contiene el archivo
	 */
	private double[][] leerDatos(File archivoTexto, int filas, int columnas){
		double[][] datosPotables = new double[filas][columnas];
		
		try {
			FileReader fr= new FileReader(archivoTexto);
			BufferedReader br= new BufferedReader(fr);
			br.readLine();
			
			for ( int i = 0; i< filas; i++) {
				String cadena = br.readLine();
				Scanner sc= new Scanner(cadena);
				sc.useDelimiter(separador);
				sc.useLocale(locale);
				int j = 0;
				while (sc.hasNext()) {
					datosPotables[i][j]= sc.nextDouble();
					j++;
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datosPotables;
	}
	
	/**
	 * Getter
	 * @param columna objeto de tipo entero que pasamos a parametro
	 * @return devuelve un array con el numero de columnas pasado como parametro
	 * @throws Exception lanza una excepcion si no se cumple 
	 */
	public double[] getColumna(int columna) throws Exception {
		if (columna < 0 && columna > numeroColumnas)
			throw new Exception("Columna no valida");

		double[] array = new double[numeroLineas];
		for (int i = 0 ; i < numeroLineas; i++)
			array[i] = datos[i][columna];

		return array;
	}
	
	/**
	 * Getter
	 * @param columna objeto de tipo entero que pasamos a parametro
	 * @return devuelve un array con la columna que queremos encontrar
	 * @throws Exception lanza una excepcion si no encuentra la columna
	 */
	public double[] getColumna(String columna)throws Exception {
		Iterator iterador = cabecera.iterator();
		boolean encontrado = false;
		int i = 0;
		int indice = 0;
		
		while (iterador.hasNext()) {
			String cadena = (String) iterador.next();
			if (cadena.equals(columna)) {
				indice = i ;
				encontrado = true;
				break;
			}
				i++;
		}
		if (!encontrado)
			throw new Exception("Columna no valida");
		
			return getColumna(indice);
	}
	
	/**
	 * Getter
	 * @return devuelve la cabecera del archivo
	 */
	public List getCabecera() {
		return cabecera;
	}
	
	/**
	 * Getter
	 * @return devuelve el separador
	 */
	public String getSeparador() {
		return separador;
	}
	
	/**
	 * Getter
	 * @return devuelve el locale
	 */
	public Locale getLocale() {
		return locale;
	}
	
	/**
	 * Getter
	 * @return devuelve el numero de lineas del archivo
	 */
	public int getNumeroLineas() {
		return numeroLineas;
	}
	
	/**
	 * Getter
	 * @return devuelve el numero de columnas del archivo
	 */
	public int getNumeroColumnas() {
		return numeroColumnas;
	}
	
	/**
	 * Getter
	 * @return devuelve los datos del archivo
	 */
	public double[][] getDatos(){
		return datos;
	}
	 
	/**
	 * Getter
	 * @return devuelve el archivo
	 */
	public File getArchivoTexto() {
		return archivoTexto;
	}
	
	/**
	 * Metodo que copia la informacion de un archivo en otro nuevo
	 * @param cabecera objeto de tipo String que pasamos a parametro
	 * @param archivoTexto objeto de tipo File que pasamos como parametro
	 * @param separador objeto de tipo String que pasamos como parametro
	 * @throws Exception lanza una excepcion si no encuentra el archivo
	 */
	public void exportar(String[] cabecera, String archivoTexto, String separador)throws Exception {
		double[][] tempDatos = new double[numeroLineas][cabecera.length];

		for (int i = 0; i < cabecera.length; i++) {
			double[] tempCol = getColumna(cabecera[i]);//array con todos los datos que vamos a meter
			for (int j = 0; j < tempCol.length; j++) {
				tempDatos[j][i] = tempCol[j];
			}
		}

		PrintWriter pw = new PrintWriter(archivoTexto); 

		for (int i = 0; i < cabecera.length; i++) { //Escribir la cabecera
			pw.print(cabecera[i]); 
			if (i < cabecera.length - 1)
				pw.print(separador);
		}

		pw.println();
		for (int i = 0; i < tempDatos.length; i++) {
			for (int j = 0; j < tempDatos[0].length; j++) {//Metemos todos los datos
				pw.print(tempDatos[i][j]);

				if (j < tempDatos[0].length - 1)
					pw.print(separador);
			}
			pw.println();

		}
		pw.close();
	}
	
	/**
	 * Metodo que exporta la informacion de un archivo a otro nuevo 
	 * @param cabecera indica la cabecera que quiere exportar al archivo nuevo
	 * @param archivoTexto objeto de tipo File que pasamos como parametro
	 * @param separador objeto de tipo String que pasamos como parametro
	 * @param locale objeto de tipo Locale que pasamos como parametro
	 * @return devuelve un objeto de la clase ConjuntoDatos con el archivo nuevo
	 * @throws Exception lanza una excepcion si no encuetra el archivo, el separador y el locale indicado
	 */
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto, String separador, Locale locale) throws Exception{
		exportar(cabecera, archivoTexto, separador);
		return new ConjuntoDatos(new File(archivoTexto), separador, locale);
	}
}
