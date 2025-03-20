package com.example.paymentservice.api;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getAsyncData")
public class AsyncAPi {

	private CustomService customService;

	@Autowired
	public AsyncAPi(CustomService customService) {

		this.customService = customService;
	}

	@GetMapping("/hello")
	public String getData() {

		CompletableFuture<String> comp = customService.getAsyncData();
		try {
			return comp.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Error";
	}
}

@Service
class CustomService {

	// i need to make the service method async

	@Async
	public CompletableFuture<String> getAsyncData() {

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return CompletableFuture.completedFuture("hello");
	}

}