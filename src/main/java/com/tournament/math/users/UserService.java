package com.tournament.math.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(User user) {
        return repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
