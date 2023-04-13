package com.microservico.pedidos.controller;

import com.microservico.pedidos.dto.PedidoDto;
import com.microservico.pedidos.dto.StatusDto;
import com.microservico.pedidos.service.PedidoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

        @Autowired
        private PedidoService service;

        @GetMapping()
        public List<PedidoDto> listarTodos() {
            return service.obterTodos();
        }

        @GetMapping("/{id}")
        public ResponseEntity<PedidoDto> listarPorId(@PathVariable @NotNull UUID id) {
            PedidoDto dto = service.obterPorId(id);

            return  ResponseEntity.ok(dto);
        }

        @PostMapping()
        public ResponseEntity<PedidoDto> realizaPedido(@RequestBody @Valid PedidoDto dto, UriComponentsBuilder uriBuilder) {
            PedidoDto pedidoRealizado = service.criarPedido(dto);

            URI endereco = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedidoRealizado.getId()).toUri();

            return ResponseEntity.created(endereco).body(pedidoRealizado);

        }

        @PutMapping("/{id}/status")
        public ResponseEntity<PedidoDto> atualizaStatus(@PathVariable UUID id, @RequestBody StatusDto status){
           PedidoDto dto = service.atualizaStatus(id, status);

            return ResponseEntity.ok(dto);
        }


        @PutMapping("/{id}/pago")
        public ResponseEntity<Void> aprovaPagamento(@PathVariable @NotNull UUID id) {
            service.aprovaPagamentoPedido(id);

            return ResponseEntity.ok().build();

        }
}
