package com.example.bms;

import com.example.bms.Exception.BadRequestException;
import com.example.bms.models.Booking;
import com.example.bms.models.SeatStatus;
import com.example.bms.models.Show_Seat;
import com.example.bms.repository.BookingRepository;
import com.example.bms.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    ShowSeatRepository showSeatRepository;

    BookingRepository bookingRepository;
    TicketService(ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }


    private List<Long> seatList;
    public Booking bookTickets(List<Long> showseats) {

        List<Show_Seat> showSeats = showSeatRepository.findAllByIdIn(showseats);
      if(showSeats.size() != showseats.size()) {
        throw  new BadRequestException("Invalid request ");
      }

      Double amount = 0.0;
      for(Show_Seat show_seat: showSeats) {
          if(!show_seat.getSeatStatus().equals(SeatStatus.AVAILIABLE)) {
              throw  new IllegalArgumentException("Hmm seats are not availiable");
          }
          amount+=show_seat.getPrice();
          show_seat.setSeatStatus(SeatStatus.BLOCKED);
      }

      showSeatRepository.saveAll(showSeats);

      Booking booking = Booking.builder()
                      .amount(amount)
                              .showSeats(showSeats)
                                      .show(showSeats.get(0).getShow())
                                              .build();
        bookingRepository.save(booking);
        return booking;
    }
}
