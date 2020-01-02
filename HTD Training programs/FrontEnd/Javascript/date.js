
// console.log('date',date.getDate());
// console.log('month',date.getMonth()+1);
// console.log('seconds',date.getSeconds());
// console.log('year',date.getFullYear());
setInterval(()=>{
    var date=new Date();
    document.getElementById('todaysDate').innerText=`
    Date::: ${date.getDate()}-${date.getMonth()+1}-${date.getFullYear()} 
    Time ::: ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}:${date.getMilliseconds()}`
},10);