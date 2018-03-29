package com.rsrit.Dops.Server.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.Dops.Server.Model.UserModel.Cloud_Environment;
import com.rsrit.Dops.Server.Repository.CloudRepository;
import com.rsrit.Dops.Server.Service.CloudEnv.ICloudService;

@RestController
@RequestMapping("api/user")
public class CloudProviderController {
	
	
	
	@Autowired
	ICloudService cloudService;
	@Autowired
	CloudRepository cloudrepository;
	
	
	@RequestMapping(value = "/cloudenv")
	public Cloud_Environment SaveCloud(@RequestBody Cloud_Environment cloudenv) {
		System.out.println("from the CLoud Environment");
		try {
			System.out.println("in CLoud Environment method");
			return cloudService.SaveNewCloud(cloudenv);
		} catch (Exception e) {
			System.out.println("Error in storing Cloud provider details");
			System.out.println(e);
			return null;
		}
	}
	
//	@GetMapping("/getcloud")
//	public Cloud_Environment getAllClouds(@RequestBody Cloud_Environment cloudenv){
//		return cloudrepository.findByUserId(cloudenv.getUserId());
//	}
	@GetMapping("/getcloud")
	public List<Cloud_Environment> getAllClouds(){
		return cloudrepository.findAll();
//		System.out.println("size is: ");
//		List<Cloud_Environment> cloudProviderList =  cloudrepository.findAll();
//		System.out.println("size is: "+cloudProviderList.size());
//		return cloudrepository.findAll();
//		//cloudrepository.findAll();
		
	}
	
	@GetMapping("/getcloudone/{id}")
	public Cloud_Environment getCloudById(@PathVariable(value="id") Long cloudId){
		return cloudrepository.findByCloudId(cloudId);
//		System.out.println("size is: ");
//		List<Cloud_Environment> cloudProviderList =  cloudrepository.findAll();
//		System.out.println("size is: "+cloudProviderList.size());
//		return cloudrepository.findAll();
//		//cloudrepository.findAll();
		
	}

}
