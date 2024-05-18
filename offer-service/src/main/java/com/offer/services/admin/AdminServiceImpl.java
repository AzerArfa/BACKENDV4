package com.offer.services.admin;

import com.offer.entity.AppelOffre;
import com.offer.entity.Offre;
import com.offer.repository.AppelOffreRepository;
import com.offer.repository.OffreRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	 @Autowired
    private final AppelOffreRepository appelOffreRepository;
	 @Autowired
    private OffreRepository offreRepository;
    @Override
    public AppelOffre createAppelOffre(AppelOffre appelOffre) {
        try {
            AppelOffre newAppelOffer = new AppelOffre();
            newAppelOffer.setTitre(appelOffre.getTitre());
            newAppelOffer.setDescription(appelOffre.getDescription());
            newAppelOffer.setDatelimitesoumission(appelOffre.getDatelimitesoumission());
            newAppelOffer.setEntrepriseId(appelOffre.getEntrepriseId());
            newAppelOffer.setImg(appelOffre.getImg());
            newAppelOffer.setLocalisation(appelOffre.getLocalisation());
            newAppelOffer.setDocument(appelOffre.getDocument());
            return appelOffreRepository.save(appelOffre);
        } catch (Exception e) {
            return null;
        }

    }
    @Override
    public List<Offre> getOffresByUserId(String userid) {
        return offreRepository.findByUserid(userid);
    }
    @Override
    public List<AppelOffre> getAllAppelOffres() {
        return appelOffreRepository.findAll();
    }

    @Override
    public Optional<AppelOffre> getAppelOffreById(UUID id) {
        return appelOffreRepository.findById(id);
    }

    @Override
    public AppelOffre updateAppelOffre(AppelOffre appelOffre) {
        return appelOffreRepository.save(appelOffre);
    }

    @Override
    public void deleteAppelOffre(UUID id) {
        appelOffreRepository.deleteById(id);
    }
    @Override
    public List<AppelOffre> getAppelOffresByEntrepriseId(UUID entrepriseId) {
        return appelOffreRepository.findByEntrepriseId(entrepriseId);
    }
    
//    GESTION OFFRE
    
    @Override
    public Offre createOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    
    @Override
    public Offre updateOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public void deleteOffre(UUID id) {
        offreRepository.deleteById(id);
    }

    @Override
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    @Override
    public Optional<Offre> getOffreById(UUID id) {
        return offreRepository.findById(id);
    }

    @Override
    public List<Offre> listAllOffresByAppelOffreId(UUID appelOffreId) {
        return offreRepository.findByAppeloffre_Id(appelOffreId);
    }
}
