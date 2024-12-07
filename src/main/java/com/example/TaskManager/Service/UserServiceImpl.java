package com.example.TaskManager.Service;
import com.example.TaskManager.Entity.User;
import com.example.TaskManager.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepo userRepository;

    @Autowired
    public UserServiceImpl(UserRepo userRepository){
        this.userRepository=userRepository;

    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public User getUserById(Long id) {
        Optional<User> result=userRepository.findById(id);
        if(result.isEmpty()){

            throw new RuntimeException("Did not find the user with the id-"+id);
        }
        return result.get();
    }




    @Override
    public User updateUser(Long id, User user) {
        Optional<User> result=userRepository.findById(id);
        if(result.isEmpty()){
            throw  new RuntimeException("User not found with id-"+id);
        }

        User ex=result.get();
        ex.setFirstName(user.getFirstName());
        ex.setLastName(user.getLastName());
        ex.setTimezone(user.getTimezone());
        ex.setIsActive(user.getIsActive());
        return userRepository.save(ex);
    }

    @Override
    public void deleteUserById(Long id) {

        User user = getUserById(id);
        userRepository.delete(user);

    }
}
