package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import util.DateUtil;
import vo.BookVO;
import vo.NoticeVO;
import vo.PostVO;
import vo.RequestVO;
import vo.UserVO;
import dao.BookDao;
import dao.BookDaoImpl;
import dao.NoticeDao;
import dao.NoticeDaoImpl;
import dao.PostDao;
import dao.PostDaoImpl;
import dao.RequestDao;
import dao.RequestDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import data.Session;

public class CopyOfAdminServiceImpl implements AdminService{


	private static CopyOfAdminServiceImpl instance;
	private CopyOfAdminServiceImpl(){}
	
	public static CopyOfAdminServiceImpl getInstance(){
		if(instance == null){
			instance = new CopyOfAdminServiceImpl();
		}
		return instance;
	}

	
	//오늘 날짜 객체생성
	Date today = new Date();
	
	//데이터베이스에서 데이터를 가져온 Dao를 서비스에서 사용하기위해 객체생성함
	BookDao bookDao = BookDaoImpl.getInstance();
	PostDao postDao = PostDaoImpl.getInstance();	
	UserDao userDao = UserDaoImpl.getInstance();
	NoticeDao noticeDao = NoticeDaoImpl.getInstance();
	
	RequestDao requestDao = RequestDaoImpl.getInstance();
	LibraryService libraryserv = LibraryServiceImpl.getInstance();
	
	Calendar cal = Calendar.getInstance();
	Scanner s = new Scanner(System.in);
	
	
	@Override
	public void manageBook() {
		int menu;
		
		do{ 
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 삭제");
		System.out.println("3. 전체 도서 목록");
		System.out.println("0. 이전 메뉴로돌아가기");
		menu = Integer.parseInt(s.nextLine());
		
			switch(menu){
				case 1:	addBook();		break;
				case 2:	deleteBook();	break;
				case 3:	bookList();		break;
				case 0:					break;
			}
		}while(menu != 0);
	}
	

	@Override
	public void manageMessage() {
		int menu;
		int menu2;
		
		do{ 
		System.out.println("1. 쪽지 리스트");
		System.out.println("2. 쪽지 보내기");
		System.out.println("0. 이전 메뉴로돌아가기");
		menu = Integer.parseInt(s.nextLine());
		
			switch(menu){
				case 1:	messageList(); break;
				case 2:						
					do {
						System.out.println("쪽지를 보내시겠습니까?/n");
						System.out.println("1. 전체쪽지 보내기");
						System.out.println("2. 개별쪽지 보내기");
						System.out.println("0. 이전 메뉴로돌아가기");
						menu2 = Integer.parseInt(s.nextLine());
						switch(menu2){
							case 1: allSendMessage(); menu2 = 0; break;	
							case 2: oneSendMessage(); menu2 = 0; break;
							case 0: break;	
						}
					}
						while(menu2 != 0);
						break;	

				case 0: break;
			}
		}while(menu != 0);
	}

	
	
	@Override
	public void addBook() {
		System.out.print("책 번호: "); //key
		String bookNumber = s.nextLine();
		System.out.println("\n==========분류번호==========");
		System.out.println("A: 문학\tB: 철학\tC: 종교\nD: 사회과학\tE: 자연과학");
		System.out.println("-------------------------");
		System.out.print("분류 번호: ");
		String areaNumber = s.nextLine();
		System.out.print("\n책 이름: ");
		String bookName = s.nextLine();
		System.out.print("\n저자: ");
		String writer = s.nextLine();
		System.out.print("\n책 설명: ");
		String bookInfo = s.nextLine();
		System.out.println("\n형식: 0000년 00월 00일");
		System.out.print("입고된 날짜: ");
		String bookAccession = s.nextLine();
		System.out.print("\n책 재고: ");
		int inventory = Integer.parseInt(s.nextLine());
		
		//중복되는 책 번호 검사
		BookVO book = new BookVO();
		book.setBookNumber(bookNumber);
		book.setAreaNumber(areaNumber);
		book.setBookName(bookName);
		book.setWriter(writer);
		book.setBookInfo(bookInfo);
		book.setAccession(bookAccession);
		book.setInventory(inventory);
		
		BookVO bookNumberCheck = bookDao.selectBook("BookNumber", book.getBookNumber());
		
		if(bookNumberCheck == null){
			bookDao.insertBook(book);
			System.out.println("**"+bookName+"**");
			System.out.println("책이 추가되었습니다!");
			System.out.println("--------------\n");
		}else{
			System.out.println("중복되는 책번호가 있습니다.\n중복되지 않는 책번호를 다시 입력해주세요.");
			System.out.println("--------------\n");
		}
	}
	
	@Override
	public void deleteBook() {
		System.out.print("삭제할 책의 책번호를 입력해주세요. > ");
		String bookNumber = s.nextLine();
		
		//입력한 책번호와 일치하는 책번호가 있는지 검사
		BookVO bookNumberCheck = bookDao.selectBook(bookNumber);
			if(bookNumberCheck == null){
				System.out.println("중복되는 책번호가 있습니다.\n책번호를 다시 입력해주세요.");
				System.out.println("--------------\n");
			}else{
				System.out.println("**"+bookNumber+"**");
				System.out.println("책이 삭제되었습니다!");
				System.out.println("--------------\n");
			}
	}

	@Override
	public void bookList(){
		ArrayList<BookVO> bookList = bookDao.selectBookList();
		
		System.out.println("=======================");
		System.out.println("분야번호\t도서번호\t도서명\t저자\t보유 권 수\t도서정보\t입고날짜");
		System.out.println("-----------------------");
		for(int i=0; i<bookList.size(); i++){
			BookVO book = bookList.get(i);
			System.out.println(book.getAreaNumber() + "\t" + book.getBookNumber()+ "\t" + book.getBookName()+ "\t" +book.getWriter()+ book.getInventory()+"\t" +book.getBookInfo()+ "\t" +book.getAccession()+ "\t");
		}
		System.out.println("=======================\n");
	}
	

	
	
	
	@Override
	public void messageList() {
		ArrayList<PostVO> postList = postDao.selectPostList();
		
		System.out.println("==============================================");
		System.out.println("쪽지번호\t쪽지제목\t\t\t보낸사람\t보낸날짜");
		System.out.println("-----------------------");
		
		for(int i=0; i<postList.size(); i++){
			PostVO post = postList.get(i);
			/*if(post.getPostTitle().length() >= 20){
				post.setPostTitle(post.getPostTitle()+"\t");
			}
			 */
			System.out.println(post.getPostNumber() + "\t" + post.getPostTitle()+ "\t" +post.getSenderID() + "\t" + post.getSendDate());
		}
		System.out.println("=======================\n");
	}


	@Override
	public void allSendMessage() {
		
		//VO(데이터를 담는 클래스) 불러오기
		PostVO post = new PostVO();
		
		boolean asmCheck = true;
		
		System.out.println("제목을 입력해주세요.");
		String title = s.nextLine();
		
		System.out.println("내용을 입력해주세요.");
		String content = s.nextLine();
		
		
		ArrayList<UserVO> userlist = userDao.selectUserList(); 
		post.setAsmCheck(true);
		//post.setPostNumber();
		post.setPostTitle(title);
		
		String Stoday = DateUtil.dateToString(today);
		post.setSendDate(Stoday);
		post.setSenderID(Session.loginUser.getUserID());
		
		postDao.insertPost(post); 
		System.out.println("쪽지를 보내셨습니다.");
	}

	@Override
	public void oneSendMessage() {
		
		//VO(데이터를 담는 클래스) 불러오기
		PostVO post = new PostVO();
		
		boolean asmCheck = false;
		
		System.out.println("제목을 입력해주세요.");
		String title = s.nextLine();
		System.out.println("받는 사람 ID: ");
		String addresseeID = s.nextLine();
		System.out.println("내용을 입력해주세요.");
		String content = s.nextLine();
		
		ArrayList<UserVO> userlist = userDao.selectUserList(); 
		
		post.setAsmCheck(false);
		//post.setPostNumber();
		post.setAddresseeID(addresseeID);
		post.setPostTitle(title);
		//post.setSendDate(today);
		post.setSenderID(Session.loginUser.getUserID());
		
		//유저아이디 일치하는 아이디가 있는지 검사
		UserVO addresseeIDCheck = userDao.selectUser("ID", addresseeID);
		if(addresseeIDCheck == null){
			System.out.println("일치하는 유저 아이디가 없습니다. 아이디를 다시 입력해주세요.\n");
		}else{
			postDao.insertPost(post); 
			System.out.println("쪽지를 보내셨습니다.");
		}

	}
	
	@Override
	public void wishBook() {
		int menu;
		
		do{ 
			System.out.println("1. 희망도서 리스트 보기");
			System.out.println("0. 이전 메뉴로 돌아가기");
			menu = Integer.parseInt(s.nextLine());
			
				switch(menu){
					case 1:	wishBookList();	break;
					case 0:					break;
				}
			}while(menu != 0);
	}
	

	@Override
	public void wishBookList() {
		ArrayList<RequestVO> wishList = requestDao.selectWishList();
		
		System.out.println("=============희망 도서 리스트===============");
		System.out.println("도서신청번호\t신청자\t도서명\t저자");
		System.out.println("---------------------------------------");
		for(int i =0; i< wishList.size(); i++){
			RequestVO book = wishList.get(i);
			System.out.println(book.getRequestNumber()+"\t"+book.getUserID()+"\t"+book.getBookName()+"\t"+book.getWriter());
		}
		System.out.println("=======================================\n");
	}
	

	@Override
	
	public void manageNotice() {
		int menu;
		do{ 
		
		System.out.println("1. 공지사항 추가"); //도서관 서비스의 공지사항 리스트와 동일
		System.out.println("2. 공지사항 삭제");
		System.out.println("3. 공지사항 리스트"); 
		System.out.println("0. 이전 메뉴로 돌아가기");
		System.out.print("메뉴에 해당하는 번호 입력>");
		menu = Integer.parseInt(s.nextLine());
		
			switch(menu){
				case 1:	addNotice();		break;
				case 2:	deleteNotice();		break;
				case 3:	noticeList();	break;
				case 0:	break;
			}
		}while(menu != 0);
	}
	
	

	@Override
	public void addNotice() {
		
		System.out.print("제목을 입력해주세요.");
		String title = s.nextLine();
		System.out.print("내용을 입력해주세요.");
		String contents = s.nextLine();

		NoticeVO notice = new NoticeVO();
		notice.setTitle(title);
		notice.setContents(contents);
		
		
		
		noticeDao.insertNotice(notice);
		System.out.println("공지사항이 추가 되었습니다.");
	}

	@Override
	public void deleteNotice() {
		System.out.print("삭제할 공지번호를 입력해주세요. > ");
		String noticeNumber = s.nextLine();
		
		NoticeVO noticeNumberCheck = noticeDao.selectNotice(noticeNumber);
			if(noticeNumberCheck == null){
				System.out.println("잘못된 번호를 입력하셨습니다.\n 다시 입력해주세요.");
				System.out.println("--------------\n");
			}else {
				System.out.println("**"+noticeNumber+"**");
				System.out.println("공지사항이 삭제되었습니다!");
				System.out.println("--------------\n");
				
			}
	}


	@Override
	public void noticeList() {
		
		ArrayList<NoticeVO> noticeList = noticeDao.selectNoticeList();
		
		System.out.println("=======================");
		System.out.println("공지번호\t글제목\t아이디\t작성일자");
		System.out.println("-----------------------");
		
		for(int i = 0; i < noticeList.size();i++){
			NoticeVO notice = noticeList.get(i);
			System.out.println(notice.getNoticeNumber() + "\t" + notice.getTitle() + "\t" + notice.getUserID() + "\t" + notice.getWriteDate());	
		}
	
	}


}
