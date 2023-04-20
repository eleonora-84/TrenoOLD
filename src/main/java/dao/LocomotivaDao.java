package dao;

import java.util.List;

import vagoni.Locomotiva;

public interface LocomotivaDao{
	public int add(Locomotiva locomotiva);
	public int add();	
	public void update(Locomotiva locomotiva);
	public Locomotiva get(int id);
	public void delete();
	public List<?> lista();
}
