package com.christmasboy_.miniproject1;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.christmasboy_.miniproject1.entity.Book;
import com.christmasboy_.miniproject1.entity.Writer;
import com.christmasboy_.miniproject1.repository.BookRepository;
import com.christmasboy_.miniproject1.repository.WriterRepository;

@SpringBootTest
@Transactional
class Miniproject1ApplicationTests {

	@Autowired private BookRepository bRepo;
	@Autowired private WriterRepository wRepo;

	@Test
	@Rollback(false)
	void contextLoads() {
		List<Book> books = bRepo.findAll();
		for(Book b : books) {
			if(b.getContentText() != null) 
				b.setContentText(b.getContentText().replaceAll("\r\n", "<br>"));
			if(b.getContentTitle() != null) 
				b.setContentTitle(b.getContentTitle().replaceAll("\r\n", "<br>"));
		}
	}

	@Test
	@Rollback(false)
	void changeWriterIntro() {
		List<Writer> writers = wRepo.findAll();
		for(Writer w : writers) {
			if(w.getIntro() != null) {
				w.setIntro(w.getIntro().replaceAll("\r\n", "<br>"));
			}
		}
	}


}
