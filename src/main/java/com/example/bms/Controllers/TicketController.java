package com.example.bms.Controllers;


import com.example.bms.DTO.BookingRequestDTO;
import com.example.bms.DTO.BookingResponseDTO;
import com.example.bms.TicketService;
import com.example.bms.models.BaseModel;
import com.example.bms.models.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    private final TicketService ticketService;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
   public @ResponseBody BookingResponseDTO bookTicket(@RequestBody BookingRequestDTO bookingRequestDTO)  {

        System.out.println("Request for Booking is received");
        System.out.println(bookingRequestDTO);

       Booking booking =  ticketService.bookTickets(bookingRequestDTO.getShowSeatLists());


       BookingResponseDTO.builder()
            .bookingrefId(booking.getId().toString())
               .amount(booking.getAmount())
               .theater(booking.getShowSeats().get(0).getShow().getScreen().getTheater().getName())
               .showSeats(booking.getShowSeats().stream().map(BaseModel::getId).toList())
               .status(com.example.bms.DTO.ResponseStatus.SUCCESS)
               .build();



        return null;
    }

    @GetMapping(path = "/get")
    @ResponseStatus(HttpStatus.OK)
    public String getTicket() {
        System.out.println("Request to get the tickets");
        return "Retrieved tickets! Enjoy the Movie";
    }
}
