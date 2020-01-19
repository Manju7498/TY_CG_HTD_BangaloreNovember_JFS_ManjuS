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

import com.cg.forestmanagementspringrest.dto.ContractBean;
import com.cg.forestmanagementspringrest.dto.ForestryResponse;
import com.cg.forestmanagementspringrest.service.ContractService;

@RestController
public class ContractController {
	@Autowired
	ContractService service;

	@PostMapping(path = "/add-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse addContract(@RequestBody ContractBean contract) {
		ForestryResponse response = new ForestryResponse();
		if (service.addContract(contract)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("contract added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("contract with same no already exists");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-contract/{contractNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse deleteContract(@PathVariable("contractNo") int contractNo) {
		ForestryResponse response = new ForestryResponse();
		if (service.deleteContract(contractNo)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("contract deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("contract not found");
		}
		return response;
	}

	@GetMapping(path = "/view-contract/{contractNo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse viewContract(@PathVariable("contractNo") int contractNo) {
		ForestryResponse response = new ForestryResponse();
		ContractBean contract = service.getContract(contractNo);
		if (contract != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Contract found");
			response.setContract(Arrays.asList(contract));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Contract No does not exist");
		}
		return response;
	}

	@GetMapping(path = "/view-allContracts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse viewAllContracts() {
		ForestryResponse response = new ForestryResponse();
		List<ContractBean> list = service.getAllContracts();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Contracts found");
			response.setContract(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}

	@PutMapping(path = "/update-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ForestryResponse updateContract(@RequestBody ContractBean bean) {
		ForestryResponse response = new ForestryResponse();
		if (service.updateContract(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Contract updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Contract  is not updated");
		}
		return response;
	}

}
