package dao;

import java.util.List;

import dto.TrenoDTO;
import treno.Treno;

public interface TrenoDao{
	public TrenoDTO add(Treno treno);
	public Treno updateTreno(Treno treno);
	public void deleteTreno();
	public List<Treno> listaTreni();
}
