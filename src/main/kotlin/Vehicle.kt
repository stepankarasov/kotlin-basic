package ru.otus.okb.first

data class Vehicle(
    val brand: String,
    val model: String,
    val price: Int,
    var mileage: Int,
    var nextTO: Int,
    var beforeTO: Int
)

class VehicleBuilder {
    var brand: String = ""
    var model: String = ""
    var price: Int = 0
    var mileage: Int = 0
    var nextTO: Int = 5000
    var beforeTO: Int = nextTO

    fun build(): Vehicle {
        return Vehicle(brand, model, price, mileage, nextTO, beforeTO)
    }
}

fun vehicle(block: VehicleBuilder.() -> Unit) = VehicleBuilder().apply(block).build()

infix fun Vehicle.mileageUp(mileageCount: Int) {
    this.mileage += mileageCount
    this.beforeTO -= mileageCount
}

operator fun Vehicle.plus(mileage: Int) {
    this mileageUp mileage
}

val doTO: (vehicle: Vehicle, targetNextTO: Int) -> Int = { vehicle, targetNextTO ->
    val nextTO = vehicle.mileage + targetNextTO
    vehicle.nextTO = nextTO
    nextTO
}