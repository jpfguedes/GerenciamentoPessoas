/**
 * 
 */
package br.mp.mpt.gerentepessoas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mp.mpt.gerentepessoas.model.Setor;
import br.mp.mpt.gerentepessoas.repository.Setores;

/**
 * @author joao.guedes
 *
 */

@FacesConverter(forClass = Setor.class)
public class SetorConverter implements Converter {
	
	@Inject
	private Setores setores;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Setor retorno = null;
		
		if(value != null && !value.isEmpty()) {
			retorno = this.setores.porId(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Setor setor = (Setor) value;
			return setor.getId() == null ? null : setor.getId().toString();
		}
		
		return "";
	}

}
