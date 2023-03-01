
package sa.gov.mc.eservices.repository


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext





//class UserRepository @Inject constructor(private val userDataSource: UserRemoteDateSource) {
//
//    lateinit var user: User
//
//    suspend fun userProfile():User{
//        withContext(Dispatchers.IO) {
//            try {
//               user = userDataSource.userProfile()
//                return@withContext user
//
//            } catch (e: Exception) {
//
//            }
//        }
//        return user
//
//    }
//
//
//
//}