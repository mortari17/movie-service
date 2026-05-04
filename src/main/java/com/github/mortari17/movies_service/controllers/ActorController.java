package com.github.mortari17.movies_service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.mortari17.movies_service.model.Actor;
import com.github.mortari17.movies_service.repository.ActorRepository;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorRepository repository;

    @GetMapping
    public ResponseEntity<List<Actor>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping()
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(actor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> update(@PathVariable Long id,
                                        @RequestBody Actor actor) {

        Optional<Actor> optActor = repository.findById(id);

        if (optActor.isPresent()) {
            actor.setId(id);
            Actor actorAlterado = repository.save(actor);
            return ResponseEntity.ok(actorAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}