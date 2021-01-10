package sboot.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import sboot.dto.SignupForm;
import sboot.entities.User;
import sboot.repository.UserRepository;

@Component
public class SignupFormValidator extends LocalValidatorFactoryBean {
	
	private UserRepository userRepository;
	
//	@Resource
//	public void setUserRepository(UserRepository userRepository){
//		this.userRepository=userRepository;
//	}
	
	@Autowired
    public SignupFormValidator(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
    public boolean supports(Class<?> clazz){
    	return clazz.isAssignableFrom(SignupForm.class);
    }
	
	@Override
	public void validate(Object obj,Errors errors, final Object...validationHints){
		super.validate(obj,errors,validationHints);
		
		if (!errors.hasErrors()) {
			SignupForm signupForm=(SignupForm) obj;
			
			User user=userRepository.findByEmail(signupForm.getEmail());
			
			if (user!=null) {
				errors.rejectValue("email", "emailNotUnique");
				
			}
		}
	}
}
	


