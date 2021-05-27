package com.brunomilitzer.document.controllers;

import com.brunomilitzer.document.entities.Document;
import com.brunomilitzer.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    private DocumentRepository repository;

    @RequestMapping("/displayUpload")
    public String displayUpload(final ModelMap modelMap) {

        final List<Document> documents = this.repository.findAll();

        modelMap.addAttribute("documents", documents);

        return "documentUpload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadDocument(@RequestParam("document") final MultipartFile multipartFile, @RequestParam("id") final Long id, final ModelMap modelMap) {

        final Document document = new Document();

        try {
            document.setId(id);
            document.setName(multipartFile.getOriginalFilename());
            document.setData(multipartFile.getBytes());

        } catch (final IOException e) {
            e.printStackTrace();
        }

        this.repository.save(document);

        final List<Document> documents = this.repository.findAll();

        modelMap.addAttribute("documents", documents);

        return "documentUpload";
    }

    @RequestMapping("/download")
    public StreamingResponseBody download(@RequestParam("id") final Long id, final HttpServletResponse response) {

        final Document document = this.repository.findById(id).get();
        final byte[] data = document.getData();

        response.setHeader("Content-Disposition", "attachment;filename=" + document.getName());

        return outputStream -> outputStream.write(data);
    }

}
