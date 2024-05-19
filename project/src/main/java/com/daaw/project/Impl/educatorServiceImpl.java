package com.daaw.project.Impl;



import com.daaw.project.model.educator;
import com.daaw.project.model.user;
import com.daaw.project.repositories.educatorRepository;
import com.daaw.project.services.educatorService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class educatorServiceImpl implements educatorService {

    @Autowired
    private educatorRepository educatorRepository;

    @Override
    public educator findById(Long id) {
        Optional<educator> educator = educatorRepository.findById(id);
        return educator.orElse(null);
    }

    @Override
    public List<educator> findAll() {
        return educatorRepository.findAll();
    }

    @Override
    public educator save(educator educator) {
        return educatorRepository.save(educator);
    }

    @Override
    public void deleteById(Long id) {
        educatorRepository.deleteById(id);
    }

    @Override
    public educator addeducator(educator educator) {
        return educatorRepository.save(educator);
    }

    @Override
    public List<educator> getAlleducators() {
        return educatorRepository.findAll();
    }

    @Override
    public Optional<educator> geteducatorById(Long id) {
        return educatorRepository.findById(id);

    }

    @Override
    public educator findByUser(user user) {

        return educatorRepository.findByUser(user);
    }

}

