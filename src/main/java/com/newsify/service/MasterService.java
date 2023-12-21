package com.newsify.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.newsify.entity.Category;
import com.newsify.entity.City;
import com.newsify.entity.NewsPost;
import com.newsify.repository.CategoryRepository;
import com.newsify.repository.CityRepository;
import com.newsify.repository.NewsRepository;
import com.newsify.vo.CategoryVO;
import com.newsify.vo.CityVO;
import com.newsify.vo.PostVO;
import com.newsify.vo.ResponseVO;

@Service
public class MasterService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private CityRepository cityRepo;

	@Autowired
	private NewsRepository newsRepo;

	public ResponseVO saveCategory(List<CategoryVO> categoryVO) {
		List<Category> categorys = new ArrayList<>();
		categoryVO.forEach(category -> {
			Category categoryEntity = new Category();
			categoryEntity.setCategory(category.getCategory());
			categorys.add(categoryEntity);

		});
		categoryRepo.saveAll(categorys);
		return new ResponseVO(true, "Saved Successfully");
	}

	public List<CategoryVO> getAllCategories() {
		List<Category> categories = categoryRepo.findAll();

		List<CategoryVO> categoriesVO = new ArrayList<>();
		categories.forEach(category -> {
			CategoryVO vo = new CategoryVO();
			BeanUtils.copyProperties(category, vo);
			categoriesVO.add(vo);
		});

		return categoriesVO;
	}

	public ResponseVO saveCities(List<CityVO> cities) {
		List<City> cityList = new ArrayList<>();
		cities.forEach(cityVO -> {
			City city = new City();
			BeanUtils.copyProperties(cityVO, city);
			cityList.add(city);

		});
		cityRepo.saveAll(cityList);
		return new ResponseVO(true, "Saved Successsfully");
	}

	public List<CityVO> getAllCities() {
		List<City> cities = cityRepo.findAll();
		List<CityVO> citiesVO = new ArrayList<>();
		cities.forEach(city -> {
			CityVO cityVO = new CityVO();
			BeanUtils.copyProperties(city, cityVO);
			citiesVO.add(cityVO);
		});
		return citiesVO;
	}

	public Page<PostVO> getPostsByCategory(List<Integer> category, List<Integer> cityId, Pageable pageable) {
		Page<NewsPost> postsPage = newsRepo.findByCategoryAndCityId(category, cityId, pageable);

		List<PostVO> postsVO = new ArrayList<>();
		postsPage.getContent().forEach(post -> {
			PostVO postVO = new PostVO();
			BeanUtils.copyProperties(post, postVO);
			postsVO.add(postVO);
		});

		return new PageImpl<>(postsVO, pageable, postsPage.getTotalElements());
	}

}
