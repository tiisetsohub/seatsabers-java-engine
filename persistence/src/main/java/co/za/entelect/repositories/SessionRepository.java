package co.za.entelect.repositories;

import co.za.entelect.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository  extends JpaRepository<UserEntity, Long> {

}
