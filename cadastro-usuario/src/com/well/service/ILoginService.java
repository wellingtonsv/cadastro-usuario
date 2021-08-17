package com.well.service;

import java.util.List;

import com.well.model.User;

/**
 * Contrato de login do usuário
 * 
 * @author WVieira
 *
 */
public interface ILoginService {
	
	/**
	 * Metodo de validar o usuário.
	 * 
	 * @param login
	 * @param password
	 * @return true/false
	 */
	boolean authenticateUser(String login, String password);
	
	/**
	 * Metodo busca o usuário pelo login 
	 * 
	 * @param login
	 * @return User
	 */
	User getUserByUserId(String login);
	
	/**
	 * Metodo que retorna todos os usuários cadastrados
	 * 
	 * @return
	 */
	List<User> getListOfUsers();
}
