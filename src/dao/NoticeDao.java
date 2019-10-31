package dao;

import java.util.ArrayList;
import java.util.HashMap;

import vo.NoticeVO;

public interface NoticeDao {

	//단일 리스트 조회	
	NoticeVO selectNotice(String Key, String value);
	NoticeVO selectNotice(String Value);
	

	
	ArrayList<NoticeVO> selectNotice(HashMap<String,String> param);
	
	
	//공지사항 삽입
	void insertNotice(NoticeVO notice);
	
	
	//전체 공지 조회
	ArrayList<NoticeVO> selectNoticeList();	

	
	
}
