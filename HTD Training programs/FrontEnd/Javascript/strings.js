let message='good morning folks';
console.log(message.charCodeAt(3));
console.log(message.charAt(2));
//splits the message
let splitMessage=message.split('');
console.log(splitMessage);
//reverse of a string
let reverseMessage=message.split('').reverse().join('');
console.log(reverseMessage);
//to check the string for a particular value
console.log(message.includes('good'));
//uppercase
console.log('uppercase : ',message.toUpperCase());
//lowercase
console.log('lowercase : ',message.toLowerCase());
//substr
console.log(message.substr(2,15));
//length
console.log(message.length);
function add(...nums){
    let sum=0;
    for(let num of nums){
        sum=sum+num;
    }
    console.log('sumof numbers is ',sum);
}
add(18,63,83,921);
var student={
    id: 518,
    name: 'manju',
    age: 21,
    location: 'plmr'
};
var { id,name ,...theRest} = student;
console.log(id);
console.log(theRest);
let marks=[50,64,90,66,54];
let[hindi,maths,english,...rest]=marks;
console.log('hindi marks',hindi);
console.log('rest of marks',rest);

