package com.example.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    private final NoteRepository noteRepository;
    
    public NotesController(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @GetMapping
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Note getNote(@PathVariable Long id) {
        return noteRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createNote(@RequestBody Note note) throws URISyntaxException {
        Note savedNote = noteRepository.save(note);
        return ResponseEntity.created(new URI("/note/" + savedNote.getId())).body(savedNote);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note currentNote = noteRepository.findById(id).orElseThrow(RuntimeException::new);
        currentNote.setTitle(note.getTitle());
        currentNote.setContent(note.getContent());
        currentNote = noteRepository.save(note);

        return ResponseEntity.ok(currentNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNote(@PathVariable Long id){
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}