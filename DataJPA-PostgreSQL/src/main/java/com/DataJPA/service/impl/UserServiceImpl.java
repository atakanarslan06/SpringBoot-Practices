package com.DataJPA.service.impl;

import com.DataJPA.dto.UserDto;
import com.DataJPA.entity.Adress;
import com.DataJPA.entity.User;
import com.DataJPA.repository.IAdressRepository;
import com.DataJPA.repository.IUserRepository;
import com.DataJPA.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IAdressRepository adressRepository;
    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        final User userDb = userRepository.save(user);
        List<Adress> list = new ArrayList<>();
        userDto.getAdresses().forEach(item -> {
            Adress adress = new Adress();
            adress.setAdress(item);
            adress.setAdresType(Adress.AdresType.OTHER);
            adress.setActive(true);
            adress.setUser(userDb);
        });
        adressRepository.saveAll(list);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDto getAll(UserDto userDto) {
        return null;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
