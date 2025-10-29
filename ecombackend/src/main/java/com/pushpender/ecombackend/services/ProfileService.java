package com.pushpender.ecombackend.services;


import com.pushpender.ecombackend.DTO.ProfileDTO.ProfileRequestDto;
import com.pushpender.ecombackend.DTO.ProfileDTO.ProfileResponseDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserResponseDto;
import com.pushpender.ecombackend.entities.Profile;
import com.pushpender.ecombackend.repositories.ProfileRepository;
import com.pushpender.ecombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository repo;
    @Autowired
    private UserRepository userRepo;
    public ProfileResponseDto getProfile(Long userId){
        var profile = repo.findById(userId).orElse(null);
        if(profile == null){
            throw  new RuntimeException("Profile not found for user id:"+userId);
        }
        var user = profile.getUser();
        var userDto = new UserResponseDto(user.getName(),user.getEmail());
        return new ProfileResponseDto(profile.getBio(),profile.getPhoneNumber(),profile.getDateOfBirth(),profile.getLoyaltyPoints(),user.getRole(),userDto);
    }
    public void saveProfile(ProfileRequestDto profile, Long id){
        var user = userRepo.findById(id).orElse(null);
        if(user == null){
            throw new RuntimeException("User Not Found");
        }

        var userProfile = repo.findById(id).orElse(null);
        if(userProfile != null){
            userProfile.setBio(profile.getBio());
            userProfile.setDateOfBirth(profile.getDateOfBirth());
            userProfile.setPhoneNumber(profile.getPhoneNumber());
            userProfile.setLoyaltyPoints(profile.getLoyaltyPoints());
            repo.save(userProfile);

        }else{
            var userProfile1 = new Profile();
            userProfile1.setUser(user);
            userProfile1.setBio(profile.getBio());
            userProfile1.setDateOfBirth(profile.getDateOfBirth());
            userProfile1.setPhoneNumber(profile.getPhoneNumber());
            userProfile1.setLoyaltyPoints(profile.getLoyaltyPoints());
            repo.save(userProfile1);
        }


    }
}
