package ru.trainee.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.trainee.model.Input;

public interface InputRepository extends CrudRepository<Input, Long> {
}