Use [FarmaciaMasS]
Go

--Compra producto
Create Procedure ModCompraProducto
@IDcompra int,
@IDpedido int,
@IDproveedor int,
@IDproducto int,
@Fecha_compra Datetime,
@Num_factura int,
@Monto money,
@Cantidad int, 
@Descuento float

As Begin 

UPDATE CompraProducto SET
IDpedido = @IDpedido,
IDproveedor = @IDproveedor,
IDproducto = @IDproducto,
Fecha_compra = @Fecha_compra,
Num_factura = @Num_factura,
Monto = @Monto,
Cantidad = @Cantidad, 
Descuento = @Descuento

Where IDcompra = @IDcompra

End 

Execute ModCompraProducto '3001', '13005', '17012', '1002', '12-03-2019', '532123' , 150, 30, 0.03



--Detalle Compra

Create Procedure ModDetalleCompra
@IDdetallecompra int,
@Idcompra int,
@IDproducto int,
@Cantidad int,
@Costo money

As
Begin

UPDATE DetalleCompra SET
Idcompra = @IDcompra,
IDproducto = @IDproducto,
Cantidad = @Cantidad,
Costo = @Costo

Where IDdetallecompra = @IDdetallecompra

END

Execute ModDetalleCompra '110001', '3004', '1023', 25, 100

--DetalleFactura

Create procedure ModDetalleFactura
@IDfactura int,
@IDproducto int,
@PrecioUnitario money,
@Cantidad int, 
@Total money
AS
Begin 
UPDAte DetalleFactura SET
PrecioUnitario = @PrecioUnitario,
Cantidad = @Cantidad,
Total = @Total

where IDfactura = @IDfactura AND IDproducto = @IDproducto
END

Execute ModDetalleFactura '12001', '1003', 50, 5, 250


-- Detalle Pedido

Create Procedure ModDetallePedido
@IDproveedor int,
@IDpedido int,
@Cantidad int,
@Monto money,
@IDproducto int
As 
Begin
UPDATE DetallePedido SET
Cantidad = @Cantidad,
Monto = @Monto

where IDproveedor = @IDproveedor AND IDpedido = @IDpedido AND IDproducto = @IDproducto
END

Execute ModDetallePedido '17001', '9001', 25, 100, '1001'

--Detalle Producto
Create procedure ModDetalleProducto
@IDproducto int,
@IDlote int,
@FechaVenc datetime,
@Precioventa money,
@PrecioUnitario money
AS 
Begin
UPDATE DetalleProducto SET
FechaVenc = @FechaVenc,
PrecioVenta = @Precioventa,
PrecioUnitario = @PrecioUnitario
where IDproducto = @IDproducto AND IDlote = @IDlote,
END

Execute ModDetalleProducto '1002', '8001', '25-05-19', 250, 25

--Empleado 

Create procedure ModEmpleado 
@IDempleado int,
@Nombre char(50),
@Salario money
As
Begin
UPDATE Empleado SET
Nombre = @Nombre,
Salario = @Salario

where IDempleado = @IDempleado
END

Execute ModEmpleado '1', 'Maria Castillo', 7000

--Enfermedad
Create procedure ModEnfermedad
@IDenfermedad int,
@Descripcion char(50)
As
Begin 
UPDATE Enfermedad SET
Descripcion = @Descripcion

where IDenfermedad = @IDenfermedad
END

Execute ModEnfermedad '5024', 'Sinusitis'

--Factura
Create Procedure ModFactura
@IDfactura int,
@IDempleado int,
@Fecha datetime
As
Begin
UPDATE Factura SET
IDempleado  = @IDempleado,
Fecha = @Fecha

where IDfactura = @IDfactura
END

Execute ModFactura '6001', '2', '23-06-19' 

--Indicacion
Create Procedure ModIndicacion
@IDindicacion int,
@Decripcion char(50)
As
Begin 
UPDATE Indicacion SET
Descripcion = @Decripcion

where IDindicacion = @IDindicacion
END

Execute ModIndicacion '7001', 'Mayores de doce años'

--IndicacionProducto
Create Procedure ModIndicacionProducto
@IDproducto int,
@IDindicacion int
As
Begin
UPDATE IndicacionProducto SET
IDproducto = @IDproducto,
IDindicacion = @IDindicacion

END

Execute ModIndicacionProducto '1001', '7002'


--Lote

Create Procedure ModLote
@IDLote int,
@Fecha_venc datetime
As
Begin
UPDATE Lote SET
IDLote = @IDLote,
Fecha_Venc = @Fecha_venc
END

Execute ModLote '8001', '10-01-2020'

--PagoServicios
Create Procedure ModPagoServicios
@IDPagoServicios int,
@IDempleado int,
@TipodePagoServicios char(40),
@PagoServicio money,
@FechaPago datetime
As
Begin
UPDATE PagoServicios SET
IDempleado = @IDempleado ,
TipodePagoServicios = @TipodePagoServicios,
PagoServicio = @PagoServicio,
FechaPago = @FechaPago

where IDPagoServicios = @IDPagoServicios 
END

execute ModPagoServicios '16001', '1', 'Luz', 361, '23-06-19'

--Pedido
Create Procedure ModPedido
@IDempleado int,
@IDpedido int,
@Fecha datetime
As
Begin
UPDATE Pedido SET
IDempleado = @IDempleado,
Fecha = @Fecha

where IDpedido = @IDpedido
END

execute ModPedido '1', '9001', '14-07-19'

--Producto
Create Procedure ModProducto
@IdProducto varchar(20),
@Nombre char(20),
@Forma_farmaceutica varchar(20),
@Restriccion bit,
@UnidadMedida varchar(10),
@Descontinuado bit,
@Generico bit,
@StockBodega int,
@StockEstante int
AS Begin

UPDATE Producto Set
Nombre = @Nombre,
Forma_farmaceutica = @Forma_farmaceutica,
Restriccion = @Restriccion,
Unidad_medida = @UnidadMedida,
Descontinuado = @Descontinuado,
Generico = @Generico,
StockBodega = @StockBodega,
StockEstante = @StockEstante
Where IdProducto = @IdProducto
END

Execute ModProducto '1003', 'Mucolex', 'Jarabe', 0, 99.1500, 110.0000, '100 ml', 0, 0


--Proveedor
Create procedure ModProveedor
@IDproveedor int,
@Tipo_proveedor char(20),
@Nombre_proveedor char(30)
As
Begin
UPDATE Proveedor SET	
Tipo_proveedor = @Tipo_proveedor,
Nombre_proveedor = @Nombre_proveedor
where IDproveedor = @IDproveedor
END

execute ModProveedor 17001, 'Laboratorio', 'Unifarm'

--UtilidadProducto
Create procedure ModUtilidadProducto
@IDproducto int,
@IDenfermedad int
As
Begin
UPDATE UtilidadProducto SET
IDproducto = @IDproducto,
IDenfermedad = @IDenfermedad
END

execute ModUtilidadProducto 1018, 10004