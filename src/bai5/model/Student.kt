package bai5.model

class Student(var firstName: String, var lastName: String, var homeAddress: Address, var schoolAddress: Address) {
    override fun toString(): String {
        return """Họ tên: $firstName $lastName
                |Địa chỉ nhà: $homeAddress
                |Địa chỉ trường: $schoolAddress""".trimMargin()
    }
}