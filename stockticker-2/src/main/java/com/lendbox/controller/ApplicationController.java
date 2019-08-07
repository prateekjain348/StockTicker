package com.lendbox.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lendbox.auth.AuthUser;
import com.lendbox.dto.StockDto;
import com.lendbox.model.files.FileUpload;
import com.lendbox.utilities.AuthUserUtilities;
import com.lendox.StockTicketListImpl;
import com.polaris.dao.StockDao;
import com.polaris.dao.StockDaoImpl;

@Controller
public class ApplicationController {
	public static final String uploadingDir = "E:\\Backup\\Prateek\\";

	@GetMapping("/login")
	public String getToHomePage(Model model) {
		AuthUser loginCredentialsObject = new AuthUser();
		model.addAttribute("loginCredentialsObject", loginCredentialsObject);
		return "login";

	}

	// @Autowired
	StockDao stockDaocall = new StockDaoImpl();
	StockTicketListImpl stockTicketListImpl = new StockTicketListImpl();

	@PostMapping("/home")
	public String getToHomePage(Model model,
			@ModelAttribute(value = "loginCredentialsObject") AuthUser loginCredentialsObject) {
		if (new AuthUserUtilities().checkIfUserCredentialsValid(loginCredentialsObject)) {
			// Model model = new Model("landingPage");
			FileUpload formUpload = new FileUpload();
			model.addAttribute("formUpload", formUpload);
			return "landingpage";

		} else {
			return "index";
		}
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes,
			Model model) throws IllegalStateException, IOException {
		List<String> paths = new ArrayList<String>();
		List<StockDto> stockDto;
		for (MultipartFile uploadedFile : files) {
			// System.out.println(uploadedFile.getOriginalFilename());
			if (uploadedFile.isEmpty()) {
				redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
				return "redirect:login";
			}
			File file = new File(uploadingDir + uploadedFile.getOriginalFilename());
			uploadedFile.transferTo(file);
			// System.out.println("File Full Path is :- "+file.getAbsolutePath());
			paths.add(file.getAbsolutePath());
		}
		for (String path : paths) {
			System.out.println("Path is " + path);
		}
		stockDto = stockDaocall.process(paths);
		model.addAttribute("stockDto", stockDto);
		System.out.println("After Callign ");
		// return "redirect:/login";
		return "success";
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public String stockRefresh(Model model) throws IllegalStateException, IOException {
		System.out.println("Insid stockRefresh function ");
		List<StockDto> stockDto=stockDaocall.fetchStockTicker();
		System.out.println("After Fetching Updated Stocks");
		model.addAttribute("stockDto", "");
		model.addAttribute("stockDto", stockDto);
		System.out.println("After Updating model");

		return "success";
	}

}
