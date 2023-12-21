package com.newsify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newsify.service.MasterService;
import com.newsify.vo.CategoryVO;
import com.newsify.vo.CityVO;
import com.newsify.vo.PostVO;
import com.newsify.vo.ResponseVO;

@RestController
@RequestMapping("/category")
public class MasterController {

	@Autowired
	private MasterService masterService;

	@PostMapping("/save")
	public ResponseVO saveCategory(@RequestBody List<CategoryVO> categoryVO) {
		return masterService.saveCategory(categoryVO);
	}

	@GetMapping("/getAll")
	public List<CategoryVO> getAllCategories() {
	    return masterService.getAllCategories();
	}


	@PostMapping("/saveCities")
	public ResponseVO saveCities(@RequestBody List<CityVO> cities) {
		return masterService.saveCities(cities);
	}

	@GetMapping("/getAllCities")
	public List<CityVO> getAllCities() {
		return masterService.getAllCities();
	}

	@GetMapping("/getPosts")
	public Page<PostVO> getPostsByCategory(
	        @RequestParam List<Integer> category,
	        @RequestParam List<Integer> cityId,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {

	    Pageable pageable = PageRequest.of(page, size);
	    return masterService.getPostsByCategory(category, cityId, pageable);
	}


}
