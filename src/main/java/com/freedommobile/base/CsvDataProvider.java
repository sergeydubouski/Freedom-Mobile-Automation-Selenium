package com.freedommobile.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.opencsv.CSVReader;

/**
 * class CsvDataProvider
 * 
 * @author SD
 * @version 1.0
 * @since 22.12.2020
 */
public class CsvDataProvider {

	@DataProvider(name = "csvDataReader")
	public static Iterator<Map> csvDataReader(Method m) {

		String path = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "dataproviders"
				+ File.separator + m.getDeclaringClass().getSimpleName() + File.separator + m.getName()+".csv";

		List<Map> list = new ArrayList<Map>();

		try {
			CSVReader csvReader = new CSVReader(new FileReader(path));

			String[] key = csvReader.readNext();
			if (key != null) {
				String[] value;
				while ((value = csvReader.readNext()) != null) {
					Map<String, String> dataSet = new HashMap<String, String>();
					for (int i = 0; i < key.length; i++) {
						dataSet.put(key[i], value[i]);
					}
					list.add(dataSet);
					//list.add(new Object[] { dataSet });
				}
				csvReader.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file [" + path + "] is not accessible. Please verify the file path/name.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The file [" + path + "] is not readable. Please verify the file.");
			e.printStackTrace();
		}
		return list.iterator();
	}
}
