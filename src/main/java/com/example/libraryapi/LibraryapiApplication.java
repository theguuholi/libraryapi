package com.example.libraryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryapiApplication.class, args);
		// AutorRepository repository = context.getBean(AutorRepository.class);
		// exemploSalvarRegistro(repository);
	}

	// public static void exemploSalvarRegistro(AutorRepository autorRepository) {
	// 	Autor autor = new Autor();
	// 	autor.setNome("Rodrigo Turini");
	// 	autor.setDataNascimento(LocalDate.of(1982, 1, 25));
	// 	autor.setNacionalidade("Brasileiro");

	// 	var autorSalvo = autorRepository.save(autor);
	// 	System.out.println(autorSalvo);
	// }

}
