package dao;

import java.util.ArrayList;

import data.Database;
import vo.ReviewVO;

public class ReviewDaoImpl implements ReviewDao {

	
	private static ReviewDaoImpl instance;
	private ReviewDaoImpl(){}
	
	public static ReviewDaoImpl getInstance(){
		if(instance == null){
			instance = new ReviewDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();

	
	@Override
	public void insertReview(ReviewVO review) {
		database.tb_review.add(review);
	}

	@Override
	public ArrayList<ReviewVO> SelectReview() {
		return database.tb_review;
	}

}
