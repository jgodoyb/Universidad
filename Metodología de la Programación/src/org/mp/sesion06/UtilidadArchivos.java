package org.mp.sesion06;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.*;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;

public class UtilidadArchivos {
	private ArrayList lista;
	
	public UtilidadArchivos() {
		super();
		lista = new ArrayList();
	}
	
	public static void copiar(File origen, File destino) throws IOException {
		FileInputStream origenStream = new FileInputStream(origen); 
		FileOutputStream destinoStream = new FileOutputStream(destino);

		byte[] buffer = new byte[1024];
		int i;
		while ((i = origenStream.read(buffer)) > 0)
			destinoStream.write(buffer, 0, i);
		origenStream.close();
		destinoStream.close();

	}
	
	public ArrayList listarDirectoriosArchivos(File dir) {
		lista.clear();
		listarDirectoriosArchivosRec(dir);
		return lista;
	}
	
	private void listarDirectoriosArchivosRec(File dir) {
		lista.add(dir.getAbsoluteFile());
		if(dir.isDirectory()) { 
			String [] child1 = dir.list();	
			for(int i=0; i<child1.length;i++) {
				listarDirectoriosArchivosRec(new File (dir, child1[i]));
			}
		}
	}
	
	public void zip(File dir, String caminoSalida, String nombreArchivo) {
		listarDirectoriosArchivos(dir);
		byte [] buffer = new byte [1024];
		try {
			String archivoSalida = caminoSalida + File.separator + nombreArchivo;
			ZipOutputStream zipos = new ZipOutputStream(new FileOutputStream(archivoSalida));
			
			for(java.util.Iterator iterador = lista.iterator() ; iterador.hasNext();) {
				File elemento = ((File) iterador.next());
				if(elemento.isFile()) {
					FileInputStream fis = new FileInputStream (elemento.getAbsolutePath());
					zipos.putNextEntry(new ZipEntry(elemento.getAbsolutePath()));
					int len;
					
					while( (len = fis.read(buffer)) >0) 
						zipos.write(buffer , 0 , len);
						
					zipos.closeEntry();	
				}	
			}		
					
		}catch(IOException e) {
		  e.printStackTrace();
		}	
	}
}
