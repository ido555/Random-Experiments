package com.example.demo.repos;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.beans.Game;

@Transactional
public interface GameRepo extends JpaRepository<Game, Long> {

}
