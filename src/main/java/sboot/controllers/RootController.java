package sboot.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sboot.dto.FileUploadForm;
import sboot.dto.SignupForm;
import sboot.mail.SmtpMailSender;
import sboot.services.PersonDAO;
import sboot.services.UserService;
import sboot.util.MyUtil;
import sboot.validators.SignupFormValidator;

@Controller
public class RootController {

	private static final Logger logger = LoggerFactory.getLogger(RootController.class);

	private UserService userservice;
	private SignupFormValidator signupFormValidator;
	private PersonDAO personDAO;
	private SmtpMailSender smtpMailSender;

	@Autowired
	public RootController(SmtpMailSender smtpMailSender,UserService userservice, SignupFormValidator signupFormValidator,PersonDAO personDAO) {
		this.userservice = userservice;
		this.signupFormValidator = signupFormValidator;
		this.personDAO=personDAO;
		this.smtpMailSender=smtpMailSender;

	}

	@InitBinder("signupForm")
	protected void initSignupBinder(WebDataBinder binder) {
		binder.setValidator(signupFormValidator);
	}

	@RequestMapping("/mail")
	public String mail() throws MessagingException {
		
		smtpMailSender.send("p11249988@gmail.com", "Test mail from Spring", "Hello World");		
		return "home";
		
	}
	
	@RequestMapping(value={"/","/index"})
	public String home() {
		return "index";

	}
	
	
	
	@RequestMapping("/login")
	public String login() {
		return "login1";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String signup(Model model) {

		model.addAttribute("signupForm", new SignupForm());
		return "register";

	}
	
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String signup(@ModelAttribute("signupForm") @Valid SignupForm signupForm, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "register";
		}
		// logger.info(signupForm.toString());

		userservice.signup(signupForm);

		MyUtil.flash(redirectAttributes, "success", "signupSuccess");

		return "redirect:/register";

	}
	
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("uploadForm") FileUploadForm uploadForm,
            Model map) throws IllegalStateException, IOException {

        List<MultipartFile> files = uploadForm.getFiles();

        List<String> fileNames = new ArrayList<String>();

        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                    //Handle file content - multipartFile.getInputStream()

                    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                    String newFolder = auth.getName(); //get logged in username
//                	String newFolder ="mujify";
//                    String saveDirectory = "H:\\Netbeans\\SpringMVCMaven\\src\\main\\webapp\\" + newFolder + "/";
                	String saveDirectory ="C:/Users/mujtaba/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/SpringBoot1.zip_expanded/SpringBoot1/src/main/resources/static/uploadedImages/"+ newFolder +"/";
//                    String saveDirectory = "C:\\Users\\mujify\\Documents\\Netbeans\\SpringMVCMaven\\src\\main\\webapp\\" + newFolder + "/";
//                    String saveDirectory = "/home/muji3009/jvm/apache-tomcat-8.0.9/domains/mujify.com/ROOT/" + newFolder + "/";

                    File theDir = new File(saveDirectory);

                    // if the directory does not exist, create it
                    if (!theDir.exists()) {
                        System.out.println("creating directory: " + saveDirectory);
                        theDir.mkdir();
                    }
                    
//                    saveDirectory="C:/Users/mujtaba/Documents/workspace-spring-tool-suite-4-4.9.0.RELEASE/SpringBoot1.zip_expanded/SpringBoot1/src/main/resources/static/uploadedImages/"+ newFolder +"/";

                    multipartFile.transferTo(new File(saveDirectory + fileName));   //Here I Added
                    fileNames.add(fileName);
                }
            }
        }
        map.addAttribute("files", fileNames);
        return "fileuploadsuccess";
    }
    	
//    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
//    public ModelAndView Register() {
//        ModelAndView fPage = new ModelAndView("register");
//        Person newUser = new Person();
//        fPage.addObject("person", newUser);
////        fPage.setViewName("register");
//
//        return fPage;
//    }
    
    @RequestMapping(value = {"/contact"}, method = RequestMethod.GET)
    public ModelAndView contact() {
        ModelAndView contact = new ModelAndView("contact");

        return contact;
    }
    
    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public ModelAndView category() {
        ModelAndView category = new ModelAndView("category");

        return category;
    }
    
    @RequestMapping(value = {"/basket"}, method = RequestMethod.GET)
    public ModelAndView basket() {
        ModelAndView basket = new ModelAndView("basket");

        return basket;
    }
    
    @RequestMapping(value = {"/detail"}, method = RequestMethod.GET)
    public ModelAndView detail() {
        ModelAndView detail = new ModelAndView("detail");

        return detail;
    }
    
    @RequestMapping(value = {"/checkout1"}, method = RequestMethod.GET)
    public ModelAndView checkout() {
        ModelAndView checkout = new ModelAndView("checkout1");

        return checkout;
    }
    
    @RequestMapping(value = {"/checkout2"}, method = RequestMethod.GET)
    public ModelAndView checkout2() {
        ModelAndView checkout2 = new ModelAndView("checkout2");

        return checkout2;
    }
    
    @RequestMapping(value = {"/checkout3"}, method = RequestMethod.GET)
    public ModelAndView checkout3() {
        ModelAndView checkout3 = new ModelAndView("checkout3");
    
        return checkout3;
    }
    
    @RequestMapping(value = {"/checkout4"}, method = RequestMethod.GET)
    public ModelAndView checkout4() {
        ModelAndView checkout4 = new ModelAndView("checkout4");

        return checkout4;
    }
    
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadFile() {
        ModelAndView model = new ModelAndView();
        model.setViewName("fileuploadform");

        return model;

    }
    
//    @RequestMapping(value = "/savePerson", method = RequestMethod.POST)
//    public ModelAndView savePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
//
//        if (result.hasErrors()) {
//            ModelAndView model2 = new ModelAndView("register");
//            return model2;
//        }
//
//        try {
//            this.personDAO.saveOrUpdate(person);
//
//            this.personDAO.addUserRole(person, "ROLE_ADMIN");
//
//            return new ModelAndView("redirect:/regSuccess");
//
//        } catch (Exception e) {
//        }
//
//        return new ModelAndView("redirect:/regSuccess");
//    }

    

}
