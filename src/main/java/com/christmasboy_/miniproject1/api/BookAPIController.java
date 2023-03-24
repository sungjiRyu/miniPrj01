package com.christmasboy_.miniproject1.api;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.christmasboy_.miniproject1.dto.BookDTO;
import com.christmasboy_.miniproject1.entity.Category;
import com.christmasboy_.miniproject1.entity.Writer;
import com.christmasboy_.miniproject1.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookAPIController {

    @Value("${file.image.basic}") String BASIC_IMAGE_PATH;
    @Value("${file.image.detail}") String DETAIL_IMAGE_PATH;

    private final BookService bService;
    

    @GetMapping("/categories")
    public ResponseEntity<Map<String, Object>> getAllCategoryInfo() {
        List<Category> allCategoryInfo = bService.getAllCategoryInfo();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("data", allCategoryInfo);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<PageAPIMessage> getAllBooks(Pageable pageable) {
        Page<BookDTO> allBooks = bService.getAllBooks(pageable);
        return new ResponseEntity<>(
            PageAPIMessage.builder()
            .data(allBooks.getContent())
            .pageNumber(allBooks.getNumber())
            .totalPages(allBooks.getTotalPages())
            .build(), 
            HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<PageAPIMessage> getCategoryBooks(@PathVariable Integer id, Pageable pageable) {
        Page<BookDTO> booksInCategory = bService.findBooksByCategory(id, pageable);
        return new ResponseEntity<>(
            PageAPIMessage.builder()
            .data(booksInCategory.getContent())
            .pageNumber(booksInCategory.getNumber())
            .totalPages(booksInCategory.getTotalPages())
            .build(), 
            HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> seachBooks(@RequestParam String title, Pageable pageable) {
        Page<BookDTO> findBooksByTitle = bService.findBooksByTitle(title, pageable);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("data", findBooksByTitle.getContent());
        map.put("pageNumber", findBooksByTitle.getNumber());
        map.put("totalPages", findBooksByTitle.getTotalPages());
        map.put("numberOfElements", findBooksByTitle.getNumberOfElements());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/writer/{id}")
    public ResponseEntity<Map<String, Object>> getWriterInfo(@PathVariable Integer id) {
        Writer writerInfo = bService.getWriterInfo(id);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("data", writerInfo);
        if(writerInfo == null) {
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/image/{type}/{id}")
    public ResponseEntity<Resource> getImageDownload(
        @PathVariable String type, @PathVariable Integer id,
        HttpServletRequest request
    ) {
        Path folderLocation = null;
        String fileName = null;

        if(type.equals("basic")) {
            folderLocation = Paths.get(BASIC_IMAGE_PATH);
            fileName = bService.getImageName(id);
        } else if(type.equals("detail")) {
            folderLocation = Paths.get(DETAIL_IMAGE_PATH);
            fileName = bService.getDetailImageName(id);
        }

        Path targetFile = folderLocation.resolve(fileName);

        Resource r = null;
        try {
            r = new UrlResource(targetFile.toUri());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(r.getFile().getAbsolutePath());

            if(contentType == null) {
                contentType = "application/octet-stream";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=\"" + r.getFilename() + "\"")
                .body(r);
    }
    
}
