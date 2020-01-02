//console.log('Welcome manju');
//variable declaration
//var a;
//variable initialisation
//a=10;
//both
//var a=10;
// console.log('value of a '+a);
// console.log(typeof(a));
// var name="manju";
// console.log(name);
// console.log(typeof(name));
// var age=21;
// var details=`The name is ${name} and age is ${age}`;
// console.log(details);
// console.log(`Addition  of 10 and 11 is ${10+11}`);
// var sampleText=`Lorem ipsum dolor sit amet consectetur adipisicing elit. Quod laborum, 
// magni sint similique odio eius facere nemo dicta facilis modi, perspiciatis asperiores corporis 
// accusantium nostrum! Quia maiores velit molestiae ipsam.`;
// console.log(sampleText);
// var icompassCleared= true;
// console.log(typeof(icompassCleared));
// var empty=null;
// console.log(typeof empty);
// if(null==undefined){
//     console.log('true block');
// }else {
//     console.log('false block');
// }
// alert('Are you fine?');
// var userConfirmation=confirm('Are you manju?');
// console.log(userConfirmation);
// if(userConfirmation){
//     console.log('user selected is ok');
// }else {
//     console.log('user is in confusion');
// }
// var userInput=prompt('Please enter your name');
// console.log(userInput);
// document.write("Welcome JavaScript");
// var a=10;
// function demo(){
//     console.log(a);
//     var b=100;
//     console.log('function is called');
// }
// function add(a,b){
// return a+b;
// }
// console.log(add(2,3));
// (function demo1(a,b){
//     var name='manju';
//     console.log('inside the function',name);
//     console.log('IIFE running');
// })(12,14);
// console.log('outside the function',name);
// function sample(x){
//     console.log('sample function started');
//     x();
//     console.log('sample function ended');
// }
// sample(function(){
//     console.log('callback function');
// });
let marks=[20,27,86,83,75,57,86];
let ascendingOrder=marks.sort((a,b)=>{
    return a-b;
});
console.log('ascending ',ascendingOrder);

let descendingOrder=marks.sort((a,b)=>{
    return b-a;
});
console.log('descending',descendingOrder);