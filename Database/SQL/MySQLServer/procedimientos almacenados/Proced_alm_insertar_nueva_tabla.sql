USE [FarmaciaMSalud]
GO

DELIMITER $$
create Procedure InsertarAbono (
in IDabono int,
in FacturaCompraPedido int,
in IDproveedor int,
in SaldoAbono decimal,
in FechaAbono datetime)
Begin 
Insert into Abono(IDabono,FacturaCompraPedido, IDproveedor, SaldoAbono,FechaAbono) 
Values(IDabono,FacturaCompraPedido, IDproveedor, SaldoAbono,FechaAbono) ;
End$$
DELIMITER 

DELIMITER $$
create Procedure InsertarCompra (
in FacturaCompra int,
in IDproveedor int,
in FacturaPedido int,
in FechaCompra datetime,
in MontoCompra decimal,
in ReciboColector char,
in Status char,
in Observacion char,
in FechaVencPago datetime,
in Descuento decimal)
Begin 
Insert into Compra(FacturaCompra,IDproveedor, FacturaPedido, FechaCompra,MontoCompra,ReciboColector,Status,
Observacion,FechaVencPago,Descuento) 
Values(FacturaCompra,IDproveedor, FacturaPedido, FechaCompra,MontoCompra,ReciboColector,Status,
Observacion,FechaVencPago,Descuento) ;
End$$
DELIMITER 


DELIMITER $$
create Procedure InsertarDetalleFactura (
in NoFactura int,
in FacturaCompraPedido int,
in IDproducto int,
in Descripcion char,
in PrecioUnitario decimal,
in Cantidad int,
in Total decimal
)
Begin 
Insert into DetalleFactura(NoFactura,FacturaCompraPedido, IDproducto, Descripcion,PrecioUnitario, Cantidad, Total) 
Values(NoFactura,FacturaCompraPedido, IDproducto, Descripcion,PrecioUnitario, Cantidad, Total);
End$$
DELIMITER 





DELIMITER $$
create Procedure InsertarDetallePedido (
in FacturaPedido int,
in IDproducto int,
in IDproveedor int,
in CantidadUnidad int,
in MontoxUnidad decimal )
Begin 
Insert into DetallePedido(FacturaPedido, IDproducto, IDproveedor,CantidadUnidad, MontoxUnidad)
Values(FacturaPedido, IDproducto, IDproveedor,CantidadUnidad, MontoxUnidad);
End$$
DELIMITER 




DELIMITER $$
create Procedure InsertarEmpleado (
in IDempleado int,
in CedulaEmpleado char,
in Nombre char(50),
in Usuario char,
in pass char  )
Begin 
Insert into Empleado(IDempleado,CedulaEmpleado, Nombre, Usuario,Pass)
Values(IDempleado,CedulaEmpleado, Nombre, Usuario,Pass);
End$$
DELIMITER 





DELIMITER $$
create Procedure InsertarEnfermedad (
in IDenfermedad int,
in Descripcion char(50) )
Begin 
Insert into Enfermedad(IDenfermedad,Descripcion)
Values(IDenfermedad,Descripcion);
End$$
DELIMITER 






DELIMITER $$
create Procedure InsertarFactura (
in NoFactura int,
in IDempleado int,
in Fecha datetime )
Begin 
Insert into Factura(NoFactura,IDempleado, Fecha)
Values(NoFactura,IDempleado,Fecha);
End$$
DELIMITER 



DELIMITER $$
create Procedure InsertarIndicacion (
in IDindicacion int,
in Descripcion char(50) )
Begin 
Insert into Indicacion(IDindicacion,Descripcion)
Values(IDindicacion,Descripcion);
End$$
DELIMITER 



DELIMITER $$
create Procedure InsertarIndicacionProducto (
in IDproducto int,
in IDindicacion int)
Begin 
Insert into IndicacionProducto(IDproducto,IDindicacion)
Values(IDproducto,IDindicacion);
End$$
DELIMITER 


DELIMITER $$
create Procedure InsertarInventarioProducto (
in FacturaCompra int, 
in IDproducto int, 
in CantidadUnidades int, 
in MontoxUnidad decimal, 
in Ganancia decimal,
in PrecioVentaUnitario decimal, 
in StockBodega int, 
in StockEstante int )
Begin 
Insert into InventarioProducto(FacturaCompra,IDproducto, CantidadUnidades, MontoxUnidad, Ganancia,PrecioVentaUnitario,StockBodega,StockEstante )
Values(FacturaCompra,IDproducto, CantidadUnidades, MontoxUnidad, Ganancia,PrecioVentaUnitario,StockBodega,StockEstante );
End$$
DELIMITER 




DELIMITER $$
create Procedure InsertarPagos (
in IDPagos int,
in IDempleado int,
in TipoPago char(40),
in MontoPago decimal,
in FechaPago datetime )
Begin 
Insert into Pagos(IDPagos,IDempleado, TipoPago, MontoPago, FechaPago )
Values(IDPagos,IDempleado, TipoPago, MontoPago, FechaPago );
End$$
DELIMITER 





DELIMITER $$
create Procedure InsertarPedido (
in FacturaPedido int,
in IDproveedor int,
in IDempleado int,
in FechaPedido datetime,
in MontoPedido decimal )
Begin 
Insert into Pedido(FacturaPedido,IDproveedor, IDempleado, FechaPedido, MontoPedido )
Values(FacturaPedido,IDproveedor, IDempleado, FechaPedido, MontoPedido );
End$$
DELIMITER 


DELIMITER $$
create Procedure InsertarPerdidaProducto (
in IDperdida int, 
in FacturaCompraPedido int, 
in IDproducto int, 
in CantidadUnidades int, 
in MontoPerdido decimal)
Begin 
Insert into PerdidaProducto(IDperdida,FacturaCompraPedido, IDproducto, CantidadUnidades, MontoPerdido )
Values(IDperdida,FacturaCompraPedido, IDproducto, CantidadUnidades, MontoPerdido );
End$$
DELIMITER 





DELIMITER $$
create Procedure InsertarProducto (
in IDproducto int,
in Nombre int,
in Forma_farmaceutica char(20),
in Dosis_Contenido int,
in Unidad_medida char(10),
in Restriccion bit,
in Generico bit,
in Descontinuado bit)
Begin 
Insert into Producto(IDproducto, Nombre,Forma_farmaceutica,Dosis_Contenido,Unidad_medida,Restriccion,Generico,Descontinuado)
Values(IDproducto, Nombre,Forma_farmaceutica,Dosis_Contenido,Unidad_medida,Restriccion,Generico,Descontinuado);
End$$
DELIMITER 



DELIMITER $$
create Procedure InsertarProveedor (
in IDproveedor int,
in Tipo_proveedor char(20),
in Nombre_proveedor char(30),
in tel1 char,
in tel2 char)
Begin 
Insert into Proveedor(IDproveedor, Tipo_proveedor,Nombre_proveedor,tel1,tel2)
Values(IDproveedor, Tipo_proveedor,Nombre_proveedor,tel1,tel2 );
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



