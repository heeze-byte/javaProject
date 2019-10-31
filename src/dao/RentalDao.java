package dao;

import java.util.ArrayList;

import vo.RentalVO;

public interface RentalDao {
	
	

	ArrayList<RentalVO> selectRentalList();
	
	void changeReturnDueDate(int num, RentalVO a);
	
	boolean addRentalBook(RentalVO rv);
	
	void removeRentalBook(int num);
	
	
	ArrayList<RentalVO> selectReturnList();
	
	boolean addReturnBook(RentalVO rv);
	
}
