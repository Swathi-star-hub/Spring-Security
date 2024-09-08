package com.example.BackendCrud.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.example.BackendCrud.DAO.BasicDetailsDAO;
import com.example.BackendCrud.VO.BasicDetailsVO;
import com.example.BackendCrud.VO.Response;
import com.example.BackendCrud.entity.Course;
import com.example.BackendCrud.entity.FamilyDtls;
import com.example.BackendCrud.entity.UserCredential;
import com.example.BackendCrud.repo.BasicDetailsRepo;
import com.example.BackendCrud.repo.CourseDetailsRepo;
import com.example.BackendCrud.repo.UserInfoRepo;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class  BasicDetailsService {

    private static final Logger log = LoggerFactory.getLogger(BasicDetailsService.class);
    private static Class<BasicDetailsService> logger=BasicDetailsService.class;

    @Autowired
    private BasicDetailsDAO basicDetailsDAO;

    @Autowired
    private BasicDetailsRepo basicDetailsRepo;

    @Autowired
    private UserInfoRepo repo;

    @Autowired
    private CourseDetailsRepo courseDtlsRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response saveBasicDetails(BasicDetailsVO basicDetailsVO) {
        System.out.println(basicDetailsVO);
        Response response = new Response();
        FamilyDtls familyDtls = null;
        try {
            System.out.println("Inside saving logic");
            if(ObjectUtils.isEmpty(basicDetailsRepo.findById(basicDetailsVO.getMebId()))) {
            /*Optional<FamilyDtls> mebId = basicDetailsRepo.findById(basicDetailsVO.getMebId());
            if(mebId.isPresent()) {
                BasicDetailsService.log.debug("Already application is there with this mebId!!");
            } else if (mebId == null) {*/
                familyDtls = new FamilyDtls();
            }
                familyDtls.setMebId(basicDetailsVO.getMebId());
                familyDtls.setName(basicDetailsVO.getName());
                familyDtls.setAge(basicDetailsVO.getAge());

            Course course = familyDtls.getCourse();

            if(course == null)
                course = new Course();
            course.setName(basicDetailsVO.getCourseDetails().getName());
            course.setPrice(basicDetailsVO.getCourseDetails().getPrice());

            Course course2 = courseDtlsRepo.save(course);
            System.out.println(course2);
            System.out.println(course2.getCid());
            familyDtls.setCourse(course2);
            System.out.println(familyDtls);
            FamilyDtls familyDtls2 = basicDetailsRepo.save(familyDtls);
            System.out.println(familyDtls2);

            response.setMebId(basicDetailsVO.getMebId());
            response.setStatus("BasicDetails Saved Successfully!");
        }catch(Exception e) {
           /* error.setErrorCode(ErrorConstants.INTERNAL_SERVER_ERROR.getCode());
            error.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR.getMsg());*/
          e.printStackTrace();
        }
        return response;
    }

    public String deleteById(Integer mebId) {
        basicDetailsRepo.deleteById(mebId);
        return "record deleted";
    }

    public FamilyDtls getById(Integer mebId) {
        Optional<FamilyDtls> findById = basicDetailsRepo.findById(mebId);
        if(findById.isPresent()) {
            return  findById.get();
        }else {
            // return null;
            return null;
        }
    }

    public String addUser(UserCredential userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repo.save(userInfo);
        return "user added to system ";
    }
    
    @PostConstruct
    public UserCredential loadDtlsFromDb(){

        UserCredential userCredential = new UserCredential(
                Stream.of(
                        new UserCredential("swathi", "pwd1", 1,"ADMIN"),
                        new UserCredential("Basant", "pwd2", 2,"USER")
                ).toString());
        return userCredential;

    }


}
