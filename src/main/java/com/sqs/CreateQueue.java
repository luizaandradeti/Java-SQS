package com.sqs;



import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;


public class CreateQueue {


	static String ACCESS_KEY = "lala";
	static String SECRET_KEY = "change+ga8q";

	public static void main(String args[]) {

		AWSCredentials awsCredentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);

		AmazonSQS sqsClient = AmazonSQSClient.builder().withRegion(Regions.US_EAST_1)
					.withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
		final CreateQueueRequest createQueueRequest = new CreateQueueRequest("fila2");
		final CreateQueueResult queueResult = sqsClient.createQueue(createQueueRequest);

		// Print the Queue URL.
		System.out.println("QUeueURL:" + queueResult.getQueueUrl());

		// Print the request ID for the CreateTopicRequest action.
		System.out.println("CreateQueueRequest: " + sqsClient.getCachedResponseMetadata(createQueueRequest));




	}

}