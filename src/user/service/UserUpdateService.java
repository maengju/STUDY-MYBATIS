/*
 수정할 아이디 입력 : angel
  찾고자 하는 아이디가 없습니다.(getuser())
  
  수정할 아이디 입력 : hong
  홍길동 hong  111 
  수정 할 이름 입력 : 홍당무
  수정 할 비밀 번호 입력 : 333
  
  데이터를 수정하였습니다.(update())
 */

package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("수정할 아이디 입력 :");
			String id = scan.next();
			
			
			UserDTO userDTO = new UserDTO();
			userDTO.setId(id);
			
			UserDAO userDAO = UserDAO.getInstance();
			
			userDTO = userDAO.getuser(userDTO);

			if(userDTO==null) {
				System.out.println("찾고자하는 아이디가 없습니다.");
			}else {
				System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
				
				System.out.print("수정할 이름 입력 : " );
				String name = scan.next();
				
				System.out.print("수정할 비밀번호 입력 : ");
				String pwd = scan.next();
				
				userDTO.setName(name);
				userDTO.setPwd(pwd);
				
				userDAO.update(userDTO);
				
				System.out.println("수정 완료");
				return;
	
			}
		}
		
	}

}
