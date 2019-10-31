package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import dao.RentalDao;
import dao.RentalDaoImpl;

public class DateUtil {
	
	RentalDao rentaldao = RentalDaoImpl.getInstance();
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		
		System.out.print("날짜를 입력해주세요. -> ");
		String date = scan.nextLine();
		
		Date today = stringToDate(date);
		
		
		String lendinDay = lendingPeriod();
		System.out.println(lendinDay);
		
	}
	
	
	// 	1. String -> date로
	public static Date stringToDate(String d){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		Date date = null;
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			System.out.println("날짜의 입력이 잘못되었습니다.");
		}
		return date;
	}
	
	//	2. date -> Calendar
	public static void dateToCalendar(Date d){
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
	}
	
	
	// 3. date -> String
	public static String dateToString(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		String date = sdf.format(d);
			
		return date;
	}
	
	
	// 	4. Calendar ->string
	public static String calendarToString(Calendar d){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	
		String date = sdf.format(d.getTime());
		return date;
	}
	
	
	//대출기간(5일)
	public static String lendingPeriod(){
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		cal.add(Calendar.DAY_OF_MONTH,5);
		String result = dateToString(cal.getTime());
		
		return result;
	}
	
	
	//연장
	public static String extension(){
		
		
		// rentaldao.selectRentalList();
		// 책대여 DB를 조회해서 로그인하고 있는 유저가 대여한 책만 출력
		// rentalDao에 관련 메서드 만들기
		// 그 중에서 기간을 연장할 책 번호를 입력
		// for문 돌려서 가져온 책정보에서 일치하는 책 번호 찾음
		// 거기에 저장되어있는 반납 날짜(String형) 반환
		// 걔를 +5씩 한당
		
		return null;
	}
	
	
	//신착도서기간 1주
		//책 DB에서 책 입고 날짜를 가져오기
		//오늘날짜 - 7일 1달 해서 그 이전의 책들만 리스트 출력
	
	
	
	//신착도서기간 1달
	
	
	//대출 연장(5일씩)
	
	
	
	

	}
	
	

