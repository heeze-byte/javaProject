package dao;

import java.util.ArrayList;

import vo.PostVO;



public interface PostDao {//데이터베이스에 접속

	//쪽지 삽입
	void insertPost(PostVO post);
	
	//쪽지 조회
	ArrayList<PostVO> selectPostList();
}
