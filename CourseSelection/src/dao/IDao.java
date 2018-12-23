package dao;
import java.util.HashMap;
import entity.IEntity;;

public interface IDao {
	void insert(IEntity entity);
	void delete();
	void update();
	public HashMap<String, IEntity> getAllEntities(); 
	public IEntity getEntity(String Id);
}
