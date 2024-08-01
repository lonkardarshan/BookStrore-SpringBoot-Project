package com.bookStore.bookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.bookStore.Entity.Book;
import com.bookStore.bookStore.Entity.MyBooklist;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookListService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private MyBookListService myBookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("bookregister") 
	public String bookregister() {
		return "BookRegister";
	}

	@GetMapping("Availablebook")
	public ModelAndView getAllbook() {
		List<Book> list = service.getAllBook();
		ModelAndView m = new ModelAndView();
		m.setViewName("booklist");
		m.addObject("book", list);

		return m;
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/Availablebook";

	}

	@GetMapping("myBooks")
	public String getMyBooks(Model model) {
		List<MyBooklist> list = myBookService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMylist(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBooklist mm = new MyBooklist(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookService.saveMyBooks(mm);
		return "redirect:/myBooks";
	}

	@RequestMapping("editbook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String delete(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/Availablebook";
	}
}
