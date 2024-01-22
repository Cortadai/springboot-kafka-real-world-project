package com.cortadai.repository;

import com.cortadai.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
