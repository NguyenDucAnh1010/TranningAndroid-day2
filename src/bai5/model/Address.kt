package bai5.model

class Address(var streetAddress: String, var city: String, var state: String, var zipCode: Long) {
    override fun toString(): String {
        return "$streetAddress, $city, $state - $zipCode"
    }
}