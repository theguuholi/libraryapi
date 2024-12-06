package com.example.libraryapi;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.libraryapi.model.Autor;
import com.example.libraryapi.repository.AutorRepository;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(LibraryapiApplication.class, args);
		AutorRepository repository = context.getBean(AutorRepository.class);
		exemploSalvarRegistro(repository);
	}

	public static void exemploSalvarRegistro(AutorRepository autorRepository) {
		Autor autor = new Autor();
		autor.setNome("Rodrigo Turini");
		autor.setDataNascimento(LocalDate.of(1982, 1, 25));
		autor.setNacionalidade("Brasileiro");

		var autorSalvo = autorRepository.save(autor);
		System.out.println(autorSalvo);
	}

}
