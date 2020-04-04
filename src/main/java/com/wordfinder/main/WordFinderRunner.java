package com.wordfinder.main;

import java.util.List;

import com.wordfinder.api.WordFinder;
import com.wordfinder.exception.WordFinderDictionaryException;
import com.wordfinder.impl.WordFinderImpl;

/**
 * Houses the main method to kick off the whole thing.
 */
public class WordFinderRunner {

	/**
	 * Standard main method to kick off the process.
	 * 
	 * @param args Array of {@link String} objects passed in as arguments
	 */
	public static void main(String[] args) {
		WordFinder wordFinder = new WordFinderImpl();
		try {
			List<String> worsWithLettersInOrder = wordFinder.findWordsWithLettersInOrder("vlr");
			for (String word : worsWithLettersInOrder) {
				System.out.println(word);
			}
		} catch (WordFinderDictionaryException exception) {
			exception.printStackTrace();
		}
	}

}
