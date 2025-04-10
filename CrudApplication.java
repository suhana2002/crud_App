package com.crud.crudapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;
import com.database.crudApp;
//import com.database.crudAppRepo;
import com.database.Services;

//import ch.qos.logback.core.model.Model;


@Controller
@SpringBootApplication(scanBasePackages = "com.database")
@EnableJpaRepositories("com.database")
@EntityScan("com.database")

public class CrudApplication {

	
	
	@GetMapping("/Home")
	public String Home() {
		
		return "Home.html";
		
	}
	
	@Autowired
	private Services empService;
	
//	@PostMapping("/addEmp")
//	public String addEmp(@RequestParam("name") String name,
//            @RequestParam("gender") String gender,
//            @RequestParam("email") String email,
//            @RequestParam("age") int age,
//            @RequestParam("phone") String phone,
//            Model m) {
//
//// Create a new Employee object
//crudApp emp = new crudApp();
//emp.setName(name);
//emp.setGender(gender);
//emp.setEmail(email);
//emp.setAge(age);
//emp.setPhone(phone);
//
//// Save to the database
//empService.saveEmp(emp);
//
//m.addAttribute("emp",emp);
//System.out.print(emp);
//m.addAttribute("message", "Employee added successfully!");
//// Redirect or return view
//return "Home"; // assuming you want to go back to homepage
//}
//	 @GetMapping("/showEmp")
//	    public String viewEmployees(Model model) {
//	        List<crudApp> employees = empService.getAllEmp();
//	        model.addAttribute("employees", employees);
//	        
//	        
//	        System.out.println("Fetched Employees: " + employees.size());
//
//	        return "Home"; // or the name of your HTML file
//	        
//	 }
	
	// POST: Add employee
	@PostMapping("/addEmp")
	public String addEmp(@RequestParam("name") String name,
	                     @RequestParam("gender") String gender,
	                     @RequestParam("email") String email,
	                     @RequestParam("age") int age,
	                     @RequestParam("phone") String phone,
	                     RedirectAttributes redirectAttributes) {

	    // Create a new Employee object
	    crudApp emp = new crudApp();
	    emp.setName(name);
	    emp.setGender(gender);
	    emp.setEmail(email);
	    emp.setAge(age);
	    emp.setPhone(phone);

	    // Save to the database
	    empService.saveEmp(emp);

	    // Add flash message to show on redirected page
	    redirectAttributes.addFlashAttribute("message", "Employee added successfully!");

	    // Redirect to the GET method (avoid form re-submission)
	    return "redirect:/showEmp";
	}

	// GET: Show employees
	@GetMapping("/showEmp")
	public String viewEmployees(Model model) {
	    List<crudApp> employees = empService.getAllEmp();
	    model.addAttribute("employees", employees);

	    System.out.println("Fetched Employees: " + employees.size());

	    return "Home"; // this is your view (Home.html / Home.jsp etc.)
	}

	 
	 @GetMapping("/editEmp/{id}")
	 public String editEmployee(@PathVariable Long id, Model model) {
	     crudApp emp = empService.getEmpById(id);
	     model.addAttribute("employee", emp);
	     return "editEmp";  // new HTML page for editing
	 }
	 @PostMapping("/updateEmp")
	 public String updateEmployee(@ModelAttribute("employee") crudApp emp) {
	     empService.saveEmp(emp);
	     return "redirect:/showEmp";
	 }


	 
	 @GetMapping("/")
	 public String redirectToShowEmp() {
	     return "redirect:/showEmp";
	 }
	 
	 @PostMapping("/deleteEmp/{id}")
	 public String deleteEmployee(@PathVariable Long id) {
	     empService.deleteEmpById(id);
	     return "redirect:/showEmp";
	 }

	 
	 
	
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
