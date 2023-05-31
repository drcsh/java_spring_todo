package com.example.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BoostrapInitialData implements CommandLineRunner {
    
    private final NoteRepository noteRepository;

    public BoostrapInitialData(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... args) {
        noteRepository.save(new Note("Learn Spring", "visit https://spring.io/"));
        noteRepository.save(new Note("Learn React", "visit https://react.dev/"));
    }
}
