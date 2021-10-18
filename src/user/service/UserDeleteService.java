/*
 삭제할 아이디 입력 : angel
  찾고자 하는 아이디가 없습니다.(getuser())
  
  삭제할 아이디 입력 : hong
 
  
  데이터를 삭제하였습니다.(delete()) 
 
 * */

package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("삭제할 아이디 입력 :");
			String id = scan.next();
			
			
			UserDTO userDTO = new UserDTO();
			userDTO.setId(id);
			
			UserDAO userDAO = UserDAO.getInstance();
			
			userDTO = userDAO.getuser(userDTO);

			if(userDTO==null) {
				System.out.println("찾고자하는 아이디가 없습니다.");
			}else {
				userDAO.delete(userDTO);
				
				System.out.println("삭제 완료");
				return;
	
			}
		}
		
	}

}
