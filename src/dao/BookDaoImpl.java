package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import vo.BookVO;
import vo.RentalVO;
import vo.ReviewVO;
import data.Database;

public class BookDaoImpl implements BookDao {
private static BookDaoImpl instance;
	
	private BookDaoImpl(){}
	
	public static BookDaoImpl getInstance(){
		if(instance == null){
			instance = new BookDaoImpl();
		}
		return instance;
	}

	Database database = Database.getInstance();
	
	@Override
	public BookVO selectBook(String key, String value) {
		for (int i = 0; i < database.tb_book.size(); i++) {
			BookVO book = database.tb_book.get(i);
			
			if(key.equals("Name")){
				if(book.getBookName().equals(value)){
					return book;
				}
			}else if(key.equals("bookNumber")){
				if(book.getBookNumber().equals(value)){
					return book;
				}
			}
		}
		return null;
	}
	
	@Override
	public BookVO selectBook(String value) {
		for (int i = 0; i < database.tb_book.size(); i++) {
			BookVO book = database.tb_book.get(i);
			if(book.getBookNumber().equals(value)){
				System.out.println(i);
				System.out.println(database.tb_book.get(i));
				database.tb_book.remove(i);
				return book;
			}
		}
		return null;
	}

	@Override
	public void insertBook(BookVO book) {
		database.tb_book.add(book);
	}

	@Override
	public ArrayList<BookVO> selectBook(HashMap<String, String> param) {
		ArrayList<BookVO> bookList = new ArrayList<BookVO>(); 
		
		for(int i=0; i<database.tb_book.size(); i++){
			BookVO book = database.tb_book.get(i);
			boolean flag = true;
			
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("BOOKNAME")){
					if(book.getBookName().indexOf(value) < 0){
						flag = false;
					}
				}
				else if(key.equals("WRITER")){
					if(!book.getWriter().equals(value)){
						flag = false;
					}
				}
				else if(key.equals("BOOKNUMBER")){
					if(!book.getBookNumber().equals(value)){
						flag = false;
					}
				}
				else if(key.equals("AREANUMBER")){
					if(!book.getAreaNumber().equals(value)){
						flag = false;
					}
				}
				else if(key.equals("ACCESSION")){
					if(!book.getAccession().equals(value)){
						flag = false;
					}
				}
			}
			if(flag){
				bookList.add(book);
			}
		}
		return bookList;
	}

	@Override
	public ArrayList<BookVO> selectBookList() {
		return database.tb_book;
	}

	@Override
	public ArrayList<ReviewVO> selectReview(HashMap<String, String> param) {
		ArrayList<ReviewVO> reviewList = new ArrayList<ReviewVO>(); 
		
		for(int i=0; i<database.tb_review.size(); i++){
			ReviewVO review = database.tb_review.get(i);
			boolean flag = true;
			
			Set<String> keys = param.keySet();
			for(String key : keys){
				String value = param.get(key);
				if(key.equals("BOOKNUMBER")){
					if(!review.getBookNumber().equals(value)){
						flag = false;
					}
				}
			}
			if(flag){
				reviewList.add(review);
			}
		}
		return reviewList;
	}

	@Override
	public boolean addBook(RentalVO rv) {
		boolean result = database.tb_return.add(rv);
		return result;
	}

	@Override
	public boolean removeBook(RentalVO rv) {
		boolean result = false;
		for(int i=0; i<database.tb_rental.size(); i++){
			if(database.tb_rental.get(i).getBookNumber().equals(rv.getBookNumber())){
				database.tb_rental.remove(i);
				result = true;
			}
		}
		return result;
		
	}
	
}
