USE [Farmacia]
GO

DELIMITER $$
CREATE PROCEDURE InsertarCompraProducto ( 
in IDcompra int, 
in IDpedido int, 
in IDproveedor int,
in IDproducto int, 
in Fecha_compra datetime,
in Num_factura int,
in Monto decimal, 
in Cantidad int, 
in Descuento float ) 
BEGIN 
Insert into CompraProducto (IDcompra, IDpedido, IDproveedor, IDproducto, Fecha_compra, Num_factura,
							Monto, Cantidad, Descuento)
Values (IDcompra, IDpedido, IDproveedor, IDproducto, Fecha_compra, Num_factura, Monto, Cantidad, Descuento);
END$$
DELIMITER 

call InsertarCompraProducto (3025, 9013, 17013, 1013, CAST(N'2018-02-26' AS Date), 100, 25,3, 0.03);






DELIMITER $$
create Procedure InsertarDetalleCompra (
in IDdetallecompra int,
in IDcompra int,
in IDproducto int,
in Cantidad int,
in Costo decimal
)
Begin 
Insert into DetalleCompra(IDdetallecompra, IDcompra, IDproducto, Cantidad, Costo) 
Values(IDdetallecompra, IDcompra, IDproducto, Cantidad, Costo);
End$$
DELIMITER 


call InsertarDetalleCompra ( 11025, 3025, 1017, 10, 910.0000);



DELIMITER $$
create Procedure InsertarDetalleFactura (
in IDfactura int,
in IDproducto int,
in PrecioUnitario decimal,
in Cantidad int,
in Total decimal )
Begin 
Insert into DetalleFactura(IDfactura, IDproducto, precioUnitario, Cantidad, Total)
Values(IDfactura, IDproducto, precioUnitario, Cantidad, Total);
End$$
DELIMITER 

call InsertarDetalleFactura (4025, 3008, 12.0000, 1, 12.0000);

DELIMITER $$
create Procedure InsertarDetallePedido (
in IDproveedor int,
in IDpedido int,
in Cantidad int,
in Monto decimal,
in IDproducto int )
Begin 
Insert into DetallePedido(IDproveedor, IDpedido, Cantidad,Monto, IDproducto)
Values(@IDproveedor, @IDpedido, @Cantidad,@Monto, @IDproducto);
End$$
DELIMITER 

call InsertarDetallePedido(17001, 9000, 12, 320, 10001);




DELIMITER $$
create Procedure InsertarDetalleProducto (
in IDproducto int,
in IDLote int,
in FechaVenc datetime,
in PrecioVenta decimal,
in PrecioUnitario decimal )
Begin 
Insert into DetalleProducto(IDproducto, IDLote, FechaVenc,PrecioVenta, PrecioUnitario)
Values(IDproducto, IDLote, FechaVenc,PrecioVenta, PrecioUnitario);
End$$
DELIMITER 

call InsertarDetalleProducto(1001, 8001, CAST(N'2020-02-21' AS Date), 12, 3 );





DELIMITER $$
create Procedure InsertarEmpleado (
in IDempleado int,
in Nombre char(50),
in Salario decimal )
Begin 
Insert into Empleado(IDempleado, Nombre, Salario)
Values(IDempleado, Nombre, Salario);
End$$
DELIMITER 

call InsertarEmpleado (3, N'Isis Amador', 4000);




DELIMITER $$
create Procedure InsertarEnfermedad (
in IDenfermedad int,
in Descripcion char(50) )
Begin 
Insert into Enfermedad(IDenfermedad,Descripcion)
Values(IDenfermedad,Descripcion);
End$$
DELIMITER 

call InsertarEnfermedad (5025, N'Infeccion vaginal');




DELIMITER $$
create Procedure InsertarFactura (
in IDfactura int,
in IDempleado int,
in Fecha datetime )
Begin 
Insert into Factura(IDfactura,IDempleado, Fecha)
Values(IDfactura,IDempleado,Fecha);
End$$
DELIMITER 

call InsertarFactura(6025, 1, CAST(N'2019-02-10 00:00:00.000' AS DateTime));

