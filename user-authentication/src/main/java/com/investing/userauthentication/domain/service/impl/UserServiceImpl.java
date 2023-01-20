package com.investing.userauthentication.domain.service.impl;

import com.investing.userauthentication.domain.exception.EntityContainsDuplicates;
import com.investing.userauthentication.domain.exception.EntityInUseException;
import com.investing.userauthentication.domain.exception.EntityNotFoundException;
import com.investing.userauthentication.domain.model.User;
import com.investing.userauthentication.domain.repository.UserRepository;
import com.investing.userauthentication.domain.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements GenericService<User> {

    @Autowired
    private UserRepository userRepository;

    @Value("${mock-url}")
    private String url;

    Random random = new Random();

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User create(User entity) {
        entity.setBalance(BigDecimal.ZERO);
        entity.setAg(String.valueOf(random.nextInt(1000)));
        entity.setAcc(String.valueOf(random.nextInt(100000)));

        logger.info(
                "Create User with cpfCnpj: ", entity.getCpfCnpj());
        try {
            return userRepository.save(entity);
        }catch (Exception e){
            logger.error("duplicate key value on user");
            throw new EntityContainsDuplicates("Entity contains duplicates values");
        }

    }

    @Override
    public User find(long id) {
        return findUser(id);
    }

    @Override
    public User update(long id, User entityUpdated) {
        logger.info("starting update on user " + id );
        User userToUpdate = findUser(id);
        BeanUtils.copyProperties(entityUpdated, userToUpdate, "id", "cpfCpnj", "ag", "acc" ,"balance", "extractList", "name");
        logger.info("finishing update on user " + id );
        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(Long id) {
        User userToDelete = findUser(id);
        logger.info("starting deleting user " + id );
        try {
            userRepository.delete(userToDelete);
            logger.info("finishing update on user " + id );
        } catch (DataIntegrityViolationException e) {
            logger.error("error on deleting user " + id);
            throw new EntityInUseException(
                    String.format("User with id %d cannot be deleted because it is in use", id));
        }
    }

    @Override
    public Page<User> list(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public User save(User user){
        return userRepository.save(user);
    }

    private User findUser(long userId){
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException());
    }

    public Optional<User> findUserByAgAndAcc(String ag, String acc){
        return userRepository.findUsersByAgAndAcc(ag, acc);
    }

    public Optional<User> findUserByCpfCNPJ(String cpfCnpj){
        return userRepository.findUsersByCpfCnpj(cpfCnpj);
    }
}
