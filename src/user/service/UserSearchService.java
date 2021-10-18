/*
 1. 이름검색
 2. 아이디 검색
 번호 입력 : ?
 
 만약 1번일 경우 
 이름 입력 : 홍(홍이들어간 이름 전부 검색) => search()
 홍길동	hong	111
 진분홍	pink	222
 
 2번일 경우
 아이디 입력 : n(n가 들어간 아이디 다 찾아오기) => search()
 홍길동	hong	111
 진분홍	pink	222
  */


package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		
		
		
		
		int num;
		while(true) {
			System.out.println();
			System.out.println("*************");
			System.out.println("   1. 이름 검색");
			System.out.println("   2. 아이디 검색");
			System.out.println("*************");
			System.out.print("번호 입력 : ");
			num = scan.nextInt();
			
			if(num==1) {
				System.out.println("이름 입력");
				String name = scan.next();
				
				UserDTO userDTO = new UserDTO();
				userDTO.setName(name);
				
				UserDAO userDAO= UserDAO.getInstance();
				List<UserDTO> list=userDAO.search(userDTO);
				
				for(UserDTO data : list) {
					System.out.println(data.getName()+"\t"+data.getId()+"\t"+data.getPwd());
					
				}
				return;
			}else if(num==2) {
				System.out.println("아이디 입력");
				String id = scan.next();
				
				UserDTO userDTO = new UserDTO();
				userDTO.setId(id);
				
				UserDAO userDAO= UserDAO.getInstance();
				
				List<UserDTO> list=userDAO.search(userDTO);
				
				for(UserDTO data : list) {
					System.out.println(data.getName()+"\t"+data.getId()+"\t"+data.getPwd());
					
				}
				return;
			}
			
		}//while
	}

}
