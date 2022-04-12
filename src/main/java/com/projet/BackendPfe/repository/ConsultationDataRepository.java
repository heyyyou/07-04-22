package com.projet.BackendPfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.BackendPfe.model.DataConsult;
import com.projet.BackendPfe.model.Images;

@Repository
public interface ConsultationDataRepository extends JpaRepository<DataConsult,Long> {}