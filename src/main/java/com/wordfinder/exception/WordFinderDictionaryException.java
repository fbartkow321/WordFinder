package com.wordfinder.exception;

/**
 * This is essentially just a wrapper for the regular Java {@link Exception}
 * class. This one in particular is for exceptions with the Dictionary.
 */
public class WordFinderDictionaryException extends Exception {

	private static final long serialVersionUID = 5007545764128440768L;

	/**
	 * WordFinder Dictionary specific Exception.
	 * 
	 * @param message {@link String} briefly describing the cause of the issue
	 * @param cause   {@link Throwable} for tracking/logging purposes
	 */
	public WordFinderDictionaryException(String message, Throwable cause) {
		super(message, cause);
	}

}
