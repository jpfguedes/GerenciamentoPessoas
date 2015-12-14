/**
 * 
 */
package br.mp.mpt.gerentepessoas.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mp.mpt.gerentepessoas.util.jsf.FacesUtil;

/**
 * @author joao
 *
 */

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private HttpServletResponse response;

	private String email;
	
	public void login() throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, response);
		
		facesContext.responseComplete();
	}

	public void preRender() {
		if("true".equals(request.getParameter("invalid"))) {
			FacesUtil.addErrorMessage("Usuário ou senha inválido!");
		}
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
