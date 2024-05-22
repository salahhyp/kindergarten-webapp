package com.daaw.project.Controllers;


import com.daaw.project.dto.*;
import com.daaw.project.model.*;
import com.daaw.project.repositories.parentRepository;
import com.daaw.project.repositories.userRepository;
import com.daaw.project.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class controller {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private parentRepository parentRepository;


    @Autowired
    private sessionService sessionService;

    @Autowired
    private groupService groupService;

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
    public ResponseEntity<String> addchild(@RequestBody ChildDto childDto) {
        Optional<parent> parent = parentRepository.findById(childDto.getParentId());

        child child = new child();
        child.setName(childDto.getName());
        child.setAge(childDto.getAge());
        child.setPlan(childDto.getPlan());
        child.setSchedule(childDto.getSchedule());
        child.setParent(parent.get());

        // Save the child object
        child addedChild = childService.addchild(child);

        return new ResponseEntity<String>("Child " + addedChild.getId() + " Child registered successfully", HttpStatus.OK);
    }


    @GetMapping("/child")
    public ResponseEntity<ChildDto> getChild(@RequestParam String parentUsername) {
        // Find the user by userId
        Optional<user> user = userRepository.findByUsername(parentUsername);
        System.out.println(user.get().getRoles()+" for "+ parentUsername);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with parentUsername " + parentUsername);
        }

        child child = childService.findByParent(parentService.findByUser(user));
        if (child == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Child not found for user with parentUsername " + parentUsername);
        }
        ChildDto fetchedChild = new ChildDto(child);

        return new ResponseEntity<>(fetchedChild, HttpStatus.OK);
    }
    @GetMapping("/children/{groupId}")
    public ResponseEntity<List<child>> getGroupChildren(@PathVariable Long groupId) {
        List<child> children = childService.getChildrenByGroupId(groupId);
        return ResponseEntity.ok().body(children);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChildById(@PathVariable("id") Long id) {
        childService.deletechildById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/child/{childId}/{groupId}")
    public ResponseEntity<child> getAvailableGroups(@PathVariable Long childId, @PathVariable Long groupId) {
        child child = childService.findById(childId);
        group group = groupService.getGroupById(groupId);
        if (!child.getPlan().equals(group.getPlan()) || !child.getSchedule().equals(group.getSchedule()) ) {

            child.setGroup(group);
            childService.save(child);
            return new ResponseEntity<>(child, HttpStatus.OK);
        }
        return new ResponseEntity<>(child, HttpStatus.NOT_MODIFIED);
    }


    @GetMapping("/groups/{plan}/{schedule}")
    public ResponseEntity<List<group>> getAvailableGroups(@PathVariable String plan, @PathVariable String schedule) {
        System.out.println(plan + schedule);
        List<group> groups = groupService.findAvailableGroups(com.daaw.project.model.group.Plan.valueOf(plan), com.daaw.project.model.group.Schedule.valueOf(schedule));
        return ResponseEntity.ok().body(groups);
    }


    @GetMapping("/groups")
    public ResponseEntity<List<group>> getAllGroups() {
        List<group> groups = groupService.getAllGroups();
        return ResponseEntity.ok().body(groups);
    }


    @PostMapping("/sessions")
    public ResponseEntity<session> addSession(@RequestBody SessionDto sessionDto) {
        Optional<group> group = groupService.findById(sessionDto.getGroupId());
        educator educator = educatorService.findById(sessionDto.getEducatorId());

        session session = new session();
        session.setModuleName(sessionDto.getModuleName());
        session.setDay(sessionDto.getDay());
        session.setTime(sessionDto.getTime());
        session.setEducator(educator);
        session.setGroup(group.get());
        sessionService.save(session);
        return new ResponseEntity<>(session, HttpStatus.CREATED);
    }

    @GetMapping("/sessions/group/{groupId}")
    public ResponseEntity<List<session>> getAllGroupSessions(@PathVariable Long groupId) {
        List<session> sessions = sessionService.findAllByGroupId(groupId);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }


    @GetMapping("/sessions/educator/{educatorId}")
    public ResponseEntity<List<session>> getAllEducatorSessions(@PathVariable Long educatorId) {
        List<session> sessions = sessionService.findAllByEducatorId(educatorId);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }


    @PutMapping("/sessions/{id}")
    public ResponseEntity<session> updateSession(@PathVariable Long id, @RequestBody session updatedSession) {
        session existingSession = sessionService.findById(id);
        if (existingSession == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingSession.setModuleName(updatedSession.getModuleName());
        existingSession.setTime(updatedSession.getTime());
        existingSession.setDay(updatedSession.getDay());
        existingSession.setGroup(updatedSession.getGroup());
        existingSession.setEducator(updatedSession.getEducator());
        session savedSession = sessionService.save(existingSession);
        return new ResponseEntity<>(savedSession, HttpStatus.OK);
    }

    // Endpoint to delete a session
    @DeleteMapping("/sessions/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    // Endpoints for absences
    @PostMapping("/absences")
    public ResponseEntity<AbsenceDto> addabsence(@RequestBody AbsenceDto absenceDto) {
        AbsenceDto savedAbsence = absencesService.addabsence(absenceDto);
        return new ResponseEntity<>(savedAbsence, HttpStatus.CREATED);
    }

    @GetMapping("/absences")
    public ResponseEntity<List<AbsenceDto>> getAllabsences() {
        List<AbsenceDto> absences = absencesService.getAllabsences();
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }

    @GetMapping("/absences/{childId}")
    public ResponseEntity<List<absences>> getChildAbsences(@PathVariable Long childId) {
        child child = childService.findById(childId);
        List<absences> absences = absencesService.getAbsencesByChild(child);
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }

    // Endpoints for educator
    @PostMapping("/educators")
    public ResponseEntity<educator> addeducator(@RequestBody educator educator) {
        educator savededucator = educatorService.addeducator(educator);
        return new ResponseEntity<>(savededucator, HttpStatus.CREATED);
    }
    @PutMapping("/educator/{userId}")
    public ResponseEntity<String> updateEducator(@PathVariable Long userId, @RequestBody EducatorUpdateDto updateDto) {
        // Find the user by userId
        Optional<user> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId);
        }

        // Find the associated parent entity
        educator educator = educatorService.findByUser(user.get());
        if (educator == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Educator not found for user with id " + userId);
        }

        educator.setName(updateDto.getName());
        educator.setSubject(updateDto.getSubject());
        educator.setEmail(updateDto.getEmail());
        educator.setPhoneNumber(updateDto.getPhoneNumber());
        educator updatedEducator = educatorService.save(educator);

        return new ResponseEntity<String>("Educator " + updatedEducator.getId() + " Educator registered successfully", HttpStatus.OK);
    }
    @GetMapping("/educator")
    public ResponseEntity<educator> getEducator(@RequestParam String username) {
        // Find the user by userId
        Optional<user> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with username " + username);
        }

        // Find the associated parent entity
        educator educator = educatorService.findByUser(user.get());
        if (educator == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Educator not found for user with username " + username);
        }

        return new ResponseEntity<>(educator, HttpStatus.OK);
    }


    @GetMapping("/educators")
    public ResponseEntity<List<educator>> getAlleducators() {
        List<educator> educators = educatorService.getAlleducators();
        return new ResponseEntity<>(educators, HttpStatus.OK);
    }




    @PostMapping("/events")
    public ResponseEntity<event> addevent(@RequestBody EventDto eventDto) {
        event savedevent = eventService.addevent(eventDto);
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

    @DeleteMapping("/preinscrit/{id}")
    public ResponseEntity<?> deletePreinscript(@PathVariable("id") Long id) {
        preinscritService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }






    @PostMapping("/parent")
    public ResponseEntity<parent> addparent(@RequestBody parent parent) {
        parent newparent = parentService.addparent(parent);
        return new ResponseEntity<>(newparent, HttpStatus.CREATED);
    }

    @PutMapping("/parents/{userId}")
    public ResponseEntity<String> updateParent(@PathVariable Long userId, @RequestBody ParentUpdateDto updateDto) {
        Optional<user> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id " + userId);
        }

        // Find the associated parent entity
        parent parent = parentService.findByUser(user);
        if (parent == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent not found for user with id " + userId);
        }

        parent.setName(updateDto.getName());
        parent.setPhoneNumber(updateDto.getPhoneNumber());
        parent updatedParent = parentService.save(parent);

        return new ResponseEntity<String>("Parent " + updatedParent.getId() + " Parent registered successfully", HttpStatus.OK);
    }
    @DeleteMapping("/parent/{id}")
    public ResponseEntity<?> deleteparent(@PathVariable("id") Long id) {
        parentService.deleteparent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}


