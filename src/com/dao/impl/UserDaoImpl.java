package com.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean check(User user) {
//		if (user != null) {
//			Session session = sessionFactory.openSession();
//			String hql = "from User where username=? and password=?";
//			Query query = session.createQuery(hql);
//			query.setString(0, user.getUsername());
//			query.setString(1, user.getPassword());
//			List<User> list = query.list();
//			if (!list.isEmpty()) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
//	}
		
		/////////////
		
		Session session = sessionFactory.openSession();
		if (user != null) {
			Transaction tx = null;
			try {

				tx = session.beginTransaction();
				// String hql = "from User where username=? and password=?";
				String hql = "insert into User values(?,?)";
				// System.out.print(user.getId().getUsername());
				// session.createQuery(hql).setString(0,
				// user.getId().getUsername()).setString(1,
				// user.getId().getPassword()).executeUpdate();
				// session.save(user);
				System.out.print(user);
				//System.out.print(user.getUsername()+user.getPassword());
		//	user.setUsername("1");
				//UserId ss = user.getId();
				// new UserId(user.getId())
				
//				查找  需要主键
//				User user_2 = (User) session.get(User.class, 1);
//				if (user_2 != null)
//					System.out.print(user_2.getUsername());
				
				
				//添加
				session.save(user);
				
				//删除 需要主键
//				user.setId(3);
//				session.delete(user);
				
				//修改 需要主键
//				user.setId(2);
//				session.update(user);
				
				
				tx.commit(); // 提交
				return true;
			}
			// query.setString(0, user.getId().getUsername());
			// query.setString(1, user.getId().getPassword());
			// List<User> list = query.list();
			catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
				return false;
			} finally {
				session.close();
			}
		}
		return false;

	}
}
