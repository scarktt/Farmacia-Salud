USE [Farmacia]
GO



DELIMITER $$
create Procedure InsertarIndicacion (
in IDindicacion int,
in Descripcion char(50) )
Begin 
Insert into Indicacion(IDindicacion,Descripcion)
Values(IDindicacion,Descripcion);
End$$
DELIMITER 

call InsertarIndicacion (7011, N'No apto para embarazadas');

DELIMITER $$
create Procedure InsertarIndicacionProducto (
in IDproducto int,
in IDindicacion int)
Begin 
Insert into IndicacionProducto(IDproducto,IDindicacion)
Values(IDproducto,IDindicacion);
End$$
DELIMITER 
call InsertarIndicacionProducto (1011, 7906);


DELIMITER $$
create Procedure InsertarLote (
in IDLote int,
in Fecha_venc datetime )
Begin 
Insert into Lote(IDLote,Fecha_venc)
Values(IDLote,Fecha_venc);
End$$
DELIMITER 

call InsertarLote (34221, CAST(N'2021-08-28 00:00:00.000' AS DateTime));





DELIMITER $$
create Procedure InsertarPagoServicios (
in IDPagoServicios int,
in IDempleado int,
in TipodePagoServicios char(40),
in PagoServicio decimal,
in FechaPago datetime )
Begin 
Insert into PagoServicios(IDPagoServicios,IDempleado, TipodePagoServicios,PagoServicio, FechaPago )
Values(IDPagoServicios,IDempleado, TipodePagoServicios,PagoServicio,FechaPago);
End$$
DELIMITER 

call InsertarPagoServicios (1, 9025, CAST(N'2019-05-10 00:00:00.000' AS DateTime));


DELIMITER $$
create Procedure InsertarPedido (
in IDempleado int,
in IDPedido int,
in Fecha datetime )
Begin 
Insert into Pedido(IDempleado, IDpedido, Fecha )
Values(IDempleado,IDpedido, Fecha );
End$$
DELIMITER 







DELIMITER $$
create Procedure InsertarProducto (
in IDproducto int,
in Nombre int,
in Forma_farmaceutica char(20),
in Restriccion bit,
in Unidad_medida char(10),
in Descontinuado bit,
in Generico bit,
in StockBodega int,
in StockEstante int )
Begin 
Insert into Producto(IDproducto, Nombre,Forma_farmaceutica,Restriccion,Unidad_medida,Descontinuado,
Generico,StockBodega,StockEstante )
Values(IDproducto,Nombre,Forma_farmaceutica,Restriccion,Unidad_medida,Descontinuado,
Generico,StockBodega,StockEstante );
End$$
DELIMITER 



DELIMITER $$
create Procedure InsertarProveedor (
in IDproveedor int,
in Tipo_proveedor char(20),
in Nombre_proveedor char(30) )
Begin 
Insert into Proveedor(IDproveedor, Tipo_proveedor,Nombre_proveedor)
Values(IDproveedor, Tipo_proveedor,Nombre_proveedor );
End$$
DELIMITER 



DELIMITER $$
create Procedure InsertarUtilidadProducto (
in IDproducto int,
in IDenfermedad int )
Begin 
Insert into UtilidadProducto(IDproducto,IDenfermedad)
Values(IDproducto,IDenfermedad );
End$$
DELIMITER 


