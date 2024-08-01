package com.bookStore.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.bookStore.Entity.MyBooklist;
import com.bookStore.bookStore.repo.MybookRepository;

@Service
public class MyBookListService {
	@Autowired
	private MybookRepository mybook;

	public void saveMyBooks(MyBooklist book) {
		mybook.save(book);

	}
	public List<MyBooklist> getAllMyBooks(){
		return mybook.findAll();
	}
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
