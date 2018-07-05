package com.java.controller;

import com.java.entity.Book;
import com.java.service.ReadingListRepository;
import com.java.utils.AmazonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Future
 */
@Controller
@RequestMapping("/")
//属性注入
@ConfigurationProperties(prefix="amazon")
public class ReadingListController {

    private String associateId;

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    private AmazonProperties amazonProperties;
    private ReadingListRepository readingListRepository ;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,AmazonProperties amazonProperties){
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList !=null){
            model.addAttribute("books",readingList);
            model.addAttribute("reader",reader);
            model.addAttribute("amazonID",associateId);
            model.addAttribute("amazonID",amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader,Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }

}
