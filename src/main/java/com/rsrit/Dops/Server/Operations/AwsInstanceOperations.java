package com.rsrit.Dops.Server.Operations;

/**
 * @author gn.teja created on 03/15/2017
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.rsrit.Dops.Server.Service.AwsService.AwsInstanceService;


public class AwsInstanceOperations {

	@Autowired
	AwsInstanceService instCred;
	
	
    public static void main( String[] args ) throws Exception
    {
    		AwsInstanceOperations m = new AwsInstanceOperations();
    		
    		m.createEC2Instances();
        
   }
    
    public Object createEC2Instances() {
    	
    	try {
        	
        	final AmazonEC2 ec2 = AmazonEC2ClientBuilder
        			.standard()
        			.withCredentials(new AWSStaticCredentialsProvider(AwsInstanceService.credentials))
        			.withRegion("us-east-1")
        			.build();
        
        	RunInstancesRequest runInstancesRequest = new RunInstancesRequest();

        	runInstancesRequest.withImageId(AwsInstanceService.imageID)
        			           .withInstanceType(AwsInstanceService.instanceType)
        			           .withMinCount(AwsInstanceService.numOfInstances)
        			           .withMaxCount(AwsInstanceService.numOfInstances);
        						
        	RunInstancesResult result = ec2.runInstances(runInstancesRequest);
        	System.out.println("---------Created Instance Successfully --------------");
        	System.out.println(result);
        	return null;
		} catch (Exception e) {
			System.out.println("Oops.... failed in createEC2Instances method ");
			e.printStackTrace();
			
			System.exit(0);
			return null;
		}
    }
    
    public void createNewSecurityGroup() {
    	
    }
    
    public void listExistingSecurityGroups() {
    	
    }
    
    public void listExistingKeyPairs() {
    	
    }
    
    public void createNewKeyPair() {
    	
    } 

   }
