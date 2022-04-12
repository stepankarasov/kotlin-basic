package ru.otus.okb.first

sealed class VehicleCollection(
    val name: String,
    val vehiclesCount: Int,
    val vehiclesList: List<Vehicle>
) {
    class Car(name: String, vehiclesCount: Int, vehiclesList: List<Vehicle> = emptyList()) :
        VehicleCollection(name, vehiclesCount, vehiclesList)

    class Truck(name: String, vehiclesCount: Int, vehiclesList: List<Vehicle> = emptyList()) :
        VehicleCollection(name, vehiclesCount, vehiclesList)
}

abstract class VehicleCollectionBuilder {
    var name: String = ""
    var vehiclesCount: Int = 0
    var vehiclesList: MutableList<Vehicle> = mutableListOf()

    fun add(vehicle: Vehicle) {
        vehiclesList.add(vehicle)
    }

    fun add(vehicleBuilder: VehicleBuilder) {
        add(vehicleBuilder.build())
    }

    abstract fun build(): VehicleCollection
}

class CarBuilder : VehicleCollectionBuilder() {
    override fun build(): VehicleCollection.Car = VehicleCollection.Car(name, vehiclesCount, vehiclesList.toList())

    fun vehicle(function: VehicleBuilder.() -> Unit) = add(VehicleBuilder().apply(function))
}

class TruckBuilder : VehicleCollectionBuilder() {
    override fun build(): VehicleCollection.Truck = VehicleCollection.Truck(name, vehiclesCount, vehiclesList.toList())

    fun vehicle(function: VehicleBuilder.() -> Unit) = add(VehicleBuilder().apply(function))
}

fun car(function: CarBuilder.() -> Unit): VehicleCollection.Car = CarBuilder().apply(function).build()

fun truck(function: TruckBuilder.() -> Unit): VehicleCollection.Truck = TruckBuilder().apply(function).build()

inline fun <reified T : VehicleCollection> vehiclesCollectionName(vehiclesCollection: T): String =
    "Collection name is ${vehiclesCollection.name}"

fun <T> printField(field: T): T = field