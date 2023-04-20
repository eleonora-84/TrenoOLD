package dao;

import java.util.List;

import vagoni.Vagone;

public interface VagoneDao {
	public int add(Vagone vagone);
	public Vagone updateVagone(Vagone vagone);
	public void deleteVagone();
	public List<Vagone> listavagoni();
}
