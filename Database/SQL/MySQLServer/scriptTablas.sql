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
	FacturaCompra Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	SaldoAbono Decimal(13,3) NOT NULL,
	Fecha Datetime NOT NULL,
Primary Key (IDabono,FacturaCompra,IDproveedor)
);

Create table Empleado
(
	IDempleado Integer NOT NULL,
	CedulaEmpleado Char(16) NULL,
	Nombre Char(30) NOT NULL,
	Usuario Char(10) NOT NULL,
	Pass Char(8) NOT NULL,
	Rol Char(8) NOT NULL,
Primary Key (IDempleado)
);


Create table Producto
(
	IDproducto Integer NOT NULL,
	Nombre Char(30) NOT NULL,
	Forma_farmaceutica Char(20) NOT NULL,
	Dosis_Contenido Integer NOT NULL,
	Unidad_medida Char(10) NOT NULL,
	Restriccion Bit NULL,
	Generico Bit NOT NULL,
	Descontinuado Bit NULL,
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


Create table Compra
(
	FacturaCompra Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	FacturaPedido Integer NOT NULL,
	FechaCompra Datetime NOT NULL,
	MontoCompra Decimal(13,3) NOT NULL,
	ReciboColector Char(8) NULL,
	Status Char(10) NOT NULL,
	Observacion Char(30) NULL,
	FechaVencPago Datetime NOT NULL,
	Descuento Decimal(13,3) NULL,
Primary Key (FacturaCompra)
);


Create table Factura
(
	NoFactura Integer NOT NULL,
	IDempleado Integer NOT NULL,
	Fecha Datetime NOT NULL,
Primary Key (NoFactura)
);


Create table DetalleFactura
(
	NoFactura Integer NOT NULL,
	FacturaCompra Integer NOT NULL,
	IDproducto Integer NOT NULL,
	Descripcion Char(30) NOT NULL,
	PrecioUnitario Decimal(13,3) NOT NULL,
	Cantidad Integer NOT NULL,
	Total Decimal(13,3) NOT NULL,
Primary Key (NoFactura,FacturaCompra,IDproducto)
);


Create table Enfermedad
(
	IDenfermedad Integer NOT NULL,
	Descripcion Char(35) NOT NULL,
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
	Descripcion Char(35) NOT NULL,
Primary Key (IDindicacion)
);


Create table IndicacionProducto
(
	IDproducto Integer NOT NULL,
	IDindicacion Integer NOT NULL,
Primary Key (IDproducto,IDindicacion)
);


Create table Pagos
(
	IDPagos Integer NOT NULL,
	IDempleado Integer NOT NULL,
	TipoPago Char(40) NULL,
	MontoPago Decimal(13,3) NOT NULL,
	FechaPago Datetime NOT NULL,
Primary Key (IDPagos)
);


Create table Pedido
(
	FacturaPedido Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	IDempleado Integer NOT NULL,
	FechaPedido Datetime NOT NULL,
	MontoPedido Decimal(13,3) NOT NULL,
Primary Key (FacturaPedido)
);


Create table DetallePedido
(
	FacturaPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	IDproveedor Integer NOT NULL,
	CantidadUnidad Integer NOT NULL,
	MontoxUnidad Decimal(13,3) NOT NULL,
Primary Key (FacturaPedido,IDproducto)
);


Create table PerdidaProducto
(
	IDperdida Integer NOT NULL,
	FacturaCompraPedido Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidades Integer NOT NULL,
	MontoPerdido Decimal(13,3) NOT NULL,
Primary Key (IDperdida)
);


Create table InventarioProducto
(
	FacturaCompra Integer NOT NULL,
	IDproducto Integer NOT NULL,
	CantidadUnidades Integer NOT NULL,
	MontoxUnidad Decimal(13,3) NOT NULL,
	Ganancia Decimal(13,3) NOT NULL,
	PrecioVentaUnitario Decimal(13,3) NOT NULL,
	StockBodega Integer NOT NULL,
	StockEstante Integer NOT NULL,
Primary Key (FacturaCompra,IDproducto)
);
