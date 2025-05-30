USE [master]
GO
/****** Object:  Database [POOII]    Script Date: 20/04/2025 12:08:22 ******/
CREATE DATABASE [POOII]
GO
USE [POOII]
GO
/****** Object:  Table [dbo].[Alumno]    Script Date: 20/04/2025 12:08:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alumno](
	[IdAlumno] [int] NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Apellido] [varchar](50) NULL,
	[NroDocumento] [varchar](8) NULL,
	[Fechanacimiento] [date] NULL,
	[flgEliminado] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdAlumno] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VentaCab]    Script Date: 20/04/2025 12:08:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VentaCab](
	[IdVenta] [int] NOT NULL,
	[Cliente] [varchar](70) NULL,
	[Nrodocumento] [varchar](15) NULL,
	[FechaVenta] [date] NULL,
	[Subtotal] [decimal](18, 4) NULL,
	[Igv] [decimal](18, 4) NULL,
	[Total] [decimal](18, 4) NULL,
	[flgEliminado] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VentaDet]    Script Date: 20/04/2025 12:08:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VentaDet](
	[IdVentaDet] [int] NOT NULL,
	[Idventa] [int] NULL,
	[Producto] [varchar](100) NULL,
	[Cantidad] [int] NULL,
	[Precio] [decimal](18, 4) NULL,
	[Subtotal] [decimal](18, 4) NULL,
	[Igv] [decimal](18, 4) NULL,
	[Total] [decimal](18, 4) NULL,
	[flgEliminado] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVentaDet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Alumno] ([IdAlumno], [Nombre], [Apellido], [NroDocumento], [Fechanacimiento], [flgEliminado]) VALUES (1, N'string', N'string', N'string', CAST(N'2025-04-16' AS Date), 0)
GO
INSERT [dbo].[VentaCab] ([IdVenta], [Cliente], [Nrodocumento], [FechaVenta], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (1, N'string', N'string', CAST(N'2025-04-20' AS Date), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[VentaCab] ([IdVenta], [Cliente], [Nrodocumento], [FechaVenta], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (2, N'Franz', N'47814917', CAST(N'2025-04-20' AS Date), CAST(1484.0000 AS Decimal(18, 4)), CAST(267.1200 AS Decimal(18, 4)), CAST(1751.1200 AS Decimal(18, 4)), 0)
GO
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (1, 1, N'string', 0, CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (2, 1, N'string', 0, CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (3, 2, N'Zapatilla', 3, CAST(256.0000 AS Decimal(18, 4)), CAST(768.0000 AS Decimal(18, 4)), CAST(138.2400 AS Decimal(18, 4)), CAST(906.2400 AS Decimal(18, 4)), 0)
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (4, 2, N'camisa', 2, CAST(358.0000 AS Decimal(18, 4)), CAST(716.0000 AS Decimal(18, 4)), CAST(128.8800 AS Decimal(18, 4)), CAST(844.8800 AS Decimal(18, 4)), 0)
GO
/****** Object:  StoredProcedure [dbo].[usp_Alumno_Insert]    Script Date: 20/04/2025 12:08:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[usp_Alumno_Insert]
(
	@Nombre varchar(50),
	@Apellidos varchar(50),
	@NroDocumento varchar(8),
	@FechNacimiento date,
	@Exito int output,
	@Mensaje varchar(200) output
)
as

if exists (select IdAlumno from Alumno where NroDocumento = @NroDocumento and flgEliminado = 0)
	begin
		set @Exito = 0
		set @Mensaje = 'El número de documento ' + @NroDocumento + ' ya existe'
	end
else
	begin
		declare @IdAlumno int = isnull((select MAX(IdAlumno) from Alumno), 0) + 1;

		insert into Alumno (IdAlumno, Nombre, Apellido, NroDocumento, Fechanacimiento, flgEliminado)
		values (@IdAlumno, @Nombre, @Apellidos, @NroDocumento, @FechNacimiento, 0)

		set @Exito = 1
		set @Mensaje = 'Registro Correcto'
	end

GO
/****** Object:  StoredProcedure [dbo].[usp_Alumno_Lista]    Script Date: 20/04/2025 12:08:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


create procedure [dbo].[usp_Alumno_Lista](
	@flgorden int,
	@IdAlumno int
)
as

if @flgorden = 1 -- Devuelve toda la lista
	begin
		select * from Alumno where flgEliminado = 0
	end
else if @flgorden = 2 -- devuelve por ID
	begin
		select * from Alumno where IdAlumno  = @IdAlumno
	end
GO
/****** Object:  StoredProcedure [dbo].[usp_venta_Det_insert]    Script Date: 20/04/2025 12:08:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE procedure [dbo].[usp_venta_Det_insert](
	@Idventa int,
	@Producto varchar(15),
	@Cantidad int,
	@Precio decimal(18,4),
	@Subtotal decimal(18,4),
	@Igv decimal(18,4),
	@Total decimal(18,4)
 )
as
	begin
		declare @IdVentaDet int = ISNULL((select MAX(IdVentaDet) from VentaDet), 0) +1
		
		insert into VentaDet (IdVentaDet, Idventa, Producto, Cantidad, Precio, Subtotal, Igv, Total, flgEliminado)
		values(@IdVentaDet, @Idventa, @Producto, @Cantidad, @Precio, @Subtotal, @Igv, @Total, 0)
	end
GO
/****** Object:  StoredProcedure [dbo].[usp_venta_insert]    Script Date: 20/04/2025 12:08:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[usp_venta_insert](
	@Cliente varchar(70),
	@Nrodocumento varchar(15),
	@Fechaventa date,
	@Subtotal decimal(18,4),
	@Igv decimal(18,4),
	@Total decimal(18,4),
	@IdVenta int output
)
as
	begin
		set @IdVenta = ISNULL((select MAX(IdVenta) from VentaCab), 0) +1
		insert into VentaCab(IdVenta, Cliente, Nrodocumento, FechaVenta, Subtotal, Igv, Total, flgEliminado)
		values(@IdVenta, @Cliente, @Nrodocumento, @Fechaventa, @Subtotal, @Igv, @Total, 0)
	end
GO
USE [master]
GO
ALTER DATABASE [POOII] SET  READ_WRITE 
GO
