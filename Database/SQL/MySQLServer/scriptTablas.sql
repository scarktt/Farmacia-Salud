/*
Created		25/03/2019
Modified		06/08/2019
Project
Model
Company
Author
Version
Database		MS SQL 2005
*/



Create table Empleado
(
	IDempleado Integer NOT NULL,
	CedulaEmpleado Char(16) NULL,
	Nombre Char(30) NOT NULL,
	Usuario Char(15) NOT NULL,
	Pass Char(10) NOT NULL,
Primary Key (IDempleado)
);


Create table Producto
(
	IDproducto Integer NOT NULL,
	Nombre Char(30) NOT NULL,
	Forma_farmaceutica Char(20) NULL,
	Dosis_Contenido Integer NULL,
	Unidad_medida Char(10) NULL,
	Restriccion Bit NULL,
	Descontinuado Bit NULL,
	Generico Bit NULL,
	StockBodega Integer NOT NULL,
	StockEstante Integer NOT NULL,
Primary Key (IDproducto)
);


Create table Proveedor
(
	IDproveedor Integer NOT NULL,
	Tipo_proveedor Char(20) NULL,
	Nombre_proveedor Char(30) NOT NULL,
	tel1 Char(8) NULL,
	tel2 Char(8) NULL,
Primary Key (IDproveedor)
);


Create table CompraProducto
(
	FacturaCompraProducto Integer NOT NULL,
	FacturaPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	FechaCompra Datetime NULL,
	MontoCompra Decimal (13,3) NULL,
	ReciboColector Integer NULL,
	Status Char(10) NULL,
	Observacion Char(30) NULL,
	FechaVencPago Datetime NULL,
Primary Key (FacturaCompraProducto)
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
	IDproducto Integer NOT NULL,
	IDLote Integer NOT NULL,
	PrecioUnitario Decimal (13,3) NOT NULL,
	Cantidad Integer NOT NULL,
	Total Decimal (13,3) NOT NULL,
Primary Key (NoFactura,IDproducto,IDLote)
);


Create table Enfermedad
(
	IDenfermedad Integer NOT NULL,
	Descripcion Char(30) NOT NULL,
Primary Key (IDenfermedad)
);


Create table UtilidadProducto
(
	IDutilidadProducto Integer NOT NULL,
	IDproducto Integer NOT NULL,
	IDenfermedad Integer NOT NULL,
Primary Key (IDutilidadProducto,IDproducto,IDenfermedad)
);


Create table Indicacion
(
	IDindicacion Integer NOT NULL,
	Descripcion Char(30) NOT NULL,
Primary Key (IDindicacion)
);


Create table IndicacionProducto
(
	IDindicacionProducto Integer NOT NULL,
	IDproducto Integer NOT NULL,
	IDindicacion Integer NOT NULL,
Primary Key (IDindicacionProducto,IDproducto,IDindicacion)
);


Create table DetalleCompraProducto
(
	FacturaCompraProducto Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidades Integer NOT NULL,
	PrecioxUnidad Decimal (13,3) NOT NULL,
Primary Key (FacturaCompraProducto)
);


Create table Lote
(
	IDlote Integer NOT NULL,
	Fecha_venc Datetime NULL,
Primary Key (IDlote)
);


Create table Pagos
(
	IDPagos Integer NOT NULL,
	IDempleado Integer NOT NULL,
	TipoPago Char(40) NULL,
	MontoPago Decimal (13,3) NULL,
	FechaPago Datetime NULL,
Primary Key (IDPagos)
);


Create table Pedido
(
	FacturaPedido Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	IDempleado Integer NOT NULL,
	FechaPedido Datetime NULL,
	MontoPedido Decimal (13,3) NULL,
Primary Key (FacturaPedido)
);


Create table DetallePedido
(
	FacturaPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidad Integer NOT NULL,
	PrecioxUnidad Decimal (13,3) NOT NULL,
	EsProductoNuevo Bit NOT NULL,
Primary Key (FacturaPedido,IDproducto)
);


Create table DetalleProducto
(
	IDproducto Integer NOT NULL,
	IDLote Integer NOT NULL,
	FechaVenc Datetime NULL,
	PrecioUnitario Decimal (13,3) NOT NULL,
	PrecioVenta Decimal (13,3) NOT NULL,
Primary Key (IDproducto,IDLote)
);


Create table PerdidaProducto
(
	IDproducto Integer NOT NULL,
	IDLote Integer NOT NULL,
	IDperdida Integer NOT NULL,
	Cantidad Integer NULL,
	MontoPerdido Decimal (13,3) NULL,
Primary Key (IDproducto,IDLote,IDperdida)
);


Create table Abono
(
	IDabono Integer NOT NULL,
	FacturaCompraProducto Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	SaldoAbono Decimal (13,3) NOT NULL,
Primary Key (IDabono, FacturaCompraProducto,IDproveedor)
);
