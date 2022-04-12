import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test
import ru.otus.okb.first.VehicleWrapper
import ru.otus.okb.first.vehicle
import kotlin.test.assertTrue

class VehicleWrapperTest {
    @Test
    fun sequenceTest() {
        val sequence = (1..10).asSequence()
            .map {
                vehicle {
                    brand = "Toyota $it"
                    model = "Hiace $it"
                    price = 100000 * it
                    mileage = 110 * it
                    nextTO = 65 * it
                }
            }
        val wrapper = VehicleWrapper()
        wrapper.addOnlyBest(sequence)
        assertTrue(wrapper.size() == 3)
    }

    @Suppress("EXPERIMENTAL_API_USAGE")
    @Test
    fun flowTest() = runTest {
        val flow = flow {
            emit(vehicle {
                brand = "Toyota"
                model = "Hiace"
            })
            emit(vehicle {
                brand = "Suzuki"
                model = "Swift"
            })
            emit(vehicle {
                brand = "Mazda"
                model = "Demio"
            })
        }
        val wrapper = VehicleWrapper()
        wrapper.addExceptBrands(flow)
        assertTrue(wrapper.size() == 2)
    }
} 