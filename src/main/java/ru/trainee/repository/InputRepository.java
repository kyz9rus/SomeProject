package ru.trainee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trainee.model.Input;

public interface InputRepository extends JpaRepository<Input, Long> {
}
