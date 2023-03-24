package com.christmasboy_.miniproject1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.christmasboy_.miniproject1.dto.BookDTO;
import com.christmasboy_.miniproject1.entity.Category;
import com.christmasboy_.miniproject1.entity.Writer;
import com.christmasboy_.miniproject1.repository.BookRepository;
import com.christmasboy_.miniproject1.repository.CategoryRepository;
import com.christmasboy_.miniproject1.repository.DetailImageRepository;
import com.christmasboy_.miniproject1.repository.ImageRepository;
import com.christmasboy_.miniproject1.repository.WriterRepository;
import com.christmasboy_.miniproject1.view.BookEntityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bRepo;
    private final WriterRepository wRepo;
    private final ImageRepository imgRepo;
    private final DetailImageRepository DIRepo;
    private final CategoryRepository cRepo;
    private final BookEntityRepository bEntityRepository;


    public List<Category> getAllCategoryInfo() {
        return cRepo.findAll();
    }

    public Writer getWriterInfo(Integer seq) {
        Optional<Writer> writer = wRepo.findById(seq);
        if(!writer.isPresent()) {
            return null;
        }
        return writer.get();
    }

    // public Page<BookDTO> getAllBooks(Pageable pageable) {
    //     return bRepo.findAll(pageable).map(BookDTO::fromEntity);
    // }

    // public Page<BookDTO> findBooksByCategory(Integer cateSeq, Pageable pageable) {
    //     return bRepo.findPageAllByCateSeq(cateSeq, pageable).map(BookDTO::fromEntity);
    // }

    // public Page<BookDTO> findBooksByTitle(String keyword, Pageable pageable) {
    //     return bRepo.searchBookByTitle(keyword, pageable).map(BookDTO::fromEntity);
    // }

    public Page<BookDTO> getAllBooks(Pageable pageable) {
        return bEntityRepository.findAll(pageable).map(BookDTO::fromEntity);
    }

    public Page<BookDTO> findBooksByCategory(Integer cateSeq, Pageable pageable) {
        return bEntityRepository.findPageAllByCateseq(cateSeq, pageable).map(BookDTO::fromEntity);
    }

    public Page<BookDTO> findBooksByTitle(String keyword, Pageable pageable) {
        return bEntityRepository.searchBookByTitle(keyword, pageable).map(BookDTO::fromEntity);
    }

    

    public String getImageName(Integer seq) {
        return imgRepo.findById(seq).get().getFileName();
    }

    public String getDetailImageName(Integer seq) {
        return DIRepo.findById(seq).get().getFileName();
    }
}
