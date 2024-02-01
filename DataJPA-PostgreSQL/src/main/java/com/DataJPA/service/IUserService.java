package com.DataJPA.service;

import com.DataJPA.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    UserDto save(UserDto userDto);
    void delete(Long id);
    List<UserDto> getAll();
    Page<UserDto> getAll(Pageable pageable);
}
