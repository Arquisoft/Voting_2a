package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.model.UserInfo;

/**
 * CRUD Repository for the entity
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

	UserInfo findByEmail(String email);
}
