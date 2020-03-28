package au.sydney.elec5619.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import au.sydney.elec5619.domain.Company;
import au.sydney.elec5619.domain.User;
import au.sydney.elec5619.service.EnterpriseService;
import au.sydney.elec5619.service.IUserService;

@Controller
@SessionAttributes(value={"client", "temp", "admin"}, types={String.class, String.class, boolean.class})
public class SearchController {

	private static final String COMPANY_URL = "company";
	private static final String FAVORITES_URL = "favorites";
	private static final String EMPLOYED_URL = "employed";
	private static final String SEARCH_URL = "search";
	
	private static final String USER_URL = "user";
	private static final String UPANEL_URL = "userpanel";
	private static final String CV_URL = "cv";

	public SearchController() { }

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public List<Object> startSearch(
			String usersearch
	) {

		Company centerprise = (Company)getSession().getAttribute("client");
		EnterpriseService es = new EnterpriseService(centerprise);
		ArrayList<Object> result = es.searchUser(usersearch);
		
		int num = result.size();
		List<Object> l1 = new LinkedList<Object>();
		
		for(int i = 0 ; i < num ; i++)
		{
			@SuppressWarnings("unchecked")
			Map<String, Object> sres = (HashMap<String, Object>)result.get(i);
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("job", sres.get("job").toString());
			m2.put("name", sres.get("name").toString());
			m2.put("homepage", sres.get("homepage").toString());
			m2.put("collected", sres.get("collected").toString());
			m2.put("hired", sres.get("hired").toString());
			m2.put("email", sres.get("email").toString());
			l1.add(m2);
		}
		
		return l1;
	}
	
	@RequestMapping("/mark")
	@ResponseBody
	public boolean startMark(
			String email,
			boolean switchon,
			boolean iscollect
	) {
		Company centerprise = (Company)getSession().getAttribute("client");
		EnterpriseService es = new EnterpriseService(centerprise);
		return es.setMark(email, switchon, iscollect);
	}
	
	@RequestMapping("/marksearch")
	@ResponseBody
	public List<Object> startMarkSearch(
			boolean isCollect
	) {

		Company centerprise = (Company)getSession().getAttribute("client");
		EnterpriseService es = new EnterpriseService(centerprise);
		ArrayList<Object> result = es.getMarked(isCollect);
		
		int num = result.size();
		List<Object> l1 = new LinkedList<Object>();
		
		for(int i = 0 ; i < num ; i++)
		{
			@SuppressWarnings("unchecked")
			Map<String, Object> sres = (HashMap<String, Object>)result.get(i);
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("job", sres.get("job").toString());
			m2.put("name", sres.get("name").toString());
			m2.put("homepage", sres.get("homepage").toString());
			m2.put("collected", sres.get("collected").toString());
			m2.put("hired", sres.get("hired").toString());
			m2.put("email", sres.get("email").toString());
			l1.add(m2);
		}
		
		return l1;
	}
	
    private HttpSession getSession()
    {
    	ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	HttpServletRequest request = attrs.getRequest();
    	HttpSession session = request.getSession();
    	return session;
    }
    
    private String token(String path)
    {
		if(getSession().getAttribute("client") != null)
		{
			if(getSession().getAttribute("client").getClass().equals(Company.class))
			{
				return path;
			}
		}		
		return "redirect:/login";
    }
    
    private String UserToken(String path)
    {
		if(getSession().getAttribute("client") != null)
		{
			if(getSession().getAttribute("client").getClass().equals(User.class))
			{
				return path;
			}
		}		
		return "redirect:/login";
    }

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)	
	public String signin(Model model) 
	{
		return token(SEARCH_URL);
	}

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String company(Model model) 
	{
		return token(COMPANY_URL);
	}

	@RequestMapping(value = "/favorites", method = RequestMethod.GET)
	public String favorites(Model model) 
	{
		return token(FAVORITES_URL);
	}

	@RequestMapping(value = "/employed", method = RequestMethod.GET)
	public String employed(Model model) 
	{
		return token(EMPLOYED_URL);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) 
	{
		return UserToken(USER_URL);
	}
	
	@RequestMapping(value = "/userpanel", method = RequestMethod.GET)
	public String userpanel(Model model) 
	{
		return UserToken(UPANEL_URL);
	}
	
	@RequestMapping(value = "/cv/{username}", method = RequestMethod.GET)
	public String toCV(
			@PathVariable("username") String username,
			Map<String, Object> map
	) {

		if(getSession().getAttribute("admin") != null && getSession().getAttribute("admin").equals(true))
		{
			map.put("temp", new IUserService().getUInfo(username));
			return CV_URL;
		}
		
		if(getSession().getAttribute("client") != null && !username.isBlank())
		{
			if(getSession().getAttribute("client").getClass().equals(User.class))
			{
				User cuser = (User)getSession().getAttribute("client");
				if(cuser.getEmail().equals(username))
				{
					map.put("temp", cuser);
					return CV_URL; 
				}
			}
			else if(getSession().getAttribute("client").getClass().equals(Company.class))
			{
				Company center = (Company)getSession().getAttribute("client");
				IUserService iuser = new IUserService();
				if(center.isAudit() && iuser.openCV(username))
				{
					map.put("temp", iuser.getUInfo(username));
					return CV_URL;
				}
			}


		}	
		
		return "404";
	}
	
}


