package com.pushpender.ecombackend.services;


import com.pushpender.ecombackend.DTO.AddressDTO.AddressRequestDto;
import com.pushpender.ecombackend.DTO.AddressDTO.AddressResponseDto;
import com.pushpender.ecombackend.entities.Address;
import com.pushpender.ecombackend.repositories.AddressRepository;
import com.pushpender.ecombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addRepo;
    @Autowired
    private UserRepository userRepo;
    public List<AddressResponseDto> getAddress(Long user_id){
//        var user = userRepo.findById(user_id).orElse(null);
        return addRepo.findByUserId(user_id).stream()
                .map(add->new AddressResponseDto(add.getStreet(),add.getCity(),add.getZip(),add.getState()))
                .collect(Collectors.toList());


    }
    public void saveAddress(AddressRequestDto dto,Long user_id){
        var user = userRepo.findById(user_id).orElse(null);
        if(user == null){
            throw new RuntimeException("No User Found for id:"+user_id);
        }
        var newAdd = new Address();
        newAdd.setUser(user);
        newAdd.setStreet(dto.getStreet());
        newAdd.setCity(dto.getCity());
        newAdd.setZip(dto.getZip());
        newAdd.setState(dto.getState());
        addRepo.save(newAdd);

    }

    public void editAddress(AddressRequestDto dto,Long id){
        var add = addRepo.findById(id).orElse(null);
        if(add == null){
            throw new RuntimeException("Address not found for id:"+id);
        }
        add.setStreet(dto.getStreet());
        add.setCity(dto.getCity());
        add.setZip(dto.getZip());
        add.setState(dto.getState());
        addRepo.save(add);

    }

    public void deleteAddress(Long id){
        var add = addRepo.findById(id).orElse(null);
        if(add == null){
            throw new RuntimeException("Address not Found");
        }
        addRepo.deleteById(id);
    }

}
