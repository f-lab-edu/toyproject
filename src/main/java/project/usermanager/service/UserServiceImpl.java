package project.usermanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import project.usermanager.dto.UserDto;
import project.usermanager.domain.User;
import project.usermanager.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl{

    private final UserRepository userRepository;

    public String join(UserDto member) {
        validateDuplicateMember(member);
        User user = member.toEntity();
        userRepository.save(user);
        return member.getId();
    }

    public void validateDuplicateMember(UserDto member) {
        userRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }

    public List<String> findAll(){
        return userRepository.findByAll();
    }

    public List<String> findName(String name){
        return userRepository.findByName(name);
    }

}
