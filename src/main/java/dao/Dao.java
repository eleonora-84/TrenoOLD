package dao;

import java.util.List;

public interface Dao {
	public int add(Object obj);
	public Object update(Object obj);
	public void delete();
	public List<?> lista();
}
