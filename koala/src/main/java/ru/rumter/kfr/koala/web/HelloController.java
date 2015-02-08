package ru.rumter.kfr.koala.web;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("name", "world");
		return "index";
	}

	@RequestMapping(value = "/json", produces="application/json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> json() {
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("success", true);
		m.put("data", "Hello!");
		return m;
	}

}