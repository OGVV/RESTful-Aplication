package com.example.Bank.Controllers;



import com.example.Bank.Model.User;
import com.example.Bank.service.UserServInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   private final UserServInterface userServInterface;

   @Autowired
   public UserController(UserServInterface userServInterface) {
      this.userServInterface = userServInterface;
   }


   @PostMapping(value = "/user")
   public ResponseEntity<?> create(@RequestBody User user) {
      userServInterface.create(user);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }
   @GetMapping(value = "/users")
   public ResponseEntity<List<User>> read(){
       final List<User> users=userServInterface.readAll();

       return users !=null && !users.isEmpty()
               ? new ResponseEntity<>(users,HttpStatus.OK)
               : new ResponseEntity<>(HttpStatus.NOT_FOUND);


   }
   @GetMapping(value = "/users/{id}")
   public ResponseEntity<User> read(@PathVariable(name = "id") int id){
      final User user=userServInterface.read(id);

      return user != null
              ?new ResponseEntity<>(user,HttpStatus.OK)
              : new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }




   @PutMapping(value = "/updateuser/{id}")
   public ResponseEntity<?> update(@PathVariable(name="id")int id,@RequestBody User user){
     final boolean update=userServInterface.update(user,id);
     return update
             ? new ResponseEntity<>(HttpStatus.OK)
             :new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   @DeleteMapping(value="/deleteuser/{id}")
   public ResponseEntity<?> delete(@PathVariable(name = "id")int id){
      final boolean delete=userServInterface.delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
   }
}
