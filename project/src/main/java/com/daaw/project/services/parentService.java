package com.daaw.project.services;



import com.daaw.project.model.parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface parentService {

   public parent addparent(parent mparent);

   public parent getparent(Long id);
   public void deleteparent(Long id);

   public Page<parent> getAllparents(Pageable pageable);
   
    
}

