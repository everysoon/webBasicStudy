var log = document.querySelector(".log");
var ul = document.querySelector("ul");

/* Event delegation */
ul.addEventListener("click",function (evt){
    //target이 image면 src 추출해서 출력하면 될 듯!
    var target = evt.target;
    if(target.tagName == "IMG"){
        log.innerHTML = "IMG URL은 "+target.src;
    }else if(target.tagName == "LI"){
        log.innerHTML ="UL URL은 "+target.firstElementChild.src;
    }
});