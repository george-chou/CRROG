package au.sydney.elec5619.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import au.sydney.elec5619.service.ClientService;

@Controller
@SessionAttributes(value={"vcode"}, types={String.class})
public class ForgetController {
	
	private static final String LOGIN_URL = "login";
	private static final String FORGET_URL = "forget";
	
	protected static final int SIGNIN_SUCCESS = 2;
	protected static final int NEED_COMPLETE = 1;
	protected static final int LOGIN_SUCCESS = 0;
	protected static final int INVALID_EMAIL = -1;
	protected static final int INCORRECT_PASS = -2;
	protected static final int INVALID_PASS = -3;
	protected static final int USER_EXIST = -4;
	
	protected static final int RESET_SUCCESS = 3;
	protected static final int RESET_FAILED = -5;
	protected static final int USER_NOTEXIST = -6;
	protected static final int OLD_EQUALNEW = -7;
	protected static final int UNKNOWN_ERR = -8;

	public ForgetController() { }
	
	@RequestMapping(value = "/forget", method = RequestMethod.GET)	
	public String resetpass(Model model) 
	{
		model.addAttribute("usererr", "");
		model.addAttribute("passerr", "");
		model.addAttribute("confirmerr", "");
		return FORGET_URL;
	}
	
	@RequestMapping(value = "/forget", method = RequestMethod.POST)
	public ModelAndView resetpass(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("confirm") String confirm,
			@RequestParam("verify") String verCode,
			@RequestParam(value = "clientype") String[] radioCheckedValues,
			SessionStatus sessionStatus
	) {
		
		ModelAndView mav = null;
		
		if(!password.equals(confirm)) 
		{
			mav = new ModelAndView(FORGET_URL);
			mav.addObject("usererr", "");
			mav.addObject("passerr", "");
			mav.addObject("confirmerr", "(x)Inconsistent password.");
			return mav;
		}
		
		if(verCode == "")
		{
			mav = new ModelAndView(FORGET_URL);
			mav.addObject("usererr", "(x)Empty verify code.");
			mav.addObject("passerr", "");
			mav.addObject("confirmerr", "");
			return mav;
		}
		else if(!verCode.equals((String)getSession().getAttribute("vcode")))
		{
			mav = new ModelAndView(FORGET_URL);
			mav.addObject("usererr", "(x)Wrong verify code.");
			mav.addObject("passerr", "");
			mav.addObject("confirmerr", "");
			return mav;
		}
		
		boolean IS_USER = radioCheckedValues[0].equals("user"); 
		ClientService cs = new ClientService(); 

		switch(cs.resetPass(username, password, IS_USER))
		{
			case RESET_SUCCESS:
				sessionStatus.setComplete();
				mav = new ModelAndView(LOGIN_URL);
				mav.addObject("message", "Reset success!");
				mav.addObject("usererr", "");
				mav.addObject("passerr", "");
				return mav;
				
			case INVALID_EMAIL:
				mav = new ModelAndView(FORGET_URL);
				mav.addObject("usererr", "(x)Invalid email.");
				mav.addObject("passerr", "");
				mav.addObject("confirmerr", "");
				return mav;
				
			case INVALID_PASS:
				mav = new ModelAndView(FORGET_URL);
				mav.addObject("usererr", "");
				mav.addObject("passerr", "(x)Pass should be 8-20 digits including upper letter, lower letter, numbers and specified marks.");
				mav.addObject("confirmerr", "");
				return mav;
				
			case RESET_FAILED:
				mav = new ModelAndView(FORGET_URL);
				mav.addObject("usererr", "");
				mav.addObject("passerr", "(x)Failed to reset pass.");
				mav.addObject("confirmerr", "");
				return mav;
				
			case USER_NOTEXIST :
				mav = new ModelAndView(FORGET_URL);
				mav.addObject("usererr", "");
				mav.addObject("passerr", "(x)The user does not exist.");
				mav.addObject("confirmerr", "");
				return mav;
				
			case OLD_EQUALNEW  :
				mav = new ModelAndView(FORGET_URL);
				mav.addObject("usererr", "");
				mav.addObject("passerr", "(x)The old pass equals to the new pass.");
				mav.addObject("confirmerr", "");
				return mav;
				
			default:
				mav = new ModelAndView(FORGET_URL);
				mav.addObject("usererr", "(x)Unknown error.");
				mav.addObject("passerr", "");
				mav.addObject("confirmerr", "");
				return mav;
		}
	}
	
    private HttpSession getSession()
    {
    	ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	HttpServletRequest request = attrs.getRequest();
    	HttpSession session = request.getSession();
    	return session;
    }
    

}
