package au.sydney.elec5619.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile; 

import au.sydney.elec5619.domain.Company;
import au.sydney.elec5619.domain.User;

@Controller
public class UploadController {

	private static final String rootPath = "F:\\downloads\\springmvc\\sts\\ResumeGenerator\\src\\main\\webapp\\resources\\data\\";

	public UploadController() { }


	@ResponseBody
    @RequestMapping(value = "/uinform", method = RequestMethod.POST)   
    public boolean userFileHandler(
    		@RequestParam("photos") MultipartFile[] photos,
    		@RequestParam("folios") MultipartFile[] folios,
    		@RequestParam("awards") MultipartFile[] awards
    ) {

		for(int i = 0 ; i < folios.length ; i++) System.out.println(uplfolio(folios[i], i + 1, true));
		for(int i = 0 ; i < awards.length ; i++) System.out.println(uplfolio(awards[i], i + 1, false));

		return uploadUFile(photos[0]) == "Uploading success!";
    }

    private String uplfolio(MultipartFile file, int id, boolean isFolio)
    {

    	if (!file.isEmpty()) 
        {
            try 
            {
            	String directory = isFolio ? "folios" : "awards";
            	User uinfo = (User)getSession().getAttribute("client");
                File dir = new File(rootPath + "user" + File.separator + uinfo.getEmail() + File.separator + directory);
                if (!dir.exists()) dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + String.valueOf(id) + ".png");
                file.transferTo(serverFile); 
                return "Uploading success!";
            } 
            catch (Exception e) 
            {
            	return "You failed to upload " +  file.getOriginalFilename() + " => " + e.getMessage();
            }
        } 
        else 
        {
        	return "You failed to upload " +  file.getOriginalFilename() + " because the file was empty.";
        }

    }
	
    private String uploadUFile(MultipartFile file)
    {

    	if (!file.isEmpty()) 
        {
            try 
            {
            	User uinfo = (User)getSession().getAttribute("client");
                File dir = new File(rootPath + "user" + File.separator + uinfo.getEmail());
                if (!dir.exists()) dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + "photo.png");
                file.transferTo(serverFile); 
                return "Uploading success!";
            } 
            catch (Exception e) 
            {
            	return "You failed to upload " +  file.getOriginalFilename() + " => " + e.getMessage();
            }
        } 
        else 
        {
        	return "You failed to upload " +  file.getOriginalFilename() + " because the file was empty.";
        }

    }


    
    @RequestMapping("/img/{username}/{imgtype}/{id}")
    public void loadIMG(
    		@PathVariable("username") String username,
    		@PathVariable("imgtype") String imgtype,
    		@PathVariable("id") int id,
    		HttpServletResponse response
    ) {
    	if(imgtype.equals("folios") || imgtype.equals("awards"))
    	{
        	File dir = new File(rootPath + "user" + File.separator + username + File.separator + imgtype);
            if (!dir.exists()) dir.mkdirs();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + String.valueOf(id) + ".png"); 
            responseFile(response, serverFile);
    	}
    }   
    

    @RequestMapping(value = "/cinform", method = RequestMethod.POST)
	@ResponseBody
    public boolean companyFileHandler(@RequestParam("license") MultipartFile file) 
    { 	
		return uploadCFile(file) == "Uploading success!";
    }
    
    private String uploadCFile(MultipartFile file)
    {

    	if (!file.isEmpty()) 
        {
            try 
            {
            	Company cinfo = (Company)getSession().getAttribute("client");            	            	
                File dir = new File(rootPath + "enterprise" + File.separator + cinfo.getEmail());
                if (!dir.exists()) dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + "license.png");
                file.transferTo(serverFile); 
                return "Uploading success!";
            } 
            catch (Exception e) 
            {
            	return "You failed to upload " +  file.getOriginalFilename() + " => " + e.getMessage();
            }
        } 
        else 
        {
        	return "You failed to upload " +  file.getOriginalFilename() + " because the file was empty.";
        }

    }    

    public HttpSession getSession()
    {
    	ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    	HttpServletRequest request = attrs.getRequest();
    	HttpSession session = request.getSession();
    	return session;
    }

    @RequestMapping("/data/{clientype}/{username}")
    public void showPicture(
    		@PathVariable("clientype") String clientype,
    		@PathVariable("username") String username,
    		HttpServletResponse response
    ) {
    	String ImgName = clientype.equals("user") ? "photo.png" : "license.png";
    	File imgFile = new File(rootPath + File.separator + clientype + File.separator + username + File.separator + ImgName);
    	if(!imgFile.exists()) imgFile = new File(rootPath + File.separator + "default.png"); 
        responseFile(response, imgFile);
    }

    private void responseFile(HttpServletResponse response, File imgFile) 
    {
    	InputStream is;
    	
        try
        {
        	is = new FileInputStream(imgFile);
        	OutputStream os = response.getOutputStream();
        	
        	byte [] buffer = new byte[1024];

        	while(is.read(buffer) != -1)
            {
                os.write(buffer);
            }
        	
            os.flush();
            
        } 
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    
    @RequestMapping(value = "/ainform", method = RequestMethod.POST)
	@ResponseBody
    public boolean adminFileHandler(
    		@RequestParam("cssfile") MultipartFile file,
    		@RequestParam("theme") int theme
    ) { 	
		return uploadCSS(file, theme) == "Uploading success!";
    }
    
    private String uploadCSS(MultipartFile file, int index)
    {
    	if (!file.isEmpty()) 
        {
            try 
            {           	            	
                File dir = new File(rootPath + "theme" + File.separator + String.valueOf(index));
                if (!dir.exists()) dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + "style.css");
                file.transferTo(serverFile); 
                return "Uploading success!";
            } 
            catch (Exception e) 
            {
            	return "You failed to upload " +  file.getOriginalFilename() + " => " + e.getMessage();
            }
        } 
        else 
        {
        	return "You failed to upload " +  file.getOriginalFilename() + " because the file was empty.";
        }
    }    
    
    @RequestMapping("/theme/{id}")
    public void loadCSS(
    		@PathVariable("id") int id,
    		HttpServletResponse response
    ) {
        File dir = new File(rootPath + File.separator + "theme");
        if (!dir.exists()) dir.mkdirs();   	
    	File cssFile = new File(dir.getAbsolutePath() + File.separator + String.valueOf(id) + File.separator + "style.css");
    	if(!cssFile.exists()) cssFile = new File(dir.getAbsolutePath() + File.separator + "1" + File.separator + "style.css"); 
        responseFile(response, cssFile);
    }
    
}
