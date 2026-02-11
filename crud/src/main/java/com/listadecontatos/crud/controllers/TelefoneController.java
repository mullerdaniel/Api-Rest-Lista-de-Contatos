package com.listadecontatos.crud.controllers;

import com.listadecontatos.crud.dto.telefoneDTO;
import com.listadecontatos.crud.model.Telefone;
import com.listadecontatos.crud.repository.TelefoneRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/telefone")
public class TelefoneController {

    private final TelefoneRepository repository;

    public TelefoneController(TelefoneRepository repository) {
        this.repository = repository;
    }

    // Cadastrar telefone com DTO e validação
    @PostMapping
    public Telefone cadastrar(@RequestBody @Valid telefoneDTO dto) {
        Telefone telefone = new Telefone(dto.getNome(), dto.getNumero());
        return repository.save(telefone);
    }

    // Listar todos os telefones
    @GetMapping
    public Iterable<Telefone> listar() {
        return repository.findAll();
    }

    // Atualizar telefone pelo id
    @PutMapping("/{id}")
    public ResponseEntity<Telefone> atualizar(@PathVariable int id, @RequestBody @Valid telefoneDTO dto) {
        Optional<Telefone> telefoneExistente = repository.findById(id);
        if (telefoneExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Telefone telefone = telefoneExistente.get();
        telefone.setNome(dto.getNome());
        telefone.setNumero(dto.getNumero());
        repository.save(telefone);
        return ResponseEntity.ok(telefone);
    }

    // Deletar telefone pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        Optional<Telefone> telefoneExistente = repository.findById(id);
        if (telefoneExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
