/*
Created		25/03/2019
Modified		25/08/2019
Project
Model
Company
Author
Version
Database		MS SQL 2005
*/

Create table Abono
(
	IDabono Integer NOT NULL,
	FacturaCompraPedido Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	SaldoAbono Decimal(13,3) NULL,
Primary Key (IDabono,FacturaCompraPedido,IDproveedor)
);

Create table Empleado
(
	IDempleado Integer NOT NULL,
	CedulaEmpleado Char(16) NOT NULL,
	Nombre Char(30) NULL,
	Usuario Char(10) NULL,
	Pass Char(8) NULL,
Primary Key (IDempleado)
);


Create table Producto
(
	IDproducto Integer NOT NULL,
	Nombre Char(30) NULL,
	Forma_farmaceutica Char(20) NULL,
	Dosis_Contenido Integer NULL,
	Unidad_medida Char(10) NULL,
	Restriccion Bit NULL,
	Generico Bit NULL,
	Descontinuado Bit NULL,
Primary Key (IDproducto)
);


Create table Proveedor
(
	IDproveedor Integer NOT NULL,
	Tipo_proveedor Char(20) NULL,
	Nombre_proveedor Char(30) NULL,
	tel1 Char(8) NULL,
	tel2 Char(8) NULL,
Primary Key (IDproveedor)
);


Create table Compra
(
	FacturaCompraPedido Integer NOT NULL,
	FacturaPedido Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	FechaCompra Datetime NULL,
	MontoCompra Decimal(13,3) NULL,
	ReciboColector Char(8) NULL,
	Status Char(10) NULL,
	Observacion Char(30) NULL,
	FechaVencPa Datetime NULL,
	Descuento Decimal(1,3) NULL,
Primary Key (FacturaCompraPedido)
);


Create table Factura
(
	NoFactura Integer NOT NULL,
	IDempleado Integer NOT NULL,
	Fecha Datetime NULL,
Primary Key (NoFactura)
);


Create table DetalleFactura
(
	NoFactura Integer NOT NULL,
	FacturaCompraPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	Descripcion Char(30) NULL,
	PrecioUnitario Decimal(13,3) NULL,
	Cantidad Integer NULL,
	Total Decimal(13,3) NULL,
Primary Key (NoFactura,FacturaCompraPedido,IDproducto)
);


Create table Enfermedad
(
	IDenfermedad Integer NOT NULL,
	Descripcion Char(15) NULL,
Primary Key (IDenfermedad)
);


Create table UtilidadProducto
(
	IDproducto Integer NOT NULL,
	IDenfermedad Integer NOT NULL,
Primary Key (IDproducto,IDenfermedad)
);


Create table Indicacion
(
	IDindicacion Integer NOT NULL,
	Descripcion Char(20) NULL,
Primary Key (IDindicacion)
);


Create table IndicacionProducto
(
	IDproducto Integer NOT NULL,
	IDindicacion Integer NOT NULL,
Primary Key (IDproducto,IDindicacion)
);


Create table PagoServicios
(
	IDPagoServicios Integer NOT NULL,
	IDempleado Integer NOT NULL,
	TipodePaServicios Char(40) NULL,
	PaServicio Decimal(13,3) NULL,
	FechaPa Datetime NULL,
Primary Key (IDPagoServicios)
);


Create table Pedido
(
	FacturaPedido Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	IDempleado Integer NOT NULL,
	FechaPedido Datetime NULL,
	MontoPedido Decimal(13,3) NULL,
Primary Key (FacturaPedido)
);


Create table DetallePedido
(
	FacturaPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidad Integer NULL,
	MontoxUnidad Decimal(13,3) NULL,
Primary Key (FacturaPedido,IDproducto)
);


Create table PerdidaProducto
(
	IDperdida Integer NOT NULL,
	FacturaCompraPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidades Integer NULL,
	MontoPerdido Decimal(13,3) NULL,
Primary Key (IDperdida)
);


Create table InventarioProducto
(
	FacturaCompraPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidades Integer NULL,
	MontoxUnidad Decimal(13,3) NULL,
	Ganancia Decimal(1,3) NULL,
	PrecioVenta Decimal(13,3) NULL,
	PrecioUnitario Decimal(13,3) NULL,
	StockBodega Integer NULL,
	StockEstante Integer NULL,
Primary Key (FacturaCompraPedido,IDproducto)
);
