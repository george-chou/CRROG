package au.sydney.elec5619.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import au.sydney.elec5619.domain.Company;
import au.sydney.elec5619.domain.User;
import au.sydney.elec5619.service.EnterpriseService;
import au.sydney.elec5619.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@SessionAttributes(value={"client", "temp"}, types={String.class, String.class})
public class CompleteController {

	public CompleteController() { }

	@RequestMapping("/ucomplete")
	@ResponseBody
	public boolean uinfoSubmit(
			@RequestParam(value="firstname") String firstname,
			@RequestParam(value="lastname") String lastname,
			@RequestParam(value="gender") int gender,
			@RequestParam(value="birth") String birth,
			@RequestParam(value="country") String country,
			@RequestParam(value="city") String city,
			@RequestParam(value="job") String job,
			@RequestParam(value="about") String about,
			@RequestParam(value="photo") String photo,
			@RequestParam(value="gitname") String gitname,
			@RequestParam(value="gitsw") boolean gitsw,
			@RequestParam(value="qmuslist") String qmuslist,
			@RequestParam(value="qmusw") boolean qmusw,
			@RequestParam(value="mapsw") boolean mapsw,
			@RequestParam(value="pgsw") boolean pgsw,
			@RequestParam(value="twitterurl") String twitterurl,
			@RequestParam(value="twittersw") boolean twittersw,
			@RequestParam(value="googleurl") String googleurl,
			@RequestParam(value="googlesw") boolean googlesw,
			@RequestParam(value="linkinurl") String linkinurl,
			@RequestParam(value="linkinsw") boolean linkinsw,
			@RequestParam(value="giturl") String giturl,
			@RequestParam(value="githubsw") boolean githubsw,
			@RequestParam(value="ycomurl") String ycomurl,
			@RequestParam(value="ycomsw") boolean ycomsw,
			@RequestParam(value="style") int style,
			@RequestParam(value="showcv") boolean showcv,
			//@RequestParam(value="codepath") String codepath,
			Map<String, Object> map
	) {

		User user = (User)getSession().getAttribute("client");
		IUserService uServivce = new IUserService(user);
		
		if(!firstname.isBlank()) uServivce.completeUser("first", firstname);
		if(!lastname.isBlank()) uServivce.completeUser("last", lastname);
		if(!birth.isBlank()) uServivce.completeUser("birth", birth);
		if(!country.isBlank()) uServivce.completeUser("country", country);
		if(!city.isBlank()) uServivce.completeUser("city", city);
		if(!job.isBlank()) uServivce.completeUser("job", job);
		uServivce.completeUser("gender", String.valueOf(gender));
		if(!about.isBlank()) uServivce.completeUser("about", about);
		if(!photo.isBlank()) uServivce.completeUser("photo", photo);
		if(!gitname.isBlank()) uServivce.completeUser("githubname", gitname);
		uServivce.completeUser("gitsw", bool2str(gitsw));
		if(!qmuslist.isBlank()) uServivce.completeUser("songlist", qmuslist);
		uServivce.completeUser("qqmusicsw", bool2str(qmusw));
		uServivce.completeUser("visitormap", bool2str(mapsw));
		uServivce.completeUser("pgsw", bool2str(pgsw));	
		
		uServivce.completeUser("twittersw", bool2str(twittersw));
		uServivce.completeUser("twitterurl", twitterurl);
		uServivce.completeUser("googlesw", bool2str(googlesw));
		uServivce.completeUser("googleurl", googleurl);
		uServivce.completeUser("linkedinsw", bool2str(linkinsw));
		uServivce.completeUser("linkedinurl", linkinurl);
		uServivce.completeUser("githubsw", bool2str(githubsw));
		uServivce.completeUser("githuburl", giturl);
		uServivce.completeUser("ycomsw", bool2str(ycomsw));
		uServivce.completeUser("ycomurl", ycomurl);
		
		uServivce.completeUser("style", String.valueOf(style));
		uServivce.completeUser("showcv", bool2str(showcv));
						
		map.put("client", uServivce.getUInfo());
		
		return true;
	}
	
	private String bool2str(boolean b)
	{
		return String.valueOf(b ? 1 : 0);
	}
	
    private HttpSession getSession()
    {
    	ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	HttpServletRequest request = attrs.getRequest();
    	HttpSession session = request.getSession();
    	return session;
    }
	
	@RequestMapping(value="/ucompletejson/{objname}", method=RequestMethod.POST)
	@ResponseBody
	public boolean ujsonSubmit(
			@RequestBody List<JSONObject> objectset,
			@PathVariable("objname") String objname,
			Map<String, Object> map
	) {
		
		User user = (User)getSession().getAttribute("client");
		IUserService uServivce = new IUserService(user);
		JSONArray ja = JSONArray.fromObject(objectset);	
		
		if(objname.equals("award"))
		{
			for(int i = 0 ; i < ja.size() ; i++)
			{
				ja.getJSONObject(i).remove("image");
				ja.getJSONObject(i).put("image", user.getEmail());				
			}
		}
		
		String content = objname.equals("programming") ? ja.get(0).toString() : ja.toString();
		if(!content.isEmpty()) uServivce.completeUser(objname, content);
		
		return true;
	}
	
	@RequestMapping(value = "/uedit", method = RequestMethod.GET)	
	public String useredit(Model model) 
	{
		return "/uinfoedit";
	}
	
	@RequestMapping(value = "/cedit", method = RequestMethod.GET)	
	public String companyedit(Model model) 
	{
		return "/cinfoedit";
	}
	
	@RequestMapping("/uload/{set}")
	@ResponseBody
	public JSONArray uload(@PathVariable("set") String set)
	{
		User user = (User)getSession().getAttribute("client");
		if(set.equals("award")) return user.getAward();
		if(set.equals("meet")) return user.getConference();
		if(set.equals("edu")) return user.getEdu();
		if(set.equals("folio")) return user.getFolios();
		if(set.equals("language")) return user.getLanguage();
		if(set.equals("pp")) return user.getPp();
		if(set.equals("webs")) return user.getWebs();
		if(set.equals("workexp")) return user.getWorkexp();
		
		JSONObject prog = user.getProgramming();
		prog.put("programming", user.isPgsw());
		
		JSONObject rest = new JSONObject();
		rest.put("gender", user.getGender());
		rest.put("country", user.getCountry());
		rest.put("about", user.getAbout());
		rest.put("githubname", user.getGithubname());
		rest.put("gitsw", user.isGitsw());
		rest.put("songlist", user.getSonglist());
		rest.put("qqmusicsw", user.isQqmusicsw());
		rest.put("visitormap", user.isVisitormap());
		//rest.put("twitterurl", user.getTwitterurl());
		rest.put("twittersw", user.isTwittersw());
		//rest.put("googleurl", user.getGoogleurl());
		rest.put("googlesw", user.isGooglesw());		
		//rest.put("linkedinurl", user.getLinkedinurl());
		rest.put("linkedinsw", user.isLinkedinsw());
		//rest.put("githuburl", user.getGithuburl());
		rest.put("githubsw", user.isGithubsw());
		//rest.put("ycomurl", user.getYcomurl());
		rest.put("ycomsw", user.isYcomsw());
		
		rest.put("style", user.getStyle());
		rest.put("showcv", user.isValid());
		
		JSONArray others = new JSONArray();
		others.add(prog);
		others.add(rest);
		
		return others;
	}
	
	@RequestMapping("/cvload/{set}")
	@ResponseBody
	public JSONArray cvload(@PathVariable("set") String set)
	{
		User user = (User)getSession().getAttribute("temp");
		if(set.equals("award")) return user.getAward();
		if(set.equals("meet")) return user.getConference();
		if(set.equals("edu")) return user.getEdu();
		if(set.equals("folio")) return user.getFolios();
		if(set.equals("language")) return user.getLanguage();
		if(set.equals("pp")) return user.getPp();
		if(set.equals("webs")) return user.getWebs();
		if(set.equals("workexp")) return user.getWorkexp();
		
		JSONObject prog = user.getProgramming();
		prog.put("programming", user.isPgsw());
		
		JSONObject rest = new JSONObject();
		rest.put("gender", user.getGender());
		rest.put("country", user.getCountry());
		rest.put("about", user.getAbout());
		rest.put("githubname", user.getGithubname());
		rest.put("gitsw", user.isGitsw());
		rest.put("songlist", user.getSonglist());
		rest.put("qqmusicsw", user.isQqmusicsw());
		rest.put("visitormap", user.isVisitormap());
		//rest.put("twitterurl", user.getTwitterurl());
		rest.put("twittersw", user.isTwittersw());
		//rest.put("googleurl", user.getGoogleurl());
		rest.put("googlesw", user.isGooglesw());		
		//rest.put("linkedinurl", user.getLinkedinurl());
		rest.put("linkedinsw", user.isLinkedinsw());
		//rest.put("githuburl", user.getGithuburl());
		rest.put("githubsw", user.isGithubsw());
		//rest.put("ycomurl", user.getYcomurl());
		rest.put("ycomsw", user.isYcomsw());
		
		rest.put("style", user.getStyle());
		rest.put("showcv", user.isValid());
		
		JSONArray others = new JSONArray();
		others.add(prog);
		others.add(rest);
		
		return others;
	}
	
	@RequestMapping("/ecomplete")
	@ResponseBody
	public boolean cinfoSubmit(
			@RequestParam(value="companyname") String companyname,
			@RequestParam(value="companycode") String companycode,
			@RequestParam(value="location") String location,
			@RequestParam(value="establishdate") String establishdate,
			@RequestParam(value="license") String license,
			@RequestParam(value="homepage") String homepage,
			@RequestParam(value="phone") String phone,
			@RequestParam(value="companytype") String companytype,
			@RequestParam(value="scale") int scale,
			Map<String, Object> map
	) {

		Company enter = (Company)getSession().getAttribute("client");
		EnterpriseService eServivce = new EnterpriseService(enter);
		
		if(!companyname.isBlank()) eServivce.completeCompany("companyname", companyname);
		if(!companycode.isBlank()) eServivce.completeCompany("companycode", companycode);
		if(!location.isBlank()) eServivce.completeCompany("location", location);
		if(!establishdate.isBlank()) eServivce.completeCompany("establishdate", establishdate);
		if(!license.isBlank()) eServivce.completeCompany("license", license);
		if(!homepage.isBlank()) eServivce.completeCompany("homepage", homepage);
		if(!phone.isBlank()) eServivce.completeCompany("phone", phone);
		if(!companytype.isBlank()) eServivce.completeCompany("companytype", companytype);
		eServivce.completeCompany("scale", String.valueOf(scale));
		eServivce.completeCompany("audit", "0");

		map.put("client", eServivce.getCoInfo());
		
		return true;
	}
	
	@RequestMapping("/getscale")
	@ResponseBody
	public int getScale()
	{
		Company enter = (Company)getSession().getAttribute("client");
		return enter.getScale();
	}


}
