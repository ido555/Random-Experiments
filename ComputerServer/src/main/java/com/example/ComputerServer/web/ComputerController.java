package com.example.ComputerServer.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ComputerServer.beans.Computer;
import com.example.ComputerServer.services.ComputerService;
import com.example.ComputerServer.services.InvalidComputerException;

@RestController
@RequestMapping("comp")
@CrossOrigin(origins = "http://localhost:4200")
public class ComputerController {

	private ComputerService service;

	public ComputerController(ComputerService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<Computer> getAll() {
		return service.getAllComputers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) {
		try {
			return ResponseEntity.ok(service.getOneComputer(id));
		} catch (InvalidComputerException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found...");
		}
	}
	
	@GetMapping("/model/{model}")
	public List<Computer> getByModel(@PathVariable String model){
		return service.getByModel(model);
	}
	
	@PostMapping
	public ResponseEntity<?> addComputer(@RequestBody Computer comp) {
		try {
			service.addComputer(comp);
			return ResponseEntity.ok(comp);
		} catch (InvalidComputerException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteComputer(@PathVariable long id){
		try {
			service.deleteComputer(id);
			return ResponseEntity.ok("Deleted!");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found...");
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateComputer(@RequestBody Computer comp) throws InvalidComputerException {
//		try {
			service.updateComputer(comp);
			return ResponseEntity.ok(comp);
//		} catch (InvalidComputerException e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
	}
	
	// think carefully before deciding to implement this.
	// no need for try catch because if any function throws InvalidComputerException will catch it
	// this is only good for when many controllers throw the exception in the same controller
	@ExceptionHandler(InvalidComputerException.class)
	public ResponseEntity<String> handleInvalidComputer(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
	}
	
}









