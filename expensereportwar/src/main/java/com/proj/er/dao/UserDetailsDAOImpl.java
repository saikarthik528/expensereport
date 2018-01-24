package com.proj.er.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.proj.er.model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
	
	public UserDetails addUserDetails(UserDetails user) {
		Session session = this.sessionFactory.getCurrentSession();
		user.setCreatedOn(new Date(System.currentTimeMillis()));
        session.persist(user);
        logger.info("User saved successfully, User Details=" + user);
        return user;
	}

	public void updateUserDetails(UserDetails user) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User Details updated successfully, User Details=" + user);
	}

	@SuppressWarnings("unchecked")
	public List<UserDetails> listUserDetails() {
		Session session = this.sessionFactory.getCurrentSession();
        List<UserDetails> userList = session.createQuery("from UserDetails").list();
        for (UserDetails user : userList) {
            logger.info("User List::" + user);
        }
        return userList;
	}

	public UserDetails getUserDetailsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails user = (UserDetails) session.load(UserDetails.class, new Integer(id));
        logger.info("User loaded successfully, User details=" + user);
        return user;
	}

	public void removeUserDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserDetails user = (UserDetails) session.load(UserDetails.class, new Integer(id));
        if (null != user) {
            session.delete(user);
        }
        logger.info("User deleted successfully, user details=" + user);
	}

}
