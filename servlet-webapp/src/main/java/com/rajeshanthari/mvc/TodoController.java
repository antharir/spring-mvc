package com.rajeshanthari.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajeshanthari.ToDoService;
import com.rajeshanthari.model.Todo;

@Controller
public class TodoController {

	private static final String RAJESHANTHARI = "rajeshanthari";
	@Autowired
	ToDoService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@RequestMapping("/todo")
	public String showTodoPage(ModelMap map) {

		map.put("todoList", service.retrieveTodos(RAJESHANTHARI));
		return "list-todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String addTodoPage(ModelMap model) {
		Todo value = new Todo();
		value.setDesc("Default Val");
		model.put("todo", value);
		throw new RuntimeException("Dummy");
		//return "add-todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String insertTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			// model.put("error", result.get)
			return "add-todo";
		}

		service.addTodo(RAJESHANTHARI, todo.getDesc(), new Date(), false);
		model.clear();
		return "redirect:todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodoPage(@RequestParam int id, ModelMap model) {
		service.deleteTodo(id);
		model.clear();
		return "redirect:todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.addAttribute("todo", todo);
		return "add-todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			// model.put("error", result.get)
			return "add-todo";
		}
		service.updateTodo(todo);
		System.out.println(todo);
		model.clear();
		return "redirect:todo";
	}

}
