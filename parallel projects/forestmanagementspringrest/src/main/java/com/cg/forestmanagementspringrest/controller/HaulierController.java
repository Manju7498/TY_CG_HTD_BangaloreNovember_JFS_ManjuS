package com.cg.forestmanagementspringrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.forestmanagementspringrest.dto.ForestryResponse;
import com.cg.forestmanagementspringrest.dto.HaulierBean;
import com.cg.forestmanagementspringrest.service.HaulierService;

@RestController
public class HaulierController {
	@Autowired
	HaulierService service;

	@PostMapping(path = "/add-haulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse addHaulier(@RequestBody HaulierBean haulier) {
		ForestryResponse response = new ForestryResponse();
		if (service.addHaulier(haulier)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Haulier added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Hailier with same id already exists");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-haulier/{haulierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse deleteHaulier(@PathVariable("haulierId") int haulierId) {
		ForestryResponse response = new ForestryResponse();
		if (service.deleteHaulier(haulierId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Haulier deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Haulier not found");
		}
		return response;
	}

	@GetMapping(path = "/view-haulier/{haulierId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse viewHaulier(@PathVariable("haulierId") int haulierId) {
		ForestryResponse response = new ForestryResponse();
		HaulierBean haulier = service.getHaulier(haulierId);
		if (haulier != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Haulier found");
			response.setHaulier(Arrays.asList(haulier));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Haulier Id does not exist");
		}
		return response;
	}

	@GetMapping(path = "/view-allHauliers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse viewAllHauliers() {
		ForestryResponse response = new ForestryResponse();
		List<HaulierBean> list = service.getAllHauliers();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Hauliers found");
			response.setHaulier(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}

	@PutMapping(path = "/update-haulier", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse updateHaulier(@RequestBody HaulierBean bean) {
		ForestryResponse response = new ForestryResponse();
		if (service.updateHaulier(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Haulier updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Haulier is not updated");
		}
		return response;
	}
}
