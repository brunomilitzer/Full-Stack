package com.brunomilitzer.document.repository;

import com.brunomilitzer.document.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
