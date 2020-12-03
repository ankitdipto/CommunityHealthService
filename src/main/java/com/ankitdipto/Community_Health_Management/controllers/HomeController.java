package com.ankitdipto.Community_Health_Management.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.ankitdipto.Community_Health_Management.Repositories.*;
import com.ankitdipto.Community_Health_Management.USER.MyUser;
import com.ankitdipto.Community_Health_Management.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
    //@Autowired
    //DummyRepo dummyrepo;
    

    @Autowired
    isolationRepo isorepo;

    @Autowired
    publicRepo publicrepo;

    @Autowired
    zoneRepo zonerepo;

    @Autowired
    covid_active_Repo covid_active_repo;

    @Autowired
    amblRepo amblrepo;

    @Autowired
    clubRepo clubrepo;

    //@Autowired
    //dengue_act_Repo dengue_act_repo;

    @Autowired
    doctorRepo doctorrepo;

    @Autowired
    medicalRepo medicalrepo;

    @Autowired
    rec_covRepo rec_covrepo;

    //@Autowired
    //reqRepo reqrepo;

    @Autowired
    hospitalRepo hosprepo;

    @Autowired
    infectionRepo infectionrepo;
    
    @GetMapping("/")
    public String findHome()
    {
        //System.out.println("In home method");
        return "home";
    }  
    
    @GetMapping("/Kaggle")
    public String findImage()
    {
        return "Kaggle";
    }

    @GetMapping("/test/{uid}")
    public String thymeleaftest(@PathVariable(name = "uid") int uid,Model model)
    {
        model.addAttribute("zone", zonerepo.getOne(uid));
        return "testview";
    }

    @GetMapping("/columnChart")
    public String ShowChart1()
    {
        return "column";
    }
    @GetMapping("/pieChart")
    public String ShowChart2()
    {
        return "pie";
    }
    @GetMapping("/lineChart")
    public String ShowChart3()
    {
        return "line";
    }
    /*@GetMapping("/dummies")
    public ModelAndView Dummies()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("dummies",dummyrepo.findAll());
        return mv;
    }

    @PostMapping("/dummy/{ID}")
    public @ResponseBody Optional<Dummy> getDummy(@PathVariable("ID") int uid)
    {
        Optional<Dummy> dummy=dummyrepo.findById(uid);
        return dummy;
    }

    @PostMapping("/dummy")
    public @ResponseBody Dummy insert(@RequestBody Dummy dummy)
    {
        dummyrepo.save(dummy);
        return dummy;
    }

    @PutMapping("/dummy")
    public @ResponseBody Dummy modify(@RequestBody Dummy dummy)
    {
        dummyrepo.save(dummy);
        return dummy;
    }

    @DeleteMapping("/dummy")
    public @ResponseBody boolean remove(int uid)
    {
        Dummy dummy=dummyrepo.getOne(uid);
        dummyrepo.delete(dummy);
        return true;
    }*/

    //================ ISOLATION CENTRE DETAILS =================//
    @GetMapping("/iso")
    public ModelAndView readIC()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("isolation_centre_details");
        mv.addObject("isocentres",isorepo.findAll());
        return mv;
        
    }

    //public ModelAndView editISO()
    //{
    //}

    @PostMapping("/iso")
    public @ResponseBody boolean addIC(@RequestBody ISOLATION_CENTRE_DETAILS isocentre)
    {
        isorepo.save(isocentre);
        return true;
    }
    @DeleteMapping("/iso")
    public @ResponseBody boolean removeByIdIC(int id)
    {
        ISOLATION_CENTRE_DETAILS isocentre=isorepo.getOne(id);
        isorepo.delete(isocentre);
        return true;
    }

    @GetMapping("/isoedit")
    public String modifyICform()
    {
        return "input";
    }

    @PutMapping("/isoedit")
    public String modifyIC(@RequestBody ISOLATION_CENTRE_DETAILS isocentre)
    {
        isorepo.save(isocentre);
        return "base";
    }
    //==========================================//

    //================ PUBLIC RECORDS =================//
    @GetMapping("/public")
    public ModelAndView readPUB()
    {
        ModelAndView mv=new ModelAndView("public_records");
        mv.addObject("public_recordss", publicrepo.findAll());
        return mv;
    }
    @PostMapping("/public/add")
    public String addPUBpost( PUBLIC_RECORDS person)
    {
        System.out.println(person.toString());
        publicrepo.save(person);
        return "redirect:/public";
    }
    @GetMapping("/public/add")
    public String addPUBget()
    {
        return "inputPublic";
    }
    @DeleteMapping("/public")
    public @ResponseBody boolean removeByIdPUB(long id)
    {
        PUBLIC_RECORDS person=publicrepo.getOne(id);
        publicrepo.delete(person);
        return true;
    }
    @PutMapping("/public")
    public @ResponseBody boolean modifyPUB(@RequestBody PUBLIC_RECORDS person)
    {
        publicrepo.save(person);
        return true;
    }
    //==========================================//

    //================ ZONE =================//
    @GetMapping("/zone")
    public ModelAndView readZONE()
    {
        ModelAndView mvzone=new ModelAndView();
        mvzone.setViewName("zone");
        mvzone.addObject("zones", zonerepo.findAllSortedByCov19());
        return mvzone;
    }
    @PostMapping("/zone")
    public @ResponseBody ZONE addZONE(@RequestBody ZONE zone)
    {
        System.out.println(zone.toString());
        zonerepo.save(zone);
        return zone;
    }
    @DeleteMapping("/zone")
    public @ResponseBody boolean removeByIdZONE(int ward)
    {
        ZONE zone=zonerepo.getOne(ward);
        zonerepo.delete(zone);
        return true;
    }
    @PutMapping("/zone")
    public @ResponseBody boolean modifyZONE(@RequestBody ZONE zone)
    {
        zonerepo.save(zone);
        return true;
    }
    //==========================================//

    //================ COV_ACTIVE =================//
    @GetMapping("/cov")
    public ModelAndView readCOV_ACTIVE()
    {
        ModelAndView mv=new ModelAndView("covid19_active");
        mv.addObject("covid_patients",covid_active_repo.findAll());
        return mv;
    }
    @PostMapping("/cov")
    public @ResponseBody boolean addCOV_ACTIVE( COVID19_ACTIVE COV_ACTIVE)
    {
        infectionrepo.addNewInfections();
        System.out.println(COV_ACTIVE.toString());
        covid_active_repo.save(COV_ACTIVE);
        return true;
    }
    @DeleteMapping("/cov")
    public @ResponseBody boolean removeByIdCOV_ACTIVE(long uid)
    {
        COVID19_ACTIVE COV_ACTIVE=covid_active_repo.getOne(uid);
        covid_active_repo.delete(COV_ACTIVE);
        return true;
    }
    @PutMapping("/cov")
    public @ResponseBody boolean modifyCOV_ACTIVE(@RequestBody COVID19_ACTIVE COV_ACTIVE)
    {
        covid_active_repo.save(COV_ACTIVE);
        return true;
    }
    //==========================================//

    
//================ DOCTORS =================// 
@GetMapping("/doctors") 
public ModelAndView readDOC() 
{ 
    ModelAndView mv=new ModelAndView("doctors");
    mv.addObject("doctors",doctorrepo.findAll());
    return mv;
} 
@PostMapping("/doctors") 
public @ResponseBody boolean addDOC(@RequestBody DOCTORS doctor) 
{ 
    doctorrepo.save(doctor); 
    return true; 
} 
@DeleteMapping("/doctors") 
public @ResponseBody boolean removeByIdDOC(int id) 
{ 
    DOCTORS doctor=doctorrepo.getOne(id); 
    doctorrepo.delete(doctor); 
    return true; 
} 
@PutMapping("/doctors") 
public @ResponseBody boolean modifyDOC(@RequestBody DOCTORS doctor) 
{ 
    doctorrepo.save(doctor); 
    return true; 
} 
//==========================================// 

//================ AMBULANCE =================// 
@GetMapping("/ambulance") 
public ModelAndView readAMBL() 
{ 
    ModelAndView mview=new ModelAndView();
    mview.setViewName("ambulance_details");
    mview.addObject("ambulance_detailss",amblrepo.findAll());
    return mview;
} 
@PostMapping("/ambulance") 
public @ResponseBody boolean addAMBL(@RequestBody AMBULANCE_DETAILS ambulance) 
{ 
    amblrepo.save(ambulance); 
    return true; 
} 
@DeleteMapping("/ambulance") 
public @ResponseBody boolean removeByIdAMBL(int id) 
{ 
    AMBULANCE_DETAILS ambulance=amblrepo.getOne(id); 
    amblrepo.delete(ambulance); 
    return true; 
} 
@PutMapping("/ambulance") 
public @ResponseBody boolean modifyAMBL(@RequestBody AMBULANCE_DETAILS ambulance) 
{ 
    amblrepo.save(ambulance); 
    return true; 
} 
//==========================================// 

/*//================ DENGUE ACTIVE =================// 
@GetMapping("/dengue_active") 
public ModelAndView readDNG() 
{ 
    ModelAndView mv=new ModelAndView("dengue_active");
    mv.addObject("dengue_active_patients",dengue_act_repo.findAll());
    return mv; 
} 
@PostMapping("/dengue_active") 
public @ResponseBody boolean addDNG(@RequestBody DENGUE_ACTIVE dengue_victim) 
{ 
    dengue_act_repo.save(dengue_victim); 
    return true; 
} 
@DeleteMapping("/dengue_active") 
public @ResponseBody boolean removeByIdDNG(long uid) 
{ 
    DENGUE_ACTIVE dengue_victim=dengue_act_repo.getOne(uid); 
    dengue_act_repo.delete(dengue_victim); 
    return true; 
} 
@PutMapping("/dengue_active") 
public @ResponseBody boolean modifyDNG(@RequestBody DENGUE_ACTIVE dengue_victim) 
{ 
    dengue_act_repo.save(dengue_victim); 
    return true; 
} 
//==========================================// 
*/
//================ REQUIREMENTS =================// 
/*@GetMapping("/requirement") 
public ModelAndView readREQ() 
{ 
    ModelAndView mv=new ModelAndView("requirements");
    mv.addObject("requirements", reqrepo.findAll());
    return mv ;
} 
@PostMapping("/requirement") 
public @ResponseBody boolean addREQ(@RequestBody REQUIREMENTS reqitems) 
{ 
    reqrepo.save(reqitems); 
    return true; 
} 
@DeleteMapping("/requirement") 
public @ResponseBody boolean removeByIdREQ(int id) 
{ 
    REQUIREMENTS reqitems=reqrepo.getOne(id); 
    reqrepo.delete(reqitems); 
    return true; 
} 
@PutMapping("/requirement") 
public @ResponseBody boolean modifyREQ(@RequestBody REQUIREMENTS reqitems) 
{ 
    reqrepo.save(reqitems); 
    return true; 
} */
//==========================================// 

//================ MEDICAL STAFF =================// 
@GetMapping("/medical") 
public ModelAndView readMED() 
{ 
    ModelAndView mv=new ModelAndView("medical_help_records");
    mv.addObject("healthworkers",medicalrepo.findAll());
    return mv;
} 
@PostMapping("/medical") 
public @ResponseBody boolean addMED(MEDICAL_HELP_RECORDS healthworker) 
{ 
    medicalrepo.save(healthworker); 
    return true; 
} 
@DeleteMapping("/medical") 
public @ResponseBody boolean removeByIdMED(int id) 
{ 
    MEDICAL_HELP_RECORDS healthworker=medicalrepo.getOne(id); 
    medicalrepo.delete(healthworker); 
    return true; 
} 
@PutMapping("/medical") 
public @ResponseBody boolean modifyMED(@RequestBody MEDICAL_HELP_RECORDS healthworker) 
{ 
    medicalrepo.save(healthworker); 
    return true; 
} 
//==========================================// 

//================ COVID-19 RECOVERED =================// 
@GetMapping("/rec_cov") 
public ModelAndView readCOVREC() 
{ 
    ModelAndView mv=new ModelAndView("covid19_recovered");
    mv.addObject("covid_inactive_patients",rec_covrepo.findAll());
    return mv;
} 
@PostMapping("/rec_cov") 
public @ResponseBody boolean addCOVREC(@RequestBody COVID19_RECOVERED covid_inactive) 
{ 
    rec_covrepo.save(covid_inactive); 
    return true; 
} 
@DeleteMapping("/rec_cov") 
public @ResponseBody boolean removeByIdCOVREC(long id) 
{ 
    COVID19_RECOVERED covid_inactive=rec_covrepo.getOne(id); 
    rec_covrepo.delete(covid_inactive); 
    return true; 
} 
@PutMapping("/rec_cov") 
public @ResponseBody boolean modifyCOVREC(@RequestBody COVID19_RECOVERED covid_inactive) 
{ 
    rec_covrepo.save(covid_inactive); 
    return true; 
} 
//==========================================// 

//================ CLUB MEMBER RECORDS =================// 
@GetMapping("/club") 
public ModelAndView readCLUB() 
{ 
    ModelAndView mv=new ModelAndView("club_member_records");
    mv.addObject("club_members",clubrepo.findAll());
    return mv; 
} 
@PostMapping("/club") 
public @ResponseBody boolean addCLUB(@RequestBody CLUB_MEMBER_RECORDS member) 
{ 
    clubrepo.save(member); 
    return true; 
} 
@DeleteMapping("/club") 
public @ResponseBody boolean removeByIdCLUB(int id) 
{ 
    CLUB_MEMBER_RECORDS member=clubrepo.getOne(id); 
    clubrepo.delete(member); 
    return true; 
} 
@PutMapping("/club") 
public @ResponseBody boolean modifyCLUB(@RequestBody CLUB_MEMBER_RECORDS member) 
{ 
    clubrepo.save(member); 
    return true; 
} 
//==========================================// 

//================ HOSPITAL INFORMATION =================// 
@GetMapping("/hospital") 
public ModelAndView readHOSPITAL() 
{ 
    ModelAndView mv=new ModelAndView("hospital_information");
    mv.addObject("hospitals",hosprepo.findAll());
    return mv;                            
} 
@PostMapping("/hospital") 
public @ResponseBody boolean addHOSPITAL(@RequestBody HOSPITAL_INFORMATION hospital) 
{ 
    hosprepo.save(hospital); 
    return true;
} 
@DeleteMapping("/hospital") 
public @ResponseBody boolean removeByIdHOSPITAL(int id) 
{ 
    HOSPITAL_INFORMATION hospital=hosprepo.getOne(id); 
    hosprepo.delete(hospital); 
    return true; 
} 
@PutMapping("/hospital") 
public @ResponseBody boolean modifyHOSPITAL(@RequestBody HOSPITAL_INFORMATION hospital) 
{ 
    boolean status=false;
    try{
        HOSPITAL_INFORMATION oldhospital=hosprepo.getOne(hospital.getRegistrationNo());
        hosprepo.delete(oldhospital);
        hosprepo.save(hospital);
        status = true;
    }
    catch( javax.persistence.EntityNotFoundException e )
    {
        e.getMessage();
    }
    
    return status; 
} 

@PostMapping("/hospital/sort")
public ModelAndView sortHospitals(String argument)
{
    ModelAndView mv=new ModelAndView("hospital_information");
    List<HOSPITAL_INFORMATION> sortedData;
    //System.out.println("argument :"+argument);
    if(argument.equals("covid"))
    {
        //System.out.println("In covid if");
        sortedData=hosprepo.findByOrderByNoOfCovidBedsFreeDesc();
    }
    else if (argument.equals("general")==true)
        sortedData=hosprepo.sortedByGeneralBeds();
    else if (argument.equals("doctor")==true)
        sortedData=hosprepo.sortedByDoctors();
    else if (argument.equals("dengue")==true)
        sortedData=hosprepo.sortedByDengueBeds();
    else
        sortedData=hosprepo.findAll();
    mv.addObject("hospitals",sortedData);
    
    /*for(HOSPITAL_INFORMATION hospital:sortedData)
    {
          System.out.println(hospital.toString());
    }*/
    return mv;
}
//==========================================// 

}
