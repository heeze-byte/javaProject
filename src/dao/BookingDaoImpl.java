package dao;

import java.util.ArrayList;

import vo.BookingVO;
import data.Database;

public class BookingDaoImpl implements BookingDao {

	private static BookingDaoImpl instance;
	private BookingDaoImpl(){}
	
	public static BookingDaoImpl getInstance(){
		if(instance == null){
			instance = new BookingDaoImpl();
		}
		return instance;
	}
	
	Database database = Database.getInstance();
	
	
	@Override
	public ArrayList<BookingVO> selectBookingList() {
		return database.tb_booking;
	}

	@Override
	public boolean addReserveBook(BookingVO bv) {
		boolean result = database.tb_booking.add(bv);
		return result;
	}
	
}
