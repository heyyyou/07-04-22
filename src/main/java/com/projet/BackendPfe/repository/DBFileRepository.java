package com.projet.BackendPfe.repository;

import com.projet.BackendPfe.model.Images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<Images, String> {

}
