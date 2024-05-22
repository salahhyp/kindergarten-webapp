package com.daaw.project.services;
import com.daaw.project.model.message;
import com.daaw.project.dto.MessageDto;

import java.util.List;
import java.util.Optional;
public interface messageService {

    MessageDto saveMessage(MessageDto messageDTO);
    List<message> getMessagesByParentId(Long parentId);
    List<MessageDto> getMessagesByAdminId(Long adminId);
    List<MessageDto> getMessagesByAdminIdAndParentId(Long adminId, Long parentId);

}
