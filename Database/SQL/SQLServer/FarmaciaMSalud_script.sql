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



















Create table [Empleado]
(
	[IDempleado] Integer NOT NULL,
	[CedulaEmpleado] Integer NOT NULL,
	[Nombre] Char(30) NULL,
	[Usuario] Char(15) NULL,
	[Pass] Char(8) NULL,
Primary Key ([IDempleado])
) 
go

Create table [Producto]
(
	[IDproducto] Integer NOT NULL,
	[Nombre] Char(30) NULL,
	[Forma_farmaceutica] Char(20) NULL,
	[Dosis-Contenido] Integer NULL,
	[Unidad_medida] Char(10) NULL,
	[Restriccion] Bit NULL,
	[Generico] Bit NULL,
	[Descontinuado] Bit NULL,
	[StockBodega] Integer NULL,
	[StockEstante] Integer NULL,
Primary Key ([IDproducto])
) 
go

Create table [Proveedor]
(
	[IDproveedor] Integer NOT NULL,
	[Tipo_proveedor] Char(20) NULL,
	[Nombre_proveedor] Char(30) NULL,
	[tel1] Char(8) NULL,
	[tel2] Char(8) NULL,
Primary Key ([IDproveedor])
) 
go

Create table [CompraPedido]
(
	[FacturaCompraPedido] Integer NOT NULL,
	[IDproducto] Integer NOT NULL,
	[FacturaPedido] Integer NOT NULL,
	[FechaCompra] Datetime NULL,
	[MontoCompra] Money NULL,
	[ReciboColector] Char(8) NULL,
	[Status] Char(10) NULL,
	[Observacion] Char(30) NULL,
	[FechaVencPago] Char(1) NULL,
Primary Key ([FacturaCompraPedido])
) 
go

Create table [Factura]
(
	[NoFactura] Integer NOT NULL,
	[IDempleado] Integer NOT NULL,
	[Fecha] Datetime NULL,
Primary Key ([NoFactura])
) 
go

Create table [DetalleFactura]
(
	[NoFactura] Integer NOT NULL,
	[IDproducto] Integer NOT NULL,
	[IDLote] Integer NOT NULL,
	[PrecioUnitario] Money NULL,
	[Cantidad] Integer NULL,
	[Total] Money NULL,
Primary Key ([NoFactura],[IDproducto],[IDLote])
) 
go

Create table [Enfermedad]
(
	[IDenfermedad] Integer NOT NULL,
	[Descripcion] Char(10) NULL,
Primary Key ([IDenfermedad])
) 
go

Create table [UtilidadProducto]
(
	[IDproducto] Integer NOT NULL,
	[IDenfermedad] Integer NOT NULL,
Primary Key ([IDproducto],[IDenfermedad])
) 
go

Create table [Indicacion]
(
	[IDindicacion] Integer NOT NULL,
	[Descripcion] Char(20) NULL,
Primary Key ([IDindicacion])
) 
go

Create table [IndicacionProducto]
(
	[IDproducto] Integer NOT NULL,
	[IDindicacion] Integer NOT NULL,
Primary Key ([IDproducto],[IDindicacion])
) 
go

Create table [DetalleCompraPedido]
(
	[FacturaCompraPedido] Integer NOT NULL,
	[IDproducto] Integer NOT NULL,
	[CantidadUnidad] Integer NOT NULL,
	[MontoxUnidad] Money NULL,
Primary Key ([FacturaCompraPedido])
) 
go

Create table [Lote]
(
	[IDLote] Integer NOT NULL,
	[Fecha_venc] Datetime NULL,
Primary Key ([IDLote])
) 
go

Create table [PagoServicios]
(
	[IDPagoServicios] Integer NOT NULL,
	[IDempleado] Integer NOT NULL,
	[TipodePagoServicios] Char(40) NULL,
	[PagoServicio] Money NULL,
	[FechaPago] Datetime NULL,
Primary Key ([IDPagoServicios])
) 
go

Create table [Pedido]
(
	[FacturaPedido] Integer NOT NULL,
	[IDproveedor] Integer NOT NULL,
	[IDempleado] Integer NOT NULL,
	[FechaPedido] Datetime NULL,
	[MontoPedido] Money NULL,
Primary Key ([FacturaPedido])
) 
go

Create table [DetallePedido]
(
	[FacturaPedido] Integer NOT NULL,
	[IDproducto] Integer NOT NULL,
	[CantidadUnidad] Integer NULL,
	[MontoxUnidad] Money NULL,
	[EsProductoNuevo] Bit NULL,
Primary Key ([FacturaPedido],[IDproducto])
) 
go

Create table [DetalleProducto]
(
	[IDproducto] Integer NOT NULL,
	[IDLote] Integer NOT NULL,
	[FechaVenc] Datetime NULL,
	[PrecioVenta] Money NULL,
	[PrecioUnitario] Money NULL,
Primary Key ([IDproducto],[IDLote])
) 
go

Create table [PerdidaProducto]
(
	[IDproducto] Integer NOT NULL,
	[IDLote] Integer NOT NULL,
	[IDperdida] Integer NOT NULL,
	[Cantidad] Integer NULL,
	[MontoPerdido] Money NULL,
Primary Key ([IDproducto],[IDLote],[IDperdida])
) 
go

Create table [Abono]
(
	[FacturaCompraPedido] Integer NOT NULL,
	[IDproveedor] Integer NOT NULL,
	[SaldoAbono] Money NULL,
Primary Key ([FacturaCompraPedido],[IDproveedor])
) 
go





Set quoted_identifier on
go









Set quoted_identifier off
go





