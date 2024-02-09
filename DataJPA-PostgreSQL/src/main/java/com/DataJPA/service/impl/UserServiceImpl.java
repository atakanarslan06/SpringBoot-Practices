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
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IAdressRepository adressRepository;
    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        Assert.isNull(userDto.getName(), "Name is correct.");

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
   public List<UserDto> getAll(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(it -> {
            UserDto userDto = new UserDto();
            userDto.setId(it.getId());
            userDto.setName(it.getName());
            userDto.setAdresses(it.getAdresses().stream().map(Adress::getAdress).collect(Collectors.toList()));
            userDtos.add(userDto);
        });
        return userDtos;
   }
//Branch Denemesi
    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
