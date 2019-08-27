Use FarmaciaMasSalud;
Use FarmaciaMSalud;
drop procedure ModAbono;
--Abono 
DELIMITER $$
Create Procedure ModAbono(
in IDabono int,
in FacturaCompraProducto int,
in IDproveedor int,
in SaldoAbono decimal,
in FechaAbono datetime)
Begin
UPDATE Abono SET
SaldoAbono = @SaldoAbono,
FechaAbono = @FechaAbono
WHERE IDabono = @IDabono AND FacturaCompraProducto = @FacturaCompraProducto AND IDproveedor = @IDproveedor;

END $$

Call ModAbono(1603, 3041, 17028, 330.000, '2019-08-07');

-- Compra producto
DELIMITER $$
Create Procedure ModCompraProducto(
in FacturaCompraProducto int,
in FacturaPedido int,
in IDproducto int,
in FechaCompra Datetime,
in MontoCompra decimal,
in ReciboColector char(15),
in Estatus char(15),
in Observacion char(30),
in FechaVencPago date,
in Descuento decimal
) 
Begin
UPDATE CompraProducto SET
FacturaPedido = @FacturaPedido, 
IDproducto = @IDproducto, 
FechaCompra = @FechaCompra, 
MontoCompra = @MontoCompra, 
ReciboColector = @ReciboColector,
Status =  @Estatus,
Observacion = @Observacion ,
FechaVencPago = @FechaVencPago, 
Descuento = @Descuento

Where FacturaCompraProducto = @FacturaCompraProducto;

End $$

Call ModCompraProducto ('3001', '9001', '1001', '2016-02-25', '150.000', '5001', 'Credito', '-', '2016-01-01', 0)

--Detalle Compra
DELIMITER $$
Create Procedure ModDetalleCompraProducto(
in FacturaCompraProducto int,
in IDproducto int,
in CantidadUnidades int,
in PrecioxUnidad decimal)
Begin
UPDATE DetalleCompraProducto SET
IDproducto = @IDproducto,
CantidadUnidades = @Cantidad,
PrecioxUnidad = @PrecioxUnidad
Where FacturaCompraProducto = @FacturaCompraProducto;
END $$

Call ModDetalleCompraProducto ('1101', '1012', '255', '4.000')

-- DetalleFactura
DELIMITER $$
Create procedure ModDetalleFactura(
in Nofactura int,
in FacturaCompraProducto int,
in IDproducto int,
in IDLote int,
in Descripcion char(30),
in PrecioUnitario decimal,
in Cantidad int, 
in Total decimal)
Begin 
UPDAte DetalleFactura SET
Descripcion = @Descripcion,
PrecioUnitario = @PrecioUnitario,
Cantidad = @Cantidad,
Total = @Total

where Nofactura = @Nofactura AND FacturaCompraProducto = @FacturaCompraProducto AND IDproducto = @IDproducto AND IDLote = @IDLote;
END $$

Call ModDetalleFactura ('6001', '1044', '84763', '-', '69.000', '10', '690.000');

-- Detalle Pedido
DELIMITER $$
Create Procedure ModDetallePedido(
in IDproveedor int,
in IDproducto int,
in CantidadUnidad int,
in MontoxUnidad decimal)
Begin
UPDATE DetallePedido SET
CantidadUnidad = @CantidadUnidad,
MontoxUnidad = @MontoxUnidad
where IDproveedor = @IDproveedor AND IDpedido = @IDpedido AND IDproducto = @IDproducto;
END $$
Call ModDetallePedido ('2201', '1092', '27', '243.000');

--Detalle Producto
DELIMITER $$
Create procedure ModDetalleProducto(
in IDproducto int,
in IDlote int,
in FechaVenc datetime,
in PrecioUnitario decimal,
in PrecioVenta decimal)
Begin
UPDATE DetalleProducto SET
FechaVenc = @FechaVenc,
PrecioUnitario = @PrecioUnitario,
PrecioVenta = @Precioventa
where IDproducto = @IDproducto AND IDlote = @IDlote;
END $$

Call ModDetalleProducto ('1001', '81329', '2018-10-29 12:52:44', '63.000', '22.050');

--Empleado 
DELIMITER $$
Create procedure ModEmpleado (
in IDempleado int,
in CedulaEmpleado int,
in Nombre char(50),
in Usuario char(15),
in Pass char(10))
Begin
UPDATE Empleado SET
CedulaEmpleado = @CedulaEmpleado,
Nombre = @Nombre,
Usuario = @Usuario,
Pass = @Pass
where IDempleado = @IDempleado;
END $$

Call ModEmpleado ('1', '001-130599-1007K', 'Francisco Silva', 'FSilva', '1234')

-- Enfermedad
DELIMITER $$
Create procedure ModEnfermedad(
in IDenfermedad int,
in escripcion char(50) )
Begin 
UPDATE Enfermedad SET
Descripcion = @Descripcion

where IDenfermedad = @IDenfermedad;
END $$

Call ModEnfermedad (5024, 'Sinusitis')
Enfermedad
-- Factura
DELIMITER $$
Create Procedure ModFactura(
in IDfactura int,
in IDempleado int,
in Fecha datetime)
Begin
UPDATE Factura SET
IDempleado  = @IDempleado,
Fecha = @Fecha
where IDfactura = @IDfactura;
END $$

Call ModFactura ('6001', '2', '23-06-19' )

-- Indicacion
DELIMITER $$
Create Procedure ModIndicacion(
in IDindicacion int,
in Descripcion char(50) )
Begin 
UPDATE Indicacion SET
Descripcion = @Decripcion
where IDindicacion = @IDindicacion;
END $$

Call ModIndicacion ('7001', 'Mayores de doce años')

-- IndicacionProducto
DELIMITER $$
Create Procedure ModIndicacionProducto(
in IDproducto int,
in IDindicacion int)
Begin
UPDATE IndicacionProducto SET
IDproducto = @IDproducto,
IDindicacion = @IDindicacion
Where IDproducto = @IDproducto AND IDindicacion = @IDindicacion;
END $$
Call ModIndicacionProducto ('1001', '7002')

-- Lote
DELIMITER $$
Create Procedure ModInventarioProducto(
in FacturaCompraPedido int,
in IDproducto int,
in CantidadUnidades int,
in MontoxUnidad decimal(13,3),
in Ganancia decimal(13,3),
in PrecioVenta decimal(13,3),
in PrecioUnitario decimal(13,3),
in StockBodega int,
in StockEstante int)
Begin
UPDATE InventarioProducto SET
CantidadUnidades = @CantidadUnidades,
MontoxUnidad = @MontoxUnidad,
Ganancia = @Ganancia,
PrecioVenta = @PrecioVenta,
PrecioUnitario = @PrecioUnitario,
StockBodega = @StockBodega,
StockEstante = @StockEstante
Where FacturaCompraPedido = @FacturaCompraPedido AND IDproducto = @IDproducto;
END $$
-- Call ModInventarioProducto ('8001', '10-01-2020')

-- PagoServicios
DELIMITER $$
Create Procedure ModPagos(
in IDPagoServicios int,
in IDempleado int,
in TipoPagoServicios char(40),
in PaServicio decimal,
in FechaPa datetime)
Begin
UPDATE PagoServicios SET
IDempleado = @IDempleado ,
TipoPagoServicios = @TipoPagoServicios,
PaServicio = @PaServicio,
FechaPa = @FechaPa
where IDPagoServicios = @IDPagoServicios;
END $$
Call ModPagoServicios ('1601', '1', 'Luz', '1072.000', '2018-09-14 01:26:52')

-- Pedido
DELIMITER $$
Create Procedure ModPedido(
in FacturaPedido int,
in IDproveedor int,
in IDempleado int,
in FechaPedido datetime,
in MontoPedido decimal)
Begin
UPDATE Pedido SET
IDempleado = @IDempleado,
IDproveedor = @IDproveedor,
FechaPedido = @FechaPedido,
MontoPedido = @MontoPedido
Where FacturaPedido = @FacturaPedido;
END $$
Call ModPedido ('2201', '17002', '2', '2019-07-09 17:06:01', '1665.000')

--Perdida producto
DELIMITER $$
Create Procedure ModPerdidaProducto(
in IDperdida int,
in FacturaCompraPedido int,
in IDproductos int,
in CantidadUnidades int,
in MontoPerdido decimal)
Begin
UPDATE Producto Set
FacturaCompraPedido = @FacturaCompraPedido,
IDproductos = @IDproductos,
CantidadUnidades = @Cantidad,
MontoPerdido = @CantidadUnidades
Where IDperdida = @IDperdida ;
END $$
Call ModPerdidaProducto (2301, 3010, 1010,6, '200.000')

-- Producto
DELIMITER $$
Create Procedure ModProducto(
in IDproducto int,
in Nombre char(30),
in Forma_farmaceutica varchar(20),
in Dosis_Contenido int,
in Unidad_medida varchar(10),
in Restriccion bit,
in Generico bit,
in Descontinuado bit)
Begin
UPDATE Producto Set
Nombre = @Nombre,
Forma_farmaceutica = @Forma_farmaceutica,
Dosis_Contenido = @Dosis_Contenido,
Unidad_medida = @Unidad_medida,
Restriccion = @Restriccion,
Descontinuado = @Descontinuado,
Generico = @Generico,
StockBodega = @StockBodega,
StockEstante = @StockEstante
Where IDproducto = @IDproducto;
END $$
Call ModProducto ('1004', 'Zepol Deportista', 'Crema', '30', 'gr', '0', '0', '0')
 
-- Proveedor
DELIMITER $$
Create procedure ModProveedor(
in IDproveedor int,
in Tipo_proveedor char(20),
in Nombre_proveedor char(30),
in tel1 char(8),
in tel2 char(8))
Begin
UPDATE Proveedor SET	
Tipo_proveedor = @Tipo_proveedor,
Nombre_proveedor = @Nombre_proveedor,
tel1 = @tel1,
tel2 = @tel2
where IDproveedor = @IDproveedor;
END $$ 

Call ModProveedor ('17008', 'Laboratorio', 'Rarpe', '87249035', '50549373')

-- UtilidadProducto
DELIMITER $$
Create procedure ModUtilidadProducto(
in IDproducto int,
in IDenfermedad int)
Begin
UPDATE UtilidadProducto SET
IDproducto = @IDproducto,
IDenfermedad = @IDenfermedad;
END $$

Call ModUtilidadProducto (2104, 1039, 5025)