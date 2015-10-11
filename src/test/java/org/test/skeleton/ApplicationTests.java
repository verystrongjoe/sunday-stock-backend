package org.test.skeleton;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skeleton.Application;
import org.skeleton.mvc.entity.Users;
import org.skeleton.mvc.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests 
{

	@Autowired
	UserDao userDao;

	@Test
	public void create() {


		Users user = null;
		String email="test@gmail.com";;
		String firstName="Christ";
		String lastName="Jejus";
		String password = "kkk";
		long id = 1;

		try {
			boolean enabled = true;
			user = new Users();

			//			user.setId(id);
			//			user.setFirstName(firstName);
			//			user.setLastName(lastName);
			//			user.setPassword(password);
			//			user.setEmail(email);
			//			

			userDao.save(user);
		}
		catch (Exception ex) {
			System.err.println("Error creating the user: " + ex.toString());
		}
		System.err.println("User succesfully created! (user = " + user.toString() + ")");
	}

	
	
	@Test
	public void insertUser() {

//		Session session = getSession();
//		Transaction transaction = session.beginTransaction();
//		College college = new College();
//		college.setCollegeName("Dr.MCET");
//
//		Student student1 = new Student();
//		student1.setStudentName("Peter");
//
//		Student student2 = new Student();
//		student2.setStudentName("John");
//
//		student1.setCollege(college);
//		student2.setCollege(college);
//
//
//
//		session.save(student1);
//		session.save(student2);
//		transaction.commit();
//

	}




	//	@Test
	//  public void insert()
	//  {
	//      SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	//      Stock stock = new Stock("C0001", "StockCode");
	//      
	//      Session session = sessionFactory.openSession();
	//      
	//      session.beginTransaction();
	//      session.save(stock);
	//      session.getTransaction().commit();
	//      System.out.println("Insert completed");
	//   
	//      session.close();
	//      sessionFactory.close();
	//  }



}
