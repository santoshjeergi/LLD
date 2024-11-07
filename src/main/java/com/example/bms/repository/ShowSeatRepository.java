package com.example.bms.repository;

import com.example.bms.models.Show_Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<Show_Seat, Long> {

    List<Show_Seat> findAllByIdIn(List<Long> list);
}
