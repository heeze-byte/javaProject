package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import util.DateUtil;
import vo.BookVO;
import vo.BookingVO;
import vo.LikeBookVO;
import vo.PostVO;
import vo.RentalVO;
import vo.RequestVO;
import vo.ReviewVO;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.BookingDao;
import dao.BookingDaoImpl;
import dao.LikeBookDao;
import dao.LikeBookDaoImpl;
import dao.PostDao;
import dao.PostDaoImpl;
import dao.RentalDao;
import dao.RentalDaoImpl;
import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.ReviewDao;
import dao.ReviewDaoImpl;
import data.Session;


public class MyLibraryServiceImpl implements MyLibraryService {
	
	
	private static MyLibraryServiceImpl instance;
	private MyLibraryServiceImpl(){}
	
	public static MyLibraryServiceImpl getInstance(){
		if(instance == null){
			instance = new MyLibraryServiceImpl();
		}
		return instance;
	}

	RentalDao rentalDao = RentalDaoImpl.getInstance();
	BookDao bookDao = BookDaoImpl.getInstance();
	BookingDao bookingDao = BookingDaoImpl.getInstance();
	PostDao postDao = PostDaoImpl.getInstance();
	RequestDao requestDao = RequestDaoImpl.getInstance();
	LikeBookDao likeBookDao = LikeBookDaoImpl.getInstance();
	ReviewDao reviewDao = ReviewDaoImpl.getInstance();
	
	
//	MyLibraryService myLibraryService = MyLibraryServiceImpl.getInstance();
	
	Scanner s = new Scanner(System.in);

	
	@Override
	public void rentalList() {
		
		ArrayList<RentalVO> rentalList = rentalDao.selectRentalList();
		String nowLoginUser = Session.loginUser.getUserID();
		
		System.out.println("\n===================================================");
		System.out.println(nowLoginUser+"님께서 대여중이신 책-----");
		System.out.println("도서번호\t도서이름\t대출일자\t반납예정일자");
		System.out.println("---------------------------------------------------");
		
		int count = 0; 
		for(int i = 0; i < rentalList.size(); i++){
			RentalVO rental = rentalList.get(i);

			if(nowLoginUser.equals(rental.getUserID())){
				BookVO bookName = bookDao.selectBook("bookNumber", rental.getBookNumber());//도서번호로 도서이름찾기
				System.out.println(rental.getBookNumber()+"\t"+bookName.getBookName()+"\t"+rental.getRentalDate()+"\t"+rental.getReturnDueDate());
				System.out.println("===================================================\n");
				count++;
			}
		}
		if(count == 0){
			System.out.println("현재 대여중인 책이 없습니다.");
			System.out.println("===================================================\n\n");
		}else if(count != 0){
			System.out.println("---------------------------------------------------");
			System.out.println("1. 대여기간 연장신청");
			System.out.println("2. 반납하기");
			System.out.println("0. 이전 메뉴로 돌아가기");
			System.out.print("해당하는 번호를 입력해주세요. > ");
			System.out.println("---------------------------------------------------");
			int menu = Integer.parseInt(s.nextLine());
				switch(menu){
					case 1: renewList(); 							break;
					case 2: returnRequest(rentalList); 				break;
					default: System.out.println("이전메뉴로 돌아갑니다.\n"); break;
				}
		}
	}
	
	
	@Override
	public void allRentalList() {
		ArrayList<RentalVO> allRentalList = rentalDao.selectReturnList();
		String nowLoginUser = Session.loginUser.getUserID();
		
		System.out.println("\n===================================================");
		System.out.println(nowLoginUser+"님께서 대여하셨던 책--------");
		System.out.println("도서번호\t도서이름\t대출일자\t반납일자");
		System.out.println("---------------------------------------------------");
		
		int count = 0; 
		for(int i = 0; i < allRentalList.size(); i++){
			RentalVO rental = allRentalList.get(i);

			if(nowLoginUser.equals(rental.getUserID())){
				BookVO bookName = bookDao.selectBook("bookNumber", rental.getBookNumber());//도서번호로 도서이름찾기
				System.out.println(rental.getBookNumber()+"\t"+bookName.getBookName()+"\t"+rental.getRentalDate()+"\t"+rental.getReturnDueDate());
				count++;
			}
		}
		if(count == 0){
			System.out.println("대여하신 책이 없습니다.");
			System.out.println("===================================================\n");
		}else{
			writeReview();
		}
	}
	
	
	@Override
	public void reserveList() {
		ArrayList<BookingVO> bookingList = bookingDao.selectBookingList();
		String loginUser = Session.loginUser.getUserID();
		
		System.out.println("\n===================================================");
		System.out.println(Session.loginUser.getUserName()+"님께서 대출 예약하신 책-----");
		System.out.println("도서번호\t도서이름\t예약일자");
		System.out.println("---------------------------------------------------");
		
		
		for(int i = 0; i < bookingList.size(); i++){
			BookingVO booking = bookingList.get(i);
			if(loginUser.equals(booking.getUserID())){
				BookVO bookName = bookDao.selectBook("bookNumber", booking.getBookNumber());// <- 도서번호로 도서이름찾기
				System.out.println(booking.getBookNumber()+"\t"+bookName.getBookName()+"\t"+booking.getBookingDate());
			}else{
			System.out.println("예약한 책이 없습니다.");
			}
		}
		System.out.println("===================================================\n");
	}
	

	
	
	@Override
	public void renewList() {
		ArrayList<RentalVO> rentalList = rentalDao.selectRentalList();
		
				System.out.println("\n대여기간 연장을 원하는 도서번호를 입력해주세요.");
				String bookNumber = s.nextLine();
				
				String newReturnDueDate = "";
				for(int i = 0; i < rentalList.size(); i++){
					RentalVO rental = rentalList.get(i);
					if(bookNumber.equals(rental.getBookNumber())){
						Date returnDueDate = DateUtil.stringToDate(rental.getReturnDueDate());
						
						Calendar cal = Calendar.getInstance();
						cal.setTime(returnDueDate);
						
						cal.add(Calendar.DAY_OF_MONTH,5);
						String result = DateUtil.dateToString(cal.getTime()); //+5일한 새로운 대여 예정일
						rental.setReturnDueDate(result);	//을 rentalVO에 저장

						rentalDao.changeReturnDueDate(i, rental);
						newReturnDueDate = rental.getReturnDueDate();
					}
				}		
				System.out.println("대여기간이 연장되었습니다.");
				System.out.println("반납 예정일: "+ newReturnDueDate);
	}
	
	
	
	
	@Override
	public void returnRequest(ArrayList<RentalVO> rentalList) {
		Scanner s = new Scanner(System.in);
	      
	      System.out.println("\n---------------------------------------------------");
	      System.out.print("도서를 반납하시겠습니까?(y/n)>");
	      String select2 = s.nextLine();
	      System.out.println("---------------------------------------------------");
	      
	      if(select2.equals("y")){
	    	  System.out.print("반납하실 도서번호를 입력해주세요>");
	    	  //int select3 = Integer.parseInt(s.nextLine());
	    	  String bookNumber = s.nextLine();
	    	  
	    	  RentalVO returnBook = null;
	    	for(int i = 0; i < rentalList.size(); i++){
				RentalVO rental = rentalList.get(i);
				
				if(bookNumber.equals(rental.getBookNumber())){
					returnBook = rentalList.get(i);
					rentalDao.removeRentalBook(i);
				}
			}
	    	  
	    	RentalVO rentalBook = new RentalVO();
	    	
	    	//반납날짜
	    	String returnDate = DateUtil.dateToString(new Date());
	    	
	    	//반납테이블에 반납할 도서 정보 추가하고
	    	bookDao.addBook(returnBook);
	    	//대여테이블에 반납할 도서 정보 삭제
	    	bookDao.removeBook(returnBook);

	    	
	    	rentalDao.selectReturnList().get(rentalDao.selectReturnList().size()-1).setReturnDate(returnDate);
	    	System.out.println(returnDate+"에 반납 완료되었습니다.\n");
	    	

	    	
			//해당 책 보유권수 늘리기
	    	int count = 0;
	    	for(int i=0; i<bookDao.selectBookList().size(); i++){
	    		if(bookDao.selectBookList().get(i).getBookNumber().equals(returnBook.getBookNumber())){
	    			bookDao.selectBookList().get(i).setInventory(bookDao.selectBookList().get(i).getInventory()+1);
	    			count = i;
	    		}
	    	}
		    	// 리뷰 작성 여부 물어보기
		    	ArrayList<BookVO> bookList = bookDao.selectBookList();
		    	BookVO reviewBook = bookList.get(count);
		    	writeReview(reviewBook.getBookName(), reviewBook.getBookNumber());
    	  
	    
	     	}else if(select2.equals("n")){
	    	  System.out.println("이전 메뉴로 돌아갑니다.\n");
	      }
	      
		
	}
	
	


	//책을 반납하면서 리뷰작성하기
	//반납한 책의 이름, 도서번호
	@Override
	public void writeReview(String bookName, String bookNumber){
		String menu = "";
		do{ 
			 System.out.println("---------------------------------------------------");
		      System.out.print("리뷰를 작성하시겠습니까?(y/n)>");
		      menu = s.nextLine();
		      System.out.println("---------------------------------------------------");
			
				switch(menu){
					case "y":
						ReviewVO review = new ReviewVO();
						
						// 유저에게 입력받는 부분 (별점, 리뷰 내용) ====================
						System.out.println("["+bookName+"] 의 별점을 남겨주세요.\n최소 0, 최대 5");
						int starScore = Integer.parseInt(s.nextLine());
						System.out.println("리뷰 내용을 작성해주세요.");
						String reviewContent = s.nextLine();
						
						// 자동으로 값 출력하는 부분 (리뷰번호, 유저아이디, 별점 변환) =====================
						// 리뷰번호
						ArrayList<ReviewVO> reviewSize = reviewDao.SelectReview();
						int reviewNumber = reviewSize.size()+1;
						
						//유저 아이디
						String userId = Session.loginUser.getUserID();
					
						//별점 변환
						String starScoreToString = "";
						
						if(starScore == 0){
							starScoreToString = "☆☆☆☆☆";
						}else{
							for(int i = 1; i <= 5; i++){
								if(i <= starScore){
									starScoreToString +="★";
								}else if(i > starScore){
									starScoreToString +="☆";
								}
							}
						}
						
						//리뷰VO에 저장
						review.setReviewNumber(reviewNumber);
						review.setUserID(userId);
						review.setBookNumber(bookNumber);
						review.setBookName(bookName);
						review.setReviewContent(reviewContent);
						review.setStarScore(starScoreToString);
						reviewDao.insertReview(review);
						
						System.out.println("도서명: "+bookName+"\t별점: "+starScoreToString);
						System.out.println("리뷰가 저장되었습니다!\n");
						menu = "n";
						break;
					case "n":	break;
				}
			}while(!(menu.equals("n")));
	}
	
	
	//대출이력조회에서 리뷰 작성하기
	@Override
	public void writeReview() {
		//유저 아이디, 리뷰 -> DB에 저장
		int menu = 99;
		do{ 
			System.out.println("===================================================");
			System.out.println("1. 리뷰 작성하기\t 0. 돌아가기");
			System.out.println("===================================================");
			menu = Integer.parseInt(s.nextLine());
			
				switch(menu){
					case 1:
						ReviewVO review = new ReviewVO();
						
						// 유저에게 입력받는 부분 (리뷰 도서명, 별점, 리뷰 내용) ====================
						System.out.println("리뷰를 작성할 도서명을 입력해주세요. -> ");
						String rBookName = s.nextLine();
						System.out.println("["+rBookName+"] 의 별점을 남겨주세요.\n최소 0, 최대 5");
						int starScore = Integer.parseInt(s.nextLine());
						System.out.println("리뷰 내용을 작성해주세요.");
						String reviewContent = s.nextLine();
						
						// 자동으로 값 출력하는 부분 (리뷰번호, 유저아이디, 입력받은 도서명의 도서번호, 별점 변환) =====================
						// 리뷰번호
						ArrayList<ReviewVO> reviewSize = reviewDao.SelectReview();
						int reviewNumber = reviewSize.size()+1;
						
						//유저 아이디
						String userId = Session.loginUser.getUserID();
						
						//입력받은 도서명의 도서번호
						BookVO book = bookDao.selectBook("Name", rBookName);
						
						//별점 변환
						String starScoreToString = "";
						
						if(starScore == 0){
							starScoreToString = "☆☆☆☆☆";
						}else{
							for(int i = 1; i <= 5; i++){
								if(i <= starScore){
									starScoreToString +="★";
								}else if(i > starScore){
									starScoreToString +="☆";
								}
							}
						}
						
						//리뷰VO에 저장
						review.setReviewNumber(reviewNumber);
						review.setUserID(userId);
						review.setBookNumber(book.getBookNumber());
						review.setReviewContent(reviewContent);
						review.setStarScore(starScoreToString);
						reviewDao.insertReview(review);
						
						System.out.println("도서명: "+rBookName+"\t별점: "+starScoreToString);
						System.out.println("리뷰가 저장되었습니다!\n");
						
						menu = 0;
						break;
					case 0:	break;
				}
			}while(menu != 0);
	}

	
	
	
	
	

	
	@Override
	public void messageBox() {
		//내 아이디 앞으로 온 쪽지만 노출 + 전체쪽지 확인
		ArrayList<PostVO> postList = postDao.selectPostList();
		String loginUser = Session.loginUser.getUserID();

		System.out.println("\n==================== 쪽지함 =======================");
		System.out.println("\t쪽지제목\t\t보낸이\t받은날짜");
		System.out.println("------------------------------------------------");
		int count = 0;
		for(int i = 0; i < postList.size();i++){
			PostVO post = postList.get(i);
			if(post.isAsmCheck()){
				//가입날짜 이전 전체쪽지는 출력 x -> 로그인할 때 로그인 시간도 저장해야함
				System.out.println(post.getPostNumber()+"\t"+post.getPostTitle()+"\t"+post.getSenderID()+"\t"+post.getSendDate());
				count++;
			}else if(loginUser.equals(post.getAddresseeID())){
				System.out.println(post.getPostNumber()+"\t"+post.getPostTitle()+"\t"+post.getSenderID()+"\t"+post.getSendDate());
				count++;
			}
		}
		if(count == 0){
			System.out.println("받은 쪽지가 없습니다.");
		}
		System.out.println("===================================================");
	}
	
	@Override
	public void messageView(){
		System.out.print("내용을 읽으실 쪽지 번호를 입력해주세요. > ");
		int number = Integer.parseInt(s.nextLine());
		
		ArrayList<PostVO> postList = postDao.selectPostList();
		for(int i = 0; i < postList.size(); i++){
			PostVO post = postList.get(i);
			if(number == post.getPostNumber()){
				System.out.println("\n===================================================");
				System.out.println("쪽지제목: "+post.getPostTitle());
				System.out.println("보낸이: "+post.getSenderID());
				System.out.println("받은날짜: "+post.getSendDate());
				System.out.println("------------------------");
				System.out.println(post.getPostContents()+"\n");
				System.out.println("===================================================");
			}
		}	
	}

	
	@Override
	public void wishBook() {
		//희망도서 신청하기
		System.out.println("===================================================");
		System.out.println("도서관에 새로 구비되길 희망하는 도서의 이름을 적어주세요.");
		String wishBookName = s.nextLine();
		System.out.println(wishBookName + " 도서의 저자를 적어주세요.");
		String wishBookWriter = s.nextLine();
		System.out.println(wishBookName + " 도서의 출판사를 적어주세요");
		String wishBookPublisher = s.nextLine();
		
		ArrayList<RequestVO> requestList = requestDao.selectWishList();
		int requestNumber = requestList.size()+1;
		
		RequestVO request = new RequestVO();
		request.setRequestNumber(requestNumber);
		request.setBookName(wishBookName);
		request.setWriter(wishBookWriter);
		request.setPublisher(wishBookPublisher);
		
		requestDao.insertRequestBook(request);
		
		System.out.println("도서명: "+wishBookName+"\t저자명: "+wishBookWriter+"\t출판사명: "+wishBookPublisher);
		System.out.println("희망 도서 신청이 완료되었습니다.");
		System.out.println("===================================================\n");
	}


}
