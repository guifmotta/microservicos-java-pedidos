package com.microservico.pedidos.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDoPedidoDto {

    private UUID id;
    private Integer quantidade;
    private String descricao;
}
