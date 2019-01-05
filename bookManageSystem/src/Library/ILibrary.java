package Library;

import java.util.HashMap;
import dataBase.*;

public interface ILibrary {
	boolean insert(elementType etp);
	boolean delete(elementType etp);
	boolean update(elementType etp);
	public HashMap<String, elementType> getAlletps();
	public elementType getEtp(String id);
}
