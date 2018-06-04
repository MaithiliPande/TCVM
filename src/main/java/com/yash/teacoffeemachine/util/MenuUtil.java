package com.yash.teacoffeemachine.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.exception.EmptyFileException;
import com.yash.teacoffeemachine.exception.FileDoesNotExistException;



public class MenuUtil {
	
	Logger logger = Logger.getLogger(MenuUtil.class);

	public File findFile(String filePath) {
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			File file = new File(classLoader.getResource(filePath).getFile());
			return file;
		} catch (Exception exception) {
			logger.error("file does not exist");
			throw new FileDoesNotExistException("File does not exist");
		}
	}

	public void readFile(String fileName) {
		BufferedReader bufferedReader = null;
		File file = findFile(fileName);
		if (file.length() == 0) {
			logger.error("file is empty");
			throw new EmptyFileException("File is empty");
		} else {
			try {
				bufferedReader = new BufferedReader(new FileReader(file));
			} catch (Exception exception) {
				logger.error("file does not exist");
				throw new FileDoesNotExistException("File does not exist");
			}
			String text;
			try {
				while ((text = bufferedReader.readLine()) != null) {
					System.out.println(text);
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		logger.info("File is read");
	}

}
