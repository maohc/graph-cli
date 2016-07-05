package com.tmessinis.graph.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileRead {

	List<String> readContent(String fileLocation) throws FileNotFoundException, IOException;

}
