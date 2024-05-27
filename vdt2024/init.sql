USE vdt2024;

SET NAMES 'utf8mb4';
SET CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS student (
id INT AUTO_INCREMENT PRIMARY KEY,
fullname VARCHAR(255) NOT NULL,
gender VARCHAR(10) NOT NULL,
school VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO student (id, fullname, gender, school) VALUES
(1, 'Lê Minh Việt Hoàng', 'Nữ', 'ITMO University'),
(2, 'Phạm Quang Bách', 'Nam', 'VinUniversity'),
(3, 'Hoàng Bá Bảo', 'Nam', 'Đại Học Bách Khoa Hà Nội'),
(4, 'Hoàng Bá Bảo', 'Nam', 'Đại Học Bách Khoa Hà Nội'),
(5, 'Trương Văn Độ', 'Nam', 'Đại học Công nghệ - Đại học Quốc gia Hà Nội'),
(6, 'Hoàng Việt Dũng', 'Nam', 'ITMO University'),
(7, 'Bùi Hoàng Dũng', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(8, 'Bùi Trọng Dũng', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(9, 'Trần Thùy Dương', 'Nữ', 'Đại học Công nghệ - Đại học Quốc gia Hà Nội'),
(10, 'Quách Đăng Giang', 'Nam', 'Đại học Công nghệ Thông tin – Đại học Quốc gia TP.HCM'),
(11, 'Nguyễn Thanh Hà', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(12, 'Nguyễn Thu Hà', 'Nữ', 'Đại học Bách Khoa Hà Nội'),
(13, 'Cù Xuân Hải', 'Nam', 'ITMO University'),
(14, 'Nguyễn Trung Hiếu', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(15, 'Đặng Việt Hoàng', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(16, 'Nguyễn Văn Hùng', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(17, 'Nguyễn Quốc Hưng', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(18, 'Lê Minh Hương', 'Nữ', 'Đại học Công nghệ - Đại học Quốc gia Hà Nội'),
(19, 'Ngô Đăng Huy', 'Nam', 'Đại học Công nghệ - Đại học Quốc gia Hà Nội'),
(20, 'Trần Quang Huy', 'Nam', 'Học viện Công Nghệ Bưu Chính Viễn Thông'),
(21, 'Trần Minh Huyền', 'Nữ', 'Đại học Bách Khoa Hà Nội'),
(22, 'Nguyễn Đôn Thế Hòa', 'Nam', 'VinUniversity'),
(23, 'Lê Hoàng Trường', 'Nam', 'ITMO University'),
(24, 'Đào Quang Lợi', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(25, 'Nguyễn Tiến Long', 'Nam', 'ITMO University'),
(26, 'Nguyễn Quang Long', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(27, 'Nguyễn Thị Ngọc Thảo', 'Nữ', 'Đại học Công nghệ - Đại học Quốc gia Hà Nội'),
(28, 'Đỗ Dương Mạnh', 'Nam', 'ITMO University'),
(29, 'Nguyễn Ngọc Minh', 'Nam', 'Học viện Công Nghệ Bưu Chính Viễn Thông'),
(30, 'Vũ Thế Nam', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(31, 'Ngô Công Bằng', 'Nam', 'Học viện Công Nghệ Bưu Chính Viễn Thông'),
(32, 'Nguyễn Huy Thái', 'Nam', 'Đại học Công nghệ - Đại học Quốc gia Hà Nội'),
(33, 'Phan Khôi Nguyên', 'Nam', 'Đại học Bách Khoa Hà Nội'),
(34, 'Đỗ Thu Trang', 'Nữ', 'Đại học Công nghệ - Đại học Quốc gia Hà Nội'),
(35, 'Nguyễn Thị Mỹ Tú', 'Nữ', 'ITMO University'),
(36, 'Nguyễn Quang Tuấn', 'Nam', 'ITMO University'),
(37, 'Hoàng Minh Tuấn', 'Nam', 'Học viện Công Nghệ Bưu Chính Viễn Thông'),
(38, 'Phạm Mạnh Tuấn', 'Nam', 'ITMO University'),
(39, 'Bùi Hoàng Vinh', 'Nam', 'Học viện Công Nghệ Bưu Chính Viễn Thông'),
(40, 'Nguyễn Ngọc Minh', 'Nam', 'PTITTTT');
