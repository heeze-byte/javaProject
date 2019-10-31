package dao;

import java.util.ArrayList;

import vo.BookingVO;
import vo.RentalVO;

public interface BookingDao {

	ArrayList<BookingVO> selectBookingList();
	
	boolean addReserveBook(BookingVO bv);
	
}
