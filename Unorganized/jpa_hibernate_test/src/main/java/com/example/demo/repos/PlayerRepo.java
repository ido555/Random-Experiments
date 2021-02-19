package com.example.demo.repos;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.beans.Player;

@Transactional
public interface PlayerRepo extends JpaRepository<Player, Long> {
	
	List<Player> findByName(String name);
}
