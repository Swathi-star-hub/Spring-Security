package com.example.BackendCrud.controller;


import com.example.BackendCrud.VO.BasicDetailsVO;
import com.example.BackendCrud.VO.CredentialVO;
import com.example.BackendCrud.VO.ErrorVO;
import com.example.BackendCrud.VO.Response;
import com.example.BackendCrud.config.TokenGeneration;
import com.example.BackendCrud.entity.UserCredential;
import com.example.BackendCrud.service.BasicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class BasicDetailsController {

    @Autowired
    BasicDetailsService basicDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenGeneration tokenGeneration;


    @PostMapping("/saveBasicDetails")
    public ResponseEntity<Object> saveBasicDetails(@RequestBody BasicDetailsVO basicDetailsVO){
        Response response = new Response();
        ErrorVO error = new ErrorVO();
        System.out.println("Inside basic details Controller");
        try {
            response = basicDetailsService.saveBasicDetails(basicDetailsVO);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch(Exception e) {
            System.out.println("Exception occured in controller");
            /*error.setErrorCode(ErrorConstants.INTERNAL_SERVER_ERROR.getCode());
            error.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR.getMsg());*/
            return new ResponseEntity<>(error,HttpStatus.OK);
        }

    }

    @DeleteMapping("/member/{mebId}")
    public ResponseEntity<String> deleteMemberById(@PathVariable Integer mebId){
        String deleteById = basicDetailsService.deleteById(mebId);
        return new ResponseEntity<>(deleteById,HttpStatus.OK);
    }

    @GetMapping("/getBasicDtls/{mebId}")
    public ResponseEntity<Object> getMemberById(@PathVariable Integer mebId){
        Object getById = basicDetailsService.getById(mebId);
        return new ResponseEntity<>(getById,HttpStatus.OK);
    }



    /*@GetMapping("/getBasicDtls/{mebId}")
    public ResponseEntity<Object> getMembersById(@RequestParam(value="mebId",required = false) Integer mebId){
        Object getById = basicDetailsService.getById(mebId);
        return new ResponseEntity<>(getById,HttpStatus.OK);
    }*/

@PostMapping("/authenticate")
    public String authenticate(@RequestBody CredentialVO credential){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credential.getUsername(), credential.getPassword()));
        if(authentication.isAuthenticated()){
          return tokenGeneration.generateToken(credential.getUsername()) ;
        }else{
            throw new UsernameNotFoundException("user not authenticated");
        }
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Spring Security Basic Authentication Demo!!";
    }
    @PostMapping("/new")
    public String addNewUser(@RequestBody UserCredential userInfo) {
        return basicDetailsService.addUser(userInfo);
    }


}
