/**
 * 
 */
package com.scb.event.workflow.exception;


/**
 * The {@link JobRepositoryInitializationException} is thrown when the JobRepositoryFactoryBean could not be
 * initialized.
 * 
 * @author Prabu Sivakumar
 * 
 */
public class JobRepositoryInitializationException extends Exception {

	private static final long serialVersionUID = 4032184482122661489L;

	public JobRepositoryInitializationException(final String msg) {
		super(msg);
	}

	public JobRepositoryInitializationException(final String msg, final Throwable cause) {
		super(msg, cause);
	}

}
