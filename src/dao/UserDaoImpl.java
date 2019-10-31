package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.Database;
import service.UserServiceImpl;
import vo.UserVO;

public class UserDaoImpl implements UserDao { //데베에 접속한 내용들

	private static UserDaoImpl instance;
	
	private UserDaoImpl(){}
	
	public static UserDaoImpl getInstance(){
		if(instance == null){
			instance = new UserDaoImpl();
		}
		return instance;
	}

	Database database = Database.getInstance();
	
	@Override
	public UserVO selectUser(String key, String value) {
		for (int i = 0; i < database.tb_user.size(); i++) {
			UserVO user = database.tb_user.get(i);
			
			if(key.equals("ID")){
				if(user.getUserID().equals(value)){
					return user;
				}
			}
		}
		return null;
	}

	@Override
	public void insertUser(UserVO user) {
		database.tb_user.add(user);
	}

	@Override
	public UserVO selectUser(HashMap<String, String> param) {
		UserVO rtnUser = null;
		
		for(int i=0; i<database.tb_user.size(); i++){
			UserVO user = database.tb_user.get(i);
			boolean flag = true;
			
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("ID")){
					if(!user.getUserID().equals(value)){
						flag = false;
					}
				}else if(key.equals("PASSWORD")){
					if(!user.getPassword().equals(value)){
						flag = false;
					}
				}else if(key.equals("NAME")){
					if(!user.getUserName().equals(value)){
						flag = false;
					}
				}
			}
			if(flag){
				rtnUser = user;
			}
		}
		return rtnUser;
	}

	@Override
	public ArrayList<UserVO> selectUserList() {
		return database.tb_user;
	}


	
	

	
	
	
	
}
