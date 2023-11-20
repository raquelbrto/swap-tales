package com.imd.web.swaptales.dto;

import com.imd.web.swaptales.enums.AvailabilityStatus;
import com.imd.web.swaptales.enums.ConditionBook;
import com.imd.web.swaptales.model.Book;
import com.imd.web.swaptales.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Integer publishingYear;
    private ConditionBook conditionBook;
    private Integer edition;
    private String description;
    private Long ownerUserId;
    private String publishingCompany;
    private AvailabilityStatus availabilityStatus;
    private Double price;
    private String urlImg;

    public Book getEntity(){
        Book book = new Book();
        book.setId(this.id);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setPublishingYear(this.publishingYear);
        book.setConditionBook(this.conditionBook);
        book.setEdition(this.edition);
        book.setDescription(this.description);
        User user = new User();
        user.setId(this.ownerUserId);
        book.setOwnerUser(user);
        book.setPublishingCompany(this.publishingCompany);
        book.setAvailabilityStatus(this.availabilityStatus);
        book.setPrice(this.price);
        book.setUrlImg(this.urlImg);

        return book;
    }
}
