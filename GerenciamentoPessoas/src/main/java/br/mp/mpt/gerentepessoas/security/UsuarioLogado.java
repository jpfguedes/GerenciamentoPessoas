/**
 * 
 */
package br.mp.mpt.gerentepessoas.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * @author joao
 *
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.METHOD, ElementType.FIELD } )
public @interface UsuarioLogado {

}
