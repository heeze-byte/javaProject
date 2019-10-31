package dao;

import java.util.ArrayList;

import vo.ReviewVO;

public interface ReviewDao {

	
	void insertReview(ReviewVO review);
	
	ArrayList<ReviewVO> SelectReview();
}
