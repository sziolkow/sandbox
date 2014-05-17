package com.github.sziolkow.recommender.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataMovieConverter {

	/**
	 * cut u.data | cut -f1,2,3 | tr "\\t" ","
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("data/u.data"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("data/movies.csv"));
        String line;
        while ((line = reader.readLine()) != null ) {
        	String[] values = line.split("\\t",-1);
        	writer.write(values[0] + "," + values[1] + "," + values[2] + "\n");
        }
        reader.close();
        writer.close();
	}

}
