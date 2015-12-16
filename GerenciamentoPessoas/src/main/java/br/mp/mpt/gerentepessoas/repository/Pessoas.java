/**
 * 
 */
package br.mp.mpt.gerentepessoas.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.mp.mpt.gerentepessoas.model.Pessoa;

/**
 * @author joao.guedes
 *
 */

public class Pessoas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Pessoa porId(Long id) {
		return this.manager.find(Pessoa.class, id);
	}
	
	public Pessoa porDocumento(String documento) {
		try {
			return this.manager.createQuery("from Pessoa where documento = :documento", Pessoa.class)
					.setParameter("documento", documento)
					.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
	
	public Pessoa guardar(Pessoa pessoa) {
		return this.manager.merge(pessoa);
	}
}
