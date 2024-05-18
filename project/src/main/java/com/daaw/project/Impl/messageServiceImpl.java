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
    private messageRepository messageRepository;

    @Override
    public List<message> getMessagesByParentId(Long parentId) {
        return messageRepository.findByParentId(parentId);
    }

    @Override
    public List<message> getMessagesByAdminId(Long adminId) {
        return messageRepository.findByAdminId(adminId);
    }

    @Override
    public message saveMessage(message message) {
        return messageRepository.save(message);
    }
}
