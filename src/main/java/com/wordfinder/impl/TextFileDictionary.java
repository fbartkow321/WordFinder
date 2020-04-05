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

		InputStreamReader dictionaryFileStreamReader = getDictionaryInputStreamReader();

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

	@Override
	public List<String> getAllMatchingWords(String regex) throws WordFinderDictionaryException {
		List<String> allWords = new ArrayList<>();

		InputStreamReader dictionaryFileStreamReader = getDictionaryInputStreamReader();

		try (BufferedReader bufferedReader = new BufferedReader(dictionaryFileStreamReader)) {
			String line = bufferedReader.readLine();
			while (line != null) {
				if (line.matches(regex)) {
					allWords.add(line);
				}
				line = bufferedReader.readLine();
			}
		} catch (IOException exception) {
			throw new WordFinderDictionaryException(FAILED_TO_RETRIEVE_TEXT_DICTIONARY, exception);
		}

		return allWords;
	}

	@Override
	public List<String> getLargestMatchingWords(String regex) throws WordFinderDictionaryException {
		List<String> allWords = new ArrayList<>();

		InputStreamReader dictionaryFileStreamReader = getDictionaryInputStreamReader();

		try (BufferedReader bufferedReader = new BufferedReader(dictionaryFileStreamReader)) {
			String line = bufferedReader.readLine();
			int largestLength = 0;
			while (line != null) {
				if (line.matches(regex)) {
					if (line.length() > largestLength) {
						allWords.clear();
						allWords.add(line);
						largestLength = line.length();
					} else if (line.length() == largestLength) {
						allWords.add(line);
					}
				}
				line = bufferedReader.readLine();
			}
		} catch (IOException exception) {
			throw new WordFinderDictionaryException(FAILED_TO_RETRIEVE_TEXT_DICTIONARY, exception);
		}

		return allWords;
	}

	/**
	 * Gets the flat-text file dictionary from the resource directory as an Input
	 * Stream Reader.
	 * 
	 * @return {@link InputStreamReader} for the flat-text file dictionary from the
	 *         resource directory
	 */
	protected InputStreamReader getDictionaryInputStreamReader() {
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream dictionaryFileAsStream = classLoader.getResourceAsStream(DICTIONARY_FILE_STRING);
		return new InputStreamReader(dictionaryFileAsStream);
	}
}
