fun main() {
    val hinhChuNhat = HinhChuNhat("Xanh", 4.0, 5.0)
    val hinhTron = HinhTron("Đỏ", 3.0)
    val hinhVuong = HinhVuong("Vàng", 4.0)

    val danhSachHinh: List<Hinh> = listOf(hinhChuNhat, hinhTron, hinhVuong)

    println("Danh sách các hình:")
    for (hinh in danhSachHinh) {
        println(hinh.LayThongTin())
    }
}