package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources; //이걸로 import해야함
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {

	private static UserDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	
	public static UserDAO getInstance() {
		if(instance == null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO();
			}
		}
		return instance;
	}
	
	public UserDAO() {
		
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//userDAO()



	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("userSQL.write", userDTO); //정수(int)형을 리턴
		sqlSession.commit(); //insert,update,delete 
		sqlSession.close();
		
		
	}//write(UserDTO userDTO) 

	
	public List<UserDTO> getUserList() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList"); //따로 담을필요없이 알아서 담아줌
		//하나만 가져올땐 sqlSession.selectOn
		
		sqlSession.close();
		return list;
	}

	public String getuser(String userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String idCheck = sqlSession.selectOne("userSQL.getUser",userDTO);
		
		return idCheck;
	}

	public UserDTO getuser(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserDTO list = sqlSession.selectOne("userSQL.getUser",userDTO);
		return list;
	}

	public void update(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.update", userDTO);
		sqlSession.commit(); //insert,update,delete 
		sqlSession.close();
	}

	public void delete(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete", userDTO);
		sqlSession.commit(); //insert,update,delete 
		sqlSession.close();
	}

	public List<UserDTO> search(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search",userDTO); 
		return list;
	}

	
	
	
	
	
	
	
	

}
