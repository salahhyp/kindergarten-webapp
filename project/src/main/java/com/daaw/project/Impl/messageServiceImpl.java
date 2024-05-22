package com.daaw.project.Impl;

import com.daaw.project.model.admin;
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
import java.util.stream.Collectors;
import com.daaw.project.dto.MessageDto;
import com.daaw.project.model.message;
import com.daaw.project.model.parent;
import com.daaw.project.model.admin;
import com.daaw.project.repositories.parentRepository;
import com.daaw.project.repositories.adminRepository;
import java.util.logging.Logger;


@Service
@Transactional
public class messageServiceImpl implements messageService {
    private static final Logger LOGGER = Logger.getLogger(messageServiceImpl.class.getName());

    private final messageRepository messageRepository;
    private final parentRepository parentRepository;
    private final adminRepository adminRepository;

    @Autowired
    public messageServiceImpl(messageRepository messageRepository, parentRepository parentRepository, adminRepository adminRepository) {
        this.messageRepository = messageRepository;
        this.parentRepository = parentRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public MessageDto saveMessage(MessageDto messageDTO) {
        Optional<parent> parentOpt = parentRepository.findById(messageDTO.getParentId());
        Optional<admin> adminOpt = adminRepository.findById(messageDTO.getAdminId());

        if (parentOpt.isPresent() && adminOpt.isPresent()) {
            message message = new message();
            message.setParent(parentOpt.get());
            message.setAdmin(adminOpt.get());
            message.setContent(messageDTO.getContent());

            String senderValue = messageDTO.getSender().toUpperCase();
            LOGGER.info("Sender value: " + senderValue);
            try {
                message.setSender(com.daaw.project.model.message.Sender.valueOf(senderValue));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid sender value: " + senderValue);
            }

            message savedMessage = messageRepository.save(message);

            return convertToDTO(savedMessage);
        } else {
            throw new IllegalArgumentException("Parent or Admin not found");
        }
    }

    @Override
    public List<message> getMessagesByParentId(Long parentId) {
        return messageRepository.findByParentId(parentId);
    }

    @Override
    public List<MessageDto> getMessagesByAdminId(Long adminId) {
        return messageRepository.findByAdminId(adminId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MessageDto convertToDTO(message message) {
        MessageDto dto = new MessageDto();
        dto.setId(message.getId());
        dto.setParentId(message.getParent().getId());
        dto.setAdminId(message.getAdmin().getId());
        dto.setContent(message.getContent());
        dto.setTimestamp(message.getTimestamp());
        dto.setSender(message.getSender().name());
        return dto;
    }

    @Override
    public List<MessageDto> getMessagesByAdminIdAndParentId(Long adminId, Long parentId) {
        return messageRepository.findAllByAdminIdAndParentId(adminId, parentId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
