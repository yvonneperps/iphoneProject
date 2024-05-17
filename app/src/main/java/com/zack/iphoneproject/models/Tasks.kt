package com.zack.iphoneproject.models

class Tasks{
    var title:String=""
    var description:String=""
    var completed:String=""
    var duedate:String=""
    var priority:String=""
    var category:String=""
    var imageUrl:String=""
    var id:String=""


    constructor(title:String,description:String,completed:String,duedate:String,priority:String,category:String,id:String){
        this.title=title
        this.description=description
        this.completed=completed
        this.duedate=duedate
        this.priority=priority
        this.category=category
        this.imageUrl=imageUrl
        this.id=id
    }
    constructor()
}