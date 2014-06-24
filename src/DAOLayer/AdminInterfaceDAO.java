package DAOLayer;

import java.util.List;

import Exceptions.MyException;

public interface AdminInterfaceDAO {
	public boolean add(Object newObject) throws MyException;
	public boolean remove(int id) throws MyException;
	public boolean update(Object newObject) throws MyException;
	public List<?> readAll() throws MyException;
}
