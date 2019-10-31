package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import util.DateUtil;
import vo.BookVO;
import vo.RentalVO;

public interface SearchService {

	void detailSearch();
	//통합검색
	
	void searchSubject();
	//분야별검색
	
	void detailView(ArrayList<BookVO> bookList);
	//상세보기
	
	void recentBook();
	//신착도서
	
/*	void review();
	//리뷰보기
*/	
	void rentalRequest(ArrayList<BookVO> bookList, int select);
	//대여신청
	
	void reserveRequest(ArrayList<BookVO> bookList, int select);
	//예약신청
	

	

}
