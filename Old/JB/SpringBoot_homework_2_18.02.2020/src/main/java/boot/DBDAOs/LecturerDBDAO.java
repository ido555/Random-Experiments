package boot.DBDAOs;
//@Repository / for DB stuff / speaks with db
//@Service - for BL - business logic - facades
//@Controller - web
//all of these are just @Component
import org.springframework.data.jpa.repository.JpaRepository;

import boot.beans.Lecturer;

public interface LecturerDBDAO extends JpaRepository<Lecturer, Integer>{
}
