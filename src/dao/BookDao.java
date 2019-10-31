package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.BookVO;
import vo.RentalVO;
import vo.ReviewVO;

public interface BookDao {
	
	BookVO selectBook(String key, String value);
	
	BookVO selectBook(String value);
	
	ArrayList<BookVO> selectBook(HashMap<String, String> param); //얘 있으면 위에 필요없음
	
	//도서 삽입
	void insertBook(BookVO book);
	
	//전체 도서 조회
	ArrayList<BookVO> selectBookList();
	
	//리뷰 조회
	ArrayList<ReviewVO> selectReview(HashMap<String, String> param);
	
	//반납내역추가
	boolean addBook(RentalVO rv);
	
	//대여내역삭제
	boolean removeBook(RentalVO rv);
}
