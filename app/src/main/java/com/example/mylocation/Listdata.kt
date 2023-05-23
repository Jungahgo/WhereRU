package com.example.mylocation

data class Listdata(
    var checkSigWrite: Int = SignalMode.DEFAULT,
    //var profileImg: String,
    var nickName: String? = null,
    var sigPromiseTime: String? = null,
    var sigPromiseArea: String? = null,
)

object SignalMode{
    const val DEFAULT = 0 //아무것도 입력안함
}