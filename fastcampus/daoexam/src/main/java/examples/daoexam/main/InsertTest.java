package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import examples.daoexam.dao.RoleDao;

public class InsertTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		RoleDao roleDao =ac.getBean(RoleDao.class);

		Role role = new Role();
		role.setRoleId(500);
		role.setDescription("CTO");
		
		int count = roleDao.insert(role);
		
		System.out.println(count + "건 저장하였습니다.");
	}

}
