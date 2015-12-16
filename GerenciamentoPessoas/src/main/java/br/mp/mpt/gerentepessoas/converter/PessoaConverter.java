/**
 * 
 */
package br.mp.mpt.gerentepessoas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mp.mpt.gerentepessoas.model.Pessoa;
import br.mp.mpt.gerentepessoas.repository.Pessoas;

/**
 * @author joao.guedes
 *
 */

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {
	
	@Inject
	private Pessoas pessoas;

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa retorno = null;
		
		if(value != null && !value.isEmpty()) {
			retorno = this.pessoas.porId(new Long(value));
		}
		
		return retorno;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Pessoa pessoa = (Pessoa) value;
			return pessoa.getId() == null ? null : pessoa.getId().toString();
		}
		
		return "";
	}

}
