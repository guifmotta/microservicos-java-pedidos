CREATE TABLE item_do_pedido (
  id uuid NOT NULL,
  descricao character varying(255) DEFAULT NULL,
  quantidade integer NOT NULL,
  pedido_id uuid NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (pedido_id) REFERENCES pedidos(id)
)