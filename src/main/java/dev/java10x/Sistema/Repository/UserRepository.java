package dev.java10x.Sistema.Repository;

import dev.java10x.Sistema.Model.User;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Repository
public class UserRepository {

    public void save(User user){
        if(user.getId()==null){
            System.out.println("Save");
        }
        else{
            System.out.println("Update");
        }
        System.out.println(user);
    }
    public void deleteById(Integer Id){
        System.out.println(String.format("Delete - %d" + Id));
        System.out.println(Id);
    }
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        users.add(new User("kaka", "1234"));
        users.add(new User("nico", "4321"));
        return users;
    }
    public User findByUsername(String username){
        return new User("kaka", "1234");
    }
    public User findById(Integer id){
        return new User("kaka", "1234");
    }
}
