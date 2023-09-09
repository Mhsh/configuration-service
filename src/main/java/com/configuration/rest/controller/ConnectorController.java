package com.configuration.rest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.ConnectorDTO;
import com.configuration.rest.service.ConnectorService;

@RestController
@RequestMapping("/connector")
public class ConnectorController {

    @Autowired
    private ConnectorService connectorService;

    @GetMapping
    public List<ConnectorDTO> getAllConnectors() {
        return connectorService.getAllConnectors();
    }

    @GetMapping("/{id}")
    public Optional<ConnectorDTO> getConnectorById(@PathVariable String id) {
        return connectorService.getConnectorById(id);
    }

    @PostMapping
    public ConnectorDTO createConnector(@RequestBody ConnectorDTO connectorDTO) {
        return connectorService.createConnector(connectorDTO);
    }

    @PutMapping("/{id}")
    public ConnectorDTO updateConnector(@PathVariable String id, @RequestBody ConnectorDTO updatedConnectorDTO) {
        return connectorService.updateConnector(id, updatedConnectorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteConnector(@PathVariable String id) {
        connectorService.deleteConnector(id);
    }
}
