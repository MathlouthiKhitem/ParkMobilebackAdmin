package com.example.demo.sERVICE;

import com.example.demo.Module.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public boolean verifyCredentials(String email, String password) {
        List<Users> users = usersRepository.findByEmail(email);
        for (Users user : users) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Users save(Users users) {
        return users;
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public Optional<Users> partialUpdate(Users users) {
        return Optional.empty();
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Optional<Users> findOne(String id) {
        return Optional.empty();
    }

    @Override
    public void delete(String id) {

    }
}
