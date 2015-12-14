/**
 * 
 */
package br.mp.mpt.gerentepessoas.service;

/**
 * @author joao
 *
 */
public class NegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NegocioException(String message) {
		super(message);
	}
	
}
