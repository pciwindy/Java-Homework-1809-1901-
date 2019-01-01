package Library;

import java.util.HashMap;
import dataBase.*;

public interface ILibrary {
	void insert(elementType etp);
	void delete(elementType etp);
	void update(elementType etp);
	public HashMap<String, elementType> getAlletps();
	public elementType getEtp(String id);
}
