package com.daaw.project.services;
import com.daaw.project.model.message;

import java.util.List;
import java.util.Optional;
public interface messageService {

    public message addmessage(message message);

    public message getmessage(Long id);
    public void deletemessage(Long id);

    public void save(message message);

}
