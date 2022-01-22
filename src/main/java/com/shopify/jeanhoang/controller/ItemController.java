package com.shopify.jeanhoang.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopify.jeanhoang.beans.Item;
import com.shopify.jeanhoang.services.CsvExportService;

@Controller
public class ItemController {

	@Autowired
	private com.shopify.jeanhoang.database.DatabaseAccess da;

	private CsvExportService csvExportService;

	@GetMapping("/")
	public String index(Model model) {

		da.insertItem();

		model.addAttribute("item", new Item());

		return "index";
	}

	@PostMapping("/insertItem")
	public String insertItem(Model model, @ModelAttribute Item item) {

		da.insertItem(item);

		model.addAttribute("itemList", da.getList());

		model.addAttribute("item", new Item());

		return "index";
	}

	@GetMapping("/deleteItem/{id}")
	public String deleteItemById(Model model, @PathVariable Long id) {

		da.deleteItem(id);

		model.addAttribute("item", da.getList());

		model.addAttribute("item", new Item());

		return "index";
	}

	@GetMapping("/editItem/{id}")
	public String editItem(Model model, @PathVariable Long id) {

		Item item = da.getItemByID(id).get(0);

		model.addAttribute("item", item);

		da.deleteItem(id);

		model.addAttribute("itemList", da.getList());
		

		return "index";

	}

	public ItemController(CsvExportService csvExportService) {
		
		this.csvExportService = csvExportService;
		
	}

	@RequestMapping(path = "/items")
	public void getItemsToCSV(HttpServletResponse servletResponse) throws IOException {

		servletResponse.setContentType("text/csv");

		servletResponse.addHeader("Content-Disposition", "attachment; filename=\"items.csv\"");

		csvExportService.writeEmployeesToCsv(servletResponse.getWriter());
	}

}
