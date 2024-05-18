package com.offer.repository;

import com.offer.entity.AppelOffre;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelOffreRepository extends JpaRepository<AppelOffre, UUID> {
	List<AppelOffre> findByEntrepriseId(UUID entrepriseId);
}
