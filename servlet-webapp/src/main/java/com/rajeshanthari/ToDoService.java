package com.rajeshanthari;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rajeshanthari.model.Todo;

@Service
public class ToDoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "rajeshanthari", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "rajeshanthari", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "rajeshanthari", "Learn Hibernate", new Date(), false));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = todos.parallelStream().filter(todo -> todo.getUser().equals(user))
				.collect(Collectors.toList());

		return filteredTodos;
	}

	public Todo retrieveTodo(int id) {
		Todo filteredTodo = todos.parallelStream().filter(todo -> todo.getId() == id).findFirst().orElseThrow();
		return filteredTodo;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		Todo todo = new Todo(++todoCount, name, desc, targetDate, isDone);
		System.out.println(todo);
		todos.add(todo);
	}

	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}

	public void updateTodo(Todo todo) {
		Todo todo2 = retrieveTodo(todo.getId());
		todo2.setDesc(todo.getDesc());
		todo2.setTargetDate(todo.getTargetDate());
	}

}
