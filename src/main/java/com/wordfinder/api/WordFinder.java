package com.wordfinder.api;

import java.util.List;

import com.wordfinder.exception.WordFinderDictionaryException;

/**
 * Main interface for finding words with letters in a certain order.
 */
public interface WordFinder {

	/**
	 * Given a String, find all of the words that exist with the letters in that
	 * String, in that order.
	 * 
	 * @param lettersInOrder {@link String} of the letters in order
	 * @return {@link List} of {@link String} objects of the words containing the
	 *         letters in the correct order
	 * @throws WordFinderDictionaryException when there is an issue with retrieving
	 *                                       data from the dictionary
	 */
	List<String> findWordsWithLettersInOrder(String lettersInOrder) throws WordFinderDictionaryException;

	/**
	 * Given a String, find all of the words that exist with the letters in that
	 * String, in that order. This method comes with the added requirement of only
	 * returning the largest words.
	 * 
	 * @param lettersInOrder {@link String} of the letters in order
	 * @return {@link List} of {@link String} objects of the words containing the
	 *         letters in the correct order
	 * @throws WordFinderDictionaryException when there is an issue with retrieving
	 *                                       data from the dictionary
	 */
	List<String> findLargestWordsWithLettersInOrder(String lettersInOrder) throws WordFinderDictionaryException;

	/**
	 * Set the Dictionary for the Word Finder to use.
	 * 
	 * @param dictionary {@link Dictionary} implementation.
	 */
	void setDictionary(Dictionary dictionary);

}
