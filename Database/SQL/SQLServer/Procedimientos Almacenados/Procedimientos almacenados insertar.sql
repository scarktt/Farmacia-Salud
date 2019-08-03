USE [Farmacia]
GO
create Procedure InsertarCompraProducto
@IDcompra int,
@IDpedido int,
@IDproveedor int,
@IDproducto int,
@Fecha_compra datetime,
@Num_factura int,
@Monto money,
@Cantidad int,
@Descuento float
As
Begin 
Insert into CompraProducto
(IDcompra, IDpedido, IDproveedor, 
IDproducto, Fecha_compra, Num_factura, Monto, Cantidad, Descuento)
Values(@IDcompra, @IDpedido, @IDproveedor, 
@IDproducto, @Fecha_compra, @Num_factura, @Monto, @Cantidad, @Descuento)
End

EXECUTE InsertarCompraProducto
'','008',21,15,50





create Procedure InsertarDetalleCompra
@IDdetallecompra int,
@IDcompra int,
@IDproducto int,
@Cantidad int,
@Costo money

As
Begin 
Insert into DetalleCompra(IDdetallecompra, IDcompra, IDproducto, 
 Cantidad, Costo)
Values(@IDdetallecompra, @IDcompra, @IDproducto, 
 @Cantidad, @Costo)
End

EXECUTE InsertarDetalleCompra
'','008',21,15,50





create Procedure InsertarDetalleFactura
@IDfactura int,
@IDproducto int,
@PrecioUnitario money,
@Cantidad int,
@Total money

As
Begin 
Insert into DetalleFactura(IDfactura, IDproducto, precioUnitario, 
 Cantidad, Total)
Values(@IDfactura, @IDproducto, @precioUnitario, 
 @Cantidad, @Total)
End

EXECUTE InsertarDetalleFactura
'','008',21,15,50




create Procedure InsertarDetallePedido
@IDproveedor int,
@IDpedido int,
@Cantidad int,
@Monto money,
@IDproducto int

As
Begin 
Insert into DetallePedido(IDproveedor, IDpedido, Cantidad,Monto, IDproducto)
Values(@IDproveedor, @IDpedido, @Cantidad,@Monto, @IDproducto)
End

EXECUTE InsertarDetallePedido
'','008',21,15,50





create Procedure InsertarDetalleProducto
@IDproducto int,
@IDLote int,
@FechaVenc datetime,
@PrecioVenta money,
@PrecioUnitario money

As
Begin 
Insert into DetalleProducto(IDproducto, IDLote, FechaVenc,PrecioVenta, PrecioUnitario)
Values(@IDproducto, @IDLote, @FechaVenc,@PrecioVenta, @PrecioUnitario)
End

EXECUTE InsertarDetalleProducto
'','008',21,15,50







create Procedure InsertarEmpleado
@IDempleado int,
@Nombre char(50)
As
Begin 
Insert into Empleado(IDempleado, Nombre)
Values(@IDempleado, @Nombre)
End

EXECUTE InsertarEmpleado
'','008',21,15,50






create Procedure InsertarEnfermedad
@IDenfermedad int,
@Descripcion char(50)
As
Begin 
Insert into Enfermedad(IDenfermedad,Descripcion)
Values(@IDenfermedad,@Descripcion)
End

EXECUTE InsertarEnfermedad
'','008',21,15,50






create Procedure InsertarFactura
@IDfactura int,
@IDempleado int,
@Fecha datetime
As
Begin 
Insert into Factura(IDfactura,IDempleado, Fecha)
Values(@IDfactura,@IDempleado,@Fecha)
End

EXECUTE InsertarFactura
'','008',21,15,50