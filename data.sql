USE master;
GO
DROP DATABASE polyroom;
GO
CREATE DATABASE polyroom;
GO
USE polyroom;
GO

CREATE TABLE phong
(
    id_phong integer NOT NULL,
    so_tang integer NOT NULL,
    ten_phong NVARCHAR(32) NOT NULL UNIQUE,
    is_cho_muon bit NOT NULL,
    PRIMARY KEY (id_phong, so_tang)
);
GO

CREATE TABLE tai_khoan
(
    id_tai_khoan varchar(64) NOT NULL,
    email varchar(128) NOT NULL,
    mat_khau varchar(128) NOT NULL,
    is_phan_quyen bit NOT NULL,
    ten NVARCHAR(64) NOT NULL,
    sdt char(10) NOT NULL,
    PRIMARY KEY (id_tai_khoan)
);
GO

CREATE TABLE muon_phong
(
    id_muon_phong integer NOT NULL IDENTITY(1,1),
    id_tai_khoan varchar(64) REFERENCES tai_khoan(id_tai_khoan) NOT NULL ,
    id_phong integer NOT NULL,
    ly_do NVARCHAR(1024) NOT NULL,
    so_tang integer NOT NULL,
    tg_muon datetime NOT NULL,
    tg_tra datetime NOT NULL,
    tg_tra_thuc_te datetime NULL,
    PRIMARY KEY (id_muon_phong),
    FOREIGN KEY (id_phong, so_tang) REFERENCES phong(id_phong, so_tang)
);
GO

CREATE TABLE thong_tin_sinh_vien
(
    id_sinh_vien varchar(8) NOT NULL,
    email varchar(128) NOT NULL,
    ten_sinh_vien NVARCHAR(128) NOT NULL,
    id_muon_phong integer NOT NULL REFERENCES muon_phong(id_muon_phong),
    PRIMARY KEY (id_sinh_vien, id_muon_phong)
);
GO

CREATE TABLE temp_muon_phong_sv
(
    id_temp INTEGER IDENTITY(1,1) PRIMARY KEY NOT NULL,
    id_phong INTEGER NOT NULL,
    so_tang INTEGER NOT NULL,
    tg_muon DATETIME NOT NULL,
    tg_tra DATETIME NOT NULL,
    id_sinh_vien VARCHAR(8) NOT NULL,
    email_sinh_vien VARCHAR(128) NOT NULL,
    ten_sinh_vien NVARCHAR(128),
    ly_do NVARCHAR(256),
    id_tai_khoan VARCHAR(64),
    otp char(8) NOT NULL,
    tg_dang_ky DATETIME NOT NULL,
    FOREIGN KEY (id_phong, so_tang) REFERENCES phong(id_phong, so_tang),
    FOREIGN KEY (id_tai_khoan) REFERENCES tai_khoan(id_tai_khoan)
);
GO

INSERT INTO phong
    (so_tang, id_phong, ten_phong, is_cho_muon)
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
SELECT *
FROM phong;

-- mat_khau equals id_tai_khoan
INSERT INTO tai_khoan
    (id_tai_khoan, email, mat_khau, is_phan_quyen, ten, sdt)
VALUES
    ('vinhlm', 'vinhlmpc01238@fpt.edu.vn', '78f7002p638e8vkpkodcn3krml', 1, N'Lê Minh Vinh', '0856538112'),
    ('ngocnty', 'ngocntypc01187@fpt.edu.vn', '51qftrbvk5g6lrqmll0os82qqo', 1, N'Nguyễn Thị Yến Ngọc', '0123456789'),
    ('vinhlmz', 'mvinhle22@gmail.com', '33j0c9sjev9nakidee0n81rtul', 0, N'Lê Minh Vinh', '0856538112'),
    ('ngocntyz', 'mvinhle@outlook.com', '44l55n0phsojvd4rvq03vivphj', 0, N'Nguyễn Thị Yến Ngọc', '0123456789'),
    ('tk1', 'tk1@fpt.edu.vn', 'mnpqof4132jpnk78upif57gfj', 0, N'Tài khoản 1', '0123456791'),
    ('tk2', 'tk2@fpt.edu.vn', '5njieomv79jnpjpsvqbesmq32h', 0, N'Tài khoản 2', '0123456792'),
    ('tk3', 'tk3@fpt.edu.vn', '7jqncfk6tacmiasf81pks3t56q', 0, N'Tài khoản 3', '0123456793'),
    ('tk4', 'tk4@fpt.edu.vn', '6dkm0brmd4bs52qk85sr474jo9', 0, N'Tài khoản 4', '0123456794'),
    ('tk5', 'tk5@fpt.edu.vn', '32bvfp285amcrn821s0j3e6hnd', 0, N'Tài khoản 5', '0123456795'),
    ('tk6', 'tk6@fpt.edu.vn', 'ks29dn6lhdemnurnf3odrhbko', 0, N'Tài khoản 6', '0123456796');
GO
SELECT *
FROM tai_khoan;

INSERT INTO muon_phong
    (/*id_muon_phong,*/id_tai_khoan, so_tang, id_phong, tg_muon, tg_tra, tg_tra_thuc_te, ly_do)
VALUES
    ('vinhlm', 1, 1, '2020-12-22 09:30:00', '2020-12-22 11:30:00', '2020-12-22 11:45:00', N'Dạy học'),
    ('ngocnty', 1, 2, '2020-12-22 09:30:00', '2020-12-22 11:30:00', '2020-12-22 11:45:00', N'Dạy học'),
    ('vinhlmz', 1, 2, '2020-12-22 15:00:00', '2020-12-22 15:00:00', '2020-12-22 11:30:00', N'Dạy học'),
    ('ngocntyz', 1, 2, '2020-12-22 15:15:00', '2020-12-22 17:15:00', '2020-12-22 17:30:00', N'Dạy học'),
    ('tk1', 2, 1, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk2', 2, 2, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk3', 2, 3, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk4', 3, 1, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk5', 3, 2, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học'),
    ('tk6', 3, 1, '2020-12-22 09:30:00', '2020-12-22 11:30:00', null, N'Dạy học');
GO
SELECT *
FROM muon_phong;

INSERT INTO thong_tin_sinh_vien
    (id_sinh_vien,email, ten_sinh_vien, ly_do, id_muon_phong)
VALUES
    ('pc01238', 'vinhlmpc01238@fpt.edu.vn', N'Vinh', 1),
    ('pc01187', 'ngocntypc01187@fpt.edu.vn', N'Ngọc', 2),
    ('pc01238', 'vinhlmpc01238@fpt.edu.vn', N'Vinh',  3),
    ('pc01187', 'ngocntypc01187@fpt.edu.vn', N'Ngọc', 3),
    ('pc01187', 'ngocntypc01187@fpt.edu.vn', N'Ngọc', 4);
GO
SELECT *
FROM thong_tin_sinh_vien;

INSERT INTO temp_muon_phong_sv
    (/*id_temp,*/so_tang, id_phong, tg_muon, tg_tra, id_sinh_vien, email_sinh_vien, ten_sinh_vien, ly_do, id_tai_khoan, otp, tg_dang_ky)
VALUES
    (1, 1, '2020-12-23 09:30:00', '2020-12-23 11:30:00', 'pc01275', 'vinhlmpc01238@fpt.edu.vn', N'Phong Trần', N'Học mỹ thuật', 'tk6', '11223344', '2020-12-22 11:30:00'),
    (1, 2, '2020-12-23 13:00:00', '2020-12-23 15:00:00', 'pc01275', 'vinhlmpc01238@fpt.edu.vn', N'Phong Trần', N'Sinh hoạt câu lạc bộ', 'vinhlm', '12345678', '2020-12-23 09:30:00'),
    (1, 3, '2020-12-23 09:30:00', '2020-12-23 11:30:00', 'pc01275', 'vinhlmpc01238@fpt.edu.vn', N'Phong Trần', N'Học thanh nhạc', 'tk6', '11223344', '2020-12-22 11:30:00');
GO
SELECT *
FROM temp_muon_phong_sv;