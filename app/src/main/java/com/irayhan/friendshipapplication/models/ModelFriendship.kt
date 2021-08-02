package com.irayhan.friendshipapplication.models
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ModelFriendship(
    @SerializedName("info")
    val info: Info?,
    @SerializedName("results")
    val friendList: List<ModelFriend>?
) : Serializable

data class Info(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: Int?,
    @SerializedName("seed")
    val seed: String?,
    @SerializedName("version")
    val version: String?
) : Serializable

data class ModelFriend(
    @SerializedName("cell")
    val cell: String?,
    @SerializedName("dob")
    val dob: Dob?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: Id?,
    @SerializedName("location")
    val location: Location?,
    @SerializedName("login")
    val login: Login?,
    @SerializedName("name")
    val name: Name?,
    @SerializedName("nat")
    val nat: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("picture")
    val picture: Picture?,
    @SerializedName("registered")
    val registered: Registered?
) : Serializable

data class Dob(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("date")
    val date: String?
) : Serializable

data class Id(
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?
) : Serializable

data class Location(
    @SerializedName("city")
    val city: String?,
    @SerializedName("coordinates")
    val coordinates: Coordinates?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("postcode")
    val postcode: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("street")
    val street: Street?,
    @SerializedName("timezone")
    val timezone: Timezone?
) : Serializable

data class Login(
    @SerializedName("md5")
    val md5: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("salt")
    val salt: String?,
    @SerializedName("sha1")
    val sha1: String?,
    @SerializedName("sha256")
    val sha256: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("uuid")
    val uuid: String?
) : Serializable

data class Name(
    @SerializedName("first")
    val first: String?,
    @SerializedName("last")
    val last: String?,
    @SerializedName("title")
    val title: String?
) : Serializable

data class Picture(
    @SerializedName("large")
    val large: String?,
    @SerializedName("medium")
    val medium: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
) : Serializable

data class Registered(
    @SerializedName("age")
    val age: Int?,
    @SerializedName("date")
    val date: String?
) : Serializable

data class Coordinates(
    @SerializedName("latitude")
    val latitude: String?,
    @SerializedName("longitude")
    val longitude: String?
) : Serializable

data class Street(
    @SerializedName("name")
    val name: String?,
    @SerializedName("number")
    val number: String?
) : Serializable

data class Timezone(
    @SerializedName("description")
    val description: String?,
    @SerializedName("offset")
    val offset: String?
) : Serializable