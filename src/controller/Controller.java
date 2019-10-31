package controller;

import java.util.Scanner;

import service.AdminService;
import service.AdminServiceImpl;
import service.LibraryService;
import service.LibraryServiceImpl;
import service.MyLibraryService;
import service.MyLibraryServiceImpl;
import service.SearchService;
import service.SearchServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import data.Session;

public class Controller {
	UserService userService = UserServiceImpl.getInstance(); //다른 패키지에 있어서 import필요함
	SearchService searchService = SearchServiceImpl.getInstance();
	LibraryService libraryService = LibraryServiceImpl.getInstance();
	MyLibraryService myLibraryService = MyLibraryServiceImpl.getInstance();
	AdminService adminService = AdminServiceImpl.getInstance();

	
	public static void main(String[] args) {
		
		new Controller().start();
		
	}

	
	
	int menu1 = 99;
	int menu2 = 99;
	int menu3 = 99;
	Scanner s = new Scanner(System.in);
	
	private void start() {
		
		do{
		
			if(Session.loginUser != null){
				System.out.println("-----------------------------");
				System.out.println("\n▶ ["+Session.loginUser.getUserID()+"]님");
			}
			System.out.println("============ 메뉴 =============");
			System.out.println("1. 로그인/로그아웃/회원가입");
			System.out.println("2. 도서검색");
			System.out.println("3. 도서관서비스");
			System.out.println("4. My Library");
			System.out.println("5. 관리자");
			System.out.println("0. 종료");
			System.out.println("- - - - - - - - - - - - - - - -");
			System.out.print("메뉴에 해당하는 번호 입력 > ");
			
			try{
			menu1 = Integer.parseInt(s.nextLine());
			}catch(Exception e){
				System.out.println("올바른 값을 입력해주세요.");
			}
			
			
			switch (menu1) {
			case 1: //회원가입
				if(Session.loginUser == null){
					loginMenu();
					break;
				}else if(Session.loginUser.getUserID().equals("admin")){
					logoutMenu();
					break;
				}else{
					logoutMenu();
					break;
				}
				
			case 2: 
				if(Session.loginUser != null){
					
					do{
						try{
							System.out.println("\n---------- 도서검색 ----------");
							System.out.println("1. 통합검색");
							System.out.println("2. 분야별검색");
							System.out.println("3. 신착도서검색");
							System.out.println("0. 이전 메뉴로 돌아가기");
							System.out.println("- - - - - - - - - - - - - -");
							System.out.print("메뉴에 해당하는 번호 입력 > ");
							menu2 = Integer.parseInt(s.nextLine());
							
							switch(menu2){
								case 1:	System.out.println("");
										searchService.detailSearch();
										break;
								case 2:	System.out.println("");
										searchService.searchSubject();
										break; 
								case 3:	System.out.println("");
										searchService.recentBook();	
										break;
								case 0:	break;
							}
						}catch(Exception e){ System.out.println("올바른 값을 입력해주세요.");}
					}while(menu2 != 0);
					break;
				}else{
					System.out.println("로그인 후 이용 가능한 서비스입니다.");
				}
				break;
				
			case 3: //도서관서비스
				if(Session.loginUser != null){
					do{
						try{
							System.out.println("--------- 도서관 시스템 ----------");
							System.out.println("1. 공지사항");
							System.out.println("2. 사서가 콕! 찍어주는 책");
							System.out.println("0. 이전 메뉴로 돌아가기");
							System.out.println("- - - - - - - - - - - - - - -");
							System.out.print("메뉴에 해당하는 번호 입력 > ");
							menu2 = Integer.parseInt(s.nextLine());
							
							switch(menu2){
								case 1:	adminService.noticeList(); libraryService.noticeView();	break;
								case 2:	libraryService.bookrecom();	break;
								case 0:								break;
							}
						}catch(Exception e){
							System.out.println("올바른 값을 입력해주세요.");
						}
					}while(menu2 != 0);
					break;
				}else{
					System.out.println("로그인 후 이용 가능한 서비스입니다.");
				}
				break;
				
			case 4:
				if(Session.loginUser != null){
					do{
						try{
							System.out.println("\n--------- My Library ----------");
							System.out.println("1. 대여｜예약｜반납 현황");
							System.out.println("2. 쪽지함");
							System.out.println("3. 희망도서신청");
							System.out.println("0. 이전 메뉴로 돌아가기");
							System.out.println("- - - - - - - - - - - - - - - -");
							System.out.print("메뉴에 해당하는 번호 입력 > ");
							menu2 = Integer.parseInt(s.nextLine());
							
							switch(menu2){
								case 1:	
									do{
										System.out.println("\n------------- 현황 --------------");
										System.out.println("1. 현재 대여중인 책");
										System.out.println("2. 총 대여 리스트");
										System.out.println("3. 예약한 책");
										System.out.println("0. 이전 메뉴로 돌아가기");
										System.out.println("- - - - - - - - - - - - - - - -");
										System.out.print("메뉴에 해당하는 번호 입력 > ");
										menu3 = Integer.parseInt(s.nextLine());
										
										switch(menu3){
											case 1:	myLibraryService.rentalList();		break;
											case 2:	myLibraryService.allRentalList();	break;
											case 3:	myLibraryService.reserveList();		break;
											case 0:										break;
										}
									}while(menu3 != 0);
									break;
								case 2:
									do{
										System.out.println("\n------------ 쪽지함 ------------");
										System.out.println("1. 쪽지 읽기");
										System.out.println("0. 이전 메뉴로 돌아가기");
										System.out.println("- - - - - - - - - - - - - - -");
										System.out.print("메뉴에 해당하는 번호 입력 > ");
										menu3 = Integer.parseInt(s.nextLine());
										
										switch(menu3){
										case 1:	myLibraryService.messageBox(); myLibraryService.messageView();	break;
										case 0:	break;
										}
									}while(menu3 != 0);
									break;
								case 3:
									do{
										System.out.println("\n--------- 희망 도서 신청 ----------");
										System.out.println("희망 도서를 신청하시겠습니까?");
										System.out.println("1. 도서 신청");
										System.out.println("0. 이전 메뉴로 돌아가기");
										System.out.println("- - - - - - - - - - - - - - -");
										System.out.print("메뉴에 해당하는 번호 입력 > ");
										menu3 = Integer.parseInt(s.nextLine());
										
										switch(menu3){
										case 1:	myLibraryService.wishBook();	break;
										case 0:									break;
										}
									}while(menu3 != 0);
									break;
								case 0:	break;
							}
						}catch(Exception e){ System.out.println("올바른 값을 입력해주세요."); }
					}while(menu2 != 0);
					break;
				}else{
					System.out.println("로그인 후 이용 가능한 서비스입니다.");
				}
				break;
				
			case 5: //관리자
				if(Session.loginUser != null && Session.loginUser.getUserID().equals("admin")){
					do{
						try{
						System.out.println("\n--------- 관리자 시스템 ----------");
						System.out.println("1. 도서관리");
						System.out.println("2. 쪽지관리");
						System.out.println("3. 회원목록");
						System.out.println("4. 희망도서 리스트");
						System.out.println("5. 공지사항");
						System.out.println("0. 이전 메뉴로 돌아가기");
						System.out.println("- - - - - - - - - - - - - - -");
						System.out.print("메뉴에 해당하는 번호 입력 > ");
						try{
							menu2 = Integer.parseInt(s.nextLine());
						}catch(Exception e){
							System.out.println("오류! ----> "+e.getMessage()+"\n"+"올바른 값을 입력해주세요!\n");
						}
						switch(menu2){
							case 1:	adminService.manageBook();		break;
							case 2:	adminService.manageMessage();	break;
							case 3:	userService.userList();			break;
							case 4:	adminService.wishBook();		break;
							case 5:	adminService.manageNotice();	break;
							case 0:									break;
						}
						}catch(Exception e){ System.out.println("올바른 값을 입력해주세요."); }
					}while(menu2 != 0);
					break;
				}else{
					System.out.println("관리자만 이용 가능한 서비스입니다.");
				}
				break;
				
			case 0: //프로그램 종료
				System.out.println("프로그램 종료");
				break;
			}
		}while(menu1 != 0);
	}
	
	
	
	void loginMenu(){
		do{
			System.out.println("\n---------- 메뉴 ----------");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("0. 이전 메뉴로 돌아가기");
			System.out.println("- - - - - - - - - - - - -");
			System.out.print("메뉴에 해당하는 번호 입력 > ");
			
			menu2 = Integer.parseInt(s.nextLine());
			
			switch(menu2){
				case 1:	System.out.println("");
						userService.join();	
						break;
				case 2:	System.out.println("");
						userService.login();
						if(Session.loginUser != null){ menu2 = 0;}
						break;
				case 0:	break;
			}
		}while(menu2 != 0);
		
	}
	
	void logoutMenu(){
		do{
			System.out.println("\n---------- 메뉴 ----------");
			System.out.println("1. 로그아웃");
			System.out.println("0. 이전 메뉴로 돌아가기");
			System.out.println("- - - - - - - - - - - - -");
			System.out.print("메뉴에 해당하는 번호 입력 > ");
			menu2 = Integer.parseInt(s.nextLine());
			
			switch(menu2){
				case 1:	Session.loginUser = null;
						System.out.println("로그아웃되었습니다.\n");
						{ menu2 = 0;}
						break;
				case 0:	break;
			}
		}while(menu2 != 0);
		
	}
	
	
	
}


