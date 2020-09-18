package com.bcaf.ivan.FinalProject.Controller;

import com.bcaf.ivan.FinalProject.Entity.Agency;
import com.bcaf.ivan.FinalProject.Entity.User;
import com.bcaf.ivan.FinalProject.Request.*;
import com.bcaf.ivan.FinalProject.Util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private AgencyDao agencyDao;

    @Bean
    public BCryptPasswordEncoder pass() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/createNewAccount")
    public HttpStatus createNewAccount(@RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setMobileNumber(registerRequest.getContactNumber());
        user.setRoleId(roleDao.findIdByRole("owner").getId());
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(pass().encode(registerRequest.getPassword()));
        userDao.save(user);

        Agency agency = new Agency();
        agency.setName(registerRequest.getAgencyName());
        agency.setDetails(registerRequest.getAgencyDetail());
        agency.setUserId(user.getId());
        agency.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        agencyDao.save(agency);
        return HttpStatus.OK;
    }

    @PostMapping("/checkEmailUserByUser")
    public String checkEmailUser(@RequestBody User userParam) throws JsonProcessingException {
        User user = userDao.findEmailValidation(userParam.getEmail());
        if (user == null)
            user = new User();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PostMapping("/checkEmailUser")
    public String checkEmailUser(@RequestBody RegisterRequest registerRequest) throws JsonProcessingException {
        User user = userDao.findEmailValidation(registerRequest.getEmail());
        if (user == null)
            user = new User();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PostMapping("/login")
    public String login(String email,String password) throws JsonProcessingException{
       User user = userDao.findEmailValidation(email);
       String encoded = pass().encode(password);
       if(pass().matches(password,user.getPassword())){
           ObjectMapper obj= new ObjectMapper();
           Agency agency=agencyDao.findAgencyByUserId(user.getId());
           UserAgencyToken userAgency = new UserAgencyToken();
           userAgency.setAgencyId(agency.getId());
           userAgency.setUserEmail(user.getEmail());
           userAgency.setUserId(user.getId());
           userAgency.setUserName(user.getFirstName()+" "+user.getLastName());
           String iss = obj.writeValueAsString(userAgency);
           String JWT = new CreateJWT()
                   .buildJWT(user.getId(),iss,"login",1000000);
           String rs = obj.writeValueAsString(JWT);
           return rs;
       }
       else{
           return "error";
        }
    }

    @PostMapping("/updateProfile")
    public String updateProfile(@RequestBody User user, HttpServletRequest request) throws JsonProcessingException, InvalidKeySpecException, NoSuchAlgorithmException {
        HttpSession session = request.getSession(true);
        String userId = (String) session.getAttribute("connectedUser");
        User userDB = userDao.findById(userId).get();
        if(user.getFirstName()!=null)
            userDB.setFirstName(user.getFirstName());
        if(user.getLastName()!=null)
            userDB.setLastName(user.getLastName());
        if(user.getMobileNumber()!=null)
            userDB.setMobileNumber(user.getMobileNumber());
        if(user.getEmail()!=null)
            userDB.setEmail(user.getEmail());
        if(user.getPassword()!=null && user.getPassword()!="")
            userDB.setPassword(pass().encode(user.getPassword()));
        userDB.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        userDao.save(userDB);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(userDB);
        return rs;
    }
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) throws JsonProcessingException, InvalidKeySpecException, NoSuchAlgorithmException {
        User userDB = userDao.findById(user.getId()).get();
        if(user.getFirstName()!=null && user.getFirstName()!="")
            userDB.setFirstName(user.getFirstName());
        if(user.getLastName()!=null && user.getLastName()!="")
            userDB.setLastName(user.getLastName());
        if(user.getMobileNumber()!=null && user.getMobileNumber()!="")
            userDB.setMobileNumber(user.getMobileNumber());
        if(user.getEmail()!=null && user.getEmail()!="")
            userDB.setEmail(user.getEmail());
        if(user.getPassword()!=null && user.getPassword()!="")
            userDB.setPassword(pass().encode(user.getPassword()));
        userDB.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        userDao.save(userDB);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(userDB);
        return rs;
    }

    @PostMapping("/getProfile")
    public String getProfile(HttpServletRequest request) throws JsonProcessingException, InvalidKeySpecException, NoSuchAlgorithmException {
        HttpSession session = request.getSession(true);
        String userId = (String) session.getAttribute("connectedUser");
        User user = userDao.findById(userId).get();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }

    @PostMapping("/getUserById")
    public String getUserById(String userId) throws JsonProcessingException, InvalidKeySpecException, NoSuchAlgorithmException {
        User user = userDao.findById(userId).get();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }
    @PostMapping("/createUser")
    public String createUser(@RequestBody User userInp) throws JsonProcessingException {
        User user = new User();
        user.setFirstName(userInp.getFirstName());
        user.setLastName(userInp.getLastName());
        user.setEmail(userInp.getEmail());
        user.setMobileNumber(userInp.getMobileNumber());
        user.setRoleId(roleDao.findIdByRole("owner").getId());
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(pass().encode(userInp.getPassword()));
        userDao.save(user);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(user);
        return rs;
    }


}
