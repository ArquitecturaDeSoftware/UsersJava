package arquitecturaSoftware.hcrodriguezl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> index(){
        List<User> users = userRepository.findAll();
        return users;
    }


    @GetMapping("/users/{id}")
    public User getUserByUserId(@PathVariable String userId){

        return userRepository.findByUserId(userId);
    }



    @PostMapping("/users")
    public User createUser(@RequestBody Map<String, String> body){
        String userId = body.get("userId");
        String name = body.get("name");
        String lunchroomId = body.get("lunchroomId");
        String activeTicket = body.get("activeTicket");
        String password = body.get("password");
        
        User oldUser = userRepository.findByUserId(userId);
        if(Objects.isNull(oldUser)){
            User newUser = new User( userId, name, lunchroomId, activeTicket, password);
            return userRepository.save(newUser);
        }else{
            return oldUser;
        }
                

    }

    @PutMapping("/users/{id}")
    public User putActiveTicket(@PathVariable String id, @RequestBody Map<String, String> body){
        int idUser = Integer.parseInt(id);
        String activeTicket = body.get("activeTicket");
        User user = userRepository.findOne(idUser);
        user.setActiveTicket(activeTicket);
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable String id ){
        int idUser = Integer.parseInt(id);
        userRepository.delete(idUser);
        return true;
    }



}
