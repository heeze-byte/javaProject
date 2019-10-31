package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import data.Database;
import vo.NoticeVO;

public class NoticeDaoImpl implements NoticeDao {


	private static NoticeDaoImpl instance;
	private NoticeDaoImpl(){}
	
	public static NoticeDaoImpl getInstance(){
		if(instance == null){
			instance = new NoticeDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	@Override
	public ArrayList<NoticeVO> selectNotice(HashMap<String, String> param) {
			ArrayList<NoticeVO> noticeList = new ArrayList<NoticeVO>();
			
			for(int i = 0; i < database.tb_notice.size();i++){
				NoticeVO notice = database.tb_notice.get(i);
				boolean flag = true;
				
				Set<String> keys = param.keySet();
				for(String key : keys){
					String value = param.get(key);
					if(key.equals("getNoticeNumber")){
						if(notice.getNoticeNumber().indexOf(value) < 0){
							flag = false;
						}
					}
					else if(key.equals("getTitle")){
						if(!notice.getTitle().equals(value)){
							flag = false;
						}

						
						
					}
					if(flag){
						noticeList.add(notice);
					}
					
				}
			}

		
		return noticeList;
	}

	
	
	@Override
	public NoticeVO selectNotice(String Key, String value) {
		for(int i = 0; i < database.tb_notice.size();i++){
			NoticeVO notice = database.tb_notice.get(i);
			
			if(Key.equals("NoticeNumber")){
				if(notice.getNoticeNumber().equals(value)){
					return notice;
				}
			}
		}
		return null;
	}

	
	@Override
	public NoticeVO selectNotice(String value) {
		for(int i = 0; i < database.tb_notice.size();i++){
			NoticeVO  notice = database.tb_notice.get(i);
			if(notice.getNoticeNumber().equals(value)){
				System.out.println(i);
				System.out.println(database.tb_notice.get(i));
				database.tb_notice.remove(i);
				return notice;
			}
		}
		

		return null;
	}


	@Override
	public void insertNotice(NoticeVO notice) {
		database.tb_notice.add(notice);
	
	}
	
	

	@Override
	public ArrayList<NoticeVO> selectNoticeList() {	
		return database.tb_notice;
	}






	
}
