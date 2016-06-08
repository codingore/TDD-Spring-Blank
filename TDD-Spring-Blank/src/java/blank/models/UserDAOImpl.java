package blank.models;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);	
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);		
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		return userList;		
	}

	@Override
	@Transactional
	public User getUserByCode(String code) {
		Session session = this.sessionFactory.getCurrentSession();		
		List<User> userList = session.createQuery("from User where code = '" + code + "'").list();
		if (userList.size() == 0) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	@Override
	@Transactional
	public void removeUser(String code) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User)session.load(User.class, code);
		if (null != u) {
			session.delete(u);
		}		
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User where email = '" + email + "'").list();
		if (userList.size() == 0) {
			return null;
		} else {
			return userList.get(0);
		}
	}

}
