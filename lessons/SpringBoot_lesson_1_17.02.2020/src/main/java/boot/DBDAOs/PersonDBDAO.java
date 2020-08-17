package boot.DBDAOs;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.beans.Person;

public interface PersonDBDAO extends JpaRepository<Person, Integer> {

}
