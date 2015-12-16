/**
 * 
 */
package br.mp.mpt.gerentepessoas.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mp.mpt.gerentepessoas.model.Setor;

/**
 * @author joao.guedes
 *
 */

public class Setores implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Setor porId(Long id) {
		return this.manager.find(Setor.class, id);
	}
	
	public Setor guardar(Setor setor) {
		return this.manager.merge(setor);
	}
}
