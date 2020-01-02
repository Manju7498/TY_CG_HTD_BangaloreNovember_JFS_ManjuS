var person={
    aadharNo:989112732223
}
var personPan={
    pan:'Dy28765'
}
var student = {
    ...person,
    ...personPan,
    id: 518,
    name: 'manju',
    degree: 'b.tech',
    phone : 9876543210,
    address:{
        town :'palamaner',
        state:'andhra'
    }
}
// console.log(student);
// console.log(student.aadharNo);
// console.log(student.pan);
// console.log(student.address.town);
for(let key in student){
    console.log(student[key]);
}