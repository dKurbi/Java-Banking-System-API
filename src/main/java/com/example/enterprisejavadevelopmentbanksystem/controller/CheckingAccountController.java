package com.example.enterprisejavadevelopmentbanksystem.controller;

import com.example.enterprisejavadevelopmentbanksystem.model.account.CheckingAccount;
import com.example.enterprisejavadevelopmentbanksystem.model.user.AccountHolderUser;
import com.example.enterprisejavadevelopmentbanksystem.service.account.CheckingAccountService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checking_account")
public class CheckingAccountController {


    private final CheckingAccountService checkingAccountService;


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccount newCheckingAccount(@RequestParam("owner_id") Long ownerId,
                                              @RequestParam("secondary_owner_id") Optional<Long> secondaryOwnerId,
                                              @RequestParam("currency") Optional<String> currency,
                                              @RequestParam("secret_key") String secretKey) {

        return checkingAccountService.newCheckingAccount(ownerId, secondaryOwnerId, currency, secretKey);

    }
}
/*

public class DoctorController {

    private final DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/doctors")
    public List<Doctor> getDoctors(@RequestParam("status") Optional<EmployeeStatus> statusOptional,
                                   @RequestParam("department") Optional<String> departmentOptional) {
        return doctorService.findWithFilter(statusOptional, departmentOptional);
    }

    @GetMapping("/doctors/id/{id}")
    public Doctor getDoctors(@PathVariable String id) {
        return doctorService.findById(id);

    }

    @GetMapping("/doctors/status/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctorsByStatus(@PathVariable EmployeeStatus status) {
        return doctorService.findByStatus(status);
    }

    @PostMapping("/doctors/newdoctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addNewDoctor(@RequestBody DoctorDto newDoctorDto) {
        return doctorService.addNewDoctor(newDoctorDto);
    }

    @PatchMapping("/doctors/newstatus/{employeeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Doctor changeStatus(@PathVariable String employeeId,
                               @RequestParam("status") EmployeeStatus newStatus) {
        return doctorService.changeStatus(employeeId, newStatus);
    }

    @PatchMapping("/doctors/changedept/{employeeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Doctor changeDept(@PathVariable String employeeId,
                             @RequestParam("newdept") String newDept) {
        return doctorService.changeDept(employeeId, newDept);
    }

}
*/