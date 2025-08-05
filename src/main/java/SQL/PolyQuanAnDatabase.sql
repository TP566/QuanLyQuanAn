--------------------------------------------------------------------------------
-- 1. Tạo database (nếu chưa có), và sử dụng nó
--------------------------------------------------------------------------------
IF DB_ID('PolyQuanAn') IS NULL
    CREATE DATABASE PolyQuanAn;
GO

USE PolyQuanAn;
GO


--------------------------------------------------------------------------------
-- 2. Bảng Người dùng
--------------------------------------------------------------------------------
CREATE TABLE dbo.[Users] (
    Username    VARCHAR(50)    NOT NULL PRIMARY KEY,
    Password    VARCHAR(255)   NOT NULL,
    Fullname    NVARCHAR(100)  NOT NULL,
    Enabled     BIT            NOT NULL DEFAULT(1),
    Manager     BIT            NOT NULL DEFAULT(0)
);
GO

--------------------------------------------------------------------------------
-- 3. Bảng Loại món ăn / đồ uống (Category)
--------------------------------------------------------------------------------
CREATE TABLE dbo.[Category] (
    MaDanhMuc      VARCHAR(20)   NOT NULL PRIMARY KEY,
    TenDanhMuc    NVARCHAR(100)  NOT NULL
);
GO

--------------------------------------------------------------------------------
-- 4. Bảng Đồ uống (Drink)
--------------------------------------------------------------------------------
CREATE TABLE dbo.[Drink] (
    DrinkId         INT             IDENTITY(1,1) PRIMARY KEY,
    DrinkName       NVARCHAR(100)   NOT NULL,
    Origin          NVARCHAR(100)   NULL,
    Price           DECIMAL(18,2)   NOT NULL DEFAULT(0),
    Unit            NVARCHAR(20)    NULL,
    StockQuantity   INT             NOT NULL DEFAULT(0),
    CategoryId      VARCHAR(20)     NOT NULL
        CONSTRAINT FK_Drink_Category FOREIGN KEY REFERENCES dbo.[Category](MaDanhMuc),
    Discount        DECIMAL(5,2)    NOT NULL DEFAULT(0)
);
GO

--------------------------------------------------------------------------------
-- 5. Bảng Hóa đơn (Bill)
--------------------------------------------------------------------------------
CREATE TABLE dbo.[Bill] (
    MaHD        INT             IDENTITY(1,1) PRIMARY KEY,
    CardId      INT             NULL,
    Username    VARCHAR(50)     NOT NULL
        CONSTRAINT FK_Bill_User FOREIGN KEY REFERENCES dbo.[Users](Username),
    Checkin     DATETIME        NOT NULL DEFAULT(GETDATE()),
    Checkout    DATETIME        NULL,
    Status      INT             NOT NULL DEFAULT(0)  -- 0=Servicing,1=Completed,2=Canceled
);
GO

--------------------------------------------------------------------------------
-- 6. Bảng Chi tiết hóa đơn (BillDetail)
--------------------------------------------------------------------------------
CREATE TABLE dbo.[BillDetail] (
    MaCT        INT             IDENTITY(1,1) PRIMARY KEY,
    MaHD        INT             NOT NULL
        CONSTRAINT FK_BillDet_Bill FOREIGN KEY REFERENCES dbo.[Bill](MaHD),
    MaMon       INT             NOT NULL
        CONSTRAINT FK_BillDet_Drink FOREIGN KEY REFERENCES dbo.[Drink](DrinkId),
    DonGia      DECIMAL(18,2)   NOT NULL,
    SoLuong     INT             NOT NULL,
    GhiChu      NVARCHAR(255)   NULL
);
GO

INSERT INTO dbo.[Users](Username,Password,Fullname,Enabled,Manager)
VALUES
 ('admin','123','Thiên Phú',1,1)


 INSERT INTO dbo.[Category](MaDanhMuc,TenDanhMuc)
VALUES
 ('C01','Cà phê'),
 ('C02','Nước ép'),
 ('C03','Trà sữa');

 INSERT INTO dbo.[Drink](DrinkName,Origin,Price,Unit,StockQuantity,CategoryId,Discount)
VALUES
 ('Cà phê sữa','Việt Nam',25000,'ly',100,'C01',5),
 ('Cam vắt','Việt Nam',30000,'ly',50,'C02',0),
 ('Trà sữa matcha','Nhật Bản',45000,'ly',80,'C03',10);