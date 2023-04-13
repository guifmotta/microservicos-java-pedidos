CREATE TABLE pedidos (
  id uuid NOT NULL,
  data_hora timestamp NOT NULL,
  status character varying(255) NOT NULL,
  PRIMARY KEY (id)
)