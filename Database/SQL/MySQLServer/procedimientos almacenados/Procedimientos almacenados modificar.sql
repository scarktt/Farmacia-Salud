Use FarmaciaMasSalud;

--Abono 
DELIMITER $$
Create Procedure ModAbono(
in pIDabono int,
in pFacturaCompraProducto int,
in pIDproveedor int,
in pSaldoAbono decimal,
in pFechaAbono datetime)
Begin
UPDATE Abono SET
SaldoAbono = pSaldoAbono,
FechaAbono = pFechaAbono
WHERE IDabono = pIDabono AND FacturaCompraProducto = pFacturaCompraProducto AND IDproveedor = pIDproveedor;
END $$

Call ModAbono(1603, 3041, 17028, 330.000, '2019-08-07');

-- Compra producto
DELIMITER $$
Create Procedure ModCompraProducto(
in pFacturaCompra int,
in pIDproveedor int,
in pFacturaPedido int,
in pFechaCompra Datetime,
in pMontoCompra decimal,
in pReciboColector char(15),
in pEstatus char(15),
in pObservacion char(30),
in pFechaVencPago date,
in pDescuento decimal
) 
Begin
UPDATE CompraProducto SET 
IDproveedor = pIDproveedor,
FacturaPedido = pFacturaPedido, 
FechaCompra = pFechaCompra, 
MontoCompra = pMontoCompra, 
ReciboColector = pReciboColector,
Status =  pEstatus,
Observacion = pObservacion ,
FechaVencPago = pFechaVencPago, 
Descuento = pDescuento
Where FacturaCompra = pFacturaCompra;
End $$

Call ModCompraProducto ('3001', '9001', '1001', '2016-02-25', '150.000', '5001', 'Credito', '-', '2016-01-01', 0)

--Detalle Compra
DELIMITER $$
Create Procedure ModDetalleCompraProducto(
in pFacturaCompraProducto int,
in pIDproducto int,
in pCantidadUnidades int,
in pPrecioxUnidad decimal)
Begin
UPDATE DetalleCompraProducto SET
IDproducto = pIDproducto,
CantidadUnidades = pCantidad,
PrecioxUnidad = pPrecioxUnidad
Where FacturaCompraProducto = pFacturaCompraProducto;
END $$

Call ModDetalleCompraProducto ('1101', '1012', '255', '4.000')

-- DetalleFactura
DELIMITER $$
Create procedure ModDetalleFactura(
in pNofactura int,
in pFacturaCompraProducto int,
in pIDproducto int,
in pIDLote int,
in pDescripcion char(30),
in pPrecioUnitario decimal,
in pCantidad int, 
in pTotal decimal)
Begin 
UPDAte DetalleFactura SET
Descripcion = pDescripcion,
PrecioUnitario = pPrecioUnitario,
Cantidad = pCantidad,
Total = pTotal
where Nofactura = pNofactura AND FacturaCompraProducto = pFacturaCompraProducto AND IDproducto = pIDproducto AND IDLote = pIDLote;
END $$
Call ModDetalleFactura ('6001', '1044', '84763', '-', '69.000', '10', '690.000');

-- Detalle Pedido
DELIMITER $$
Create Procedure ModDetallePedido(
in pIDproveedor int,
in pIDproducto int,
in pCantidadUnidad int,
in pMontoxUnidad decimal)
Begin
UPDATE DetallePedido SET
CantidadUnidad = pCantidadUnidad,
MontoxUnidad = pMontoxUnidad
where IDproveedor = pIDproveedor AND IDpedido = pIDpedido AND IDproducto = pIDproducto;
END $$
Call ModDetallePedido ('2201', '1092', '27', '243.000');

--Detalle Producto
DELIMITER $$
Create procedure ModDetalleProducto(
in pIDproducto int,
in pIDlote int,
in pFechaVenc datetime,
in pPrecioUnitario decimal,
in pPrecioVenta decimal)
Begin
UPDATE DetalleProducto SET
FechaVenc = pFechaVenc,
PrecioUnitario = pPrecioUnitario,
PrecioVenta = pPrecioventa
where IDproducto = pIDproducto AND IDlote = pIDlote;
END $$

Call ModDetalleProducto ('1001', '81329', '2018-10-29 12:52:44', '63.000', '22.050');

--Empleado 
DELIMITER $$
Create procedure ModEmpleado (
in pIDempleado int,
in pCedulaEmpleado int,
in pNombre char(50),
in pUsuario char(15),
in pPass char(10))
Begin
UPDATE Empleado SET
CedulaEmpleado = pCedulaEmpleado,
Nombre = pNombre,
Usuario = pUsuario,
Pass = pPass
where IDempleado = pIDempleado;
END $$

Call ModEmpleado ('1', '001-130599-1007K', 'Francisco Silva', 'FSilva', '1234')

-- Enfermedad
DELIMITER $$
Create procedure ModEnfermedad(
in pIDenfermedad int,
in pDescripcion char(50) )
Begin 
UPDATE Enfermedad SET
Descripcion = pDescripcion
where IDenfermedad = pIDenfermedad;
END $$
Call ModEnfermedad (5024, 'Sinusitis')

-- Factura
DELIMITER $$
Create Procedure ModFactura(
in pIDfactura int,
in pIDempleado int,
in pFecha datetime)
Begin
UPDATE Factura SET
IDempleado  = pIDempleado,
Fecha = pFecha
where IDfactura = pIDfactura;
END $$

Call ModFactura ('6001', '2', '23-06-19' )

-- Indicacion
DELIMITER $$
Create Procedure ModIndicacion(
in pIDindicacion int,
in pDescripcion char(50) )
Begin 
UPDATE Indicacion SET
Descripcion = pDecripcion
where IDindicacion = pIDindicacion;
END $$

Call ModIndicacion ('7001', 'Mayores de doce años')

-- IndicacionProducto
DELIMITER $$
Create Procedure ModIndicacionProducto(
in pIDproducto int,
in pIDindicacion int)
Begin
UPDATE IndicacionProducto SET
IDproducto = pIDproducto,
IDindicacion = pIDindicacion
Where IDproducto = pIDproducto AND IDindicacion = pIDindicacion;
END $$
Call ModIndicacionProducto ('1001', '7002')

-- InventarioProducto
DELIMITER $$
Create Procedure ModInventarioProducto(
in pFacturaCompra int,
in pIDproducto int,
in pCantidadUnidades int,
in pMontoxUnidad decimal(13,3),
in pGanancia decimal(13,3),
in pPrecioUnitario decimal(13,3),
in pStockBodega int,
in pStockEstante int)
Begin
UPDATE InventarioProducto SET
CantidadUnidades = pCantidadUnidades,
MontoxUnidad = pMontoxUnidad,
Ganancia = pGanancia,
PrecioUnitario = pPrecioUnitario,
StockBodega = pStockBodega,
StockEstante = pStockEstante
Where FacturaCompra = pFacturaCompra AND IDproducto = pIDproducto;
END $$
-- Call ModInventarioProducto ('8001', '10-01-2020')

-- PagoServicios
DELIMITER $$
Create Procedure ModPagos(
in pIDPagos int,
in pIDempleado int,
in pTipoPago char(40),
in pMontoPago decimal,
in pFechaPago datetime)
Begin
UPDATE PagoServicios SET
IDempleado = pIDempleado ,
TipoPago = pTipoPago,
MontoPago = pMontoPago,
FechaPago = pFechaPago
where IDPagos = pIDPagos;
END $$
Call ModPagoServicios ('1601', '1', 'Luz', '1072.000', '2018-09-14 01:26:52')

-- Pedido
DELIMITER $$
Create Procedure ModPedido(
in pFacturaPedido int,
in pIDproveedor int,
in pIDempleado int,
in pFechaPedido datetime,
in pMontoPedido decimal)
Begin
UPDATE Pedido SET
IDempleado = pIDempleado,
IDproveedor = pIDproveedor,
FechaPedido = pFechaPedido,
MontoPedido = pMontoPedido
Where FacturaPedido = pFacturaPedido;
END $$
Call ModPedido ('2201', '17002', '2', '2019-07-09 17:06:01', '1665.000')

--Perdida producto
DELIMITER $$
Create Procedure ModPerdidaProducto(
in pIDperdida int,
in pFacturaCompraPedido int,
in pIDproductos int,
in pCantidadUnidades int,
in pMontoPerdido decimal)
Begin
UPDATE Producto Set
FacturaCompraPedido = pFacturaCompraPedido,
IDproductos = pIDproductos,
CantidadUnidades = pCantidad,
MontoPerdido = pCantidadUnidades
Where IDperdida = pIDperdida ;
END $$
Call ModPerdidaProducto (2301, 3010, 1010,6, '200.000')
drop procedure ModProducto;
-- Producto
DELIMITER $$
Create Procedure ModProducto(
in pIDproducto int,
in pNombre char(30),
in pForma_farmaceutica char(20),
in pDosis_Contenido int,
in pUnidad_medida varchar(10),
in pRestriccion bit,
in pGenerico bit,
in pDescontinuado bit)
Begin
UPDATE Producto Set
Nombre = pNombre,
Forma_farmaceutica = pForma_farmaceutica,
Dosis_Contenido = pDosis_Contenido,
Unidad_medida = pUnidad_medida,
Restriccion = pRestriccion,
Generico = pGenerico,
Descontinuado = pDescontinuado
Where IDproducto = pIDproducto;
END $$
Call ModProducto(1001, 'Acetaminophen', 'Gotas', '30.000', 'ml', 0, 1, 0) 

-- Proveedor
DELIMITER $$
Create procedure ModProveedor(
in pIDproveedor int,
in pTipo_proveedor char(20),
in pNombre_proveedor char(30),
in ptel1 char(8),
in ptel2 char(8))
Begin
UPDATE Proveedor SET	
Tipo_proveedor = pTipo_proveedor,
Nombre_proveedor = pNombre_proveedor,
tel1 = ptel1,
tel2 = ptel2
where IDproveedor = pIDproveedor;
END $$ 

Call ModProveedor ('17008', 'Laboratorio', 'Rarpe', '87249035', '50549373')

-- UtilidadProducto
DELIMITER $$
Create procedure ModUtilidadProducto(
in pIDproducto int,
in pIDenfermedad int)
Begin
UPDATE UtilidadProducto SET
IDproducto = pIDproducto,
IDenfermedad = pIDenfermedad;
END $$

Call ModUtilidadProducto (2104, 1039, 5025)

-- Procedimienti para restar la cantidad de unidades en inventario si se realiza una venta
DELIMITER $$
CREATE PROCEDURE ModRestarInventario(
in pFacturaCompra int,
in pIDproducto int,
in pCantidad int,
in pCantidadUnidades int
)
Begin
UPDATE InventarioProducto I INNER JOIN DetalleFactura DF on I.FacturaCompra = DF.FacturaCompra AND
I.IDproducto = DF.IDproducto SET
I.CantidadUnidades = pCantidad,
DF.Cantidad = pCantidadUnidades,
DF.Total = pCantidadUnidades * DF.PrecioUnitario,
I.CantidadUnidades = pCantidad - pCantidadUnidades,
I.StockEstante  = I.StockEstante - pCantidadUnidades,
I.Subtotal = I.CantidadUnidades * I.PrecioVentaUnitario
Where I.FacturaCompra = pFacturaCompra AND DF.FacturaCompra = pFacturaCompra AND
I.IDproducto = pIDproducto AND DF.IDproducto = pIDproducto;
END $$
call ModRestarInventario (3081, 1027, 8, 2)

-- Procedimiento para recalcular el subtotal si se cambia la cantidad de unidades en el inventario
DELIMITER $$
Create Procedure ModcalcularProducto(
in pFacturaCompra int,
in pIDproducto int,
in pCantidadUnidades int,
in pPrecioVentaUnitario decimal(13,3),
in pSubtotal decimal(13,3)
)
Begin
UPDATE InventarioProducto SET
CantidadUnidades = pCantidadUnidades,
PrecioVentaUnitario = pPrecioVentaUnitario,
Subtotal = pSubtotal,
Subtotal = CantidadUnidades * PrecioVentaUnitario
Where FacturaCompra = pFacturaCompra AND IDproducto = pIDproducto;
END $$
Call ModcalcularProducto(3081, 1027, 7, 85.000, 255)

-- Procedimiento para saber el monto perdido, el subtotal y cantidad de producto de inventario 
-- cuando se modifique la cantidad de unidades perdidas
DELIMITER $$
CREATE PROCEDURE ModCantPerdidas(
in pIDperdidda int,
in pFacturaCompra int,
in pIDproducto int,
in pCantidadUnidades int,
in pCantidadPerdida int)
Begin
UPDATE InventarioProducto I INNER JOIN PerdidaProducto PP on I.FacturaCompra = PP.FacturaCompra AND
I.IDproducto = PP.IDproducto SET 
PP.CantidadUnidades = pCantidadPerdida,
PP.MontoPerdido = I.PrecioVentaUnitario * pCantidadPerdida,
I.CantidadUnidades = pCantidadUnidades - pCantidadPerdida,
I.StockEstante  = I.StockEstante - pCantidadPerdida,
I.Subtotal = I.CantidadUnidades * I.PrecioVentaUnitario
Where PP.IDperdida = pIDperdidda AND I.FacturaCompra = pFacturaCompra AND PP.FacturaCompra = pFacturaCompra AND
I.IDproducto = pIDproducto AND PP.IDproducto = pIDproducto;
END $$
Call ModCantPerdidas(2001, 3081, 1027, 6, 3);

-- Proceso para modificar la cantidad de productos pedido y recalcular el monto del pedido
DELIMITER $$
Create Procedure ModcalcularMontoPedido(
in pFacturaPedido int,
in pIDproducto int,
in pCantidadUnidad int
)
Begin
UPDATE  Pedido p INNER JOIN DetallePedido DP on P.FacturaPedido = DP.FacturaPedido SET 
DP.CantidadUnidad = pCantidadUnidad,
P.MontoPedido = pCantidadUnidad * DP.MontoxUnidad
Where P.FacturaPedido = pFacturaPedido AND DP.FacturaPedido = pFacturaPedido AND DP.IDproducto = pIDproducto ;
END $$
Call ModcalcularMontoPedido(2001, 1001, 15)
