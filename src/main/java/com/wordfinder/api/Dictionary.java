package com.wordfinder.api;

import java.util.List;

import com.wordfinder.exception.WordFinderDictionaryException;

/**
 * Interface for all dictionaries, be them text file dictionaries, or perhaps
 * databases in the future.
 */
public interface Dictionary {

	/**
	 * Get every single word in the dictionary as a List of Strings.
	 * 
	 * @return {@link List} of {@link String} objects for every single word in the
	 *         dictionary.
	 * @throws WordFinderDictionaryException when there is an issue retrieving all
	 *                                       words
	 */
	List<String> getAllWords() throws WordFinderDictionaryException;

	/**
	 * Get every single word in the dictionary that matches the given regular
	 * expression.
	 * 
	 * @param regex {@link String} of a regular expression
	 * @return {@link List} of {@link String} objects for every single word in the
	 *         dictionary.
	 * @throws WordFinderDictionaryException when there is an issue retrieving all
	 *                                       words
	 */
	List<String> getAllMatchingWords(String regex) throws WordFinderDictionaryException;

	/**
	 * Get the largest words in dictionary that match the given regular expression.
	 * This is a List as opposed to a single word in case there are multiple words
	 * of the same length.
	 * 
	 * @param regex {@link String} of a regular expression
	 * @return {@link List} of {@link String} objects for every single word in the
	 *         dictionary.
	 * @throws WordFinderDictionaryException when there is an issue retrieving all
	 *                                       words
	 */
	List<String> getLargestMatchingWords(String regex) throws WordFinderDictionaryException;

}
