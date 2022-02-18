package project.usermanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import project.usermanager.dto.UserDto;
import project.usermanager.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    /* 회원가입 */
    @PostMapping("/user")
    public String createUser(@Valid UserDto user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                System.err.println("code : " + objectError.getCode());
                System.err.println("defaultMessage : " + objectError.getDefaultMessage());
                System.err.println("objectName : " + objectError.getObjectName());
            });
            return bindingResult.getFieldError().getField().toString() +": "+ bindingResult.getFieldError().getDefaultMessage().toString() ;
        } else {
            return userService.join(user);
        }
    }


    /* 저장되어있는 유저 전부 조회 */
    @GetMapping("all")
    public List<String> findAllUsers(){
        return userService.findAll();
    }

    /*이름값으로 유저 조회*/
    @GetMapping("find")
    public List<String> findOne(@RequestParam(name = "name") String name) {
        return userService.findName(name);
    }
}

