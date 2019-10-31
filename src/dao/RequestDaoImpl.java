package dao;

import java.util.ArrayList;

import vo.RequestVO;
import data.Database;

public class RequestDaoImpl implements RequestDao{

	Database database = Database.getInstance();
	
	private static RequestDaoImpl instance;
	private RequestDaoImpl(){}
	
	public static RequestDaoImpl getInstance(){
		if(instance == null){
			instance = new RequestDaoImpl();
		}
		return instance;
	}
	
	
	@Override
	public ArrayList<RequestVO> selectWishList() {
		return database.tb_request;
	}
	
	@Override
	public void insertRequestBook(RequestVO a) {
		database.tb_request.add(a);
		}
	
	
	
}
