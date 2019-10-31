package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import util.RegEx;
import vo.UserVO;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class UserServiceImpl implements UserService { //서비스나 다오는 여러곳에서 쓰일수 있으므로 싱글톤

	private static UserServiceImpl instance;
	
	private UserServiceImpl(){}
	
	public static UserServiceImpl getInstance(){
		if(instance == null){
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	UserDao userDao = UserDaoImpl.getInstance();
	
	@Override
	public void join() {
		//회원가입
		//사용자 정보 입력
		Scanner s = new Scanner(System.in);
		
		System.out.print("아이디\t\t\t: ");
		String id = s.nextLine();
		while(!RegEx.regId(id)){
			System.out.print("적합하지 않은 아이디입니다. 다시 입력해주세요. \r아이디\t\t\t: ");
			id = s.nextLine();
		}
		
		System.out.print("비밀번호\t\t\t: ");
		String password = s.nextLine();
		while(!RegEx.regPw(password)){
			System.out.print("적합하지 않은 비밀번호입니다. 다시 입력해주세요. \r비밀번호\t\t\t: ");
			password = s.nextLine();
		}
		
		System.out.print("이름\t\t\t: ");
		String name = s.nextLine();
		while(!RegEx.regName(name)){
			System.out.print("적합하지 않은 이름입니다. 다시 입력해주세요. \r이름\t\t\t: ");
			name = s.nextLine();
		}

		System.out.print("이메일\t\t\t: ");
		String email = s.nextLine();
		while(!RegEx.regemail(email)){
			System.out.print("적합하지 않은 이메일입니다. 다시 입력해주세요. \r이메일\t\t\t: ");
			email = s.nextLine();
		}
		
		
		System.out.print("생년월일(yyyy-mm-dd)\t: ");
		String birthDay = s.nextLine();
		while(!RegEx.regBirth(birthDay)){
			System.out.print("적합하지 않은 생년월일입니다. \r생년월일[yyyy-mm-dd]\t: ");
			birthDay = s.nextLine();
		}
		
		System.out.print("주소\t\t\t: ");
		String address = s.nextLine();
		
		
		System.out.print("핸드폰번호(-포함)\t\t: ");
		String tel = s.nextLine();
		while(!RegEx.regPhone(tel)){
			System.out.print("적합하지 않은 핸드폰번호 입니다. 다시 입력해주세요. \r핸드폰번호(-포함)\t\t: ");
			tel = s.nextLine();
		}
		
		//아이디 중복 검사(아이디가 일치하는 회원 검색)
		UserVO user = new UserVO();
		user.setUserID(id);
		user.setPassword(password);
		user.setUserName(name);
		user.setEmail(email);
		user.setBirthDate(birthDay);
		user.setAddress(address);
		user.setTel(tel);
	
		UserVO userCheck = userDao.selectUser("ID", user.getUserID());
		
		//사용자 정보 저장
		if(userCheck == null){
			userDao.insertUser(user);
			System.out.println(user.getUserName() + "님의 가입을 환영합니다.");
		}else{
			System.out.println("이미 존재하는 아이디입니다.");
		}
	}

	Scanner s = new Scanner(System.in);
	@Override
	public void login() {
		//로그인
		//아이디, 비밀번호 입력
		
		System.out.print("아이디 : ");
		String id = s.nextLine();
		System.out.print("비밀번호 : ");
		String password = s.nextLine();
		
		//아이디와 비밀번호가 일치하는 회원 검색
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("ID", id);
		param.put("PASSWORD", password);
		
		UserVO user = userDao.selectUser(param);
		
		//있으면 로그인
		//없으면 로그인 실패
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else if(user.getUserID() == "admin"){
			Session.loginUser = user;
			System.out.println("[관리자 로그인 성공]");
			System.out.println("==== [관리자]님 환영합니다. ====");
		}
		else{
			Session.loginUser = user;
			System.out.println("- - - - - - - - - - - - -");
			System.out.println("[로그인 성공]");
			System.out.println("==== [" + user.getUserName() + "]님 환영합니다. ====");
		}
	}

	@Override
	public void userList() {
		//회원 전체 목록 출력
		//회원 전체 검색
		ArrayList<UserVO> userList = userDao.selectUserList();
		
		//출력
		System.out.println("=======================");
		System.out.println("번호\t아이디\t이름");
		System.out.println("-----------------------");
		for(int i=0; i<userList.size(); i++){
			UserVO user = userList.get(i);
			System.out.println(i + 1 + "\t" + user.getUserID() + "\t" + user.getUserName());
		}
		System.out.println("=======================");
		
		// 유저 개인정보 상세 보기
		String detailUserID;
		int menu = 99;
		do{
			System.out.println("1. 유저 상세조회 \t 0. 이전 메뉴로 돌아가기 \n");
			System.out.print("해당하는 번호를 입력해주세요 > ");
			
			try{
				menu = Integer.parseInt(s.nextLine());
			}catch(Exception e){
				System.out.println("올바른 값을 입력해주세요!");
			}
			
				switch(menu){
				case 1:
					System.out.print("상세조회할 유저의 아이디를 입력해주세요. > ");
					detailUserID = s.nextLine();
					
					boolean check = true;
					for(int i=0; i<userList.size(); i++){
						UserVO user = userList.get(i);
							if(detailUserID.equals(user.getUserID())){
								System.out.println("\n---<" + user.getUserID()+">---");
								System.out.println("이름: "+ user.getUserName());
								System.out.println("이메일: "+ user.getEmail());
								System.out.println("생일: "+ user.getBirthDate());
								System.out.println("주소: "+ user.getAddress());
								System.out.println("전화번호: "+ user.getTel());
								System.out.println("-------------------------"+"\n"+"\n");
								check = false;
							}
					}
					if(check){
						System.out.println("=== 일치하는 회원 아이디가 없습니다. \n");
					}
					break;
				case 0: break;
				}
		}while(menu != 0);
		
	}

	


}
