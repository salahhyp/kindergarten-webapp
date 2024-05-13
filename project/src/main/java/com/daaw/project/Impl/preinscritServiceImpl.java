package com.daaw.project.Impl;


import com.daaw.project.model.preinscrit;
import com.daaw.project.repositories.preinscritRepository;
import com.daaw.project.services.preinscritService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class preinscritServiceImpl implements preinscritService {

    @Autowired
    private preinscritRepository preinscritRepository;

    @Override
    public preinscrit findById(Long id) {
        Optional<preinscrit> preinscrit = preinscritRepository.findById(id);
        return preinscrit.orElse(null);
    }

    @Override
    public preinscrit addPreinscrit(preinscrit mcommpte) {
        return null;
    }

    @Override
    public List<preinscrit> findAll() {
        return preinscritRepository.findAll();
    }

    @Override
    public preinscrit save(preinscrit preinscrit) {
        return preinscritRepository.save(preinscrit);
    }

    @Override
    public void deleteById(Long id) {
        preinscritRepository.deleteById(id);
    }

}
