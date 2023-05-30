package co.za.entelect.services;

import co.za.entelect.dtos.UserDto;
import co.za.entelect.dtos.UserRequestDto;
import co.za.entelect.entities.UserEntity;
import co.za.entelect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserRequestDto userRequest){
        var existingUser = userRepository.findUserByPhoneNumber(userRequest.getPhoneNumber());
        System.out.println("1");
        if (existingUser.isPresent()){
            existingUser.get().setAccessToken(userRequest.getAccessToken());
            existingUser.get().setRefreshToken(userRequest.getRefreshToken());
            existingUser.get().setIdToken(userRequest.getIdToken());
            var updatedUser = userRepository.save(existingUser.get());
            return UserDto.fromEntity(updatedUser);
        }
        System.out.println("3");

        return UserDto.fromEntity(createUserEntity(userRequest));
    }

    public UserEntity createUserEntity(UserRequestDto userRequest){
        UserEntity newUser = UserEntity.builder()
                .phoneNumber(userRequest.getPhoneNumber())
                .accessToken(userRequest.getAccessToken())
                .refreshToken(userRequest.getRefreshToken())
                .idToken(userRequest.getIdToken())
                .build();
        var savedUser = userRepository.save(newUser);
        System.out.println(savedUser.toString());

        return savedUser;
    }
}
