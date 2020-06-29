package br.com.zup.crud_cliente.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@PostMapping
	public ResponseEntity<?> criaUser(@Valid @RequestBody User user) {
		try {
			userService.createUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@GetMapping
	public ResponseEntity<?> showUser(HttpSession session) {
		if (userService.quantityUser() > 0) {
			ObjectUser objectUser = new ObjectUser();

			objectUser.setUser(userService.takeUserById(id));
			objectUser.getUser().iterator().next().getAlternatives().size();

			return ResponseEntity.ok(objectUser);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		try {
			userService.deleteUser(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
