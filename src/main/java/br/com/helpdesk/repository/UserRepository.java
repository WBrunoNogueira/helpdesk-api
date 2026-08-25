package br.com.helpdesk.repository;

import br.com.helpdesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

/*
* save()
findById()
findAll()
delete()
deleteById()
existsById()
*
* */