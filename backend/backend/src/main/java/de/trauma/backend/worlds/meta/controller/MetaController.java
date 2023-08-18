package de.trauma.backend.worlds.meta.controller;

import de.trauma.backend.worlds.meta.domain.Meta;
import de.trauma.backend.worlds.meta.service.MetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaController {
    private final MetaService metaService;

    public MetaController(MetaService metaService) {
        this.metaService = metaService;
    }

    public List<MetaDTO> list() {
        return this.metaService.findAllMetas()
                .stream()
                .map(MetaDTO::new)
                .toList();
    }

    public MetaDTO read(@PathVariable Long id) {
        return this.metaService.findMetaById(id)
                .map(MetaDTO::new)
                .orElseThrow();
    }

    public MetaDTO create(@RequestBody Meta meta) {
        return new MetaDTO(this.metaService.createMeta(meta));
    }

    public MetaDTO update(@PathVariable Long id, @RequestBody Meta meta) {
        return new MetaDTO(this.metaService.updateMeta(id, meta));
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.metaService.deleteMeta(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
