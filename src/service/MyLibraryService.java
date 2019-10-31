package service;

import java.util.ArrayList;

import vo.BookVO;
import vo.RentalVO;

public interface MyLibraryService {
	
	void rentalList();
	//대출
	
	void allRentalList();
	//총대출
	
	void reserveList();
	//예약
	
	void renewList();
	//연장
	
	void returnRequest(ArrayList<RentalVO> rentalList);
	//반납신청
	
	
	//========================
	
	
	void writeReview(String bookName, String bookNumber);
	void writeReview();
	//리뷰 작성
	
	
	
	
	void messageBox();
	//쪽지함
	
	void messageView();
	//쪽지 자세히 읽기
	
	void wishBook();
	//희망 도서 신청
	
}
