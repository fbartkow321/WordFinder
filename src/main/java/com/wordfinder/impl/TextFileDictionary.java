package com.wordfinder.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.wordfinder.api.Dictionary;
import com.wordfinder.exception.WordFinderDictionaryException;

/**
 * Text file implementation of the {@link Dictionary} class. Retrieves words
 * from a flat text file.
 */
public class TextFileDictionary implements Dictionary {

	public static final String DICTIONARY_FILE_STRING = "dictionary/words.txt";
	public static final String FAILED_TO_RETRIEVE_TEXT_DICTIONARY = "Failed to retrieve the text dictionary.";

	@Override
	public List<String> getAllWords() throws WordFinderDictionaryException {
		List<String> allWords = new ArrayList<>();

		ClassLoader classLoader = getClass().getClassLoader();
		InputStream dictionaryFileAsStream = classLoader.getResourceAsStream(DICTIONARY_FILE_STRING);
		InputStreamReader dictionaryFileStreamReader = new InputStreamReader(dictionaryFileAsStream);

		try (BufferedReader bufferedReader = new BufferedReader(dictionaryFileStreamReader)) {
			String line = bufferedReader.readLine();
			while (line != null) {
				allWords.add(line);
				line = bufferedReader.readLine();
			}
		} catch (IOException exception) {
			throw new WordFinderDictionaryException(FAILED_TO_RETRIEVE_TEXT_DICTIONARY, exception);
		}

		return allWords;
	}

}
