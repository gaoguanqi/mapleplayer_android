package com.maple.player.db.user

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "users")
class User{

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0

    @ColumnInfo(name = "loginType")
    var loginType:Int = 0

    @ColumnInfo(name = "nickname")
    var nickname:String? = ""

    @ColumnInfo(name = "uid")
    var uid:String? = ""

    @ColumnInfo(name = "token")
    var token:String? = ""


}


//@Entity(tableName = "users")
//@TypeConverters(AccountConverters::class,ProfileConverters::class,BindingConverters::class,ExpertsConverters::class)
//class User {
//    @PrimaryKey(autoGenerate = true)
//    var id:Long = 0
//
//    @ColumnInfo(name = "loginType")
//    var loginType:Int = 0
//
//    @ColumnInfo(name = "token")
//    var token:String = ""
//
//    @ColumnInfo(name = "account")
//    var account:Account? = null
//
//    @ColumnInfo(name = "profile")
//    var profile:Profile? = null
//
//    @ColumnInfo(name = "bindings")
//    var bindings:MutableList<Binding>? = null
//
//
//
//}
//
//data class Account(var anonimousUser: Boolean?,
//                   var ban: String? = "",
//                   var baoyueVersion: String? = "",
//                   var createTime: Long?,
//                   var donateVersion: String? = "",
//                   var id: String? = "",
//                   var salt: String? = "",
//                   var status: String? = "",
//                   var tokenVersion: String? = "",
//                   var type: String? = "",
//                   var userName: String? ="",
//                   var vipType: String? = "",
//                   var viptypeVersion: String? = "",
//                   var whitelistAuthority: String? = "")
//
//data class Profile(var accountStatus: String? = "",
//                   var authStatus: String? = "",
//                   var authority: String? = "",
//                   var avatarImgId: Long?,
//                   var avatarImgIdStr: String? = "",
//                   var avatarImgId_str: String? = "",
//                   var avatarUrl: String? = "",
//                   var backgroundImgId: Long?,
//                   var backgroundImgIdStr: String? = "",
//                   var backgroundUrl: String? = "",
//                   var birthday: String? = "",
//                   var city: String? = "",
//                   var defaultAvatar: Boolean? = false,
//                   var description: String? = "",
//                   var detailDescription: String? = "",
//                   var djStatus: String? = "",
//                   var eventCount: String? = "",
//                   var expertTags: Any?,
//                   var experts: Experts?,
//                   var followed: Boolean? = false,
//                   var followeds: String? = "",
//                   var follows: String? = "",
//                   var gender: String? = "",
//                   var mutual: Boolean? = false,
//                   var nickname: String? = "",
//                   var playlistBeSubscribedCount: String? = "",
//                   var playlistCount: String? = "",
//                   var province: String? = "",
//                   var remarkName: Any?,
//                   var signature: String? = "",
//                   var userId: String? = "",
//                   var userType: String? = "",
//                   var vipType: String? = "")
//
//data class Experts(var id: String? = "")
//
//data class Binding(
//    var bindingTime: Long?,
//    var expired: Boolean? = false,
//    var expiresIn: String? = "",
//    var id: String? = "",
//    var refreshTime: Long?,
//    var tokenJsonStr: String? = "",
//    var type: String? = "",
//    var url: String? = "",
//    var userId: String? = ""
//)
//
//class AccountConverters {
//    @TypeConverter
//    fun stringToObject(value: String): Account {
//        val typeype = object : TypeToken<Account>() {}.type
//        return Gson().fromJson(value, typeype)
//    }
//
//    @TypeConverter
//    fun objectToString(obj: Account): String {
//        val gson: Gson = Gson()
//        return gson.toJson(obj)
//    }
//}
//
//class ProfileConverters {
//    @TypeConverter
//    fun stringToObject(value: String): Profile {
//        val typeype = object : TypeToken<Profile>() {}.type
//        return Gson().fromJson(value, typeype)
//    }
//
//    @TypeConverter
//    fun objectToString(obj: Profile): String {
//        val gson: Gson = Gson()
//        return gson.toJson(obj)
//    }
//}
//
//class ExpertsConverters {
//    @TypeConverter
//    fun stringToObject(value: String): Experts {
//        val typeype = object : TypeToken<Experts>() {}.type
//        return Gson().fromJson(value, typeype)
//    }
//
//    @TypeConverter
//    fun objectToString(obj: Experts): String {
//        val gson: Gson = Gson()
//        return gson.toJson(obj)
//    }
//}
//
//class BindingConverters{
//    @TypeConverter
//    fun stringToObject(value:String):List<Binding>{
//        val typeype = object : TypeToken<Binding>(){}.type
//        return Gson().fromJson(value,typeype)
//    }
//
//    @TypeConverter
//    fun objectToString(obj:List<Binding>):String{
//        val gson:Gson = Gson()
//        return gson.toJson(obj)
//    }
//}