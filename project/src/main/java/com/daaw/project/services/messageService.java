package com.daaw.project.services;
import com.daaw.project.model.message;

import java.util.List;
import java.util.Optional;
public interface messageService {

    List<message> getMessagesByParentId(Long parentId);
    List<message> getMessagesByAdminId(Long adminId);
    message saveMessage(message message);

}
