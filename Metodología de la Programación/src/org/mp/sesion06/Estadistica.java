package org.mp.sesion06;

import java.io.*;
import java.util.*;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Estadistica {
	private ConjuntoDatos cd;
	
	public Estadistica(ConjuntoDatos cd) {
		this.cd= cd;
		
	}
	
	public double media ( String columna) throws Exception {
		double[] datos = cd.getColumna(columna);
		DescriptiveStatistics stats = new DescriptiveStatistics(datos);
		return stats.getMean();
	
	}

	public double max (String columna) throws Exception {
		double[] datos = cd.getColumna(columna);
		DescriptiveStatistics stats= new DescriptiveStatistics(datos);
		return stats.getMax();
		
	}

	public double min (String columna) throws Exception {
		double[] datos = cd.getColumna(columna);
		DescriptiveStatistics stats= new DescriptiveStatistics(datos);
		return stats.getMin();
		
	}

	public double suma ( String columna) throws Exception {
		double[] datos = cd.getColumna(columna);
		DescriptiveStatistics stats = new DescriptiveStatistics(datos);
		return stats.getSum();
		
	}
}
