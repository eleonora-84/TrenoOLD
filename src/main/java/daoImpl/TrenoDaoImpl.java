package daoImpl;

import java.util.List;


import dao.*;
import treno.Treno;
import dto.*;

public class TrenoDaoImpl implements TrenoDao {
	
	private static TrenoDaoImpl instance = null;
	
	private TrenoDaoImpl() {
	}

	public static TrenoDaoImpl getInstance() {
		if (instance==null) 
			return new TrenoDaoImpl();
		else return instance;
	}
	
	@Override
	public TrenoDTO add(Treno treno) {

		TrenoDTO trenoDTO = new TrenoDTO(treno.getSigla(), treno.getPeso());


		return trenoDTO;
	}

	@Override
	public Treno updateTreno(Treno treno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTreno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Treno> listaTreni() {
		// TODO Auto-generated method stub
		return null;
	}


}
	

