package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.UserVO;

public interface UserDao {//데이터베이스에 접속
	//단일회원 조회
	UserVO selectUser(String key, String value);
	
	UserVO selectUser(HashMap<String, String> param); //얘 있으면 위에 필요없음
	
	//회원 삽입
	void insertUser(UserVO user);
	
	//전체 회원 조회
	ArrayList<UserVO> selectUserList();
	
	
}
