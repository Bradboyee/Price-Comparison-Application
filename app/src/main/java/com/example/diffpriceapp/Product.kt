package com.example.diffpriceapp

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class  Product() : RealmObject() {
    var Producttopic: String = ""
    var ProductAname: String = ""
    var ProductBname: String = ""
    var ProductAsize: String = ""
    var ProductBsize: String = ""
    var ProductAprice: String = ""
    var ProductBprice: String = ""
    var result: String? = ""
    constructor(Producttopic: String, ProductAname: String, ProductBname: String,ProductAsize:String,ProductBsize:String,ProductAprice:String,ProductBprice:String,result:String?) : this() {
        this.Producttopic = Producttopic
        this.ProductAname = ProductAname
        this.ProductBname = ProductBname
       this.ProductAsize = ProductAsize
        this.ProductBsize = ProductBsize
        this.ProductAprice = ProductAprice
        this.ProductBprice = ProductBprice
        this.result = result
    }
}

