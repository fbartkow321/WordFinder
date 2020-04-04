package com.wordfinder.api;

import java.util.List;

import com.wordfinder.exception.WordFinderDictionaryException;

/**
 * Main interface for finding words with letters in a certain order.
 */
public interface WordFinder {

	/**
	 * Given a String, find all of the words that exist with the letters in the
	 * String, in that order.
	 * 
	 * @param lettersInOrder {@link String} of the letters in order
	 * @return {@link List} of {@link String} objects of the words containing the
	 *         letters in the correct order
	 * @throws WordFinderDictionaryException when there is an issue with retrieving
	 *                                       data from the dictionary
	 */
	List<String> findWordsWithLettersInOrder(String lettersInOrder) throws WordFinderDictionaryException;

}
