package com.daaw.project.Impl;

import com.daaw.project.model.parent;
import com.daaw.project.model.payment;
import com.daaw.project.services.messageService;
import com.daaw.project.model.message;
import com.daaw.project.repositories.messageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class messageServiceImpl implements messageService {

    @Autowired
    messageRepository messageRepository;

    @Override
    public message addmessage(message message) {
        return messageRepository.save(message);
    }

    @Override
    public message getmessage(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public void deletemessage(Long id) {
         messageRepository.deleteById(id);
    }

    @Override
    public void save(message message) {
         messageRepository.save(message);
    }
}
