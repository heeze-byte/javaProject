package dao;

import java.util.ArrayList;

import data.Database;
import vo.LikeBookVO;

public class LikeBookDaoImpl implements LikeBookDao {

	private static LikeBookDaoImpl instance;
	private LikeBookDaoImpl(){}
		
	public static LikeBookDaoImpl getInstance(){
		if(instance == null){
			instance = new LikeBookDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	@Override
	public ArrayList<LikeBookVO> selectLikeBook() {
		return null;
	}




}
