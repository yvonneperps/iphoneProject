package com.zack.iphoneproject.models

import android.provider.ContactsContract.CommonDataKinds.Email

class User {
    var email: String= ""
    var pass: String= ""
    var userid: String= ""


    constructor(email: String, pass: String, userid: String){
        this.email= email
        this.pass= pass
        this.userid= userid
    }
    constructor()
}