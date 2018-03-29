package com.rsrit.Dops.Server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsrit.Dops.Server.Model.UserModel.Cloud_Environment;

public interface CloudRepository extends JpaRepository <Cloud_Environment, Long> {

	
	Cloud_Environment findByUserId(Long userId);
//	List<Cloud_Environment> findByUserId(Long userId);
	Cloud_Environment findByCloudId(Long cloudId);
	
	
//	Cloud_Environment findOne(Long cloudId);
	
	//List<Cloud_Environment> findAll();
}
