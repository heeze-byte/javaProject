package dao;

import java.util.ArrayList;

import vo.RentalVO;
import data.Database;

public class RentalDaoImpl implements RentalDao {

	
	private static RentalDaoImpl instance;
	private RentalDaoImpl(){}
	
	public static RentalDaoImpl getInstance(){
		if(instance == null){
			instance = new RentalDaoImpl();
		}
		return instance;
	}
	
	
	Database database = Database.getInstance();
	
	@Override
	public ArrayList<RentalVO> selectRentalList() {
		return database.tb_rental;
	}


	@Override
	public void changeReturnDueDate(int num, RentalVO date) {
		for(int i = 0; i < database.tb_rental.size(); i++){
			if(i == num){
				database.tb_rental.set(num, date);
			}
		}
	
	}

	@Override
	public boolean addRentalBook(RentalVO rv) {
		boolean result = database.tb_rental.add(rv);
		return result;
	}


	@Override
	public ArrayList<RentalVO> selectReturnList() {
		return database.tb_return;
	}

	@Override
	public boolean addReturnBook(RentalVO rv) {
		boolean result = database.tb_return.add(rv);
		return result;
	}

	@Override
	public void removeRentalBook(int num) {
		database.tb_rental.remove(num);
	}

}
