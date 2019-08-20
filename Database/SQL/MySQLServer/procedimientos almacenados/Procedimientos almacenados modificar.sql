Use FarmaciaMasS
DELIMITER $$
CREATE PROCEDURE spCompraProductoEliminar (
    IN IDcompra INT,
    IN IDpedido INT,
    IN IDproveedor INT,
    IN IDproducto INT
) 
BEGIN
   DELETE FROM dbo.CompraProducto 
    WHERE   IDcompra = @IDcompra AND
            IDpedido = @IDpedido AND
            IDproveedor = @IDproveedor AND
            IDproducto = @IDproducto;
END $$
DELIMITER $$
-- Compra producto
DELIMITER $$
Create Procedure ModCompraProducto(
in IDcompra int,
in IDpedido int,
in IDproveedor int,
in IDproducto int,
in Fecha_compra Datetime,
in Num_factura int,
in Monto decimal,
in Cantidad int, 
in Descuento float)
Begin
UPDATE CompraProducto SET
IDpedido = @IDpedido,
IDproveedor = @IDproveedor,
IDproducto = @IDproducto,
Fecha_compra = @Fecha_compra,
Num_factura = @Num_factura,
Monto = @Monto,
Cantidad = @Cantidad, 
Descuento = @Descuento
Where IDcompra = @IDcompra;

End $$

Call ModCompraProducto ('3001', '13005', '17012', '1002', '12-03-2019', '532123' , 150, 30, 0.03);

--Detalle Compra
DELIMITER $$
Create Procedure ModDetalleCompra(
in IDdetallecompra int,
in Idcompra int,
in IDproducto int,
in Cantidad int,
in Costo decimal)
Begin
UPDATE DetalleCompra SET
Idcompra = @IDcompra,
IDproducto = @IDproducto,
Cantidad = @Cantidad,
Costo = @Costo
Where IDdetallecompra = @IDdetallecompra;
END $$

Call ModDetalleCompra ('110001', '3004', '1023', 25, 100)

-- DetalleFactura
DELIMITER $$
Create procedure ModDetalleFactura(
in IDfactura int,
in IDproducto int,
in PrecioUnitario decimal,
in Cantidad int, 
in Total decimal)
Begin 
UPDAte DetalleFactura SET
PrecioUnitario = @PrecioUnitario,
Cantidad = @Cantidad,
Total = @Total

where IDfactura = @IDfactura AND IDproducto = @IDproducto;
END $$

Call ModDetalleFactura ('12001', '1003', 50, 5, 250);


-- Detalle Pedido
DELIMITER $$
Create Procedure ModDetallePedido(
in IDproveedor int,
in IDpedido int,
in Cantidad int,
in Monto decimal,
in IDproducto int)
Begin
UPDATE DetallePedido SET
Cantidad = @Cantidad,
Monto = @Monto
where IDproveedor = @IDproveedor AND IDpedido = @IDpedido AND IDproducto = @IDproducto;
END $$
Call ModDetallePedido ('17001', '9001', 25, 100, '1001');

--Detalle Producto
DELIMITER $$
Create procedure ModDetalleProducto(
in IDproducto int,
in IDlote int,
in FechaVenc datetime,
in Precioventa decimal,
in PrecioUnitario decimal)
Begin
UPDATE DetalleProducto SET
FechaVenc = @FechaVenc,
PrecioVenta = @Precioventa,
PrecioUnitario = @PrecioUnitario
where IDproducto = @IDproducto AND IDlote = @IDlote;
END $$

Call ModDetalleProducto ('1001', '8001', '25-05-19', 250, 25);

--Empleado 
DELIMITER $$
Create procedure ModEmpleado (
in IDempleado int,
in Nombre char(50),
in Salario decimal)
Begin
UPDATE Empleado SET
Nombre = @Nombre,
Salario = @Salario
where IDempleado = @IDempleado;
END $$

Call ModEmpleado ('1', 'Maria Castillo', 7000)

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

Call ModEnfermedad ('5024', 'Sinusitis')

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
Create Procedure ModLote(
in IDLote int,
in Fecha_venc datetime)
Begin
UPDATE Lote SET
Fecha_Venc = @Fecha_venc
Where IDLote = @IDLote;
END $$
Call ModLote ('8001', '10-01-2020')

-- PagoServicios
DELIMITER $$
Create Procedure ModPagoServicios(
in IDPagoServicios int,
in IDempleado int,
in TipodePagoServicios char(40),
in PagoServicio decimal,
in FechaPago datetime)
Begin
UPDATE PagoServicios SET
IDempleado = @IDempleado ,
TipodePagoServicios = @TipodePagoServicios,
PagoServicio = @PagoServicio,
FechaPago = @FechaPago
where IDPagoServicios = @IDPagoServicios ;
END $$
Call ModPagoServicios ('16001', '1', 'Luz', 361, '23-06-19')

-- Pedido
DELIMITER $$
Create Procedure ModPedido(
in IDempleado int,
in IDpedido int,
in Fecha datetime)
Begin
UPDATE Pedido SET
IDempleado = @IDempleado,
Fecha = @Fecha
Where IDpedido = @IDpedido;
END $$
Call ModPedido ('1', '9001', '14-07-19')

-- Producto
DELIMITER $$
Create Procedure ModProducto(
in IdProducto varchar(20),
in Nombre char(20),
in Forma_farmaceutica varchar(20),
in Restriccion bit,
in UnidadMedida varchar(10),
in Descontinuado bit,
in Generico bit,
in StockBodega int,
in StockEstante int)
Begin
UPDATE Producto Set
Nombre = @Nombre,
Forma_farmaceutica = @Forma_farmaceutica,
Restriccion = @Restriccion,
Unidad_medida = @UnidadMedida,
Descontinuado = @Descontinuado,
Generico = @Generico,
StockBodega = @StockBodega,
StockEstante = @StockEstante
Where IdProducto = @IdProducto;
END $$
Call ModProducto ('1003', 'Mucolex', 'Jarabe', 0, 99.1500, 110.0000, '100 ml', 0, 0)

-- Proveedor
DELIMITER $$
Create procedure ModProveedor(
in IDproveedor int,
in Tipo_proveedor char(20),
in Nombre_proveedor char(30))
Begin
UPDATE Proveedor SET	
Tipo_proveedor = @Tipo_proveedor,
Nombre_proveedor = @Nombre_proveedor
where IDproveedor = @IDproveedor;
END $$

Call ModProveedor (17001, 'Laboratorio', 'Unifarm')

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

Call ModUtilidadProducto (1018, 10004)