USE [master]
GO
/****** Object:  Database [POOII]    Script Date: 4/05/2025 12:21:22 ******/
CREATE DATABASE [POOII]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'POOII', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\POOII.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'POOII_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\POOII_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [POOII] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [POOII].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [POOII] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [POOII] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [POOII] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [POOII] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [POOII] SET ARITHABORT OFF 
GO
ALTER DATABASE [POOII] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [POOII] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [POOII] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [POOII] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [POOII] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [POOII] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [POOII] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [POOII] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [POOII] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [POOII] SET  ENABLE_BROKER 
GO
ALTER DATABASE [POOII] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [POOII] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [POOII] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [POOII] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [POOII] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [POOII] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [POOII] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [POOII] SET RECOVERY FULL 
GO
ALTER DATABASE [POOII] SET  MULTI_USER 
GO
ALTER DATABASE [POOII] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [POOII] SET DB_CHAINING OFF 
GO
ALTER DATABASE [POOII] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [POOII] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [POOII] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [POOII] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'POOII', N'ON'
GO
ALTER DATABASE [POOII] SET QUERY_STORE = ON
GO
ALTER DATABASE [POOII] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [POOII]
GO
/****** Object:  Table [dbo].[Alumno]    Script Date: 4/05/2025 12:21:23 ******/
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
/****** Object:  Table [dbo].[VentaCab]    Script Date: 4/05/2025 12:21:23 ******/
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
/****** Object:  Table [dbo].[VentaDet]    Script Date: 4/05/2025 12:21:23 ******/
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
INSERT [dbo].[VentaCab] ([IdVenta], [Cliente], [Nrodocumento], [FechaVenta], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (2, N'Franz', N'47814917', CAST(N'2025-04-20' AS Date), CAST(13580.0000 AS Decimal(18, 4)), CAST(2444.4000 AS Decimal(18, 4)), CAST(16024.4000 AS Decimal(18, 4)), 0)
GO
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (1, 1, N'string', 0, CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (2, 1, N'string', 0, CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (3, 2, N'Zapatilla', 3, CAST(256.0000 AS Decimal(18, 4)), CAST(768.0000 AS Decimal(18, 4)), CAST(138.2400 AS Decimal(18, 4)), CAST(906.2400 AS Decimal(18, 4)), 1)
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (4, 2, N'camisa', 10, CAST(358.0000 AS Decimal(18, 4)), CAST(3580.0000 AS Decimal(18, 4)), CAST(644.4000 AS Decimal(18, 4)), CAST(4224.4000 AS Decimal(18, 4)), 0)
INSERT [dbo].[VentaDet] ([IdVentaDet], [Idventa], [Producto], [Cantidad], [Precio], [Subtotal], [Igv], [Total], [flgEliminado]) VALUES (5, 2, N'Mochila', 100, CAST(100.0000 AS Decimal(18, 4)), CAST(10000.0000 AS Decimal(18, 4)), CAST(1800.0000 AS Decimal(18, 4)), CAST(11800.0000 AS Decimal(18, 4)), 0)
GO
/****** Object:  StoredProcedure [dbo].[usp_Alumno_Insert]    Script Date: 4/05/2025 12:21:23 ******/
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
/****** Object:  StoredProcedure [dbo].[usp_Alumno_Lista]    Script Date: 4/05/2025 12:21:23 ******/
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
/****** Object:  StoredProcedure [dbo].[usp_venta_det_delete]    Script Date: 4/05/2025 12:21:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[usp_venta_det_delete](
	@IdventaDet int	 
)
as

update VentaDet set flgEliminado = 1 where IdVentaDet = @IdventaDet
GO
/****** Object:  StoredProcedure [dbo].[usp_venta_Det_insert]    Script Date: 4/05/2025 12:21:23 ******/
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
/****** Object:  StoredProcedure [dbo].[usp_venta_det_update]    Script Date: 4/05/2025 12:21:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[usp_venta_det_update](
	@IdventaDet int,
	@Cantidad int,
	@Precio decimal(12,2),
	@Subtotal decimal(12,2),
	@Igv decimal(12,2),
	@Total decimal(12,2)
)

as

update VentaDet 
	set
		Cantidad = @Cantidad,
		Precio = @Precio,
		Subtotal = @Subtotal ,
		Igv = @Igv,
		Total = @Total
	where IdVentaDet = @IdventaDet
GO
/****** Object:  StoredProcedure [dbo].[usp_venta_insert]    Script Date: 4/05/2025 12:21:23 ******/
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
/****** Object:  StoredProcedure [dbo].[usp_ventacab_update]    Script Date: 4/05/2025 12:21:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


create procedure [dbo].[usp_ventacab_update](
	@Idventa int,
	@Subtotal decimal(12,2),
	@Igv decimal(12,2),
	@Total decimal(12,2)
)
as
update VentaCab 
	set 
		Subtotal = @Subtotal ,
		Igv = @Igv,
		Total = @Total
	where IdVenta = @Idventa 
GO
/****** Object:  StoredProcedure [dbo].[usp_ventas_listar]    Script Date: 4/05/2025 12:21:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


create procedure [dbo].[usp_ventas_listar](
	@flgorden int,
	@buscar varchar(50),
	@Idventa int
)
as


if @flgorden = 1 --- Listar todas las ventas
	begin
		select * from VentaCab where flgEliminado  = 0
	end
if @flgorden = 2 -- devuelve lista por Id
	begin
		select 
			IdVenta,
			Cliente,
			Nrodocumento,
			FechaVenta, 
			Subtotal,
			Igv,
			Total
		from VentaCab where flgEliminado = 0 and IdVenta = @Idventa
		
		select
			IdVentaDet ,
			Idventa,
			Producto,
			Cantidad,
			Precio,
			Subtotal,
			Igv,
			Total
		from VentaDet where Idventa = @Idventa and flgEliminado = 0
	end
GO
USE [master]
GO
ALTER DATABASE [POOII] SET  READ_WRITE 
GO
