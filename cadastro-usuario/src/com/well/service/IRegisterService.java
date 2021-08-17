package com.well.service;

import com.well.model.User;

/**
 * Contrato para registrar e verificar o usuario.
 * 
 * @author WVieira
 *
 */
public interface IRegisterService {

	/**
	 * Metodo de registrar o usuario.
	 * 
	 * @param user
	 * @return true/false
	 */
	boolean register(User user);
	
	/**
	 * Metodo que verifica se existe o usuario.
	 * 
	 * @param user
	 * @return true/false
	 */
	boolean isUserExists(User user);
}
