import org.junit.Assert.assertTrue
import org.junit.Test
import ru.otus.okb.first.*
import kotlin.test.assertEquals

class DslTest {
    @Test
    fun vehicleCollectionTest() {
        var carsCollection: VehicleCollection = car {
            name = "My cars"
            vehiclesCount = 8

            vehicle {
                brand = "Toyota"
                model = "Hiace"
                price = 600000
            }
            vehicle {
                brand = "Suzuki"
                model = "Swift"
                price = 700000
            }
            vehicle {
                brand = "Mazda"
                model = "Demio"
                price = 500000
            }
        }

        val carsCollectionName: String = vehiclesCollectionName(carsCollection)

        assertEquals("My cars", carsCollection.name)
        assertEquals(8, carsCollection.vehiclesCount)
        assertEquals(3, carsCollection.vehiclesList.size)
        assertTrue(
            "Incorrect vehicle brand!",
            carsCollection.vehiclesList.first().brand.equals("Toyota")
        )
        assertTrue(
            "Incorrect vehicle model!",
            carsCollection.vehiclesList.first().model.equals("Hiace")
        )
        assertTrue(
            "Incorrect vehicles price!",
            carsCollection.vehiclesList.first().price == 600000
        )
        assertEquals("Collection name is My cars", carsCollectionName)

        printField(carsCollection.name)
    }

    @Test
    fun vehicleMileageTest() {
        var vehicle: Vehicle = vehicle {
            brand = "Suzuki"
            model = "Swift"
            price = 700000
            mileage = 0
            nextTO = 5000
        }
        vehicle mileageUp 2000
        vehicle + 3000

        val targetNextTO = doTO(vehicle, 10000)

        assertEquals("Suzuki", vehicle.brand)
        assertEquals("Swift", vehicle.model)
        assertEquals(5000, vehicle.mileage)
        assertTrue(targetNextTO in 14000..16000)
    }
}