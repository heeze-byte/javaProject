package service;

public interface AdminService {

	//***** 책 관리 *****
	void manageBook();
	//책 추가
	void addBook();
	//책 삭제
	void deleteBook();
	//현재 도서관에 저장되어있는 책 리스트
	void bookList();
	

	
	//***** 쪽지 관리 *****
	void manageMessage();
	
	//전체보내기
	void allSendMessage();
	//개별쪽지
	void oneSendMessage();
	//쪽지 리스트
	void messageList();


	
	
	//***** 희망도서 관리 *****
	void wishBook();
	void wishBookList();
	
	

	//***** 공지 관리 *****
	void manageNotice();
	//공지 추가
	void addNotice();
	//공지 삭제
	void deleteNotice();	
	//공지 리스트
	void noticeList();
	

	

	
}
