/**
 * 
 */
package br.mp.mpt.gerentepessoas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.mp.mpt.gerentepessoas.model.Visita;
import br.mp.mpt.gerentepessoas.repository.Visitas;

/**
 * @author joao.guedes
 *
 */

@FacesConverter(forClass = Visita.class)
public class VisitaConverter implements Converter {
	
	@Inject
	private Visitas visitas;

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Visita retorno = null;
		
		if(value != null && !value.isEmpty()) {
			retorno = this.visitas.porId(new Long(value));
		}
		
		return retorno;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Visita visita = (Visita) value;
			return visita.getId() == null ? null : visita.getId().toString();
		}
		
		return "";
	}

}
