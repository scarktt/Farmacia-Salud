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
	CedulaEmpleado Integer NOT NULL,
	Nombre Char(30) NULL,
	Usuario Char(15) NULL,
	Pass Char(8) NULL,
Primary Key (IDempleado)
); 


Create table Producto
(
	IDproducto Integer NOT NULL,
	Nombre Char(30) NULL,
	Forma_farmaceutica Char(20) NULL,
	Dosis-Contenido Integer NULL,
	Unidad_medida Char(10) NULL,
	Restriccion Bit NULL,
	Generico Bit NULL,
	Descontinuado Bit NULL,
	StockBodega Integer NULL,
	StockEstante Integer NULL,
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


Create table CompraPedido
(
	FacturaCompraPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	FacturaPedido Integer NOT NULL,
	FechaCompra Datetime NULL,
	MontoCompra Decimal (13,3) NULL,
	ReciboColector Char(8) NULL,
	Status Char(10) NULL,
	Observacion Char(30) NULL,
	FechaVencPa Char(1) NULL,
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
	IDproducto Integer NOT NULL,
	IDLote Integer NOT NULL,
	PrecioUnitario Decimal (13,3) NULL,
	Cantidad Integer NULL,
	Total Decimal (13,3) NULL,
Primary Key (NoFactura,IDproducto,IDLote)
); 


Create table Enfermedad
(
	IDenfermedad Integer NOT NULL,
	Descripcion Char(10) NULL,
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


Create table DetalleCompraPedido
(
	FacturaCompraPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidad Integer NOT NULL,
	MontoxUnidad Decimal (13,3) NULL,
Primary Key (FacturaCompraPedido)
); 


Create table Lote
(
	IDLote Integer NOT NULL,
	Fecha_venc Datetime NULL,
Primary Key (IDLote)
); 


Create table PaServicios
(
	IDPaServicios Integer NOT NULL,
	IDempleado Integer NOT NULL,
	TipodePaServicios Char(40) NULL,
	PaServicio Decimal (13,3) NULL,
	FechaPa Datetime NULL,
Primary Key (IDPaServicios)
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
	CantidadUnidad Integer NULL,
	MontoxUnidad Decimal (13,3) NULL,
	EsProductoNuevo Bit NULL,
Primary Key (FacturaPedido,IDproducto)
); 


Create table DetalleProducto
(
	IDproducto Integer NOT NULL,
	IDLote Integer NOT NULL,
	FechaVenc Datetime NULL,
	PrecioVenta Decimal (13,3) NULL,
	PrecioUnitario Decimal (13,3) NULL,
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
	FacturaCompraPedido Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	SaldoAbono Decimal (13,3) NULL,
Primary Key (FacturaCompraPedido,IDproveedor)
); 






















