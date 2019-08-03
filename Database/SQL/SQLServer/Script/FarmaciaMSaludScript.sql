Create table [Empleado]
(
	[IDempleado] Integer NOT NULL,
	[Nombre] Char(50) NULL,
Primary Key ([IDempleado])
)
go

Create table [Producto]
(
	[IDproducto] Integer NOT NULL,
	[Nombre] Char(30) NULL,
	[Forma_farmaceutica] Char(20) NULL,
	[Restriccion] Bit NULL,
	[Unidad_medida] Char(10) NULL,
	[Descontinuado] Bit NULL,
	[Generico] Bit NULL,
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
Primary Key ([IDproveedor])
)
go

Create table [CompraProducto]
(
	[IDcompra] Integer NOT NULL,
	[IDpedido] Integer NOT NULL,
	[IDproveedor] Integer NOT NULL,
	[IDproducto] Integer NOT NULL,
	[Fecha_compra] Datetime NULL,
	[Num_factura] Integer NULL,
	[Monto] Money NULL,
	[Cantidad] Integer NULL,
	[Descuento] Float NULL,
Primary Key ([IDcompra])
)
go

Create table [Factura]
(
	[IDfactura] Integer NOT NULL,
	[IDempleado] Integer NOT NULL,
	[Fecha] Datetime NULL,
Primary Key ([IDfactura])
)
go

Create table [DetalleFactura]
(
	[IDfactura] Integer NOT NULL,
	[IDproducto] Integer NOT NULL,
	[PrecioUnitario] Money NULL,
	[Cantidad] Integer NULL,
	[Total] Money NULL,
Primary Key ([IDfactura],[IDproducto])
)
go

Create table [Enfermedad]
(
	[IDenfermedad] Integer NOT NULL,
	[Descripcion] Char(50) NULL,
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
	[Descripcion] Char(50) NULL,
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

Create table [DetalleCompra]
(
	[IDdetallecompra] Integer NOT NULL,
	[IDcompra] Integer NOT NULL,
	[IDproducto] Integer NOT NULL,
	[Cantidad] Integer NOT NULL,
	[Costo] Money NULL,
Primary Key ([IDdetallecompra],[IDcompra])
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
	[IDempleado] Integer NOT NULL,
	[IDpedido] Integer NOT NULL,
	[Fecha] Datetime NULL,
Primary Key ([IDpedido])
)
go

Create table [DetallePedido]
(
	[IDproveedor] Integer NOT NULL,
	[IDpedido] Integer NOT NULL,
	[Cantidad] Integer NULL,
	[Monto] Money NULL,
	[IDproducto] Integer NOT NULL,
Primary Key ([IDproveedor],[IDpedido],[IDproducto])
)
go

Create table [DetalleProducto]
(
	[IDproducto] Integer NOT NULL,
	[IDLote] Integer NOT NULL,
	[FechaVenc] Datetime NULL,
	[PrecioVenta] Money NULL,
	[PrecioUnitario] Money NULL,
Primary Key ([IDproducto])
)
go

Alter table [Factura] add  foreign key([IDempleado]) references [Empleado] ([IDempleado])  on update no action on delete no action
go
Alter table [Pedido] add  foreign key([IDempleado]) references [Empleado] ([IDempleado])  on update no action on delete no action
go
Alter table [PagoServicios] add  foreign key([IDempleado]) references [Empleado] ([IDempleado])  on update no action on delete no action
go
Alter table [UtilidadProducto] add  foreign key([IDproducto]) references [Producto] ([IDproducto])  on update no action on delete no action
go
Alter table [IndicacionProducto] add  foreign key([IDproducto]) references [Producto] ([IDproducto])  on update no action on delete no action
go
Alter table [DetalleProducto] add  foreign key([IDproducto]) references [Producto] ([IDproducto])  on update no action on delete no action
go
Alter table [DetallePedido] add  foreign key([IDproducto]) references [Producto] ([IDproducto])  on update no action on delete no action
go
Alter table [DetalleCompra] add  foreign key([IDproducto]) references [Producto] ([IDproducto])  on update no action on delete no action
go
Alter table [DetallePedido] add  foreign key([IDproveedor]) references [Proveedor] ([IDproveedor])  on update no action on delete no action
go
Alter table [DetalleCompra] add  foreign key([IDcompra]) references [CompraProducto] ([IDcompra])  on update no action on delete no action
go
Alter table [DetalleFactura] add  foreign key([IDfactura]) references [Factura] ([IDfactura])  on update no action on delete no action
go
Alter table [UtilidadProducto] add  foreign key([IDenfermedad]) references [Enfermedad] ([IDenfermedad])  on update no action on delete no action
go
Alter table [IndicacionProducto] add  foreign key([IDindicacion]) references [Indicacion] ([IDindicacion])  on update no action on delete no action
go
Alter table [DetalleProducto] add  foreign key([IDLote]) references [Lote] ([IDLote])  on update no action on delete no action
go
Alter table [DetallePedido] add  foreign key([IDpedido]) references [Pedido] ([IDpedido])  on update no action on delete no action
go
Alter table [CompraProducto] add  foreign key([IDproveedor],[IDpedido],[IDproducto]) references [DetallePedido] ([IDproveedor],[IDpedido],[IDproducto])  on update no action on delete no action
go
Alter table [DetalleFactura] add  foreign key([IDproducto]) references [DetalleProducto] ([IDproducto])  on update no action on delete no action
go

Set quoted_identifier on
go

Set quoted_identifier off
go
