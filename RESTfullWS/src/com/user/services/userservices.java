package com.user.services;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/user/service")
public class userservices {
	
	@PUT
	@Path("/create")
	public void addUser()
	{
		
	}
	@DELETE
	public void deleteUser()
	{
		
	}
	@POST
	@Path("/post")
	public void updateUser(@FormParam("username") String userName, @CookieParam("orgname") String orgName, @CookieParam("email") String email, @CookieParam("lastname") String lastName)
	{
		System.out.println("Update User Function");
		System.out.println("User name is : " + userName);
		//System.out.println("Last Name is : " + lastName);
		System.out.println("Email is : " + email);
		System.out.println("Org is : " + orgName);
		
		
	}
	@GET
	@Path("getURIParams/{uriparma1}/{uriparam2}")
	public void getURIParams(@Context UriInfo ui ){
		System.out.println("PATH parameters are : ");
		MultivaluedMap<String, String> mm = ui.getPathParameters();
		extractKeyValueFromMMap(mm);
		System.out.println("Query parameters are : ");
		MultivaluedMap<String, String> mmQuery = ui.getQueryParameters();
		extractKeyValueFromMMap(mmQuery);
	}
	
	@GET
	@Path("/getHeaderParams")
	
	public void getHeaderParams(@Context HttpHeaders hh){
		System.out.println("Header parameters are : ");
		MultivaluedMap<String, String> mmHH = hh.getRequestHeaders();
		extractKeyValueFromMMap(mmHH );
		
		System.out.println("Cookies  are : ");
		Map<String, Cookie> mmCk = hh.getCookies();
		
			Set<String> keySet = mmCk.keySet();
			for(String key : keySet){
				System.out.println("Key is  "+ key + " and the value is " + mmCk.get(key));
			}
	}

	@POST
	@Path("/getFormParams")
	public void getFormParams(MultivaluedMap<String, String> getformparams){
		
		extractKeyValueFromMMap(getformparams);
	}
	
	private void extractKeyValueFromMMap(MultivaluedMap<String, String> mm) {
		// TODO Auto-generated method stub
		Set<String> keySet = mm.keySet();
		for(String key : keySet){
			System.out.println("Key is  "+ key + " and the value is " + mm.get(key));
			
		}
		
	}
	@GET
	//@Path("/get/{userid}")
	@Path("/get")
	public void getUser(@PathParam("userid") String userID, @QueryParam("fname") String fName, @HeaderParam("host") String clientName)
	{
		System.out.println("Inside get user function");
		System.out.println("User name is : " + userID);
		System.out.println("and your first name is : " + fName);
		System.out.println("Hosted on server name is : " + clientName);
		
	}
	
	@GET
	@Path("/getUserID/{username}/{email}")
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_XML)
	//@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public User getUserID(@PathParam("username") String userID, @PathParam("email") String eMail){
		
		System.out.println("Inside getUserID Method");
		User user = new User();
		user.setUserid(userID);
		user.setEmail(eMail);
		
		return user;
		//return userID + " and " + eMail;
	}
	
	@GET
	@Path("/getUserID/{username}/{email}")
	//@Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserID1(@PathParam("username") String userID, @PathParam("email") String eMail){
		
		System.out.println("Inside getUserID-1 Method");
		User user = new User();
		user.setUserid(userID);
		user.setEmail(eMail);
		
		return user;
		//return userID + " and " + eMail;
	}
	
	@POST
	@Path("processInput")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	public String processInput(String input){
		
		System.out.println("Inside processInput Method");

		return "Processed "+ input;
	}
	
	@POST
	@Path("/fileUpload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void fileUpload(@FormDataParam("file") InputStream is, @FormDataParam("file") FormDataContentDisposition attachmentInfo)
	{
		System.out.println("Inside fileUpload Method");
		String uploadtoFile = "D:\\Temp\\" + attachmentInfo.getFileName();
		
		
		try{
			FileOutputStream outputstream = new FileOutputStream(new File(uploadtoFile));
			byte[] bytes = new byte[1024];
			int bytesRead = 0;
			
			while((bytesRead = is.read(bytes)) != -1){
				outputstream.write(bytes, 0, bytesRead);
			}
			
			outputstream.flush();
			outputstream.close();
		} 

		catch(Exception e){
		System.out.println("Exception Caught :" + e);
		}
	}
	
	@PUT
	@Path("/special")
	public SpecialUser getSpecialUser()
	{
		return new SpecialUser();
	}
}
