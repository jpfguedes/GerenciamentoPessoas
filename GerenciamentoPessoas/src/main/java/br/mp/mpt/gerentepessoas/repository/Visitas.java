/**
 * 
 */
package br.mp.mpt.gerentepessoas.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.mp.mpt.gerentepessoas.model.Visita;

/**
 * @author joao.guedes
 *
 */

public class Visitas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Visita porId(Long id) {
		return this.manager.find(Visita.class, id);
	}
	
	public Visita guardar(Visita visita) {
		return this.manager.merge(visita);
	}
}
