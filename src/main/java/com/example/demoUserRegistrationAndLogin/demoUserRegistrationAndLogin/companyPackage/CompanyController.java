package com.example.demoUserRegistrationAndLogin.demoUserRegistrationAndLogin.companyPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository companyrepo;

    @GetMapping("/companyindex")
    public String companyindex(){
        return "companyindex";
    }

    @PostMapping("/register_company")
    public String processRegistration(Company company){
        companyrepo.save(company);
        return "company_register_success";
    }

    @GetMapping("/company")
    public String listCompanies(Model model){
        List<Company> listCompanies = companyrepo.findAll();
        model.addAttribute("listCompanies", listCompanies);
        return "company";
    }
    @GetMapping("/addNewCompany")
    public String addNewCompany(Model model){
        Company company = new Company();
        model.addAttribute("company",company);
        return "new_company";
    }

    @PostMapping("/saveCompany")
    public String saveUser(@ModelAttribute("company") Company company){
        companyrepo.save(company);
        return "redirect:/company";
    }

    @GetMapping("/showFromForUpdateCompany/{id}")
    public String showFromForUpdateCompany(@PathVariable("id") long id, Model model) {
        Company company = companyrepo.getCompanyById(id);
        model.addAttribute("company",company);
        return "update_company";
    }


    @GetMapping("/company/{id}")
    public String deleteCompany(@PathVariable("id") long id){
        this.companyrepo.deleteCompanyById(id);
        return "redirect:/company";
    }

}
