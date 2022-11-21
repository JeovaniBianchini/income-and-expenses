package com.bianchinijeovani.incomeandexpenses.repositorys;

import com.bianchinijeovani.incomeandexpenses.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserName(String userName);
    Optional<User> findById (UUID id);
}
