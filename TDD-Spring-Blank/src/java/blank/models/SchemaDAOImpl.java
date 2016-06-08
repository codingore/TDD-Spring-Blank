package blank.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SchemaDAOImpl implements SchemaDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public void executeSqlScript(String filename) {
		Session session = this.sessionFactory.getCurrentSession();
		session.doWork(connection -> 
			ScriptUtils.executeSqlScript(connection, new ClassPathResource(filename))		
				); 
	}

}
