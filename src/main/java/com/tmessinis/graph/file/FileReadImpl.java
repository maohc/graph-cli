package com.tmessinis.graph.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReadImpl implements FileRead {

	@Override
	public List<String> readContent(String fileLocation) throws FileNotFoundException, IOException {
		List<String> content = new ArrayList<String>();
		FileInputStream fstream = new FileInputStream(fileLocation);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			if (!strLine.startsWith("#") && !strLine.startsWith("//")) {
				/** disregard the comment */
				content.add(strLine);
			}
		}
		br.close();
		return content;
	}

}
