package com.zack.iphoneproject.models

class Products {
    var name: String=""
    var quantity:String=""
    var price: String=""
    var id: String=""
    constructor(name:String,quantity:String,price:String,id:String){
        this.name=name
        this.quantity=quantity
        this.price=price
        this.id=id
    }
    constructor()
}