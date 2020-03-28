package au.sydney.elec5619.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import au.sydney.elec5619.service.AdminService;


@Controller
@SessionAttributes(value={"admin"}, types={boolean.class})
public class AdminController {

	public AdminController() { }
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)	
	public String login(Model model) 
	{
		return "adminlogin";
	}
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam("password") String password,
			Map<String, Object> map
	) {

		if(new AdminService().adminLogin(password))
		{
			map.put("admin", true);
			return new ModelAndView("admincompany");
		}
		else
		{
			ModelAndView mav = new ModelAndView("adminlogin");
			mav.addObject("passerr", "(x)Incorrect pass.");
			return mav;
		}
		
	}
	
	@RequestMapping("/companyban")
	@ResponseBody
	public boolean startCompanyban(
			String email,
			boolean switchon
	) {

		return new AdminService().Ban(email, true, !switchon);
	}

	@RequestMapping("/userban")
	@ResponseBody
	public boolean startUserban(
			String email,
			boolean switchon
	) {

		return new AdminService().Ban(email, false, !switchon);
	}
	
	@RequestMapping(value = "/companysearch", method = RequestMethod.POST)
	@ResponseBody
	public List<Object> companySearch(
			String companysearch
	) {

		ArrayList<Object> result = new AdminService().companySearch(companysearch);
		
		int num = result.size();
		List<Object> l1 = new LinkedList<Object>();
		
		for(int i = 0 ; i < num ; i++)
		{
			@SuppressWarnings("unchecked")
			Map<String, Object> sres = (HashMap<String, Object>)result.get(i);
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("email", sres.get("email").toString());
			m2.put("company", sres.get("company").toString());
			m2.put("ban", sres.get("ban").toString());
			l1.add(m2);
		}
		
		return l1;
	}
	
	@RequestMapping(value = "/usersearch", method = RequestMethod.POST)
	@ResponseBody
	public List<Object> userSearch(
			String usersearch
	) {

		ArrayList<Object> result = new AdminService().userSearch(usersearch);
		
		int num = result.size();
		List<Object> l1 = new LinkedList<Object>();
		
		for(int i = 0 ; i < num ; i++)
		{
			@SuppressWarnings("unchecked")
			Map<String, Object> sres = (HashMap<String, Object>)result.get(i);
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("email", sres.get("email").toString());
			m2.put("name", sres.get("name").toString());
			m2.put("ban", sres.get("ban").toString());
			l1.add(m2);
		}
		
		return l1;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)  
	public String toAdminhome()
	{
		return "admin";
	} 
	
	@RequestMapping(value = "/audit", method = RequestMethod.GET)  
	public String toAudit()
	{
		return "audit";
	} 
	
	@RequestMapping(value = "/admincompany", method = RequestMethod.GET)  
	public String toCompanysearch()
	{
		return "admincompany";
	} 
	
	@RequestMapping(value = "/adminuser", method = RequestMethod.GET)  
	public String toUsersearch()
	{
		return "adminuser";
	} 
	
	@RequestMapping(value = "/bannedcompany", method = RequestMethod.GET)  
	public String toCompanyBan()
	{
		return "bannedcompany";
	} 
	
	@RequestMapping(value = "/banneduser", method = RequestMethod.GET)  
	public String toUserBan()
	{
		return "banneduser";
	} 
	
	@RequestMapping("/bannedusers")
	@ResponseBody
	public List<Object> getBannedUser(boolean ban) 
	{

		ArrayList<Object> result = new AdminService().getBannedUser();
		
		int num = result.size();
		List<Object> l1 = new LinkedList<Object>();
		
		for(int i = 0 ; i < num ; i++)
		{
			@SuppressWarnings("unchecked")
			Map<String, Object> sres = (HashMap<String, Object>)result.get(i);
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("email", sres.get("email").toString());
			m2.put("name", sres.get("name").toString());
			//m2.put("ban", sres.get("ban").toString());
			l1.add(m2);
		}
		
		return l1;
	}
	
	@RequestMapping("/bannedcompanies")
	@ResponseBody
	public List<Object> getBannedCompany(boolean ban) 
	{

		ArrayList<Object> result = new AdminService().getBannedCompany();
		
		int num = result.size();
		List<Object> l1 = new LinkedList<Object>();
		
		for(int i = 0 ; i < num ; i++)
		{
			@SuppressWarnings("unchecked")
			Map<String, Object> sres = (HashMap<String, Object>)result.get(i);
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("email", sres.get("email").toString());
			m2.put("company", sres.get("company").toString());
			//m2.put("ban", sres.get("ban").toString());
			l1.add(m2);
		}
		
		return l1;
	}
	
	@RequestMapping("/auditcompanies")
	@ResponseBody
	public List<Object> getWaitingList(boolean audit) 
	{

		ArrayList<Object> result = new AdminService().getWaiting();
		
		int num = result.size();
		List<Object> l1 = new LinkedList<Object>();
		
		for(int i = 0 ; i < num ; i++)
		{
			@SuppressWarnings("unchecked")
			Map<String, Object> sres = (HashMap<String, Object>)result.get(i);
			Map<String, Object> m2 = new HashMap<String, Object>();
			m2.put("email", sres.get("email").toString());
			m2.put("company", sres.get("company").toString());
			//m2.put("ban", sres.get("ban").toString());
			l1.add(m2);
		}
		
		return l1;
	}
	
	@RequestMapping("/companyaudit")
	@ResponseBody
	public boolean startAudit(
			String email,
			boolean switchon
	) {

		return new AdminService().Audit(email);
	}
}
