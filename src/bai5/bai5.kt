package bai5

import bai5.model.Address
import bai5.model.Student

fun main() {
    val homeAddress = Address("123 Lý Tự Trọng", "Hà Nội", "VN", 100000)
    val schoolAddress = Address("456 Trần Hưng Đạo", "Hà Nội", "VN", 100001)

    val student1 = Student("Nguyễn", "Văn A", homeAddress, schoolAddress)

    println(student1)
}