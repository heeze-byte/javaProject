package dao;

import java.util.ArrayList;

import vo.RequestVO;

public interface RequestDao {

	void insertRequestBook(RequestVO a);
	
	ArrayList<RequestVO> selectWishList();
	
}
