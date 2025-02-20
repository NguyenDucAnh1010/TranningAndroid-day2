package bai1

import bai1.model.Category
import bai1.model.Product

fun addProduct(productList: MutableList<Product>) {
    print("Mã sản phẩm: ")
    val productId = readlnOrNull()?.toIntOrNull()
    print("Tên sản phẩm: ")
    val productName = readlnOrNull()
    print("Giá cả: ")
    val productPrice = readlnOrNull()?.toDoubleOrNull()
    print("Xuất xứ: ")
    val productOrigin = readlnOrNull()
    if (productId != null && productName != null && productPrice != null && productOrigin != null)
        productList.add(Product(productId, productName, productPrice, productOrigin))
}

fun enterValue(categoryList: MutableList<Category>) {
    println("Nhập danh mục")
    print("Mã danh mục: ")
    val categoryId = readlnOrNull()?.toIntOrNull()
    print("Tên danh mục: ")
    val categoryName = readlnOrNull()
    println("--------------------------")

    var countProduct: Int?
    do {
        print("Nhập số lượng sản phẩm: ")
        countProduct = readlnOrNull()?.toIntOrNull()
    } while (countProduct == null)

    val productList: MutableList<Product> = mutableListOf()
    for (i in 1..countProduct) {
        println("Nhập sản phẩm thứ $i")
        addProduct(productList)
        println("--------------------------")
    }

    if (categoryId != null && categoryName != null)
        categoryList.add(Category(categoryId, categoryName, productList))

    printListCategory(categoryList)
}

fun printListCategory(categoryList: MutableList<Category>) {
    println("\nDanh sách danh mục")
    for (category in categoryList) {
        println("Mã danh mục: ${category.id}, Tên danh mục: ${category.categoryName}")
        println("\nDanh sách sản phẩm của")
        for (product in category.productList) {
            println(product)
            println("--------------------------")
        }
    }
}

fun getListOfProduct(categoryList: MutableList<Category>) {
    var searchCategoryId: Int?
    do {
        print("Nhập mã danh mục mà bạn muốn tìm: ")
        searchCategoryId = readlnOrNull()?.toIntOrNull()
    } while (searchCategoryId == null)

    println("Danh sách sản phẩm theo danh mục:")
    val category = categoryList.find { it.id == searchCategoryId }
    category?.let {
        for (product in category.productList) {
            println(product)
        }
    } ?: println("Không tìm thấy danh mục")
}

fun updateProduct(categoryList: MutableList<Category>) {
    var categoryId: Int?
    do {
        print("Nhập mã danh mục mà bạn muốn sửa: ")
        categoryId = readlnOrNull()?.toIntOrNull()
    } while (categoryId == null)

    var productId: Int?
    do {
        print("Nhập mã sản phẩm mà bạn muốn sửa: ")
        productId = readlnOrNull()?.toIntOrNull()
    } while (productId == null)

    val category = categoryList.find { it.id == categoryId }
    category?.productList?.find { it.id == productId }?.let { product ->
        println("Cập nhật sản phẩm")

        print("Tên sản phẩm: ")
        val newProductName = readlnOrNull()

        print("Giá cả: ")
        val newProductPrice = readlnOrNull()?.toDoubleOrNull()

        print("Xuất xứ: ")
        val newProductOrigin = readlnOrNull()

        if (newProductName != null && newProductPrice != null && newProductOrigin != null) {
            product.apply {
                nameProduct = newProductName
                price = newProductPrice
                origin = newProductOrigin
            }
            println("Cập nhật sản phẩm thành công!\n")
            printListCategory(categoryList)
        } else {
            println("Thông tin nhập vào không hợp lệ, cập nhật thất bại!")
        }
    } ?: println("Không tìm thấy sản phẩm với ID $productId")
}

fun deleteProduct(categoryList: MutableList<Category>) {
    var categoryId: Int?
    do {
        print("Nhập ID danh mục: ")
        categoryId = readlnOrNull()?.toIntOrNull()
    } while (categoryId == null)

    val isCategoryRemove = categoryList.find { it.id == categoryId }

    isCategoryRemove?.let {
        print("Nhập ID sản phẩm cần xóa: ")
        val productId = readlnOrNull()?.toIntOrNull()
        val isRemoved = isCategoryRemove.productList.removeIf { it.id == productId }

        isRemoved.let {
            println("Xóa sản phẩm thành công!")
            printListCategory(categoryList)
        }
    } ?:println("Không tìm thấy danh mục với ID $categoryId")
}

fun caculateTotalPriceOf(categoryList: MutableList<Category>) {
    val totalValue = categoryList.sumOf { it.productList.sumOf { it.price } }
    println("Tổng giá trị của các mặt hàng: $totalValue")
}

fun getListChinaProduct(categoryList: MutableList<Category>) {
    for (category in categoryList) {
        val chinaProducts = category.productList.filter { it.origin.equals("Trung Quốc", ignoreCase = true) }
        for (product in chinaProducts) {
            println(product)
        }
    }
}

fun main() {
    val mutableCategory: MutableList<Category> = mutableListOf()

    do {
        println("\n--- QUẢN LÝ BÁN HÀNG ---")
        println("1. Thêm danh mục sản phẩm và sản phẩm")
        println("2. Xuất danh sách sản phẩm theo danh mục")
        println("3. Cập nhật sản phẩm")
        println("4. Xóa sản phẩm")
        println("5. Tính tổng giá trị hàng hóa")
        println("6. Liệt kê sản phẩm xuất xứ Trung Quốc")
        println("7. Thoát")

        print("Chọn chức năng: ")
        val choice = readln().toIntOrNull() ?: -1

        when (choice) {
            1 -> enterValue(mutableCategory)
            2 -> getListOfProduct(mutableCategory)
            3 -> updateProduct(mutableCategory)
            4 -> deleteProduct(mutableCategory)
            5 -> caculateTotalPriceOf(mutableCategory)
            6 -> getListChinaProduct(mutableCategory)
            7 -> {
                println("Thoát chương trình.")
                return
            }

            else -> println("Lựa chọn không hợp lệ!")
        }
    } while (true)
}