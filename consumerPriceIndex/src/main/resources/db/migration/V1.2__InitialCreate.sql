

create table IF NOT EXISTS STAGING_AREA  (
      id int identity primary key,
      Fecha varchar(255) null,
      Granularidad varchar (255)  null,
      Tipo varchar (255) null,
      Detalle varchar (255)  null,
      Unidad varchar (255)  null,
      Valor varchar (255)  null,
      Url varchar (255)  null
);

insert into STAGING_AREA (Fecha, Granularidad, Tipo, Detalle,Unidad,Valor,Url) values
  ('Coca Cola', 'John Doe', 'john.doe@cocacola.com', '202-555-0143','-','-','-'),
  ('Dell', 'Bob Frapples', 'bob.frapples@dell.com', '202-555-0180','-','-','-'),
  ('Apple', 'Barb Ackue', 'barb.ackue@apple.com', '202-555-0128','-','-','-'),
  ('Google', 'Sue Vaneer', 'sue.vaneer@google.com', '202-555-0174','-','-','-'),
  ('FedEx', 'Robin Banks', 'robin.banks@fedex.com', '202-555-0146','-','-','-'),
  ('Salesforce', 'Zack Lee', 'zack.lee@salesforce.com', '202-555-0122','-','-','-');