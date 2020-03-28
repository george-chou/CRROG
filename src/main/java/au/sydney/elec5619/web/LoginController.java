package au.sydney.elec5619.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import au.sydney.elec5619.domain.Company;
import au.sydney.elec5619.domain.User;
import au.sydney.elec5619.service.EnterpriseService;
import au.sydney.elec5619.service.IUserService;
import au.sydney.elec5619.service.SMTPService;

@Controller
@SessionAttributes(value={"client", "vcode"}, types={String.class, String.class})
public class LoginController 
{	
	private static final int SIGNIN_SUCCESS = 2;
	private static final int NEED_COMPLETE = 1;
	private static final int LOGIN_SUCCESS = 0;
	private static final int INVALID_EMAIL = -1;
	private static final int INCORRECT_PASS = -2;
	private static final int INVALID_PASS = -3;
	private static final int USER_EXIST = -4;
	private static final int ACCOUNT_BANNED = -9;
	private static final int NEED_AUDIT = -10;

	private static final String LOGIN = "login";
	private static final String SIGNIN = "signin";
	private static final String USUCCESS = "user";
	private static final String UCOMPLETE = "uinfocomplete";
	private static final String ESUCCESS = "company";
	private static final String ECOMPLETE = "cinfocomplete";
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)	
	public String login(Model model) 
	{
		model.addAttribute("message", "");
		model.addAttribute("usererr", "");
		model.addAttribute("passerr", "");
		return LOGIN;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value = "clientype") String[] radioCheckedValues,
			Map<String, Object> map
	) {		
		
		boolean IS_USER = radioCheckedValues[0].equals("user");
		int LOGIN_RESULT = 0;
		IUserService uServivce = null;
		EnterpriseService cService = null;
		
		if(IS_USER)
		{
			User user = new User(username, password);
			uServivce = new IUserService(user);
			LOGIN_RESULT = uServivce.tryLogin();
		}
		else
		{
			Company company = new Company(username, password);
			cService = new EnterpriseService(company);
			LOGIN_RESULT = cService.tryLogin();
		}
		
		ModelAndView mav = null;
		
		switch(LOGIN_RESULT)
		{
			case LOGIN_SUCCESS:
				map.put("client", IS_USER ? uServivce.getUInfo() : cService.getCoInfo());
				return new ModelAndView(IS_USER ? USUCCESS : ESUCCESS);
			
			case NEED_COMPLETE:
				map.put("client", IS_USER ? uServivce.getUInfo() : cService.getCoInfo());
				return new ModelAndView(IS_USER ? UCOMPLETE : ECOMPLETE);
				
			case INVALID_EMAIL:
				mav = new ModelAndView(LOGIN);
				mav.addObject("usererr", "(x)Invalid email.");
				mav.addObject("passerr", "");
				return mav;
				
			case ACCOUNT_BANNED:
				mav = new ModelAndView(LOGIN);
				mav.addObject("usererr", "(x)Banned account.");
				mav.addObject("passerr", "");
				return mav;
				
			case NEED_AUDIT:
				mav = new ModelAndView(LOGIN);
				mav.addObject("usererr", "(x)Awaiting audit.");
				mav.addObject("passerr", "");
				return mav;
				
			case INCORRECT_PASS:
				mav = new ModelAndView(LOGIN);
				mav.addObject("usererr", "");
				mav.addObject("passerr", "(x)Incorrect username or password.");
				return mav;
				
			default:
				mav = new ModelAndView(LOGIN);
				mav.addObject("usererr", "(x)Unknown error.");
				mav.addObject("passerr", "");
				return mav;	
		}
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)	
	public String signin(Model model) 
	{
		model.addAttribute("usererr", "");
		model.addAttribute("passerr", "");
		model.addAttribute("confirmerr", "");
		return SIGNIN;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signin(
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
			mav = new ModelAndView(SIGNIN);
			mav.addObject("usererr", "");
			mav.addObject("passerr", "");
			mav.addObject("confirmerr", "(x)Inconsistent password.");
			return mav;
		}
		
		if(verCode == "")
		{
			mav = new ModelAndView(SIGNIN);
			mav.addObject("usererr", "(x)Empty verify code.");
			mav.addObject("passerr", "");
			mav.addObject("confirmerr", "");
			return mav;
		}
		else if(!verCode.equals((String)getSession().getAttribute("vcode")))
		{
			mav = new ModelAndView(SIGNIN);
			mav.addObject("usererr", "(x)Wrong verify code.");
			mav.addObject("passerr", "");
			mav.addObject("confirmerr", "");
			return mav;
		}
		
		boolean IS_USER = radioCheckedValues[0].equals("user");
		int SIGNIN_RESULT = 0;
		IUserService uServivce = null;
		EnterpriseService cService = null;
		
		if(IS_USER)
		{
			User user = new User(username, password);
			uServivce = new IUserService(user);
			SIGNIN_RESULT = uServivce.trySignIn();
		}
		else
		{
			Company company = new Company(username, password);
			cService = new EnterpriseService(company);
			SIGNIN_RESULT = cService.trySignIn();
		}

		switch(SIGNIN_RESULT)
		{
			case SIGNIN_SUCCESS:
				sessionStatus.setComplete();
				mav = new ModelAndView(LOGIN);
				mav.addObject("message", "Welcome!");
				mav.addObject("usererr", "");
				mav.addObject("passerr", "");
				return mav;
				
			case INVALID_EMAIL:
				mav = new ModelAndView(SIGNIN);
				mav.addObject("usererr", "(x)Invalid email.");
				mav.addObject("passerr", "");
				mav.addObject("confirmerr", "");
				return mav;
				
			case INVALID_PASS:
				mav = new ModelAndView(SIGNIN);
				mav.addObject("usererr", "");
				mav.addObject("passerr", "(x)Pass should be 8-20 digits including upper letter, lower letter, numbers and specified marks.");
				mav.addObject("confirmerr", "");
				return mav;
				
			case USER_EXIST:
				mav = new ModelAndView(SIGNIN);
				mav.addObject("usererr", "(x)The user already exists.");
				mav.addObject("passerr", "");
				mav.addObject("confirmerr", "");
				return mav;
				
			default:
				mav = new ModelAndView(SIGNIN);
				mav.addObject("usererr", "(x)Unknown error.");
				mav.addObject("passerr", "");
				mav.addObject("confirmerr", "");
				return mav;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)  
	public RedirectView logout(SessionStatus sessionStatus) 
	{
	    sessionStatus.setComplete();
	    return REDIRECT(".");
	} 


	@RequestMapping("/sendemail")	
	@ResponseBody
	public Map<String, Object> sendEmail(
			String username,
			String suffix,
			Map<String, Object> map
	) {
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		if(username.isBlank() || suffix.isBlank())
		{
			resultMap.put("result", "(x)Invalid email.");
			return resultMap;
		}
		
		String tail = suffix.equals("user") ? "@uni.sydney.edu.au" : "@sydney.edu.au";		
		SMTPService smtp = new SMTPService(username + tail);
		smtp.start();
		map.put("vcode", smtp.getVCode());

		resultMap.put("result", "Sending success.");
		return resultMap;
	}

	
    private HttpSession getSession()
    {
    	ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	HttpServletRequest request = attrs.getRequest();
    	HttpSession session = request.getSession();
    	return session;
    }
    
    private RedirectView REDIRECT(String path)
    {
    	return new RedirectView(path, true, false, false);
    }

}
