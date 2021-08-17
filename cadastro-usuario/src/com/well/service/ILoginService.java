package com.well.service;

import java.util.List;

import com.well.model.User;

/**
 * Contrato de login do usu�rio
 * 
 * @author WVieira
 *
 */
public interface ILoginService {
	
	/**
	 * Metodo de validar o usu�rio.
	 * 
	 * @param login
	 * @param password
	 * @return true/false
	 */
	boolean authenticateUser(String login, String password);
	
	/**
	 * Metodo busca o usu�rio pelo login 
	 * 
	 * @param login
	 * @return User
	 */
	User getUserByUserId(String login);
	
	/**
	 * Metodo que retorna todos os usu�rios cadastrados
	 * 
	 * @return
	 */
	List<User> getListOfUsers();
}
