var technologies=["java","jdbc","spring","sql",true,18,null];
console.log(technologies[6]);
// for(let technology of technologies){
//     console.log(technology);
// }
// for(let index in technologies){
//     console.log(technologies[index]);
// }
// technologies.forEach((value,y) => {
//     console.log(y);
//     console.log(value)
// });
// console.log('index of sql '+technologies.indexOf('sql')); 
// console.log('before pop ', technologies);
// console.log(technologies.pop());
// console.log('after pop ',technologies); 
// console.log('before push',technologies);
// console.log(technologies.push('hibernate','spring'));
// console.log('after push',technologies); 
// console.log('before shift',technologies);
// console.log(technologies.shift());
// console.log('after shift',technologies);
// console.log('before unshift',technologies);
// console.log(technologies.unshift('JS'));
// console.log('after unshift',technologies);
// technologies.splice(2,0,'bootstrap','json');
// console.log('splice',technologies);
// technologies.splice(technologies.indexOf('json'),3);
// console.log(technologies);
// console.log(technologies.length); 
// technologies.reverse();
// console.log('reversed array',technologies);
// let marks=[13,30,45,69,76,90];
// console.log(marks);
// let filteredMarks=marks.filter((value,index,array)=>{
//     return value>35;
// });
// console.log('after filter',filteredMarks);
let marks=[20,20,20,30,30,40,40,50,60,60,50];
console.log(marks);
let filteredMarks=marks.filter((value,index,array)=>{
    return array.indexOf(value)===index;
});
console.log('after filter',filteredMarks);
let myArray=filteredMarks.map((value,index,array)=> {
    return {ind:index,val:value};
});
console.log(myArray);

var persons=[{
    name: 'manju',
    age:21
},{
    name: 'pranitha',
    age:23
}];