package com.daaw.project.Controllers;

import com.daaw.project.model.*;
import com.daaw.project.services.*;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private childService childService;

    @Autowired
    private absencesService absencesService;
    @Autowired
    private parentService parentService;

    @Autowired
    private educatorService educatorService;

    @Autowired
    private eventService eventService;

    @Autowired
    private paymentService paymentService;

    @Autowired
    private preinscritService preinscritService;

    @Autowired
    private visitorService visitorService;

    // Endpoints for child
    @PostMapping("/child")
    public ResponseEntity<child> addchild(@RequestBody child child) {
        child addedChild = childService.addchild(child);
        return ResponseEntity.ok().body(addedChild);
    }
    @GetMapping("/child")
    public ResponseEntity<List<child>> getAllchilds() {
        List<child> children = childService.getAllchildren();
        return ResponseEntity.ok().body(children);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChildById(@PathVariable("id") Long id) {
        childService.deletechildById(id);
        return ResponseEntity.ok().build();
    }




    // Endpoints for absences
    @PostMapping("/absences")
    public ResponseEntity<absences> addabsence(@RequestBody absences absences) {
        absences savedabsence = absencesService.addabsence(absences);
        return new ResponseEntity<>(savedabsence, HttpStatus.CREATED);
    }
    @GetMapping("/absences")
    public ResponseEntity<List<absences>> getAllabsences() {
        List<absences> absences = absencesService.getAllabsences();
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }


    // Endpoints for educator
    @PostMapping("/educators")
    public ResponseEntity<educator> addeducator(@RequestBody educator educator) {
        educator savededucator = educatorService.addeducator(educator);
        return new ResponseEntity<>(savededucator, HttpStatus.CREATED);
    }
    @GetMapping("/educators")
    public ResponseEntity<List<educator>> getAlleducators() {
        List<educator> educators = educatorService.getAlleducators();
        return new ResponseEntity<>(educators, HttpStatus.OK);
    }




    @PostMapping("/events")
    public ResponseEntity<event> addevent(@RequestBody event event) {
        event savedevent = eventService.addevent(event);
        return new ResponseEntity<>(savedevent, HttpStatus.CREATED);
    }
    @GetMapping("/events")
    public ResponseEntity<List<event>> getAllevents() {
        List<event> events = eventService.getAllevents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PostMapping("/payments")
    public ResponseEntity<payment> addpayment(@RequestBody payment payment) {
        payment savedpayment = paymentService.addpayment(payment);
        return new ResponseEntity<>(savedpayment, HttpStatus.CREATED);
    }
    @GetMapping("/payments")
    public ResponseEntity<List<payment>> getAllpayments() {
        List<payment> payment = paymentService.getAllpayments();
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }



    // Endpoints for preinscrit
    @PostMapping("/preinscrits/add")
    public ResponseEntity<preinscrit> addpreinscrit(@RequestBody preinscrit preinscrit) {
        preinscrit savedpreinscrit = preinscritService.save(preinscrit);
        return new ResponseEntity<>(savedpreinscrit, HttpStatus.CREATED);
    }
    @GetMapping("/preinscrits")
    public ResponseEntity<List<preinscrit>> getAllpreinscrits() {
        List<preinscrit> preinscrits = preinscritService.findAll();
        return new ResponseEntity<>(preinscrits, HttpStatus.OK);
    }


    @PostMapping("/parent")
    public ResponseEntity<parent> addparent(@RequestBody parent parent) {
        parent newparent = parentService.addparent(parent);
        return new ResponseEntity<>(newparent, HttpStatus.CREATED);
    }

    // Endpoint to delete an existing parent
    @DeleteMapping("/parent/{id}")
    public ResponseEntity<?> deleteparent(@PathVariable("id") Long id) {
        parentService.deleteparent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}


