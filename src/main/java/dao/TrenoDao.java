package dao;

import java.util.List;

import treno.Treno;

public interface TrenoDao{
	public int add(Treno treno);
	public Treno updateTreno(Treno treno);
	public void deleteTreno();
	public List<Treno> listaTreni();
}
