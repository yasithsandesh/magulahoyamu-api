package com.yasithsandesh.magulahoyamuapi.service.impl;

import com.yasithsandesh.magulahoyamuapi.dto.request.CreateAccountDTO;
import com.yasithsandesh.magulahoyamuapi.dto.response.ResponseDTO;
import com.yasithsandesh.magulahoyamuapi.entity.PartnerPreference;
import com.yasithsandesh.magulahoyamuapi.entity.Profile;
import com.yasithsandesh.magulahoyamuapi.entity.User;
import com.yasithsandesh.magulahoyamuapi.enums.Gender;
import com.yasithsandesh.magulahoyamuapi.repo.UserRepo;
import com.yasithsandesh.magulahoyamuapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepository;

    @Override
    public ResponseDTO createAccount(CreateAccountDTO createAccountDTO) {

        ResponseDTO responseDTO = new ResponseDTO();

        if(userRepository.existsByEmail(createAccountDTO.getEmail())) {
            responseDTO.setMessage("Email already exists");
            return responseDTO;
        }

        if(createAccountDTO.getPartnerPreference() == null){
            responseDTO.setMessage("PartnerPreference is null");
            return responseDTO;
        }

        PartnerPreference partnerPreference =  this.modelMapper.map(createAccountDTO.getPartnerPreference(), PartnerPreference.class);

        Profile profile = new Profile();
        profile.setPartnerPreference(partnerPreference);
        profile.setCity(createAccountDTO.getCity());
        profile.setCountry(createAccountDTO.getCountry());
        profile.setHeight(createAccountDTO.getHeight());
        profile.setJob(createAccountDTO.getJob());
        profile.setText(createAccountDTO.getText());
        profile.setBirthYear(createAccountDTO.getBirthYear());
        profile.setEducationLevel(createAccountDTO.getEducationLevel());


        User user = new User();
        user.setPassword(this.passwordEncoder.encode(createAccountDTO.getPassword()));
        user.setProfile(profile);
        user.setName(createAccountDTO.getName());
        user.setEmail(createAccountDTO.getEmail());
        user.setGender(
                "male".equalsIgnoreCase(createAccountDTO.getGender()) ? Gender.MALE : Gender.FEMALE
        );

        this.userRepository.save(user);

        responseDTO.setMessage("Account created successfully");
        responseDTO.setSuccess(true);

        return responseDTO;
    }

    @Override
    public ResponseDTO login(String email, String password) {
        return null;
    }



}
