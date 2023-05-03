package dao;

import java.util.List;

import dto.UtenteDTO;

public interface UtenteDao{	
	public void add(String username, String password);
	public UtenteDTO updateUtente(UtenteDTO utente);
	public UtenteDTO findByUsername(String username);
	public UtenteDTO findByPassword(String password);
	public void deleteUtente();
	public UtenteDTO findByID(int id);
	public List<UtenteDTO> listaUtenti();
	public UtenteDTO findByUsernameEPassword(String username, String password);
}
