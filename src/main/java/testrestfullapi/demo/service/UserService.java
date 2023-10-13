package testrestfullapi.demo.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import testrestfullapi.demo.entity.User;
import testrestfullapi.demo.model.RegisterUserRequest;
import testrestfullapi.demo.model.UpdateUserRequest;
import testrestfullapi.demo.model.UserResponse;
import testrestfullapi.demo.repository.UserRepository;
import testrestfullapi.demo.security.BCrypt;

import java.util.Objects;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request){
        validationService.validate(request);
        if (userRepository.existsById(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    @Transactional
    public UserResponse get(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    public UserResponse update(User user, UpdateUserRequest request){
        validationService.validate(request);

        log.info("REQUEST : {}", request);

        if (Objects.nonNull(request.getName())){
            user.setName(request.getName());
        }
        if(Objects.nonNull(request.getName())){
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        userRepository.save(user);

        log.info("User : {}", user.getName());

        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();

    }





}
