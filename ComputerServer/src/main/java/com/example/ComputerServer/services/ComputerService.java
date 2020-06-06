package com.example.ComputerServer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ComputerServer.beans.Computer;
import com.example.ComputerServer.db.ComputerRepository;

@Service
public class ComputerService {

	private ComputerRepository repository;

	public ComputerService(ComputerRepository repository) {
		super();
		this.repository = repository;
	}
	
	public void addComputer(Computer computer) throws InvalidComputerException {
		if(computer.getRam() <= 0 || computer.getPrice() <= 0)
			throw new InvalidComputerException();
		repository.save(computer);
	}
	
	public void updateComputer(Computer computer) throws InvalidComputerException {
		if(repository.existsById(computer.getId())) {
			if(computer.getRam() <= 0 || computer.getPrice() <= 0)
				throw new InvalidComputerException();
			repository.save(computer);
		} else {
			throw new InvalidComputerException();
		}
	}
	
	public void deleteComputer(long id) {
		repository.deleteById(id);
	}
	
	public List<Computer> getAllComputers(){
		return repository.findAll();
	}
	
	public Computer getOneComputer(long id) throws InvalidComputerException {
		return repository.findById(id).orElseThrow(InvalidComputerException::new);
	}
	
	public List<Computer> getByModel(String model) {
		return repository.findByModel(model);
	}
	
}
