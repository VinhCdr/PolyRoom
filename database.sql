IF (db_id('polyroom') IS NOT NULL)
BEGIN
    USE master;
    DROP DATABASE polyroom;
END;
GO
CREATE DATABASE polyroom;
GO
USE polyroom;
GO

CREATE TABLE [phong]
(
    [id_phong] integer NOT NULL,
    [so_tang] integer NOT NULL,
    [ten_phong] NVARCHAR(32) NOT NULL UNIQUE,
    [is_cho_muon] bit NOT NULL,
    PRIMARY KEY ([id_phong], [so_tang])
);
GO

CREATE TABLE [tai_khoan]
(
    [id_tai_khoan] varchar(64) NOT NULL,
    [email] varchar(128) NOT NULL UNIQUE,
    [mat_khau] varchar(128) NOT NULL,
    [is_phan_quyen] bit NOT NULL,
    [ten] NVARCHAR(64) NOT NULL,
    [sdt] char(10) NOT NULL,
    PRIMARY KEY ([id_tai_khoan])
);
GO

CREATE TABLE [muon_phong]
(
    [id_muon_phong] integer NOT NULL IDENTITY(1,1),
    [id_tai_khoan] varchar(64) NOT NULL,
    [id_phong] integer NOT NULL,
    [ly_do] NVARCHAR(1024) NOT NULL,
    [so_tang] integer NOT NULL,
    [tg_muon] datetime NOT NULL,
    [tg_tra] datetime NOT NULL,
    [tg_tra_thuc_te] datetime NULL,
    PRIMARY KEY ([id_muon_phong]),
    FOREIGN KEY ([id_phong], [so_tang]) REFERENCES phong([id_phong], [so_tang]) ON UPDATE NO ACTION ON DELETE CASCADE,
    FOREIGN KEY ([id_tai_khoan]) REFERENCES [tai_khoan]([id_tai_khoan]) ON UPDATE NO ACTION ON DELETE CASCADE
);
GO

CREATE TABLE [thong_tin_sinh_vien]
(
    [id_sinh_vien] varchar(8) NOT NULL,
    [email_sv] varchar(128) NOT NULL,
    [ten_sinh_vien] NVARCHAR(128) NOT NULL,
    [id_muon_phong] integer NOT NULL,
    PRIMARY KEY ([id_sinh_vien], [id_muon_phong]),
    FOREIGN KEY ([id_muon_phong]) REFERENCES [muon_phong] ([id_muon_phong]) ON UPDATE NO ACTION ON DELETE CASCADE
);
GO

CREATE TABLE [temp_muon_phong_sv]
(
    [id_temp] INTEGER IDENTITY(1,1) PRIMARY KEY NOT NULL,
    [id_phong] INTEGER NOT NULL,
    [so_tang] INTEGER NOT NULL,
    [tg_muon] DATETIME NOT NULL,
    [tg_tra] DATETIME NOT NULL,
    [id_sinh_vien] VARCHAR(8) NOT NULL,
    [email_sinh_vien] VARCHAR(128) NOT NULL,
    [ten_sinh_vien] NVARCHAR(128),
    [ly_do] NVARCHAR(256),
    [id_tai_khoan] VARCHAR(64),
    [otp] char(8) NOT NULL,
    [tg_dang_ky] DATETIME NOT NULL,
    FOREIGN KEY ([id_phong], [so_tang]) REFERENCES phong([id_phong], [so_tang]) ON UPDATE NO ACTION  ON DELETE CASCADE,
    FOREIGN KEY ([id_tai_khoan]) REFERENCES tai_khoan([id_tai_khoan]) ON UPDATE NO ACTION  ON DELETE CASCADE
);
GO

INSERT INTO [phong]
    ([so_tang], [id_phong], [ten_phong], [is_cho_muon])
VALUES
    (0, 1, N'Đào tạo', 0),
    (0, 2, N'Đảm bảo', 0),
    (1, 1, N'101', 1),
    (1, 2, N'102', 1),
    (1, 3, N'Hội trường', 1),
    (2, 1, N'201', 1),
    (2, 2, N'Khách sạn', 1),
    (2, 3, N'Công nghệ', 1),
    (3, 1, N'301', 1),
    (3, 2, N'302', 1);
GO

/*
vinhlm => vipass
loilh => loipass
phongtc => phongpass
minhvhn => minhpass
taivt => taipass
linhntt => linhpass
...
tk1 => tk1
tk2 => tk2
...
*/
INSERT INTO [tai_khoan]
    ([id_tai_khoan], [email], [mat_khau], [is_phan_quyen], [ten], [sdt])
VALUES
    ('vinhlm', 'vinhlmpc01238@fpt.edu.vn', 'n64b81cqjs7e4g9uqjvfkufqs', 1, N'Lê Minh Vinh', '0856538112'),
    ('loilh', 'loilhpc01261@fpt.edu.vn', 'sb2ishbus3f8hgpu95ktp8389', 1, N'Lương Hửu Lợi', '0126101261'),
    ('phongtc', 'phongtcpc01275@fpt.edu.vn', 'u9v4imgr6qt0v6alcifnva6oe', 1, N'Trần Chí Phong', '0127501275'),
    ('taivt', 'taivtpc01260@fpt.edu.vn', '3vcdvv80btm9q90dpm84o26fvo', 1, N'Võ Tấn Tài', '0126001260'),
    ('minhvhn', 'minhvhnpc01239@fpt.edu.vn', '734rmd9eqag5824ln9ue02nlgf', 1, N'Võ Hồng Nhật Minh', '0123901239'),
    ('linhntt', 'linhnttpc01259@fpt.edu.vn', '5i8bh0raevh6057esh1ck9ctrs', 1, N'Nguyễn Thị Tài Linh', '0125901259'),
    ('tk1', 'tk1@fpt.edu.vn', 'mnpqof4132jpnk78upif57gfj', 0, N'Tài khoản 1', '0123456791'),
    ('tk2', 'tk2@fpt.edu.vn', '5njieomv79jnpjpsvqbesmq32h', 0, N'Tài khoản 2', '0123456792'),
    ('tk3', 'tk3@fpt.edu.vn', '7jqncfk6tacmiasf81pks3t56q', 0, N'Tài khoản 3', '0123456793'),
    ('tk4', 'tk4@fpt.edu.vn', '6dkm0brmd4bs52qk85sr474jo9', 0, N'Tài khoản 4', '0123456794'),
    ('tk5', 'tk5@fpt.edu.vn', '32bvfp285amcrn821s0j3e6hnd', 0, N'Tài khoản 5', '0123456795'),
    ('tk6', 'tk6@fpt.edu.vn', 'ks29dn6lhdemnurnf3odrhbko', 0, N'Tài khoản 6', '0123456796');
GO

INSERT INTO [muon_phong]
    (/*id_muon_phong,*/[id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], [tg_tra_thuc_te], [ly_do])
VALUES
    ('vinhlm', 1, 1, GETDATE(), DATEADD(HOUR, 2, GETDATE()), null, N'Dạy học'),
    ('loilh', 1, 2, DATEADD(HOUR, 1, GETDATE()), DATEADD(HOUR, 3, GETDATE()), null, N'Dạy học'),
    ('loilh', 1, 2, '2020-12-22 09:30:00', '2020-12-22 11:30:00', '2020-12-22 11:45:00', N'Dạy học'),
    ('phongtc', 1, 2, '2020-12-22 15:00:00', '2020-12-22 17:00:00', '2020-12-22 16:30:00', N'Dạy học'),
    ('taivt', 1, 2, '2020-12-22 15:15:00', '2020-12-22 17:15:00', '2020-12-22 16:30:00', N'Dạy học'),
    ('tk1', 2, 1, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk2', 2, 2, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk3', 2, 3, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk4', 3, 1, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk5', 3, 2, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk6', 3, 1, '2020-12-23 09:30:00', '2020-12-23 11:30:00', null, N'Dạy học');
GO

INSERT INTO [thong_tin_sinh_vien]
    ([id_sinh_vien],[email_sv], [ten_sinh_vien], [id_muon_phong])
VALUES
    ('pc01238', 'vinhlmpc01238@fpt.edu.vn', N'Vinh', 6),
    ('pc01187', 'ngocntypc01187@fpt.edu.vn', N'Ngọc', 2),
    ('pc01238', 'vinhlmpc01238@fpt.edu.vn', N'Vinh', 3),
    ('pc01187', 'ngocntypc01187@fpt.edu.vn', N'Ngọc', 4),
    ('pc01187', 'ngocntypc01187@fpt.edu.vn', N'Ngọc', 5);
GO

INSERT INTO [temp_muon_phong_sv]
    (/*id_temp,*/[so_tang], [id_phong], [tg_muon], [tg_tra], [id_sinh_vien], [email_sinh_vien], [ten_sinh_vien], [ly_do], [id_tai_khoan], [otp], [tg_dang_ky])
VALUES
    (1, 1, '2020-12-23 09:30:00', '2020-12-23 11:30:00', 'pc01275', 'vinhlmpc01238@fpt.edu.vn', N'Phong Trần', N'Học mỹ thuật', 'tk6', '11223344', '2020-12-22 11:30:00'),
    (1, 2, '2020-12-23 13:00:00', '2020-12-23 15:00:00', 'pc01275', 'vinhlmpc01238@fpt.edu.vn', N'Phong Trần', N'Sinh hoạt câu lạc bộ', 'vinhlm', '12345678', '2020-12-23 09:30:00'),
    (1, 3, '2020-12-23 09:30:00', '2020-12-23 11:30:00', 'pc01275', 'vinhlmpc01238@fpt.edu.vn', N'Phong Trần', N'Học thanh nhạc', 'tk6', '11223344', '2020-12-22 11:30:00');
GO

GO
CREATE PROC get_phong_mp
    (@tg_hien_tai DATETIME)
AS
BEGIN
    SELECT phong.so_tang, phong.id_phong, ten_phong, is_cho_muon,
        (
        SELECT COUNT(*)
        FROM muon_phong AS mp
        WHERE tg_tra_thuc_te IS NULL AND mp.so_tang = phong.so_tang AND mp.id_phong = phong.id_phong
        ) AS luot_dat,
        (
        SELECT IIF(COUNT(*) = 0, 1, 0)
        FROM muon_phong AS mp2
        WHERE tg_muon <= @tg_hien_tai AND tg_tra_thuc_te IS NULL AND mp2.so_tang = phong.so_tang AND mp2.id_phong = phong.id_phong
        ) AS is_trong
    FROM muon_phong RIGHT JOIN phong ON phong.so_tang = muon_phong.so_tang AND phong.id_phong = muon_phong.id_phong
    GROUP BY phong.so_tang, phong.id_phong, ten_phong, is_cho_muon;
END;

GO
CREATE PROC get_phong_mp_id
    (@tg_hien_tai DATETIME,
    @so_tang INTEGER,
    @id_phong INTEGER)
AS
BEGIN
    SELECT phong.so_tang, phong.id_phong, ten_phong, is_cho_muon,
        (
        SELECT COUNT(*)
        FROM muon_phong AS mp
        WHERE tg_tra_thuc_te IS NULL AND mp.so_tang = phong.so_tang AND mp.id_phong = phong.id_phong
        ) AS luot_dat,
        (
        SELECT IIF(COUNT(*) = 0, 1, 0)
        FROM muon_phong AS mp2
        WHERE tg_muon <= @tg_hien_tai AND tg_tra_thuc_te IS NULL AND mp2.so_tang = phong.so_tang AND mp2.id_phong = phong.id_phong
        ) AS is_trong
    FROM muon_phong RIGHT JOIN phong ON phong.so_tang = muon_phong.so_tang AND phong.id_phong = muon_phong.id_phong
    WHERE phong.so_tang = @so_tang AND phong.id_phong = @id_phong
    GROUP BY phong.so_tang, phong.id_phong, ten_phong, is_cho_muon;
END;

GO
CREATE VIEW view_thong_tin_muon_phong
AS
    SELECT [phong].[id_phong], [phong].[so_tang], [ten_phong], [is_cho_muon], [muon_phong].[id_muon_phong], [tai_khoan].[id_tai_khoan], [ly_do], [tg_muon], [tg_tra], [tg_tra_thuc_te], [email], [mat_khau], [is_phan_quyen], [ten], [sdt], [id_sinh_vien], [ten_sinh_vien], [email_sv],
        (
        SELECT COUNT(*)
        FROM muon_phong AS mp
        WHERE tg_tra_thuc_te IS NULL AND mp.so_tang = phong.so_tang AND mp.id_phong = phong.id_phong
        ) AS luot_dat,
        (
        SELECT IIF(COUNT(*) = 0, 1, 0)
        FROM muon_phong AS mp2
        WHERE tg_muon <= GETDATE() AND tg_tra_thuc_te IS NULL AND mp2.so_tang = phong.so_tang AND mp2.id_phong = phong.id_phong
        ) AS is_trong
    FROM [phong]
        LEFT JOIN [muon_phong] ON [phong].[so_tang] = [muon_phong].[so_tang] AND [phong].[id_phong] = [muon_phong].[id_phong]
        LEFT JOIN [tai_khoan] ON [muon_phong].[id_tai_khoan] LIKE [tai_khoan].[id_tai_khoan]
        LEFT JOIN [thong_tin_sinh_vien] ON [muon_phong].[id_muon_phong] LIKE [thong_tin_sinh_vien].[id_muon_phong]
    GROUP BY [phong].[id_phong], [phong].[so_tang], [ten_phong], [is_cho_muon], [muon_phong].[id_muon_phong], [tai_khoan].[id_tai_khoan], [ly_do], [tg_muon], [tg_tra], [tg_tra_thuc_te], [email], [mat_khau], [is_phan_quyen], [ten], [sdt], [id_sinh_vien], [ten_sinh_vien], [email_sv];

GO
CREATE PROC sp_refresh_poro
AS
BEGIN
    UPDATE [muon_phong] 
    SET [tg_tra_thuc_te] = GETDATE() 
    WHERE [tg_tra] <= GETDATE() AND tg_tra_thuc_te IS NULL;

    DELETE [temp_muon_phong_sv] 
    WHERE [tg_dang_ky] < GETDATE() AND DATEDIFF(MINUTE, [tg_dang_ky], GETDATE()) > 10;

    DELETE [temp_muon_phong_sv]
    WHERE [id_temp] = ANY (
        SELECT id_temp
    FROM temp_muon_phong_sv AS t
        INNER JOIN muon_phong as m ON t.so_tang = m.so_tang AND t.id_phong = m.id_phong
    WHERE (t.tg_muon BETWEEN m.tg_muon AND m.tg_tra OR t.tg_tra BETWEEN m.tg_muon AND m.tg_tra OR m.tg_muon BETWEEN t.tg_muon AND t.tg_tra) AND m.tg_tra_thuc_te IS NULL
    );

END;

GO
CREATE PROC sp_confirm_temp_sv
    (@id_temp INTEGER,
    @otp CHAR(8))
AS
BEGIN
    IF ((SELECT [id_temp]
    FROM temp_muon_phong_sv
    WHERE [id_temp] = @id_temp AND [otp] LIKE @otp) IS NOT NULL) 
    BEGIN
        INSERT INTO [muon_phong]
            ([id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], [tg_tra_thuc_te], [ly_do])
        SELECT [id_tai_khoan], [so_tang], [id_phong], [tg_muon], [tg_tra], null, [ly_do]
        FROM [temp_muon_phong_sv]
        WHERE [id_temp] = @id_temp AND [otp] LIKE @otp;

        DECLARE @id_muon INTEGER;
        SET @id_muon = (SELECT TOP(1)
            id_muon_phong
        FROM muon_phong
        ORDER BY id_muon_phong DESC);

        INSERT INTO [thong_tin_sinh_vien]
            ([id_sinh_vien],[email_sv], [ten_sinh_vien], [id_muon_phong])
        SELECT [id_sinh_vien], [email_sinh_vien], [ten_sinh_vien], @id_muon
        FROM [temp_muon_phong_sv]
        WHERE [id_temp] = @id_temp AND [otp] LIKE @otp;

        DELETE temp_muon_phong_sv 
        WHERE [id_temp] = @id_temp AND [otp] LIKE @otp;
    END 
    ELSE
    BEGIN
        DELETE temp_muon_phong_sv 
        WHERE [id_temp] = -1;
    END
END;