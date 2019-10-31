package dao;

import java.util.ArrayList;

import data.Database;
import vo.PostVO;


public class PostDaoImpl implements PostDao {

	private static PostDaoImpl instance;
	
	private PostDaoImpl(){}
	
	public static PostDaoImpl getInstance(){
		if(instance == null){
			instance = new PostDaoImpl();
		}
		return instance;
	}

	Database database = Database.getInstance();
	
	@Override
	public ArrayList<PostVO> selectPostList() {
		return database.tb_post;
	}

	@Override
	public void insertPost(PostVO post) {		
		database.tb_post.add(post);
	}


}
