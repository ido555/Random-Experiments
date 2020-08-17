package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ajax")
@CrossOrigin(origins = "https://localhost:8080") // dont block ajax requests from this protocol/url/port
public class AJAX_Controller {
//  dont use ResponseEntity for now
//	Get – public List<String> getAllTexts()
//	Get – public String getText(int index)
//	Post – public void addText(String text)
	ArrayList<String> texts = new ArrayList<String>();

	@GetMapping("getAll")
	public List<String> getAllTexts() {
		return texts;
	}

	@GetMapping("getOne")
	public String getOneText(int i) {
		return texts.get(i);
	}

	@PostMapping("addOne")
	public void addText(@RequestBody String text) {
		texts.add(text);
	}
}
