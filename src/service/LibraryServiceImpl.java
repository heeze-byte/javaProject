package service;

import java.util.ArrayList;
import java.util.Scanner;

import vo.NoticeVO;
import dao.NoticeDao;
import dao.NoticeDaoImpl;
import data.Database;

public class LibraryServiceImpl implements LibraryService {

	
	private static LibraryServiceImpl instance;
	private LibraryServiceImpl(){}
	
	public static LibraryServiceImpl getInstance(){
		if(instance == null){
			instance = new LibraryServiceImpl();
		}
		return instance;
	}
	
	NoticeDao noticeDao = NoticeDaoImpl.getInstance();
	
	Scanner s = new Scanner(System.in);
	

	@Override
	   public void bookrecom() {
	      
	      Database database = Database.getInstance();
	      
	      //database.tb_book.get(Math.round(0)*100+1);
	      
	       int recom1 = (int)(Math.random()*100);
	       int recom2 = (int)(Math.random()*100);
	       int recom3 = (int)(Math.random()*100);
	       
	      System.out.println("******오늘의 추천책 입니다******");
	      System.out.println("도서번호" + "\t" + "도서명" + "\t\t" + "저자");
	      System.out.println(database.tb_book.get(recom1).getBookNumber()+"\t"
	                     +database.tb_book.get(recom1).getBookName()+"\t"
	                     +database.tb_book.get(recom1).getWriter());
	      
	      System.out.println(database.tb_book.get(recom2).getBookNumber()+"\t"
	            +database.tb_book.get(recom2).getBookName()+"\t"
	            +database.tb_book.get(recom2).getWriter());
	      
	      System.out.println(database.tb_book.get(recom3).getBookNumber()+"\t"
	            +database.tb_book.get(recom3).getBookName()+"\t"
	            +database.tb_book.get(recom3).getWriter());
	      System.out.println("*******************************");
	   }

	@Override
	public void noticeView() {
		System.out.println("내용을 읽으실 공지 번호를 입력해주세요.");
		int number = Integer.parseInt(s.nextLine());
		String noticeNumber = Integer.toString(number);
		
		ArrayList<NoticeVO> noticeList = noticeDao.selectNoticeList();
		
		for(int i = 0; i < noticeList.size(); i++){
			NoticeVO notice = noticeList.get(i);
			if(noticeNumber.equals(notice.getNoticeNumber())){
				System.out.println("========================");
				System.out.println("공지제목: "+notice.getTitle());
				System.out.println("작성자: "+notice.getUserID());
				System.out.println("공지날짜: "+notice.getWriteDate());
				System.out.println("------------------------");
				System.out.println(notice.getContents()+"\n");
				System.out.println("========================");
			}
		}		
	}
	
	
}
