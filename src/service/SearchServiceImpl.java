package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import util.DateUtil;
import vo.BookVO;
import vo.BookingVO;
import vo.RentalVO;
import vo.ReviewVO;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.BookingDao;
import dao.BookingDaoImpl;
import dao.RentalDao;
import dao.RentalDaoImpl;
import dao.ReviewDao;
import dao.ReviewDaoImpl;
import data.Database;
import data.Session;

public class SearchServiceImpl implements SearchService {

   
   private static SearchServiceImpl instance;
   private SearchServiceImpl(){}
   
   public static SearchServiceImpl getInstance(){
      if(instance == null){
         instance = new SearchServiceImpl();
      }
      return instance;
   }
   
   BookDao bookDao = BookDaoImpl.getInstance();
   ReviewDao reviewDao = ReviewDaoImpl.getInstance();
   RentalDao rentalDao = RentalDaoImpl.getInstance();
   BookingDao bookingDao = BookingDaoImpl.getInstance();
   
   @Override
   public void detailSearch() {
      Scanner s = new Scanner(System.in);
      
      System.out.println("");
      System.out.print("도서명 : ");
      String bookName = s.nextLine();
      
      HashMap<String, String> param = new HashMap<String, String>();
      param.put("BOOKNAME", bookName);
      
      ArrayList<BookVO> bookList = bookDao.selectBook(param);
      
      System.out.println("=============================================");
      System.out.println("번호" +"\t"+ "도서번호" + "\t" + "도서명" + "\t\t" + "저자");
      for(int i=0; i<bookList.size(); i++){
         BookVO book = bookList.get(i);
         if(book.getBookName().length() <5)
            book.setBookName(book.getBookName()+"\t");
         System.out.println(i+1 + "\t"+ book.getBookNumber() + "\t" + book.getBookName() + "\t" + book.getWriter());
      }
      if(bookList.size() == 0){
         System.out.println("해당 도서를 조회할 수 없습니다.");
         
      }else{
    	  System.out.println("=============================================");
    	  detailView(bookList);
      }
   }

   @Override
   public void searchSubject() {
      Scanner s = new Scanner(System.in);
      
      System.out.println("");
      System.out.println("----------분야----------");
      System.out.println("A. 문학");
      System.out.println("B. 철학");
      System.out.println("C. 종교");
      System.out.println("D. 사회과학");
      System.out.println("E. 자연과학");
      System.out.println("-----------------------");
      System.out.print("분야 번호 입력 > ");
      
      String areaNumber = s.nextLine();
      
      HashMap<String, String> param = new HashMap<String, String>();
      param.put("AREANUMBER", areaNumber);
      
      ArrayList<BookVO> bookList = bookDao.selectBook(param);
      
      System.out.println("=============================================");
      System.out.println("번호" +"\t"+ "도서번호" + "\t" + "도서명" + "\t\t" + "저자");
      for(int i=0; i<bookList.size(); i++){
         BookVO book = bookList.get(i);
         if(book.getBookName().length() <5)
            book.setBookName(book.getBookName()+"\t");
         System.out.println(i+1 + "\t"+ book.getBookNumber() + "\t" + book.getBookName() + "\t" + book.getWriter());
      }
   
      if(bookList.size() == 0){
         System.out.println("해당 도서를 조회할 수 없습니다.");
      }
      System.out.println("=============================================");
      detailView(bookList);
      
   }

   @Override
   public void detailView(ArrayList<BookVO> bookList) {
      Scanner s = new Scanner(System.in);
      
      System.out.print("상세내역을 조회하시려면 번호를 선택하세요 > ");
      
      int select = Integer.parseInt(s.nextLine());
      
      /*ArrayList<ReviewVO> review = new ArrayList<ReviewVO>();*/
      System.out.println();
      System.out.println("*********************************************");
      System.out.println("도서번호\t: " + bookList.get(select-1).getBookNumber());
      System.out.println("도서명\t: " + bookList.get(select-1).getBookName());
      System.out.println("저자\t: " + bookList.get(select-1).getWriter());
      System.out.println("서평\t: " + bookList.get(select-1).getBookInfo());
      System.out.println("보유 권 수\t: " + bookList.get(select-1).getInventory());
      System.out.println("\n-------------------- 리뷰 --------------------");
      
      
      HashMap<String, String> param = new HashMap<String, String>();
      param.put("BOOKNUMBER", bookList.get(select-1).getBookNumber());
      ArrayList<ReviewVO> reviewList = bookDao.selectReview(param);
      
      for(int i=0; i<reviewList.size(); i++){
         ReviewVO review = reviewList.get(i);
      System.out.println("리뷰번호" + "\t" +"아이디"+ "\t" + "별점" + "\t" + "리뷰");
      System.out.println(review.getReviewNumber() + "\t" + review.getUserID() + "\t"
                  + review.getStarScore()+ "\t" + review.getReviewContent());
      }
      
      if(reviewList.size() == 0){
         System.out.println("작성된 리뷰가 없습니다.");
         
      }
      System.out.println("\n*********************************************");
      System.out.println();
      
      rentalRequest(bookList, select);
      
   }
   
   
   @Override
   public void recentBook() {
	   Date today = new Date();
	   Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		
		cal.add(Calendar.DAY_OF_MONTH,-7);
		Date result = cal.getTime();
		
		
		//발간날짜 다 넣은 후에 3을 bookDao.selectBookList().size()으로 고쳐야함
	  for(int i=0; i<bookDao.selectBookList().size(); i++){
		  if(DateUtil.stringToDate(bookDao.selectBookList().get(i).getAccession()).compareTo(result) > 0){
			  System.out.println(bookDao.selectBookList().get(i).getBookName());
			  System.out.println(bookDao.selectBookList().get(i).getAccession());
		  }
	  }
   }


   @Override
   public void rentalRequest(ArrayList<BookVO> bookList, int select) {
	   Scanner s = new Scanner(System.in);
	      
	      System.out.println("---------------------------");
	      System.out.print("도서를 대여하시겠습니까?(y/n)>");
	      String select2 = s.nextLine();
	      System.out.println("---------------------------");
	      
	      if(select2.equals("y")){
	      
	      if(bookList.get(select-1).getInventory() > 0){
	    	  
	    	 String rentalDate = DateUtil.dateToString(new Date()); //대여날짜
	    	 String returnDueDate =  DateUtil.lendingPeriod(); //반납 예정일
	    	  
	    	  //대여 테이블 한 줄 추가
				RentalVO rental = new RentalVO();
				rental.setUserID(Session.loginUser.getUserID());
				rental.setBookNumber(bookList.get(select-1).getBookNumber());
				rental.setRentalDate(rentalDate);
				rental.setReturnDueDate(returnDueDate);
				rentalDao.addRentalBook(rental);
				
				
				System.out.println();
				
				System.out.println(rental.getUserID()+"님이 "+"'"+bookList.get(select-1).getBookName()+"'"+" 도서를 대여하셨습니다.");
				System.out.println("대여일\t: " + rental.getRentalDate());
				System.out.println("반납예정일\t: " + rental.getReturnDueDate());
				
				 //해당 책 보유권수 줄이기
			      bookList.get(select-1).setInventory(bookList.get(select-1).getInventory()-1);
		      }else{
		    	  System.out.println("해당 도서는 모두 대여 중 입니다.");
		    	  reserveRequest(bookList, select);
		      }
	      

	     	}else if(select2.equals("n")){
	    	  System.out.println("이전 메뉴로 돌아갑니다.");
	      }
	      

	      
   }

   @Override
   public void reserveRequest(ArrayList<BookVO> bookList, int select) {
	   Scanner s = new Scanner(System.in);
	      
	      System.out.println("---------------------------");
	      System.out.print("도서를 예약하시겠습니까?(y/n)>");
	      String select2 = s.nextLine();
	      System.out.println("---------------------------");
	      
	      if(select2.equals("y")){

	    	  ArrayList<RentalVO> rental = rentalDao.selectRentalList();
		    	
		    	//가장 빠른 예약 가능날짜
		    	String reserveDate = "9999년 99월 99일";
		    	
		    	//가장 빠른 예약 가능날짜 찾기
		    	for(int i=0; i<rental.size(); i++){
		    		if(rental.get(i).getBookNumber().equals(bookList.get(select-1).getBookNumber())){
		    			if(DateUtil.stringToDate(reserveDate).compareTo(DateUtil.stringToDate(rental.get(i).getReturnDueDate())) > 0){
		    				reserveDate = rental.get(i).getReturnDueDate();
		    			}
		    		}
		    	}

		    	
		    	BookingVO reserve = new BookingVO();
				reserve.setUserID(Session.loginUser.getUserID());
				reserve.setBookNumber(bookList.get(select-1).getBookNumber());
				reserve.setPossibleDate(reserveDate);
				reserve.setBookingDate(reserveDate);
				bookingDao.addReserveBook(reserve);
				
				System.out.println(reserve.getUserID()+"님이 "+"'"+bookList.get(select-1).getBookName()+"'"+" 도서를 예약하셨습니다.");
				System.out.println("예약일\t\t: " + reserve.getPossibleDate());
					

		    
		     	}else if(select2.equals("n")){
		    	  System.out.println("이전 메뉴로 돌아갑니다.");
		      }
   }





   
}