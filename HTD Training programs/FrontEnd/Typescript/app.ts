console.log('Typescript variables ');
 
let a=100; //implicitly considered as number
a=200;
a=null;
//a='one';   error-cannot reassign type number to string
let b; //implicitly considered as any
b=100;
b='manju';
let marks:number[]=[1,3,4,2,6];
let student:{name: string,age: number,pass: boolean};
student={
    name: 'manju',
    age: 21,
    pass: true
}
console.log(b);
class Sample{
    a=100;
    b='manju';
}
let sample=new Sample();
console.log('class a',sample.a);
class Student {
    constructor(
        public name: string,
        public age: number,
        public USN: string,
        public marks: number
    ){

    }
    printDetails():void{
        console.log(`
        Name: ${student1.name},
        Age: ${student1.age},
        USN: ${student1.USN},
        Marks: ${student1.marks}
        `);
    }
}
let student1 =new Student('manju',21,'15KA1A0518',66);
console.log('student details : ',student1.name , student1.age , student1.USN );
student1.printDetails();